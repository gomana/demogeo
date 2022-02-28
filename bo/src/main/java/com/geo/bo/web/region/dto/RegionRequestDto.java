package com.geo.bo.web.region.dto;

import com.geo.bo.common.dto.RequestDto;
import com.geo.bo.common.vo.Area;

import com.geo.bo.domain.region.Region;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Polygon;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RegionRequestDto extends RequestDto {
    private Long id;
    private String name;
    private List<Area> area;

    @Builder
    public RegionRequestDto(Long id, String name, List<Area> area) {
        this.id = id;
        this.name = name;
        this.area = area;
    }

    public Region toEntity(){

        GeometryFactory geometryFactory = new GeometryFactory();

        // Add road to event
        Coordinate[] coordinates = new Coordinate[area.size()];
        for (Area a :area){
            coordinates[area.indexOf(a)] = new Coordinate(a.getX(), a.getY()); // Starting point
        }
        LinearRing linear = new GeometryFactory().createLinearRing(coordinates);
        Polygon poly = new Polygon(linear, null, geometryFactory);

        return Region.builder()
                .id(id)
                .name(this.name)
                .area(poly)
                .build();
    }
}
