package MUMOMU.mumomu_project.controller;

import MUMOMU.mumomu_project.domain.Company;
import MUMOMU.mumomu_project.domain.MatchingAlba;
import MUMOMU.mumomu_project.domain.Part_timer;
import MUMOMU.mumomu_project.service.CompanyService;
import MUMOMU.mumomu_project.service.MatchingAlbaService;
import MUMOMU.mumomu_project.service.Part_timerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MatchingAlbaController {
    private final MatchingAlbaService matchingAlbaService;
    private final Part_timerService partTimerService;
    private final CompanyService companyService;

    @GetMapping(value="/part_timer/{id}")
    public Part_timer getPartTimerOne(@PathVariable Long id){
        Part_timer one = partTimerService.findOne(id);
        return one;
    }

    public List<Part_timer> getPartTimers(){
       List<Part_timer> partTimers =partTimerService.findPart_timers();
       return partTimers;
    }

    @PostMapping(value="/matchingAlba/{partTimerId}/{companyId}")
    public MatchingAlba getMatchingAlbaForm(@PathVariable Long partTimerId, @PathVariable Long companyId){
        Map<String, Object> response  = new HashMap<>();

        MatchingAlba matchingAlba = matchingAlbaService.MatchingAlba(partTimerId, companyId);

        return matchingAlba;
    }
    //결제
}
