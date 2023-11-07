package MUMOMU.mumomu_project.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MatchingAlba")
@Getter  @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MatchingAlba {
    @Id @GeneratedValue
    @Column(name = "alba_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id")
    private Company company;

    private Part_timer part_timer;

    private Long timeMoney;

    private String jobType;

    @Enumerated(EnumType.STRING)
    private MatchingStatus status;

    public void setPart_timer(Part_timer part_timer){
        this.part_timer = part_timer;
        part_timer.setSearchAlba(this);
    }


    public static MatchingAlba createMatchingAlba(Company company, Part_timer part_Timer){
        MatchingAlba MatchingAlba = new MatchingAlba();
        MatchingAlba.setCompany(company);
        MatchingAlba.setPart_timer(part_Timer);

        MatchingAlba.setStatus(MatchingStatus.match_complete);
        return MatchingAlba;
    }

    public void cancel(){
        this.setStatus(MatchingStatus.match_canceled);
    }


}
