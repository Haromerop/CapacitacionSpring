package com.rti.market.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
@Data
public class Buy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idBuy;
    @Column(name = "id_cliente")
    private String idCustomer;
    @Column(name = "fecha")
    private LocalDateTime date;
    @Column(name = "medio_pago")
    private String paymentMethod;
    @Column(name = "comentario")
    private String comment;
    @Column(name = "estado")
    private String state;
    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Customer customer;
    @OneToMany(mappedBy = "buy", cascade = {CascadeType.ALL})
    private List<BuyProduct> products;
}
