package br.com.ecommercevinil.controller;

import br.com.ecommercevinil.model.Disco;
import br.com.ecommercevinil.model.Genero;
import br.com.ecommercevinil.service.DiscoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "/disco", tags = {"Disco"})
@RestController
@RequestMapping(path = "/disco")
public class DiscoController {

    private DiscoService discoService;

    @Autowired
    public DiscoController(DiscoService discoService){
        this.discoService = discoService;
    }

    @ApiOperation(
            value = "buscarPorGenero",
            nickname = "buscarPorGenero",
            httpMethod = "GET",
            notes = "Consultar o catálogo de discos de forma paginada, filtrando por gênero e ordenando de forma crescente pelo nome do disco")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Disco>> buscarPorGenero(
            @RequestParam(name = "numeroDaPagina", defaultValue = "0", required = false) Integer numeroDaPagina,
            @RequestParam(name = "qtdePorPagina", defaultValue = "10", required = false) Integer qtdePorPagina,
            @RequestParam(name = "genero", required = true) Genero genero
    ) {
        Page<Disco> discoList = discoService.buscarPorGenero(genero, numeroDaPagina, qtdePorPagina);
        return ResponseEntity.ok(discoList);
    }

    @GetMapping(path = "/{idDisco}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "buscarPorIdentificador",
            nickname = "buscarPorIdentificador",
            httpMethod = "GET",
            notes = "Consultar o disco pelo seu identificador")
    public ResponseEntity<Disco> buscarPorIdentificador(
            @PathVariable(name = "idDisco") Integer idDisco
    ) {
        Disco disco = discoService.buscarPorId(idDisco);
        return ResponseEntity.ok(disco);
    }
}
