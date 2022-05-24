package com.rti.market.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class BuyProductPK implements Serializable {

    @Column(name = "id_compra")
    private Integer idBuy;
    @Column(name = "id_producto")
    private Integer idProduct;
}
