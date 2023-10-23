package com.courseplat.courseplat.domain.transactions.Category_Company;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "category_company")
@Entity(name = "category_company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Category_Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String company_id;
    private String category_id;


    public Category_Company(String company_id, String category_id){
        this.company_id = company_id;
        this.category_id = category_id;
    }


    @Override
    public String toString() {
        return "Category_Company{" +
                "id='" + id + '\'' +
                ", company_id='" + company_id + '\'' +
                ", category_id='" + category_id + '\'' +
                '}';
    }




}
