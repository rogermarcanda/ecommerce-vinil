package br.com.ecommercevinil.service;

import br.com.ecommercevinil.model.Disco;

import java.util.List;

public interface DiscoService{

    List<Disco> buscarPorGenero(Integer idGenero, Integer numeroDaPagina, Integer qtdePorPagina);

    Disco buscarPorId(Integer idDisco);
}
