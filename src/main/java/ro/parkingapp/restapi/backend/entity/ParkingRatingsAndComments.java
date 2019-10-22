package ro.parkingapp.restapi.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "parking_rating_and_comments")
public class ParkingRatingsAndComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "parking_id", nullable = false)
    private Integer parkingId;
    @Column(name = "rating", nullable = false)
    private Double rating;
    @Column(name = "comments")
    private String comments;

    public Integer getParkingId() {
        return parkingId;
    }

    public void setParkingId(Integer parkingId) {
        this.parkingId = parkingId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
