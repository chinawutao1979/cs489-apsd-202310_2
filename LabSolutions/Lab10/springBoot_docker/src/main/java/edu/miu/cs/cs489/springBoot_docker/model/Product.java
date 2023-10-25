package edu.miu.cs.cs489.springboot_docker.model;

import java.time.LocalDate;
import java.util.StringJoiner;

public class Product {
    private Long productId;
    private String name;
    private Double unitPrice;
    private Integer quantityInStock;
    private LocalDate dateSupplied;

    public Product(Long productId, String name, Double unitPrice, Integer quantityInStock, LocalDate dateSupplied) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
        this.dateSupplied = dateSupplied;
    }

    public Product() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("productId=" + productId)
                .add("name='" + name + "'")
                .add("unitPrice=" + unitPrice)
                .add("quantityInStock=" + quantityInStock)
                .add("dateSupplied=" + dateSupplied)
                .toString();
    }
}
