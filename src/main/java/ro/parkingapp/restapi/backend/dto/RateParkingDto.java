package ro.parkingapp.restapi.backend.dto;

public class RateParkingDto {
    private Double rating;
    private String comments;

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
