package com.bayraktolga.springapiserver.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;

import java.util.Date;
@Table(name = "tb_categories")
@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @CreationTimestamp
    private Date created_at;
}
