package cars;

import carrentalsystem.DBConnection;
import carrentalsystem.Feedback;


public class CarForRent extends Car {
    private int RentingID;
    private String BookedFrom;
    private String BookedTo;
    private float PricePerHour;
    private float Rate;
    private Feedback Feedback;

    public CarForRent() {
        this.RentingID = 0;
        this.BookedFrom = "";
        this.BookedTo = "";
        this.PricePerHour = 0f;
        this.Rate = 0f;
        this.Feedback=new Feedback();
    }

    public void setRentingID(int RentingID) {
        this.RentingID = RentingID;
    }

    public int getRentingID() {
        return RentingID;
    }

    public void setBookedFrom(String BookedFrom) {
        this.BookedFrom = BookedFrom;
    }

    public String getBookedFrom() {
        return BookedFrom;
    }

    public void setBookedTo(String BookedTo) {
        this.BookedTo = BookedTo;
    }

    public String getBookedTo() {
        return BookedTo;
    }

    public void setPricePerHour(float PricePerHour) {
        this.PricePerHour = PricePerHour;
    }

    public float getPricePerHour() {
        return PricePerHour;
    }

    public void setRate(float Rate) {
        this.Rate = Rate;
    }

    public float getRate() {
        return Rate;
    }

    public void setFeedback(Feedback Feedback) {
        this.Feedback = Feedback;
    }

    public Feedback getFeedback() {
        return Feedback;
    }
    public void unBookRentedCar(){
       
        }
}
