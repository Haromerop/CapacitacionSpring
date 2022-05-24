package com.rti.market.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategory;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "estado")
    private Boolean state;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
