package MUMOMU.mumomu_project.repository;

import MUMOMU.mumomu_project.domain.MatchingAlba;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;

@Repository
@RequiredArgsConstructor
public class MatchingAlbaRepository {
    private final EntityManager em;

    public void save(MatchingAlba matchingAlba){em.persist(matchingAlba);}
    public MatchingAlba findOne(Long id){return em.find(MatchingAlba.class, id);}


}
