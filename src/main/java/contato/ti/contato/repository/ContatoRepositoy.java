package contato.ti.contato.repository;

import contato.ti.contato.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepositoy extends JpaRepository<Contato,Long> {
}
