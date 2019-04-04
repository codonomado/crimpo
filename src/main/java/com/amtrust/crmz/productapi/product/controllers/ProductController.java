package com.amtrust.crmz.productapi.product.controllers;

import com.amtrust.crmz.productapi.product.models.Product;
import com.amtrust.crmz.productapi.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value= "/")
    public ResponseEntity<List<Product>> index() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping(value= "/{productCode}/")
    public ResponseEntity<Product> show(@PathVariable String productCode) {
        return ResponseEntity.ok(productService.getProduct(productCode));
    }

    @GetMapping(value = "/hello-world")
    public String hello() {
        return "Hello World";
    }

    @PostMapping(value = "/")
    public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
        productService.createProduct(product);
        return null;
                //ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{productCode}").buildAndExpand(product.getProductCode()).toUri()).body(product);
    }

}
