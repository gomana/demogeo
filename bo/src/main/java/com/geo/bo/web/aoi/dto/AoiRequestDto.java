package com.geo.bo.web.aoi.dto;

import com.geo.bo.common.dto.RequestDto;
import com.geo.bo.common.vo.Area;
import com.geo.bo.domain.aoi.Aoi;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Polygon;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AoiRequestDto extends RequestDto {
    private Long id;
    private String name;
    private List<Area> area;

    @Builder
    public AoiRequestDto(Long id, String name, List<Area> area) {
        this.id = id;
        this.name = name;
        this.area = area;
    }

    public Aoi toEntity(){

        GeometryFactory geometryFactory = new GeometryFactory();

        // Add road to event
        Coordinate[] coordinates = new Coordinate[area.size()];
        for (Area a :area){
            coordinates[area.indexOf(a)] = new Coordinate(a.getX(), a.getY()); // Starting point
        }
        LinearRing linear = new GeometryFactory().createLinearRing(coordinates);
        Polygon poly = new Polygon(linear, null, geometryFactory);

        return Aoi.builder()
                .id(id)
                .name(this.name)
                .area(poly)
                .build();
    }
}
