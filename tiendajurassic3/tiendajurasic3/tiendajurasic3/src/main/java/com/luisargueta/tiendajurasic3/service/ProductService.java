package com.luisargueta.tiendajurasic3.service;

import com.luisargueta.tiendajurasic3.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> listProducts();
    Product getById(Integer id);
    Product create(Product product);
    Product update(Integer id, Product product);
    void delete(Integer id);

}
