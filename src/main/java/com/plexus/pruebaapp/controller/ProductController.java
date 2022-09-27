package com.plexus.pruebaapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plexus.pruebaapp.model.ProductDetail;
import com.plexus.pruebaapp.model.SimilarProducts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Value("${base.port.mock}")
    private String port;
    @Value("${base.url.mock}")
    private String baseurlMock;
    private static RestTemplate restTemplate;

    @GetMapping("/{productId}")
    public ProductDetail getProduct(@PathVariable String productId){
        restTemplate=new RestTemplate();
        String urlMock= baseurlMock.concat(":"+port+"/product/").concat(productId);
        return restTemplate.getForObject(urlMock,ProductDetail.class);
    }

    @GetMapping("/{productId}/similarids")
    public Integer[] getProductsSimilar(@PathVariable String productId){
        restTemplate=new RestTemplate();
        String urlMock=baseurlMock.concat(":"+port+"/product/").concat(productId).concat("/similarids");
        return restTemplate.getForObject(urlMock, Integer[].class);
    }
}
