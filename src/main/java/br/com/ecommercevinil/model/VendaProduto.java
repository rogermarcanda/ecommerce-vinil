package br.com.ecommercevinil.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class VendaProduto implements Serializable {

    private static final long serialVersionUID = 4087975436377845929L;

    @Id
    @GeneratedValue
    private Integer id;
    private Disco disco;
    private Integer qtde;
    private BigDecimal valor;
    private BigDecimal valorComCashBack;

}