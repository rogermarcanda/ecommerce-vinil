package br.com.ecommercevinil.controller;

import br.com.ecommercevinil.model.Disco;
import br.com.ecommercevinil.model.Venda;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/venda")
public class VendaController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Venda> buscar(
            @RequestParam(name = "numeroPagina", defaultValue = "0", required = false) Integer numeroPagina,
            @RequestParam(name = "qtdePagina", defaultValue = "10", required = false) Integer qtdePagina,
            @RequestParam(name = "dataInicial", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate dataInicial,
            @RequestParam(name = "dataFinal", required = true) @DateTimeFormat(pattern="yyyy-MM-dd" ) LocalDate dataFinal
    ) {
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{idVenda}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Venda> buscar(
            @PathVariable(name = "idVenda") Integer idDisco
    ) {
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Venda> vender(@RequestBody Venda venda){
        return ResponseEntity.status(HttpStatus.CREATED).body(venda);
    }
}
