package br.com.ecommercevinil.controller;

import br.com.ecommercevinil.facede.VendaFacede;
import br.com.ecommercevinil.model.Venda;
import br.com.ecommercevinil.service.VendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/venda")
@Api(value = "/venda", tags = {"Venda"})
public class VendaController {

    private VendaService vendaService;
    private VendaFacede vendaFacede;

    @Autowired
    public VendaController(
            VendaService vendaService,
            VendaFacede vendaFacede){
        this.vendaService = vendaService;
        this.vendaFacede = vendaFacede;
    }

    @ApiOperation(
            value = "buscarPorPeriodoData",
            nickname = "buscarPorPeriodoData",
            httpMethod = "GET",
            notes = "Consultar todas as vendas efetuadas de forma paginada, " +
                    " filtrando pelo range de datas (inicial e final) da venda " +
                    " e ordenando de forma decrescente pela data da venda"
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Venda>> buscarPorPeriodoData(
            @RequestParam(name = "numeroPagina", defaultValue = "0", required = false) Integer numeroDaPagina,
            @RequestParam(name = "qtdePagina", defaultValue = "10", required = false) Integer qtdePorPagina,
            @RequestParam(name = "dataInicial", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate dataInicial,
            @RequestParam(name = "dataFinal", required = true) @DateTimeFormat(pattern="yyyy-MM-dd" ) LocalDate dataFinal
    ) {
        Page<Venda> vendaList = vendaService.findByBetweenData(dataInicial, dataFinal, numeroDaPagina, qtdePorPagina);
        return ResponseEntity.ok(vendaList);
    }

    @ApiOperation(
            value = "buscarPorIdentificador",
            nickname = "buscarPorIdentificador",
            httpMethod = "GET",
            notes = "Consultar uma venda pelo seu identificador"
    )
    @GetMapping(path = "/{idVenda}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Venda> buscar(
            @PathVariable(name = "idVenda") Integer idVenda
    ) {
        Venda venda = vendaService.findById(idVenda);
        return ResponseEntity.ok(venda);
    }

    @ApiOperation(
            value = "vender",
            nickname = "vender",
            httpMethod = "POST",
            notes = "Registrar uma nova venda de discos calculando o valor total de cashback considerando a tabela"
    )
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Venda> vender(
            @RequestBody Venda venda
    ){
        Venda vendaBanco = vendaFacede.vender(venda);
        return ResponseEntity.status(HttpStatus.CREATED).body(venda);
    }
}
