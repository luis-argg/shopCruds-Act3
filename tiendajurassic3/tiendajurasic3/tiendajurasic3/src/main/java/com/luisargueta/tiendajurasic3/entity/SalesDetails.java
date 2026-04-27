package com.luisargueta.tiendajurasic3.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "sales_details")
public class SalesDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_details")
    private Integer idSalesDetails;

    @NotNull(message = "The quantity can not be empty")
    @Column(name = "quantity")
    private Integer quantity;

    @NotNull(message = "The unit price can not be empty")
    @Column(name = "unit_price")
    private Double unitPrice;

    @NotNull(message = "The subtotal can not be empty")
    @Column(name = "subtotal")
    private Double subtotal;


    public SalesDetails() {
    }

    public SalesDetails(Integer idSalesDetails, Integer quantity, Double unitPrice, Double subtotal) {
        this.idSalesDetails = idSalesDetails;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

    public Integer getIdSalesDetails() {
        return idSalesDetails;
    }

    public void setIdSalesDetails(Integer idSalesDetails) {
        this.idSalesDetails = idSalesDetails;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}
