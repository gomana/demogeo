package com.geo.bo.web.aoi.controller;

import com.geo.bo.common.vo.Area;
import com.geo.bo.domain.aoi.Aoi;
import com.geo.bo.domain.aoi.AoiRepository;
import com.geo.bo.web.aoi.dto.AoiRequestDto;
import com.geo.bo.web.aoi.dto.AoiResponseDto;
import com.geo.bo.web.aoi.dto.AoiListResponseDto;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AoiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private AoiRepository aoiRepository;

    @Test
    @DisplayName("관심지역 목록")
    public void aoi_list() throws Exception{
        //given
        String url = "http://localhost:" + port + "/aoi";

        //when
        ResponseEntity<AoiListResponseDto> responseEntity = restTemplate.getForEntity(url, AoiListResponseDto.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        System.out.println(responseEntity.getBody());
        //assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    @DisplayName("관심지역 저장")
    public void aoi_save() throws Exception{
        //given
        List<Area> areas = new ArrayList<>();
        areas.add(new Area(126.835,37.688 ));
        areas.add(new Area(127.155 ,37.702 ));
        areas.add(new Area( 127.184, 37.474 ));
        areas.add(new Area( 126.821 , 37.454 ));
        areas.add(new Area(  126.835, 37.688));

        AoiRequestDto requestDto = AoiRequestDto.builder()
                .name("서울시")
                .area(areas)
                .build();
        String url = "http://localhost:" + port + "/aoi";

        //when
        ResponseEntity<AoiResponseDto> responseEntity = restTemplate.postForEntity(url, requestDto, AoiResponseDto.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        System.out.println(responseEntity.getBody());

        List<Aoi> all = aoiRepository.findAll();
        System.out.println(all.size());
    }
}
