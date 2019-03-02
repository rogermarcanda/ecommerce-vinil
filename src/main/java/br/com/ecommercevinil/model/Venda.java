package br.com.ecommercevinil.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Venda implements Serializable {

    private static final long serialVersionUID = 5832549185558688739L;

    @Id
    @GeneratedValue
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate data;

    private BigDecimal valorTotal;

    private BigDecimal valorTotalComCashBack;

    //@OneToMany
    //@JoinColumn(name="venda", referencedColumnName = "id")
    //private List<VendaProduto> vendaProduoList;
}
