package com.courseplat.courseplat.domain.transactions.Company;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "company")
@Entity(name = "company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String image;

    public Company(String name, String image) {
        this.name = name;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
