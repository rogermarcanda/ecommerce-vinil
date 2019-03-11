package br.com.ecommercevinil.service;

import br.com.ecommercevinil.model.Genero;

import java.math.BigDecimal;
import java.time.DayOfWeek;

public interface CashBackService {

    Integer retornaPorcentagemCashback(Genero genero, DayOfWeek diaDaSemana);
}
