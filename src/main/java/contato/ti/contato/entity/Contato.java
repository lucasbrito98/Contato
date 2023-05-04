package contato.ti.contato.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Data
@Accessors(chain = true)
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "cpf", nullable = false)
    private String cpf;
    @Column(name = "idade")
    private Integer idade;
}
