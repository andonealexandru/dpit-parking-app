package ro.parkingapp.restapi.backend.dto;

public class PostHistoryDto {
    private int renterUserId;
    private int parkingLotId;

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

    public int getId() {
        return 0;
    }
}
