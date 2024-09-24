package com.example.MultiLinks.Services;

import com.example.MultiLinks.Model.Url;
import com.example.MultiLinks.Repositories.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlService {

    @Autowired
    UrlRepository urlRepository;

    private String GerarUrl(){
        return UUID.randomUUID().toString().substring(0, 5);
    }


    public String EncurtarUrl(String urlOriginal){

        String urlEncurtada = GerarUrl();

        Url url = new Url();
        url.setUrlOriginal(urlOriginal);
        url.setUrlEncurtada(urlEncurtada);
        urlRepository.save(url);

        return  urlEncurtada;
    }

}
