package com.geo.bo.domain.aoi;


import org.junit.jupiter.api.Test;
import com.vividsolutions.jts.geom.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AoiRepositoryTest {
    @Autowired
    AoiRepository aoiRepository;

    /**
     * 관심목록 조회
     */
    @Test
    public void listAois() {
        try {

            List<Aoi> aoiList = aoiRepository.findAll();

            for (Aoi item : aoiList){
                System.err.println("-->"+item.getName());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void saveAois() {

        try {

            GeometryFactory geometryFactory = new GeometryFactory();

            // Add road to event
            Coordinate[] coordinates = new Coordinate[5];
            coordinates[0] = new Coordinate(1, 2); // Starting point
            coordinates[1] = new Coordinate(2, 20);
            coordinates[2] = new Coordinate(20, 36);
            coordinates[3] = new Coordinate(36, 100);
            coordinates[4] = new Coordinate(1, 2); // Ending point
            LinearRing linear = new GeometryFactory().createLinearRing(coordinates);
            Polygon poly = new Polygon(linear, null, geometryFactory);

            Aoi aoi = Aoi.builder().name("test01").area(poly).build();
            aoiRepository.save(aoi);

            System.out.println("new aoi: "+aoi.getId());

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void delAois() {
        try {
            aoiRepository.delete(Aoi.builder().id(3L).build());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
