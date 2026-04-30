package com.luisargueta.tiendajurasic3.service;

import com.luisargueta.tiendajurasic3.entity.SalesDetails;
import com.luisargueta.tiendajurasic3.exception.ResourceNotFoundException;
import com.luisargueta.tiendajurasic3.repository.SalesDetailsRepository;

import java.util.List;

public class SalesDetailsServiceImpl implements  SalesDetailsService{

    private final SalesDetailsRepository salesDetailsRepository;

    public SalesDetailsServiceImpl(SalesDetailsRepository salesDetailsRepository) {
        this.salesDetailsRepository = salesDetailsRepository;
    }

    @Override
    public List<SalesDetails> listSalesDetails() {
        return salesDetailsRepository.findAll();
    }

    @Override
    public SalesDetails getById(Integer id) {
        return salesDetailsRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
    }

    @Override
    public SalesDetails create(SalesDetails salesDetails) {
        salesDetails.setIdSalesDetails(null);
        return salesDetailsRepository.save(salesDetails);
    }

    @Override
    public SalesDetails update(Integer id, SalesDetails salesDetails) {

        SalesDetails salesDetailsExists = getById(id);

        salesDetailsExists.setQuantity(salesDetails.getQuantity());
        salesDetailsExists.setSubtotal(salesDetails.getSubtotal());
        salesDetailsExists.setUnitPrice(salesDetails.getUnitPrice());

        return salesDetailsRepository.save(salesDetailsExists);

    }

    @Override
    public void delete(Integer id) {
        if (!salesDetailsRepository.existsById(id)) {
            throw new ResourceNotFoundException("SalesDetails with ID: " + id  + " not found");
        }

        salesDetailsRepository.deleteById(id);
    }


}
