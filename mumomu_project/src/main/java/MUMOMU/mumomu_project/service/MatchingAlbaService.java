package MUMOMU.mumomu_project.service;

import MUMOMU.mumomu_project.domain.Company;
import MUMOMU.mumomu_project.domain.MatchingAlba;
import MUMOMU.mumomu_project.domain.Part_timer;
import MUMOMU.mumomu_project.repository.CompanyRepository;
import MUMOMU.mumomu_project.repository.MatchingAlbaRepository;
import MUMOMU.mumomu_project.repository.Part_timerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MatchingAlbaService {
    private final MatchingAlbaRepository matchingAlbaRepository;
    private final Part_timerRepository partTimerRepository;
    private final CompanyRepository companyRepository;
    @Transactional
    public Long MatchingAlba(Long partTimerId, Long companyId){

        Part_timer part_timer = partTimerRepository.findOne(partTimerId);
        Company company = companyRepository.findOne(companyId);

        MatchingAlba matchingAlba = MatchingAlba.createMatchingAlba(company, part_timer);

        matchingAlbaRepository.save(matchingAlba);
        return matchingAlba.getId();

    }

    public void cancelMatching(Long matchingId){
        MatchingAlba matchingAlba = matchingAlbaRepository.findOne(matchingId);
        matchingAlba.cancel();
    }
}
