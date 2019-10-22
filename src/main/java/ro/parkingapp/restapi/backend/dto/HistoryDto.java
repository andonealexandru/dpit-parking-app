package ro.parkingapp.restapi.backend.dto;

import java.math.BigDecimal;

public class HistoryDto {

    private int renterUserId;
    private int parkingLotId;

    //ParkingRatingAndComments
    private Double rating;

    //User
    private String firstName;
    private String lastName;

    //ParkingLot
    private Byte[] photo;
    private String location;
    private BigDecimal price;
    private String startHours;
    private String endHours;

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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(Byte[] photo) {
        this.photo = photo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStartHours() {
        return startHours;
    }

    public void setStartHours(String startHours) {
        this.startHours = startHours;
    }

    public String getEndHours() {
        return endHours;
    }

    public void setEndHours(String endHours) {
        this.endHours = endHours;
    }
}
