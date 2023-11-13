package MUMOMU.mumomu_project.service;

import MUMOMU.mumomu_project.domain.Part_timer;
import MUMOMU.mumomu_project.repository.Part_timerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class Part_timerService {

    public final Part_timerRepository partTimerRepository;
    public List<Part_timer> findPart_timers(){
        return partTimerRepository.findAll();
    }

    public Part_timer findOne(Long partTimerId){
        return partTimerRepository.findOne(partTimerId);
    }
}
