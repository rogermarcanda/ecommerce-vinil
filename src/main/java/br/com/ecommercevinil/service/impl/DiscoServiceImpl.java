package br.com.ecommercevinil.service.impl;

import br.com.ecommercevinil.model.Disco;
import br.com.ecommercevinil.repository.DiscoRepository;
import br.com.ecommercevinil.service.DiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class DiscoServiceImpl implements DiscoService {

    private DiscoRepository discoRepository;

    @Autowired
    public DiscoServiceImpl(DiscoRepository discoRepository){
        this.discoRepository = discoRepository;
    }

    @Override
    public List<Disco> buscarPorGenero(Integer idGenero, Integer numeroDaPagina, Integer qtdePorPagina) {
        Sort sort = Sort.by(Sort.Direction.ASC, "nome");
        Pageable pageable = PageRequest.of(numeroDaPagina, qtdePorPagina, sort);
        return discoRepository.findByGenero(idGenero, pageable);
    }
}
