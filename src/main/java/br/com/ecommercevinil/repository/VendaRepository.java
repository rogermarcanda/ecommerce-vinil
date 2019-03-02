package br.com.ecommercevinil.repository;

import br.com.ecommercevinil.model.Venda;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Integer> {

    @Query("SELECT e FROM #{#entityName} e WhERE e.data BETWEEN :dataInicial AND :dataFinal")
    List<Venda> findByBetweenData(
            @Param("dataInicial") LocalDate dataInicial,
            @Param("dataFinal") LocalDate dataFinal,
            Pageable pageable);
}
