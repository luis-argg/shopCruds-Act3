package com.luisargueta.tiendajurasic3.service;

import com.luisargueta.tiendajurasic3.entity.Product;
import com.luisargueta.tiendajurasic3.exception.ResourceNotFoundException;
import com.luisargueta.tiendajurasic3.repository.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Integer id) {
       return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID : " + id + " not found"));

    }

    @Override
    public Product create(Product product) {
        product.setIdProducto(null);

        return productRepository.save(product);

    }

    @Override
    public Product update(Integer id, Product product) {
        Product producExists = getById(id);


        producExists.setProductName(producExists.getProductName());
        producExists.setPrice(producExists.getPrice());
        producExists.setStock(producExists.getStock());

        return producExists;
    }

    @Override
    public void delete(Integer id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product with ID: " + id  + " not found");
        }

        productRepository.deleteById(id);
    }
}
