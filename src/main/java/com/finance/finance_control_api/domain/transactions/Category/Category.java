package com.finance.finance_control_api.domain.transactions.Category;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "category")
@Entity(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;

    public Category(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
