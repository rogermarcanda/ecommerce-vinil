package br.com.ecommercevinil.facede.impl;

import br.com.ecommercevinil.facede.VendaFacede;
import br.com.ecommercevinil.model.Venda;
import br.com.ecommercevinil.service.VendaService;
import br.com.ecommercevinil.service.VendaDiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaFacedeImpl implements VendaFacede {

    private VendaService vendaService;
    private VendaDiscoService vendaDiscoService;

    @Autowired
    public VendaFacedeImpl(
            VendaService vendaService,
            VendaDiscoService vendaDiscoService){
        this.vendaService = vendaService;
        this.vendaDiscoService = vendaDiscoService;
    }

    @Override
    public Venda vender(Venda venda) {
        vendaService.popularDataVenda(venda);

        venda
            .getVendaProduoList()
            .stream()
            .forEach(vendaDisco -> {
                vendaDiscoService.popularDadosVendaDisco(vendaDisco);
                vendaDiscoService.calcularCashBack(vendaDisco, venda.getData());
            }
        );

        return vendaService.save(venda);
    }
}
