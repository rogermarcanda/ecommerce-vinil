package br.com.ecommercevinil.model;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Genero implements Serializable {

    private static final long serialVersionUID = 6235956392222945617L;

    @Getter
    private Integer id;
    @Getter
    private String nome;
}
