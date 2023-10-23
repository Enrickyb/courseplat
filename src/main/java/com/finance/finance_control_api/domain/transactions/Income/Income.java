package com.finance.finance_control_api.domain.transactions.Income;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "income")
@Entity(name = "income")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Income  {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private String description;
    private String user_id;
    private float value;
    private String date;


    public Income(String title, String description, String user_id, float value, String date) {
        this.title = title;
        this.description = description;
        this.user_id = user_id;
        this.value = value;
        this.date = date;

    }



    @Override
    public String toString() {
        return "Income{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", user_id='" + user_id + '\'' +
                ", value='" + value + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

}
