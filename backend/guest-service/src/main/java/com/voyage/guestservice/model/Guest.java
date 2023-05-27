package com.voyage.guestservice.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="guest")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "address_guest",
            joinColumns = @JoinColumn(name = "guest_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id")
    )
    List<Address> addresses = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true, mappedBy = "guest")
    Set<CreditCard> creditCards = new HashSet<>();




    // Convenience method for bidirectional relationship
    public void addCreditCard(CreditCard card){
        creditCards.add(card);
        card.setGuest(this);
    }

    public void removeCreditCard(CreditCard card){
        creditCards.remove(card);
        card.setGuest(null);
    }

    public void addAddress(Address address) {
        addresses.add(address);
        address.getGuests().add(this);

    }
    public void removeAddress(Address address){
        addresses.remove(address);
        address.getGuests().add(null);
    }



    @Override
    public String toString() {
        return "Guest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", addresses=" + addresses +
                ", creditCards=" + creditCards +
                '}';
    }


}