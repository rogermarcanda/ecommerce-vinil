package br.com.ecommercevinil.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Disco implements Serializable {

    private static final long serialVersionUID = 7999942222907517014L;

    @Getter
    @Id
    @GeneratedValue
    private Integer id;

    @Getter
    private String nome;

    @Getter
    private Integer ano;

    @Getter
    private BigDecimal valor;

    @Getter
    @ManyToOne
    @JoinColumn(name="genero", referencedColumnName = "id")
    private Genero genero;
}
