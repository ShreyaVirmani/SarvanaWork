package com.examples.spring.cloud.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("product-service")
public interface ProductClient {
    @RequestMapping(method = RequestMethod.GET, value = "/products")
    List<Product> getProducts();

    @RequestMapping(method = RequestMethod.PUT, value = "/products/{id}", consumes = "application/json")
    Product update(@PathVariable("id") Long id, Product product);
}
