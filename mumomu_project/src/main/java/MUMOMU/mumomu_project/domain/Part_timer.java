package MUMOMU.mumomu_project.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Part_timer {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "part_timer_id", unique = true)
    private Long id;

    @Column(length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Part_timer_sexuality sexuality;

   // @Column(length = 50)
   // private String education;

    @Column(nullable = false)
    private int age;

    private Double star;

    //@Column(length = 50)
    //private String membershipClass;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private JobType hope_jobType;

    @Embedded
    private Stats status;

    private int HopeWage;


   // private MatchingAlba searchAlba;

}
