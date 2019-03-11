package br.com.ecommercevinil.config;

import br.com.ecommercevinil.consumers.SpotifyConsumer;
import br.com.ecommercevinil.model.Genero;
import br.com.ecommercevinil.service.DiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DadosDiscosConfig {

    private DiscoService discoService;
    private SpotifyConsumer spotifyConsumer;

    @Autowired
    public DadosDiscosConfig(
            DiscoService discoService,
            SpotifyConsumer spotifyConsumer
    ) {
        this.discoService = discoService;
        this.spotifyConsumer = spotifyConsumer;
    }

    @Bean
    public void criarDadosIniciaisAplicacao() {
        Arrays
                .stream(Genero.values())
                .forEach(genero -> {
                    if (!discoService.isDiscosDoGeneroExiste(genero)) {
                        discoService.salvarDiscosDoGenero(
                                spotifyConsumer.recuperaAlbumSpotifyPorGenero(genero)
                        );

                    }
                });
    }
}
