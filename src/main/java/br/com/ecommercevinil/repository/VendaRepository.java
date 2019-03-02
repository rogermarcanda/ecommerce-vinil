package br.com.ecommercevinil.repository;

import br.com.ecommercevinil.model.Venda;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Integer> {

    List<Venda> findByBetweenData(LocalDate dataInicial, LocalDate dataFinal, Pageable pageable);
}
