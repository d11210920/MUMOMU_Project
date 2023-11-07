package MUMOMU.mumomu_project.service;

import MUMOMU.mumomu_project.domain.Company;
import MUMOMU.mumomu_project.domain.Part_timer;
import MUMOMU.mumomu_project.repository.CompanyRepository;
import MUMOMU.mumomu_project.repository.Part_timerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CompanyService {

    public final CompanyRepository companyRepository;
    public Company findOne(Long companyId){
        return companyRepository.findOne(companyId);
    }

    public Long join(Company company) {
        companyRepository.save(company);
        return company.getId();
    }
}
