package br.com.ecommercevinil.repository;

import br.com.ecommercevinil.model.Disco;
import br.com.ecommercevinil.model.Genero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface DiscoRepository extends JpaRepository<Disco, Integer> {

    Page<Disco> findByGenero(
            @Param("genero") Genero genero,
            Pageable pageable);

    Integer countByGenero(@Param("genero") Genero genero);
}
