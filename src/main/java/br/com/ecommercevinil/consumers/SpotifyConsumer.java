package br.com.ecommercevinil.consumers;

import br.com.ecommercevinil.EcommerceVinilException;
import br.com.ecommercevinil.model.Disco;
import br.com.ecommercevinil.model.Genero;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SpotifyConsumer {

    @Value("${spotify.client.id}")
    private String clientId;

    @Value("${spotify.client.secret}")
    private String clientSecret;

    public List<Disco> recuperaAlbumSpotifyPorGenero(Genero genero) {

        SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .build();

        try {
            ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();

            ClientCredentials clientCredentials = clientCredentialsRequest.execute();

            spotifyApi.setAccessToken(clientCredentials.getAccessToken());

            Paging<AlbumSimplified> albumSimplifiedPaging = spotifyApi
                    .searchAlbums(genero.name())
                    .limit(50)
                    .build()
                    .execute();

            List<Disco> discoList = new ArrayList<>();
            Arrays.stream(albumSimplifiedPaging.getItems()).forEach(albumSimplified -> {
                discoList.add(
                        Disco
                            .builder()
                            .nome(albumSimplified.getName())
                            .genero(genero)
                            .autor(albumSimplified.getArtists()[0].getName())
                            .valor(BigDecimal.valueOf(Math.random()))
                            .build()
                );
            });
            return discoList;

        } catch (SpotifyWebApiException e) {
            throw new EcommerceVinilException("Erro executar API para recuperar os dados dos discos do genero " + genero, e);
        } catch (IOException e) {
            throw new EcommerceVinilException("Erro ao invocar API para recuperar os dados dos discos do genero " + genero, e);
        }
    }
}
