package com.geo.bo.web.region.controller;
/**
 * 행정지역
 */
import com.geo.bo.domain.aoi.Aoi;
import com.geo.bo.domain.region.Region;
import com.geo.bo.service.region.RegionService;
import com.geo.bo.web.aoi.dto.AoiListResponseDto;
import com.geo.bo.web.region.dto.RegionListResponseDto;
import com.geo.bo.web.region.dto.RegionRequestDto;
import com.geo.bo.web.region.dto.RegionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RegionController {
    private final RegionService regionService;

    /**
     * 행정지역 저장
     * @param requestDto
     * @return
     * @throws Exception
     */
    @PostMapping(value="/region")
    public ResponseEntity<RegionResponseDto> apiSave(@RequestBody RegionRequestDto requestDto )throws Exception{
        Long id = regionService.save(requestDto);
        return  new ResponseEntity<RegionResponseDto>(RegionResponseDto.builder().id(id).build(), new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * 행정지역 조회
     * @return
     * @throws Exception
     */
    @GetMapping("/region")
    public ResponseEntity<RegionListResponseDto> apiList()throws Exception{

        List<Region> list = regionService.list();
        return  new ResponseEntity<RegionListResponseDto>(RegionListResponseDto.builder().list(list).build(), new HttpHeaders(), HttpStatus.OK);
    }
}
