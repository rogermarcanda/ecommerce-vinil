package br.com.ecommercevinil.controller;

import br.com.ecommercevinil.model.Disco;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/disco")
public class DiscoController {


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Disco> buscar(
            @RequestParam(name = "numeroPagina", defaultValue = "0", required = false) Integer numeroPagina,
            @RequestParam(name = "qtdePagina", defaultValue = "10", required = false) Integer qtdePagina,
            @RequestParam(name = "idGenero", required = true) Integer idGenero
    ) {
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{idDisco}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Disco> buscar(
            @PathVariable(name = "idDisco") Integer idDisco
    ) {
        return ResponseEntity.ok().build();
    }
}
