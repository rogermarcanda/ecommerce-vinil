package br.com.ecommercevinil.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Builder
public class Genero implements Serializable {

    private static final long serialVersionUID = 6235956392222945617L;

    @Getter
    private Integer id;
    @Getter
    private String nome;
}
