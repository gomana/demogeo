package com.geo.bo.web.region.dto;

import com.geo.bo.common.dto.ResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RegionResponseDto extends ResponseDto {
    private Long id;

    @Builder
    public RegionResponseDto(Long id) {
        super(null, null);
        this.id = id;
    }

    @Builder
    public RegionResponseDto(Long id, String resultCode, String resultMsg) {
        super(resultCode, resultMsg);
        this.id = id;
    }
}
