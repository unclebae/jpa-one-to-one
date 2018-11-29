package com.example.jpa.demotestjpa;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
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

    @OneToOne(
            mappedBy = "user",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    UserProfile userProfile;


    @OneToOne(
            mappedBy = "user",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    UserCurrentJob userCurrentJob;

    public void addAddress(Address address) {
        if (this.address == null) {
            this.address = new ArrayList<>();
        }

        this.address.add(address);
    }

    public void setUserProfile(UserProfile userProfile) {
        if (userProfile == null) {
            if (this.userProfile != null) {
                this.userProfile.setUser(null);
            }
        } else {
            userProfile.setUser(this);
        }
        this.userProfile = userProfile;
    }

    public void setUserCurrentJob(UserCurrentJob userCurrentJob) {
        if (userCurrentJob == null) {
            if (this.userCurrentJob != null) {
                this.userCurrentJob.setUser(null);
            }
        } else {
            userCurrentJob.setUser(this);
        }
        this.userCurrentJob = userCurrentJob;
    }

}

