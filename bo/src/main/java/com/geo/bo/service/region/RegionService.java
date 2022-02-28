package com.geo.bo.service.region;

import com.geo.bo.domain.region.Region;
import com.geo.bo.domain.region.RegionRepository;
import com.geo.bo.web.region.dto.RegionRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RegionService {
    private final RegionRepository regionRepository;

    @Transactional
    public Long save(RegionRequestDto requestDto){
        return regionRepository.save(requestDto.toEntity()).getId();
    }

    public List<Region> list(){
        return regionRepository.findAll();
    }
}
