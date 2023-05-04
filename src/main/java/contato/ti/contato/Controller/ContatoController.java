package contato.ti.contato.Controller;

import contato.ti.contato.dto.request.ContatoRequestDto;
import contato.ti.contato.entity.Contato;
import contato.ti.contato.service.impl.ContatoServiceImpl;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/contato")
public class ContatoController {
    @Autowired
    private ContatoServiceImpl contatoServiceImpl;
@Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContatoRequestDto salvar(@RequestBody ContatoRequestDto contatoRequestDto) {
        this.contatoServiceImpl.salvar(contatoRequestDto.build());
        return contatoRequestDto;
    }

    @GetMapping
    public List<Contato> listarContato(ContatoRequestDto contatoRequestDto) {
        return contatoServiceImpl.listarContato(contatoRequestDto);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Contato buscarContatoPorId(@PathVariable Long id) {
        return contatoServiceImpl.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não existe"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerContato(@PathVariable Long id) {
        contatoServiceImpl.buscarPorId(id)
                .map(contato -> {
                    contatoServiceImpl.removerPorId(contato.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não existe"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Contato> atualizarContato(@RequestBody Contato contato){
        Contato contatoAtualizado = contatoServiceImpl.salvar(contato);
        return new ResponseEntity<Contato>(contatoAtualizado,HttpStatus.OK);
    }
}
