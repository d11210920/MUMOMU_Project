package MUMOMU.mumomu_project.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="companyId", unique = true, nullable = false)
    private Long id;

    @Column(length = 50, nullable = false)
    private String companyName;

    @Embedded
    private Address address;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id")
    private Owner owner;

}
