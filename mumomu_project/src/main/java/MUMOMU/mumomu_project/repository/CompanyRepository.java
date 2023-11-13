package MUMOMU.mumomu_project.repository;

import MUMOMU.mumomu_project.domain.Company;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CompanyRepository {
    private final EntityManager em;

    public void save(Company company){
        em.persist(company);
    }

    public Company findOne(Long id){return em.find(Company.class, id);}
}
