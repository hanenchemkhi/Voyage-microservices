package com.voyage.guestservice.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="credit_card")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String nameHolder;
    String number;
    String expirationDate;
    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    Guest guest;

    @Override
    public String toString() {
        return "CreditCard{" +
                "nameHolder='" + nameHolder + '\'' +
                ", number='" + number + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", guest=" + guest +
                '}';
    }
}