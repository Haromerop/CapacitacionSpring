package com.rti.market.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "productos")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProduct;
    @Column(name = "nombre")
    private String name;
    @Column(name = "id_categoria")
    private Integer idCategory;
    @Column(name = "codigo_barras")
    private String barcode;
    @Column(name = "precio_venta")
    private Double salePrice;
    @Column(name = "cantidad_stock")
    private Integer stockQuantity;
    @Column(name = "estado")
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Category category;
}
