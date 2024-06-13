package com.astratech.MI2C_Anisatul.Fatikha_0320220030.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class ImdbService {
    private static final String url = "https://covid-193.p.rapidapi.com/countries";

    private static final String xRapidapiKey = "98ac22db58mshb1a15f329153af6p15fbd8jsnb5ac112396c8";

    private static final String getxRapidApiHost = "covid-193.p.rapidapi.com";

    @Autowired
    private RestTemplate restTemplate;

    public Object getAllImdbCovid() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-rapidapi-key", xRapidapiKey);
            headers.set("x-rapidapi-host", getxRapidApiHost);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,new HttpEntity<>(headers),String.class);
            log.info("Output API: {} ", response.getBody());

            return response.getBody();

        }catch (Exception e){
            log.error("Terjadi kesalahan dengan RapidAPI ", e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exeception ketika memanggil API",
                    e
            );
        }
    }
}
