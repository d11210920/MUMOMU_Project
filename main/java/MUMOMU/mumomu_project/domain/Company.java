package MUMOMU.mumomu_project.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
@Table(name = "Company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="company_id", unique = true)
    private Long id;

    @Column(length = 50)
    private String companyName;

    @Embedded
    private Address address;

    @OneToOne
    private Owner owner;

}
