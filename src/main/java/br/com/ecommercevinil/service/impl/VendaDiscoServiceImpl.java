package br.com.ecommercevinil.service.impl;

import br.com.ecommercevinil.model.Disco;
import br.com.ecommercevinil.model.VendaDisco;
import br.com.ecommercevinil.service.CashBackService;
import br.com.ecommercevinil.service.DiscoService;
import br.com.ecommercevinil.service.VendaDiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class VendaDiscoServiceImpl implements VendaDiscoService {

    private CashBackService cashBackService;
    private DiscoService discoService;

    @Autowired
    public VendaDiscoServiceImpl(
            CashBackService cashBackService,
            DiscoService discoService
    ) {
        this.cashBackService = cashBackService;
        this.discoService = discoService;
    }


    @Override
    public void popularDadosVendaDisco(VendaDisco vendaDisco) {

        Disco disco = discoService.buscarPorId(vendaDisco.getDisco().getId());
        vendaDisco.setDisco(disco);
        vendaDisco.setValor(disco.getValor());
    }

    @Override
    public void calcularCashBack(VendaDisco vendaDisco, LocalDate dataVenda) {

        Integer porcentagemCashback = cashBackService.retornaPorcentagemCashback(
                vendaDisco.getDisco().getGenero(),
                dataVenda.getDayOfWeek());

        BigDecimal valorCashback = vendaDisco
                .getValorTotal()
                .divide(BigDecimal.valueOf(100))
                .multiply(BigDecimal.valueOf(porcentagemCashback));

        vendaDisco.setValorCashBack(valorCashback);

    }
}
