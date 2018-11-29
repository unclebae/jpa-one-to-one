package com.example.jpa.demotestjpa;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "user")
@Entity
@Table(name = "UserProfile")
public class UserProfile {

    @Id
    private Long id;

    private Integer age;
    private Integer weight;
    private Integer tall;

    private LocalDateTime createdAt;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

}
