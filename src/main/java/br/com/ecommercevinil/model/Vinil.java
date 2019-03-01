package br.com.ecommercevinil.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@Builder
public class Vinil implements Serializable {

    private static final long serialVersionUID = -224015881376052545L;

    @Getter
    private Integer id;
    @Getter
    private String nome;
    @Getter
    private BigDecimal valor;
    @Getter
    private Genero genero;
}