package com.example.jpa.demotestjpa;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue
    long id;

    String name;

    LocalDateTime joinedAt;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    List<Address> address;

    public void addAddress(Address address) {
        if (this.address == null) {
            this.address = new ArrayList<>();
        }

        this.address.add(address);
    }


}

