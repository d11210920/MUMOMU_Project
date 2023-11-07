package MUMOMU.mumomu_project.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Stack;

@Getter@Setter
@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "memberId", unique = true, nullable = false)
    private Long id;

    @Column(name = "companyId")
    private Long companyId;

    @OneToOne(mappedBy = "company")
    private Company company;

    @Column(length = 50, nullable = false)
    private String name;



}