package br.com.caelum.ingresso.Rest;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.caelum.ingresso.model.DetalhesDoFilme;
import br.com.caelum.ingresso.model.Filme;

	@Component
	public class ImdbClient {
		
		private Logger logger = Logger.getLogger (ImdbClient.class);
		//	public Optional <DetalhesDoFilme> request (Filme filme) {
		
		public <T> Optional <T> request (Filme filme, Class<T> tClass) {
			
			RestTemplate cliente = new RestTemplate ();
			String titulo = filme.getNome().replace("", "+");
			String url = String.format ("https://imbd-fj22.herokuapp.com/imdb?title=%s", titulo);
		
			try {
				// DetalhesDoFilme detalhesDoFilme = cliente.getForObject (url, DetalhesDoFilme.class);
				//return Optional.of(detalhesDoFilme);
				return Optional.of(cliente.getForObject (url, tClass));
			} catch (RestClientException e) {
				logger.error(e.getMessage(), e);
				return Optional.empty();
			}
		}
	}
