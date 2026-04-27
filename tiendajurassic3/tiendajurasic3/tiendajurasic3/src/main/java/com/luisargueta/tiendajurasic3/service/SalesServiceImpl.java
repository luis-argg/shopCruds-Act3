package com.luisargueta.tiendajurasic3.service;

import com.luisargueta.tiendajurasic3.entity.Sales;
import com.luisargueta.tiendajurasic3.exception.ResourceNotFoundException;
import com.luisargueta.tiendajurasic3.repository.SalesRepostory;

import java.util.List;

public class SalesServiceImpl implements SalesService {

    private final SalesRepostory salesRepostory;

    public SalesServiceImpl(SalesRepostory salesRepostory) {
        this.salesRepostory = salesRepostory;
    }


    @Override
    public List<Sales> listSales() {
        return salesRepostory.findAll();
    }

    @Override
    public Sales getById(Integer id) {
        return salesRepostory.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id not found: " + id));
    }

    @Override
    public Sales create(Sales sales) {
        salesRepostory.setIdSale(id);
        return salesRepostory.save(sales);

    }

    @Override
    public Sales update(Integer id, Sales sales) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
