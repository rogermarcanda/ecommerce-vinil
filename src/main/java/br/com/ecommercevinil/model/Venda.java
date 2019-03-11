package br.com.ecommercevinil.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "Venda", description = "Dados referentes a venda de discos de vinil")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Venda implements Serializable {

    private static final long serialVersionUID = 5832549185558688739L;

    @ApiModelProperty(name = "id", notes = "identificador da venda")
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Integer id;

    @ApiModelProperty(name = "data", example = "DD-MM-YYYY", notes = "data da venda")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Setter
    @Getter
    private LocalDate data;

    @ApiModelProperty(name = "valorTotalComCashBack", example = "10.50", notes = "valor total da venda")
    private BigDecimal valorTotal;

    @ApiModelProperty(name = "valorCashBack", example = "10.50", notes = "valor total do cashback")
    private BigDecimal valorCashBack;

    @ApiModelProperty(name = "vendaProduoList", notes = "Lista com os discos vendidos")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="venda", referencedColumnName = "id")
    @Getter
    private List<VendaDisco> vendaProduoList = new ArrayList<>();

    public BigDecimal getValorTotal() {
        return vendaProduoList.stream().map(VendaDisco::getValorTotal).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    public BigDecimal getValorCashBack() {
        return vendaProduoList.stream().map(VendaDisco::getValorCashBack).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }
}
