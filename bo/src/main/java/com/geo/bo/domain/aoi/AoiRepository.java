package com.geo.bo.domain.aoi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AoiRepository extends JpaRepository<Aoi,Long> {
    /*
    	@Query(value="SELECT * from aoi where ST_DistanceSphere(geom, :p) < :distanceM", nativeQuery = true)
	List<Aoi> findNearWithinDistance(Point p, double distanceM);
     */
}