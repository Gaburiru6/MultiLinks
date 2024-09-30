package com.example.MultiLinks.Controller;


import com.example.MultiLinks.Model.Url;
import com.example.MultiLinks.Repositories.UrlRepository;
import com.example.MultiLinks.Services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/url")
public class UrlController {
     @Autowired
        private UrlService urlService;

     @Autowired
        private UrlRepository urlRepository;

    @PostMapping("/encurtadorUrl")
    public ResponseEntity<String> EncurtarUrl(@RequestBody String urlOriginal){
        String UrlEncurtada = urlService.EncurtarUrl(urlOriginal);
        return ResponseEntity.ok(UrlEncurtada);
    }

    @GetMapping("/{urlEncurtada}")
    public ResponseEntity redirecionarUrl(@PathVariable("urlEncurtada") String urlEncurtada){

       Url url= urlRepository.findByUrlEncurtada(urlEncurtada);
        HttpHeaders headers= new HttpHeaders();
        headers.setLocation(URI.create(url.getUrlOriginal()));

          if(url!=null){

              return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();

          }


         return ResponseEntity.notFound().build();
    }

}


