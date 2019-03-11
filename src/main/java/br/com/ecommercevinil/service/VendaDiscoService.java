package br.com.ecommercevinil.service;

import br.com.ecommercevinil.model.VendaDisco;

import java.time.LocalDate;

public interface VendaDiscoService {

    void popularDadosVendaDisco(VendaDisco vendaDisco);

    void calcularCashBack(VendaDisco vendaDisco, LocalDate dataVenda);
}
