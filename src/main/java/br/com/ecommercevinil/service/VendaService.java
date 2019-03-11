package br.com.ecommercevinil.service;

import br.com.ecommercevinil.model.Venda;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public interface VendaService {

    Page<Venda> findByBetweenData(LocalDate dataInicial, LocalDate dataFinal, Integer numeroDaPagina, Integer qtdePorPagina);

    Venda findById(Integer idVenda);

    Venda save(Venda venda);

    void popularDataVenda(Venda venda);
}
