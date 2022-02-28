package com.geo.bo.web.region.controller;

import com.geo.bo.common.vo.Area;
import com.geo.bo.domain.aoi.Aoi;
import com.geo.bo.domain.region.Region;
import com.geo.bo.domain.region.RegionRepository;
import com.geo.bo.web.aoi.dto.AoiRequestDto;
import com.geo.bo.web.aoi.dto.AoiResponseDto;
import com.geo.bo.web.region.dto.RegionListResponseDto;
import com.geo.bo.web.region.dto.RegionRequestDto;
import com.geo.bo.web.region.dto.RegionResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegionControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    RegionRepository regionRepository;

    @Test
    @DisplayName("행정지역 목록")
    public void region_list() throws Exception{
        //given
        String url = "http://localhost:" + port + "/region";

        //when
        ResponseEntity<RegionListResponseDto> responseEntity = restTemplate.getForEntity(url, RegionListResponseDto.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        System.out.println(responseEntity.getBody());
        //assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    @DisplayName("행정지역 저장")
    public void region_save() throws Exception{
        //given
        List<Area> areas = new ArrayList<>();
        areas.add(new Area(126.835,37.688 ));
        areas.add(new Area(127.155 ,37.702 ));
        areas.add(new Area( 127.184, 37.474 ));
        areas.add(new Area( 126.821 , 37.454 ));
        areas.add(new Area(  126.835, 37.688));

        RegionRequestDto requestDto = RegionRequestDto.builder()
                .name("서울시2")
                .area(areas)
                .build();
        String url = "http://localhost:" + port + "/region";

        //when
        ResponseEntity<RegionResponseDto> responseEntity = restTemplate.postForEntity(url, requestDto, RegionResponseDto.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        System.out.println(responseEntity.getBody());

        List<Region> all =regionRepository.findAll();
        System.out.println(all.size());
    }
}
