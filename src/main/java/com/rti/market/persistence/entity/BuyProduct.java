package com.rti.market.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "compras_productos")
@Data
public class BuyProduct {

    @EmbeddedId
    private BuyProductPK id;
    @Column(name = "cantidad")
    private Integer amount;
    @Column(name = "total")
    private Double total;
    @Column(name = "estado")
    private Boolean state;
    @ManyToOne
    @MapsId("idBuy")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Buy buy;
    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Product product;
}
