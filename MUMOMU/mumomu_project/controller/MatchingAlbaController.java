package MUMOMU.mumomu_project.controller;

import MUMOMU.mumomu_project.domain.MatchingAlba;
import MUMOMU.mumomu_project.domain.Part_timer;
import MUMOMU.mumomu_project.service.MatchingAlbaService;
import MUMOMU.mumomu_project.service.Part_timerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MatchingAlbaController {
    private final MatchingAlbaService matchingAlbaService;
    private final Part_timerService partTimerService;

    @GetMapping(value="/matchingAlba")
    public String createForm(Model model){
        List<Part_timer> partTimers = partTimerService.findPart_timers();

        model.addAttribute("partTimers", partTimers);

        return "MatchingAlba/MatchingAlbaForm";
    }

}
