package br.com.ecommercevinil.service.impl;

import br.com.ecommercevinil.model.Disco;
import br.com.ecommercevinil.model.Genero;
import br.com.ecommercevinil.repository.DiscoRepository;
import br.com.ecommercevinil.service.DiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscoServiceImpl implements DiscoService {

    private DiscoRepository discoRepository;

    @Autowired
    public DiscoServiceImpl(DiscoRepository discoRepository){
        this.discoRepository = discoRepository;
    }

    @Override
    public Page<Disco> buscarPorGenero(Genero genero, Integer numeroDaPagina, Integer qtdePorPagina) {
        Sort sort = Sort.by(Sort.Direction.ASC, "nome");
        Pageable pageable = PageRequest.of(numeroDaPagina, qtdePorPagina, sort);
        return discoRepository.findByGenero(genero, pageable);
    }

    @Override
    public Boolean isDiscosDoGeneroExiste(Genero genero) {
        return discoRepository.countByGenero(genero) > 0;
    }

    @Override
    public Disco buscarPorId(Integer idDisco) {
        return discoRepository
                .findById(idDisco)
                .orElseThrow(() -> new RuntimeException("Disco não encontrad"));
    }

    @Override
    public void salvarDiscosDoGenero(List<Disco> discoList) {
        discoRepository.saveAll(discoList);
    }
}
