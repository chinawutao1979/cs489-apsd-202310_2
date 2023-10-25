package edu.miu.cs.cs489.springboot_docker.controller;


import edu.miu.cs.cs489.springboot_docker.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = {"/prodmgmtapp/api/product"})
public class ProductController {

    public ProductController() {
    }

    @GetMapping(value = {"/list"})
    public List<Product> getProducts() {
        return List.of(
                new Product(1001L, "Apple iPhone 14XS", 1850.95, 48, LocalDate.of(2022,1,15)),
                new Product(1002L, "Samsung Galaxy S22", 1700.99, 115, LocalDate.of(2021,10,27)),
                new Product(1003L, "Google Pixel KiMax", 1350.50, 82, LocalDate.of(2022,3,19))
        );
    }
}
