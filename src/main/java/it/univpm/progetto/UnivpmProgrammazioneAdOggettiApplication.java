package it.univpm.progetto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Fa partire l'applicazione 
 */

@SpringBootApplication
public class UnivpmProgrammazioneAdOggettiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnivpmProgrammazioneAdOggettiApplication.class, args);
	}

	/**
	 * Oggetto RestTemplate utilizzato per accedere all'API Get messa a disposizione da Ticket Master
	 */
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
