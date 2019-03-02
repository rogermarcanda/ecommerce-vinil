package br.com.ecommercevinil.service.impl;

import br.com.ecommercevinil.model.Venda;
import br.com.ecommercevinil.repository.VendaRepository;
import br.com.ecommercevinil.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

public class VendaServiceImpl implements VendaService {

    private VendaRepository vendaRepository;

    @Autowired
    public VendaServiceImpl(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }


    @Override
    public Venda findById(Integer idVenda) {
        return vendaRepository
                .findById(idVenda)
                .orElseThrow(() -> new RuntimeException("Venda não encontrad"));
    }

    @Override
    public List<Venda> findByBetweenData(LocalDate dataInicial, LocalDate dataFinal, Integer numeroDaPagina, Integer qtdePorPagina) {
        Sort sort = Sort.by(Sort.Direction.DESC, "data");
        Pageable pageable = PageRequest.of(numeroDaPagina, qtdePorPagina, sort);
        return vendaRepository.findByBetweenData(dataInicial, dataFinal, pageable);
    }

    @Override
    public Venda save(Venda venda) {
        return vendaRepository.save(venda);
    }
}
