package MUMOMU.mumomu_project.service;

import MUMOMU.mumomu_project.domain.*;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{
        private final EntityManager em;
        public void dbInit(){
            Company company = new Company();
            company.setCompanyName("고기집");
            company.setAddress(new Address("인천","인하로","100","인하상가 1층 고기집"));
            Owner owner = new Owner();
            owner.setName("고기집주인");
            owner.setCompany(company);

            em.persist(owner);
            em.persist(company);

            Part_timer part_timer1 = new Part_timer();
            part_timer1.setName("알바생1");
            part_timer1.setAge(20);
            part_timer1.setHope_jobType(JobType.매장관리);
            part_timer1.setHopeWage(10000);

            Part_timer part_timer2 = new Part_timer();
            part_timer2.setName("알바생2");
            part_timer2.setAge(22);
            part_timer2.setHope_jobType(JobType.배달);
            part_timer2.setHopeWage(11000);

            Part_timer part_timer3 = new Part_timer();
            part_timer3.setName("알바생3");
            part_timer3.setAge(20);
            part_timer3.setHope_jobType(JobType.포장);
            part_timer3.setHopeWage(12000);

            MatchingAlba matchingAlba1 = MatchingAlba.createMatchingAlba(company,part_timer1);
            em.persist(matchingAlba1);

        }
    }
}
