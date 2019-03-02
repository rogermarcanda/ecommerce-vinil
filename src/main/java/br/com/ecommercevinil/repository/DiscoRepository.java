package br.com.ecommercevinil.repository;

import br.com.ecommercevinil.model.Disco;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscoRepository extends JpaRepository<Disco, Integer> {

    //@Query("SELECT disco FROM Disco disco WHERE disco.genero.id =:id")
    List<Disco> findByGenero(Integer idGenero, Pageable pageable);
}
