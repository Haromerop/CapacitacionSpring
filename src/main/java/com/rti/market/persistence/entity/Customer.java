package com.rti.market.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
@Data
public class Customer {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "apellidos")
    private String lastname;
    @Column(name = "celular")
    private Long mobile;
    @Column(name = "direccion")
    private String direction;
    @Column(name = "correo_electronico")
    private String email;
    @OneToMany(mappedBy = "customer")
    private List<Buy> buys;
}
