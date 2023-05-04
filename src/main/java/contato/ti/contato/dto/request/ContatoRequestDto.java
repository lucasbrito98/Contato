package contato.ti.contato.dto.request;

import contato.ti.contato.entity.Contato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ContatoRequestDto {

    private String nome;
    private String email;
    private String cpf;
    private Integer idade;

public Contato build (){
    Contato contato = new Contato().setCpf(this.cpf)
            .setNome(this.nome)
            .setEmail(this.email)
            .setIdade(this.idade);
return contato;
}

}
