package com.geo.bo.domain.aoi;

import com.vividsolutions.jts.geom.Polygon;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.locationtech.jts.geom.Polygon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Aoi {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Polygon area;

    @Builder
    public Aoi(Long id, String name, Polygon area){
        this.id = id;
        this.name = name;
        this.area = area;
    }
}
