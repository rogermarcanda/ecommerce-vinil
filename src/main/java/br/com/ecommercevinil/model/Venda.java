package br.com.ecommercevinil.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Venda implements Serializable {

    private static final long serialVersionUID = 5832549185558688739L;

    private Integer id;
    private LocalDate data;
    private BigDecimal valorTotal;
    private BigDecimal valorTotalComCashBack;
    private List<VendaProduto> vendaProduoList;
}
