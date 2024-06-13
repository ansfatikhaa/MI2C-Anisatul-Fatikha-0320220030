package com.astratech.MI2C_Anisatul.Fatikha_0320220030.Controller;

import com.astratech.MI2C_Anisatul.Fatikha_0320220030.Service.ImdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imdb")
public class ImdbController {

    @Autowired
    private final ImdbService imbdService;

    public ImdbController(ImdbService imbdService){
        this.imbdService = imbdService;
    }

    @GetMapping("/getAllCovid")
    public ResponseEntity<?> callImdbFilm(){
        return ResponseEntity.ok(imbdService.getAllImdbCovid());
    }

}

