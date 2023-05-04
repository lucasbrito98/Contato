package contato.ti.contato.service.impl;

import contato.ti.contato.entity.Contato;
import contato.ti.contato.dto.request.ContatoRequestDto;
import contato.ti.contato.repository.ContatoRepositoy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
@RequiredArgsConstructor
public class ContatoServiceImpl implements ContatoService {

    private final ContatoRepositoy contatoRepositoy;

    public Contato salvar(Contato contato) {
        return contatoRepositoy.save(contato);
    }

    public List<Contato> listarContato(ContatoRequestDto contatoRequestDto) {
        return contatoRepositoy.findAll();


    }

    public Optional<Contato> buscarPorId(Long id) {
        return contatoRepositoy.findById(id);
    }

    public void removerPorId(Long id) {
        contatoRepositoy.deleteById(id);
    }
}
