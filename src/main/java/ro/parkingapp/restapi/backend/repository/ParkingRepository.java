package ro.parkingapp.restapi.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ro.parkingapp.restapi.backend.entity.ParkingLot;

import java.math.BigDecimal;
import java.util.List;

@RepositoryRestResource
public interface ParkingRepository extends CrudRepository<ParkingLot, Integer> {
    @Query("SELECT parkingLot.photo FROM ParkingLot parkingLot WHERE parkingLot.id=?1")
    Byte[] getParkingLotPhotoById(Integer id);

    @Query("SELECT parkingLot.location FROM ParkingLot parkingLot WHERE parkingLot.id=?1")
    String getParkingLotLocationById(Integer id);

    @Query("SELECT parkingLot.startHours FROM ParkingLot parkingLot WHERE parkingLot.id=?1")
    String getParkingLotStartHourById(Integer id);

    @Query("SELECT parkingLot.endHours FROM ParkingLot parkingLot WHERE parkingLot.id=?1")
    String getParkingLotEndHourById(Integer id);

    @Query("SELECT parkingLot.price FROM ParkingLot parkingLot WHERE parkingLot.id=?1")
    BigDecimal getParkingLotPriceById(Integer id);

    @Query("SELECT parkingLot FROM ParkingLot parkingLot WHERE parkingLot.latitude BETWEEN ?1 AND ?2 AND parkingLot.longitude BETWEEN ?3 AND ?4 AND parkingLot.available = 'Free' ")
    List<ParkingLot> getParkingLotByCoordinates(Double lat1, Double lat2, Double lng1, Double lng2);

    @Query("SELECT parkingLot FROM ParkingLot parkingLot WHERE parkingLot.ownerId=?1")
    List<ParkingLot> getParkingLotByOwnerId(Integer id);
}
