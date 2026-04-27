package com.luisargueta.tiendajurasic3.service;

import com.luisargueta.tiendajurasic3.entity.Sales;

import java.util.List;

public interface SalesService {

    List<Sales> listSales();
    Sales getById(Integer id);
    Sales create(Sales sales);
    Sales update(Integer id, Sales sales);
    void delete(Integer id);
}
