package br.com.ecommercevinil.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "Disco", description = "Dados referentes ao disco")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Disco implements Serializable {

    private static final long serialVersionUID = 7999942222907517014L;

    @ApiModelProperty(name = "id", notes = "identidicador")
    @Getter
    @Id
    @GeneratedValue
    private Integer id;

    @ApiModelProperty(name = "nome", notes = "nome do disco")
    @Getter
    private String nome;

    @ApiModelProperty(name = "autor", example = "banda, cantor, dupla, etc", notes = "nome do autor do disco")
    @Getter
    private String autor;

    @ApiModelProperty(name = "valor", example = "10.5", notes = "valor do disco")
    @Getter
    private BigDecimal valor;

    @ApiModelProperty(name = "genero", notes = "genero do disco")
    @Getter
    @Enumerated(EnumType.STRING)
    private Genero genero;
}
