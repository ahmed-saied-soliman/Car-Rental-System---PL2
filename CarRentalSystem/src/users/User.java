package users;

import java.io.FileInputStream;
import javax.swing.ImageIcon;

public abstract class User {
    private int UserID;
    private String FirstName;
    private String LastName;
    private String Username;
    private byte[] Image;
    private String Email;
    private String Password;
    private String Phone;
    private int Age;
    private String UserGender;
    private String UserStatus;
    private String UserType;
    
    public User(){
        this.UserID=0;
        this.FirstName="";
        this.LastName="";
        this.Username="";
        this.Image=null;
        this.Email="";
        this.Password="";
        this.Phone="";
        this.Age=0;
        this.UserGender="";
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getUsername() {
        return Username;
    }

    public void setImage(byte[] Image) {
        this.Image = Image;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEmail() {
        return Email;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPassword() {
        return Password;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getPhone() {
        return Phone;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public int getAge() {
        return Age;
    }

    public void setUserGender(String UserGender) {
        this.UserGender = UserGender;
    }

    public String getUserGender() {
        return UserGender;
    }

    public void setUserStatus(String UserStatus) {
        this.UserStatus = UserStatus;
    }

    public String getUserStatus() {
        return UserStatus;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }

    public String getUserType() {
        return UserType;
    }
}
