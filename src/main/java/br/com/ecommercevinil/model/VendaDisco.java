package br.com.ecommercevinil.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "VendaDisco", description = "Dados referentes a um item da venda disco de vinil")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class VendaDisco implements Serializable {

    private static final long serialVersionUID = 4087975436377845929L;

    @ApiModelProperty(name = "id", notes = "identidicador")
    @Id
    @GeneratedValue
    @Getter
    private Integer id;

    @ApiModelProperty(name = "disco", notes = "disco vendido")
    @ManyToOne
    @JoinColumn(name="disco", referencedColumnName = "id")
    @Getter
    @Setter
    private Disco disco;

    @ApiModelProperty(name = "qtde", notes = "quantidade de discos")
    @Getter
    @Setter
    private Integer qtde;

    @ApiModelProperty(name = "valor", example = "10.50", notes = "valor unitario do disco")
    @Getter
    @Setter
    private BigDecimal valor;

    @ApiModelProperty(name = "valorTotal", example = "10.50", notes = "valor total do item (valor 8 qtde)")
    private BigDecimal valorTotal;

    @ApiModelProperty(name = "valorCashBack", example = "10.50", notes = "valor do cashback")
    @Getter
    @Setter
    private BigDecimal valorCashBack;

    public BigDecimal getValorTotal() {
        return valor.multiply(BigDecimal.valueOf(qtde));
    }
}