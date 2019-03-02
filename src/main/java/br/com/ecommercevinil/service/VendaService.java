package br.com.ecommercevinil.service;

import br.com.ecommercevinil.model.Venda;

import java.time.LocalDate;
import java.util.List;

public interface VendaService {

    List<Venda> findByBetweenData(LocalDate dataInicial, LocalDate dataFinal, Integer numeroDaPagina, Integer qtdePorPagina);

    Venda findById(Integer idVenda);

    Venda save(Venda venda);
}
