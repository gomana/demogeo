package com.geo.bo.web.region.dto;

import com.geo.bo.common.dto.ResponseDto;
import com.geo.bo.domain.aoi.Aoi;
import com.geo.bo.domain.region.Region;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class RegionListResponseDto extends ResponseDto {
    private List<Region> list;

    @Builder
    public RegionListResponseDto(List<Region> list) {
        super(null, null);
        this.list = list;
    }

    @Builder
    public RegionListResponseDto(List<Region> list, String resultCode, String resultMsg) {
        super(resultCode, resultMsg);
        this.list = list;
    }
}
