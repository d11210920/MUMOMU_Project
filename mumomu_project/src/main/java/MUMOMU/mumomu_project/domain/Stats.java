package MUMOMU.mumomu_project.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;


@Embeddable
@Getter
public class Stats {
    private int kindness;
    private int power;
    private int sense;
    private int jobUnderstanding;

    protected Stats(){

    }
    public Stats(int kindness,int power, int sense, int jobUnderstanding ){
        this.kindness=kindness;
        this.power=power;
        this.sense=sense;
        this.jobUnderstanding=jobUnderstanding;
    }

}
