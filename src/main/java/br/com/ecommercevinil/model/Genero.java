package br.com.ecommercevinil.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
public class Genero implements Serializable {

    private static final long serialVersionUID = 6235956392222945617L;

    @Getter
    @Id
    private Integer id;
    @Getter
    private String nome;
}
