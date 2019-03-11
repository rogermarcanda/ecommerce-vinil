package br.com.ecommercevinil.repository;

import br.com.ecommercevinil.model.Cashback;
import br.com.ecommercevinil.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.DayOfWeek;

public interface CashbackRepository extends JpaRepository<Cashback, Integer> {

    @Query(value = "SELECT e FROM #{#entityName} e where e.genero = :genero AND e.diaDaSemana = :diaDaSemana")
    Cashback findByGeneroAndDiadaSemana(
            @Param("genero") Genero genero,
            @Param("diaDaSemana") DayOfWeek diaDaSemana
    );
}