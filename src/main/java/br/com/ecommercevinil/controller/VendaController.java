package br.com.ecommercevinil.controller;

import br.com.ecommercevinil.model.Venda;
import br.com.ecommercevinil.service.VendaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/venda")
public class VendaController {

    private VendaService vendaService;

    public VendaController(VendaService vendaService){
        this.vendaService = vendaService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Venda>> buscar(
            @RequestParam(name = "numeroPagina", defaultValue = "0", required = false) Integer numeroDaPagina,
            @RequestParam(name = "qtdePagina", defaultValue = "10", required = false) Integer qtdePorPagina,
            @RequestParam(name = "dataInicial", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate dataInicial,
            @RequestParam(name = "dataFinal", required = true) @DateTimeFormat(pattern="yyyy-MM-dd" ) LocalDate dataFinal
    ) {
        List<Venda> vendaList = vendaService.findByBetweenData(dataInicial, dataFinal, numeroDaPagina, qtdePorPagina);
        return ResponseEntity.ok(vendaList);
    }

    @GetMapping(path = "/{idVenda}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Venda> buscar(
            @PathVariable(name = "idVenda") Integer idVenda
    ) {
        Venda venda = vendaService.findById(idVenda);
        return ResponseEntity.ok(venda);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Venda> vender(
            @RequestBody Venda venda
    ){
        Venda vendaBanco = this.vendaService.save(venda);
        return ResponseEntity.status(HttpStatus.CREATED).body(venda);
    }
}
