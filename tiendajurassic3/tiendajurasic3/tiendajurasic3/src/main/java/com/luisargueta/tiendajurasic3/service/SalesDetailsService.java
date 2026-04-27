package com.luisargueta.tiendajurasic3.service;

import com.luisargueta.tiendajurasic3.entity.SalesDetails;
import com.luisargueta.tiendajurasic3.entity.User;

import java.util.List;

public interface SalesDetailsService {

    List<SalesDetails> listSalesDetails();
    SalesDetails getById(Integer id);
    SalesDetails create(SalesDetails salesDetails);
    SalesDetails update(Integer id, SalesDetails salesDetails);
    void delete(Integer id);

}
