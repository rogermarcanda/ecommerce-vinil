package br.com.ecommercevinil.controller;

import br.com.ecommercevinil.model.Disco;
import br.com.ecommercevinil.service.DiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/disco")
public class DiscoController {

    private DiscoService discoService;

    @Autowired
    public DiscoController(DiscoService discoService){
        this.discoService = discoService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Disco>> buscar(
            @RequestParam(name = "numeroDaPagina", defaultValue = "0", required = false) Integer numeroDaPagina,
            @RequestParam(name = "qtdePorPagina", defaultValue = "10", required = false) Integer qtdePorPagina,
            @RequestParam(name = "idGenero", required = true) Integer idGenero
    ) {
        List<Disco> discoList = discoService.buscarPorGenero(idGenero, numeroDaPagina, qtdePorPagina);
        return ResponseEntity.ok(discoList);
    }

    @GetMapping(path = "/{idDisco}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Disco> buscar(
            @PathVariable(name = "idDisco") Integer idDisco
    ) {
        Disco disco = discoService.buscarPorId(idDisco);
        return ResponseEntity.ok().build();
    }
}
