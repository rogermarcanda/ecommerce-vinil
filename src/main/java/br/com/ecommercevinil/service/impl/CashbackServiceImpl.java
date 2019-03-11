package br.com.ecommercevinil.service.impl;

import br.com.ecommercevinil.model.Cashback;
import br.com.ecommercevinil.model.Genero;
import br.com.ecommercevinil.repository.CashbackRepository;
import br.com.ecommercevinil.service.CashBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.DayOfWeek;

@Service
public class CashbackServiceImpl implements CashBackService {

    private CashbackRepository cashbackRepository;

    @Autowired
    public CashbackServiceImpl(CashbackRepository cashbackRepository) {
        this.cashbackRepository = cashbackRepository;
    }

    @Override
    public Integer retornaPorcentagemCashback(Genero genero, DayOfWeek diaDaSemana) {
        Cashback cashback = findByGeneroAndDiadaSemana(genero, diaDaSemana);
        return cashback.getPorcentagem();
    }

    @Cacheable("cashbacks")
    private Cashback findByGeneroAndDiadaSemana(Genero genero, DayOfWeek diaDaSemana) {
        return cashbackRepository.findByGeneroAndDiadaSemana(genero, diaDaSemana);

    }

}
