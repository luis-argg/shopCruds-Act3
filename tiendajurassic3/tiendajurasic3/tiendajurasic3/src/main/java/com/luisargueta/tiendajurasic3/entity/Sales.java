package com.luisargueta.tiendajurasic3.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "sale_id")
    private Integer idSale;

    @NotNull(message = "The date can not be empty")
    @Column(name = "sale_date")
    private Date saleDate;

    @NotNull(message = "The total can not be empty")
    @Column(name = "total")
    private Double total;


    public Sales() {
    }

    public Sales(Integer idSale, Double total, Date saleDate) {
        this.idSale = idSale;
        this.total = total;
        this.saleDate = saleDate;
    }

    public Integer getIdSale() {
        return idSale;
    }

    public void setIdSale(Integer idSale) {
        this.idSale = idSale;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
