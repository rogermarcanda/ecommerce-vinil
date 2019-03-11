package br.com.ecommercevinil.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.time.DayOfWeek;

@ApiModel(
        value = "Cashback",
        description = "Dinheiro de volta, é o valor calculado a partir de um determinado " +
                      "percentual para calcular o valor recebido de volta na conta.")
@Entity
@Getter
@EqualsAndHashCode(of = "diaDaSemana")
@NoArgsConstructor
@AllArgsConstructor
public class Cashback {

    @Id
    private Integer id;
    @ApiModelProperty(value = "", notes = "genero que o cashback esta relacionado")
    @Enumerated(EnumType.STRING)
    private Genero genero;
    @ApiModelProperty(value = "diaDaSemana", notes = "Dia da semana")
    @Enumerated(EnumType.STRING)
    private DayOfWeek diaDaSemana;
    @ApiModelProperty(value = "porcentagem", notes = "porcentagem de cachback")
    private Integer porcentagem;

}
