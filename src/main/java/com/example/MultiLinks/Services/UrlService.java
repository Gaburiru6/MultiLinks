package com.example.MultiLinks.Services;

import com.example.MultiLinks.Model.Url;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlService {

    private String GenerateUrl(){
        return UUID.randomUUID().toString().substring(0, 5);
    }

    String urlEncurtada = GenerateUrl();

}
