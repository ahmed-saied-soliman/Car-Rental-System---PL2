package carrentalsystem;

import users.NormalUser;

public class Feedback {
    private int FeedbackID;
    private String Feedback;
    private int FromWhom;

    public Feedback() {
        this.FeedbackID = 0;
        this.Feedback = "";
        this.FromWhom=0;
    }

    public void setFromWhom(int FromWhom) {
        this.FromWhom = FromWhom;
    }

    public int getFromWhom() {
        return FromWhom;
    }

    public void setFeedbackID(int FeedbackID) {
        this.FeedbackID = FeedbackID;
    }

    public int getFeedbackID() {
        return FeedbackID;
    }

    public void setFeedback(String Feedback) {
        this.Feedback = Feedback;
    }

    public String getFeedback() {
        return Feedback;
    }
}
