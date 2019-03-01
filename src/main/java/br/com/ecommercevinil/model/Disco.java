package br.com.ecommercevinil.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Disco implements Serializable {

    private static final long serialVersionUID = 7999942222907517014L;

    @Getter
    private Integer id;
    @Getter
    private String nome;
    @Getter
    private Integer ano;
    @Getter
    private BigDecimal valor;
    @Getter
    private Genero genero;
}
