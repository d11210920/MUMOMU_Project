package MUMOMU.mumomu_project.repository;

import MUMOMU.mumomu_project.domain.Part_timer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class Part_timerRepository {
    private final EntityManager em;

    public void save(Part_timer part_timer){
        em.persist(part_timer);
    }

    public Part_timer findOne (Long id){
        return em.find(Part_timer.class, id);
    }

    public List<Part_timer> findAll () {return em.createQuery("select p from Part_timer p", Part_timer.class).getResultList();}

    public List<Part_timer> findByType(String hope_jopType){
        return em.createQuery("select p from Part_timer p where p.hope_jopType = :hope_jopType",
                Part_timer.class).setParameter("hope_jopType", hope_jopType).getResultList();
    }

    public List<Part_timer> findAllbyString(Part_timerSearch partTimerSearch){
        String jpql = "select p from Part_timer";

        boolean isFirstCondition = true;

        //최대 시급(직접 검색)
        if(partTimerSearch.getHopeWage()!=null){
            if(isFirstCondition){
                jpql+="where";
                isFirstCondition=false;
            }
            else{
                jpql+="and";
            }
            jpql+="p.hopeWage like :hopeWage";
        }


        //희망 직무
        if(partTimerSearch.getHope_jopType()!=null){
            if(isFirstCondition){
                jpql+="where";
                isFirstCondition=false;
            }
            else{
                jpql+="and";
            }
            jpql +="p.hope_jobType =hope_jobType";
        }

        //최대 거리

        //거리,경험등 정렬


        TypedQuery<Part_timer> query = em.createQuery(jpql, Part_timer.class).setMaxResults(1000);

        if(partTimerSearch.getHope_jopType()!=null){
            query=query.setParameter("hope_jobType", partTimerSearch.getHope_jopType());

        }
        if(partTimerSearch.getHopeWage()!=null){
            query=query.setParameter("hopeWage",partTimerSearch.getHopeWage());
        }
        return query.getResultList();

    }


}
