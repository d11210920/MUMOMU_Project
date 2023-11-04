package com.mumomu.project.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "memberId", unique = true, nullable = false)
    private Long id;

    @Column(name = "companyId")
    private Long companyId;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String phoneNum;

    @Column(length = 45, nullable = false)
    private Grade grade;
}
