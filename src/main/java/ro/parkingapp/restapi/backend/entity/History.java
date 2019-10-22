package ro.parkingapp.restapi.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "parking_history")

public class History {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "renter_user_id")
    private int renterUserId;

    @Column(name = "parking_lot_id")
    private int parkingLotId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRenterUserId() {
        return renterUserId;
    }

    public void setRenterUserId(int renterUserId) {
        this.renterUserId = renterUserId;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
}
