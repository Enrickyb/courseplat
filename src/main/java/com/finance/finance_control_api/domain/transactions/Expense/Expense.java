package com.finance.finance_control_api.domain.transactions.Expense;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "expense")
@Entity(name = "expense")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String company_id;
    private String title;
    private String description;
    private String userId;
    private float value;
    private String date;


    public Expense(String title, String description, String user_id, String company_id, float value, String date) {

        this.title = title;
        this.description = description;
        this.userId = user_id;
        this.company_id = company_id;
        this.value = value;
        this.date = date;

    }



    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", company_id='" + company_id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", user_id='" + userId + '\'' +
                ", value='" + value + '\'' +
                ", date='" + date + '\'' +
                '}';
    }




}
