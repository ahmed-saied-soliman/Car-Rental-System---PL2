package carrentalsystem;

import users.NormalUser;
import users.User;

public class Confirmation {
    private static final String Email = "carrentproject2018@gmail.com";
    private static final String Password = "carrentpassword";


    public static void sellConfirmation(String Email) {
        String[] to = { "", Email };
        EmailOperation.sendMail(Confirmation.Email, Confirmation.Password, "Your Car has been sold.", to);

    }

    public static void confirmUnbookDriver(String Email) {
        String[] to = { "", Email };
        EmailOperation.sendMail(Confirmation.Email, Confirmation.Password, "The Driver has been Unbooked successfully.",
                                to);


    }

    public static void buyConfirmation(NormalUser user) {
        String Email = user.getEmail();
        String[] to = { "", Email };
        EmailOperation.sendMail(Confirmation.Email, Confirmation.Password, "You've successfully bought the Car.", to);

    }

    public static void rentConfirmation(String Email) {
        String[] to = { "", Email };
        EmailOperation.sendMail(Confirmation.Email, Confirmation.Password, "You've successfully rented the Car.", to);


    }

    public static void editConfirmation(String Email) {

        String[] to = { "", Email };
        EmailOperation.sendMail(Confirmation.Email, Confirmation.Password, "You've successfully edited your profile.",
                                to);


    }

    public static void confirmUnbookCar(User This) {
        String Email = This.getEmail();
        String[] to = { "", Email };
        EmailOperation.sendMail(Confirmation.Email, Confirmation.Password, "The Car has been successfully Unbooked .",
                                to);

    }

    public static void confirmBookingDriver(String Email) {
        String[] to = { "", Email };
        EmailOperation.sendMail(Confirmation.Email, Confirmation.Password, "You've successfully booked a driver.", to);


    }

    public static void accountConfirmation(User This) {
        String Email = This.getEmail();
        String[] to = { "", Email };
        EmailOperation.sendMail(Confirmation.Email, Confirmation.Password,
                                "Your Account has been created successfully.", to);

    }

    public static void forgetPasswordConfirmation(NormalUser user) {
        String message = "your Password is ";
        message.concat(user.getPassword());
        String Email = user.getEmail();
        String[] to = { "", Email };
        EmailOperation.sendMail(Confirmation.Email, Confirmation.Password, message, to);


    }

    public static void acceptedToSell(String confirmationEmail) {
        String[] to = { "", confirmationEmail };
        EmailOperation.sendMail(Confirmation.Email, Confirmation.Password, "The car has been approved to be soled.",
                                to);


    }

    public static void WaitingForAdminApproval(String Email) {
        String[] to = { "", Email };
        EmailOperation.sendMail(Confirmation.Email, Confirmation.Password, "Please wait for your car to be approved.",
                                to);

    }

}
