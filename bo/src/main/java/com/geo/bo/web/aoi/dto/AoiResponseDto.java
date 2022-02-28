package com.geo.bo.web.aoi.dto;


import com.geo.bo.common.dto.ResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
public class AoiResponseDto extends ResponseDto {

    private Long id;

    @Builder
    public AoiResponseDto(Long id) {
        super(null, null);
        this.id = id;
    }

    @Builder
    public AoiResponseDto(Long id, String resultCode, String resultMsg) {
        super(resultCode, resultMsg);
        this.id = id;
    }
}
