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
@Table(name = "UserCurrentJob")
public class UserCurrentJob {

    @Id
    @GeneratedValue
    private Long id;

    private String companyName;

    private String jobName;

    private String title;

    private LocalDateTime joinedAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}
