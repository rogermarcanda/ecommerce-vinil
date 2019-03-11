package br.com.ecommercevinil.service;

import br.com.ecommercevinil.model.Disco;
import br.com.ecommercevinil.model.Genero;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DiscoService{

    Page<Disco> buscarPorGenero(Genero genero, Integer numeroDaPagina, Integer qtdePorPagina);

    Boolean isDiscosDoGeneroExiste(Genero genero);

    Disco buscarPorId(Integer idDisco);

    void salvarDiscosDoGenero(List<Disco> discoList);
}
