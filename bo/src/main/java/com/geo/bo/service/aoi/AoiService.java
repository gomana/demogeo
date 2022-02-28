package com.geo.bo.service.aoi;

import com.geo.bo.domain.aoi.Aoi;
import com.geo.bo.domain.aoi.AoiRepository;
import com.geo.bo.web.aoi.dto.AoiRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AoiService {
    private final AoiRepository aoiRepository;

    @Transactional
    public Long save(AoiRequestDto requestDto){
        return aoiRepository.save(requestDto.toEntity()).getId();
    }

    public List<Aoi> list(){
        return aoiRepository.findAll();
    }
}
