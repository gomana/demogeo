package com.geo.bo.web.aoi.controller;
/**
 * 관심지역
 */
import com.geo.bo.domain.aoi.Aoi;
import com.geo.bo.service.aoi.AoiService;
import com.geo.bo.web.aoi.dto.AoiRequestDto;
import com.geo.bo.web.aoi.dto.AoiResponseDto;
import com.geo.bo.common.controller.BaseController;
import com.geo.bo.web.aoi.dto.AoiListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AoiController extends BaseController {

    private final AoiService aoiService;

    /**
     * 관심지역 저장
     * @param requestDto
     * @return
     * @throws Exception
     */
    @PostMapping(value="/aoi")
    public ResponseEntity<AoiResponseDto> apiSave(@RequestBody AoiRequestDto requestDto )throws Exception{
        Long id = aoiService.save(requestDto);
        return  new ResponseEntity<AoiResponseDto>(AoiResponseDto.builder().id(id).build(), new HttpHeaders(), HttpStatus.OK);
    }

    /**
     *  관심지역 조회
     * @return
     * @throws Exception
     */
    @GetMapping("/aoi")
    public ResponseEntity<AoiListResponseDto> apiList()throws Exception{

        List<Aoi> list = aoiService.list();
        return  new ResponseEntity<AoiListResponseDto>(AoiListResponseDto.builder().list(list).build(), new HttpHeaders(), HttpStatus.OK);
    }


}
