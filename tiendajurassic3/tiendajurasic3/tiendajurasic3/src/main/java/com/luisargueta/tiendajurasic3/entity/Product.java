package com.luisargueta.tiendajurasic3.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "product_code" , nullable = false)
    private Integer idProduct;

    @NotNull(message = "The name of the product can not be empty")
    @Column(name = "product_name", nullable = false)
    private String productName;

    @NotNull(message = "The price can not be empty")
    @Column(name = "price", nullable = false)
    private Double price;

    @NotNull(message = "The stock can not be empty")
    @Min(value = 1, message = "The stock must be greater than or equal 1")
    @Column(name = "stock", nullable = false)
    private Integer stock;


    public Product() {
    }

    public Product(Integer idProduct, String productName, Double price, Integer stock) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
