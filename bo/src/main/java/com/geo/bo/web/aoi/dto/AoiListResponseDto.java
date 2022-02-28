package com.geo.bo.web.aoi.dto;


import com.geo.bo.common.dto.ResponseDto;
import com.geo.bo.domain.aoi.Aoi;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class AoiListResponseDto extends ResponseDto {

    private List<Aoi> list;

    @Builder
    public AoiListResponseDto(List<Aoi> list) {
        super(null, null);
        this.list = list;
    }

    @Builder
    public AoiListResponseDto(List<Aoi> list, String resultCode, String resultMsg) {
        super(resultCode, resultMsg);
        this.list = list;
    }
}
