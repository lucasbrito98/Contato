package contato.ti.contato.service.impl;

import contato.ti.contato.entity.Contato;
import contato.ti.contato.dto.request.ContatoRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ContatoService {
    Contato salvar(Contato contato);

    List<Contato> listarContato(ContatoRequestDto contatoRequestDto);


    Optional<Contato> buscarPorId(Long id);

    void removerPorId(Long id);

}
