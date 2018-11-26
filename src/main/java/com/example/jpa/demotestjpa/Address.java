package com.example.jpa.demotestjpa;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue
    Long id;

    private String name;
    private String sido;
    private String doro;
    private String detail;

    @Column(name = "userId")
    private Long userId;
}
