package br.com.tiago.restapiwithspringboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Long idCategory;

    @Column(name = "name_category", unique = true, nullable = false, length = 300)
    private String nameCategory;

    @Column(name = "description_category", nullable = false, length = 3000)
    private String descriptionCategory;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
    private Set<Product> products;
}
