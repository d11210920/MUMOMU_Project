package MUMOMU.mumomu_project.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;


@Embeddable
@Getter

public class Stats {
    private Long kindness;
    private Long power;
    private Long sense;
    private Long jobUnderstanding;


}
