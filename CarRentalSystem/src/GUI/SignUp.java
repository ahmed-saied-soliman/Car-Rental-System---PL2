package GUI;

import carrentalsystem.CarRentSystemException;
import carrentalsystem.DBConnection;
import users.NormalUser;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SignUp implements EventHandler<ActionEvent> {

    private Stage window;
    private Scene scene;
    private BorderPane layout;
    private Label LogoInHeader;
    private GridPane glass2;
    private Label copyRight, userPicture, fName, lName, username, email, password, confirmPass, phoneNumber, Age, genderLabel;
    private TextField fNameInput, lNameInput, Username, phoneNumberInput, emailInput, AgeInput;
    private PasswordField passwordInput, confirmPassInput;
    private Button browseImage, save, cancel;
    private ComboBox<String> gender;
    private HBox header, footer;
    private Image pic;
    private NormalUser NewUser;
    private String Path = "male.png";
    private ImageView Pic;

    public SignUp() {
        NewUser = new NormalUser();
        window = new Stage();
        userPicture = new Label();
        layout = new BorderPane();
        header = new HBox();
        header.setPadding(new Insets(5, 5, 5, 5));
        header.setSpacing(5);
        LogoInHeader = new Label();
        LogoInHeader.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("logo.png"))));
        header.getChildren().add(LogoInHeader);
        header.setId("header");
        save = new Button("Save");
        save.setId("blackButton");

        footer = new HBox();
        footer.setPadding(new Insets(5, 5, 5, 5));
        copyRight = new Label("all rights reserved. copyright © 2016");
        copyRight.setId("copyRight");
        footer.getChildren().add(copyRight);
        footer.setId("footer");
        footer.setAlignment(Pos.CENTER);
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("black.png")));
        imageView.setFitHeight(700);
        imageView.setFitWidth(1420);
        glass2 = new GridPane();
        glass2.setPadding(new Insets(20, 20, 20, 20));
        glass2.setVgap(10);
        glass2.setHgap(10);
        glass2.setMaxWidth(imageView.getFitWidth() - 100);
        glass2.setMaxHeight(550);
        glass2.setId("glass");
        browseImage = new Button("Choose Image");
        browseImage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser picchooser = new FileChooser();
                picchooser.setTitle("Select Image");
                picchooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
                File pics = picchooser.showOpenDialog(null);
                String pathss = pics.getAbsolutePath();
                pathss = pathss.replace('\\', '/');
                File image = new File(pathss);
                try {
                    NewUser = new NormalUser();
                    FileInputStream fis = new FileInputStream(image);
                    NewUser.setfis(fis);
//                    byte[] byteImage = null;
//                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
//                    try {
//                        bos.write(byteImage);
//                        NewUser.setImage(byteImage);
//                    } catch (IOException ex) {
//                        Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                } catch (FileNotFoundException ex) {
                    System.out.print(ex.getMessage());
                }
                try {
                    BufferedImage bufferedImage = ImageIO.read(pics);
                    pic = SwingFXUtils.toFXImage(bufferedImage, null);
                    userPicture.setBackground(new Background(new BackgroundImage(pic, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
                    Path = pics.getAbsolutePath();
                } catch (Exception ex) {
                    CarRentSystemException.warningMessage("You need to choose a picture");
                }
            }
        });
        pic = new Image(getClass().getResourceAsStream(Path));
        Pic = new ImageView(pic);
        Background back = new Background(new BackgroundImage(pic, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
        userPicture.setBackground(back);
        userPicture.setMinHeight(150);
        userPicture.setMinWidth(150);
        userPicture.setAccessibleText("type");
        fName = new Label("First Name: ");
        lName = new Label("Last Name: ");
        username = new Label("Username: ");
        email = new Label("E-mail: ");
        password = new Label("Password: ");
        confirmPass = new Label("Confirm Password: ");
        phoneNumber = new Label("PhoneNumber: ");
        Age = new Label("Age: ");
        genderLabel = new Label("Gender: ");
        fNameInput = new TextField();
        fNameInput.setPromptText("type your First Name...");
        lNameInput = new TextField();
        lNameInput.setPromptText("type your Last Name...");
        Username = new TextField();
        Username.setPromptText("type your Username...");
        emailInput = new TextField();
        emailInput.setPromptText("type your email...");
        passwordInput = new PasswordField();
        passwordInput.setPromptText("type a password...");
        confirmPassInput = new PasswordField();
        confirmPassInput.setPromptText("re-type your password...");
        phoneNumberInput = new TextField();
        phoneNumberInput.setPromptText("type your phone number...");
        AgeInput = new TextField();
        AgeInput.setPromptText("Type Your Age....");
        gender = new ComboBox<String>();
        gender.getItems().addAll("Male", "Female");
        gender.setPromptText("gender");
        ComboBox<String> paymentMethod = new ComboBox<String>();
        paymentMethod.getItems().addAll("Bank transaction", "Visa", "Cash");
        paymentMethod.setPromptText("Payment Method");
        TextField visaNumber = new TextField();
        visaNumber.setPromptText("type your visa number");
        visaNumber.setVisible(false);
        TextField visaType = new TextField();
        visaType.setPromptText("type your visa type");
        visaType.setVisible(false);
        TextField bankName = new TextField();
        bankName.setPromptText("type your bank name");
        TextField AccountNumber = new TextField();
        AccountNumber.setPromptText("type your account number");
        AccountNumber.setVisible(false);
        bankName.setVisible(false);
        cancel = new Button("Cancel");
        cancel.setId("save");
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.close();
                new LoginPage();
            }
        });
        GridPane.setConstraints(browseImage, 0, 0);
        GridPane.setConstraints(userPicture, 1, 0);
        GridPane.setConstraints(fName, 0, 1);
        GridPane.setConstraints(fNameInput, 1, 1);
        GridPane.setConstraints(lName, 0, 2);
        GridPane.setConstraints(lNameInput, 1, 2);
        GridPane.setConstraints(username, 0, 3);
        GridPane.setConstraints(Username, 1, 3);
        GridPane.setConstraints(email, 0, 4);
        GridPane.setConstraints(emailInput, 1, 4);
        GridPane.setConstraints(password, 0, 5);
        GridPane.setConstraints(passwordInput, 1, 5);
        GridPane.setConstraints(confirmPass, 0, 6);
        GridPane.setConstraints(confirmPassInput, 1, 6);
        GridPane.setConstraints(phoneNumber, 0, 7);
        GridPane.setConstraints(phoneNumberInput, 1, 7);
        GridPane.setConstraints(Age, 0, 8);
        GridPane.setConstraints(AgeInput, 1, 8);
        GridPane.setConstraints(genderLabel, 0, 9);
        GridPane.setConstraints(gender, 1, 9);
        GridPane.setConstraints(save, 2, 10);
        GridPane.setConstraints(cancel, 3, 10);
        GridPane.setConstraints(paymentMethod, 4, 0);
        GridPane.setConstraints(visaType, 4, 1);
        GridPane.setConstraints(visaNumber, 4, 2);
        GridPane.setConstraints(bankName, 4, 3);
        GridPane.setConstraints(AccountNumber, 4, 4);
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                save.setDisable(true);
                boolean check = false;
                try {
                    CarRentSystemException.mismatchString(emailInput.getText());
                    check = true;
                } catch (Exception ex) {
                    CarRentSystemException.warningMessage(ex.getMessage());
                    save.setDisable(false);
                }
                if (check) {
                    String Email = emailInput.getText();
                    if (CarRentSystemException.isEmail(Email)) {
                        boolean NotUser = false;
                        try {
                            CarRentSystemException.isUserThere(Email);
                            CarRentSystemException.warningMessage("this email is used");
                            emailInput.setText(null);
                            save.setDisable(false);
                        } catch (Exception ex) {
                            NotUser = true;
                        }
                        if (NotUser) {
                            try {
                                CarRentSystemException.mismatchString(passwordInput.getText());
                                CarRentSystemException.mismatchString(AgeInput.getText());
                                CarRentSystemException.mismatchString(confirmPassInput.getText());
                                CarRentSystemException.mismatchString(fNameInput.getText());
                                CarRentSystemException.mismatchString(lNameInput.getText());
                                CarRentSystemException.mismatchString(phoneNumberInput.getText());
                                CarRentSystemException.mismatchString(Username.getText());
                                CarRentSystemException.phoneNumberException(phoneNumberInput.getText());
                                CarRentSystemException.mismatchCheckBox(gender.getSelectionModel().getSelectedIndex());
                                String Fname = fNameInput.getText();
                                String LName = lNameInput.getText();
                                String Usernames = Username.getText();
                                int Age = Integer.parseInt(AgeInput.getText());
                                String PhoneNumber = phoneNumberInput.getText();
                                String Password = passwordInput.getText();
                                String CnonfirmPass = confirmPassInput.getText();
                                String gend;
                                int Gender = gender.getSelectionModel().getSelectedIndex();
                                if (Gender == 0) {
                                    gend = "Male";
                                } else {
                                    gend = "Female";
                                }
//                                int PaymentMethod= paymentMethod.getSelectionModel().getSelectedIndex();
//                                PaymentMethod Payment;
//                                switch (PaymentMethod) {
//                                    case 0:
//                                        Payment= new bankTransaction();
//                                        break;
//                                    case 1:
//                                        Payment=new Visa();
//                                        break;
//                                    default:
//                                        Payment= new Cash();
//                                        break;
//                                }
                                if (Password.equals(CnonfirmPass)) {
                                    NewUser.setAge(Age);
                                    NewUser.setFirstName(Fname);
                                    NewUser.setLastName(LName);
                                    NewUser.setUsername(Usernames);
                                    NewUser.setEmail(Email);
                                    NewUser.setPassword(Password);
                                    NewUser.setPhone(PhoneNumber);
                                    NewUser.setUserGender(gend);
                                    DBConnection.executeInsertUser(NewUser);
                                    CarRentSystemException.warningMessage("You created account successfuly");
                                    window.close();
                                    save.setDisable(false);
                                    new LoginPage();
                                } else {
                                    CarRentSystemException.warningMessage("Passwords don't match");
                                    passwordInput.setText(null);
                                    confirmPassInput.setText(null);
                                    save.setDisable(false);
                                }
                            } catch (Exception e) {
                                emailInput.setText(null);
                                passwordInput.setText(null);
                                confirmPassInput.setText(null);
                                fNameInput.setText(null);
                                lNameInput.setText(null);
                                phoneNumberInput.setText(null);
                                AgeInput.setText(null);
                                Username.setText(null);
                                save.setDisable(false);
                                CarRentSystemException.warningMessage(e.getMessage());
                            }
                        }
                    } else {
                        CarRentSystemException.warningMessage("Please Enter a valid Email");
                        emailInput.setText(null);
                        passwordInput.setText(null);
                        confirmPassInput.setText(null);
                        fNameInput.setText(null);
                        lNameInput.setText(null);
                        phoneNumberInput.setText(null);
                        AgeInput.setText(null);
                        save.setDisable(false);
                    }
                }
            }

        });
        glass2.getChildren().addAll(browseImage, userPicture, fName, fNameInput, lName, lNameInput, Age, AgeInput, phoneNumber, phoneNumberInput, email, emailInput, password,
                passwordInput, confirmPass, confirmPassInput, Username, username,
                genderLabel, gender, save, cancel, paymentMethod, visaType, visaNumber, bankName, AccountNumber);
        layout.getChildren().addAll(imageView);
        layout.setTop(header);
        layout.setCenter(glass2);
        layout.setBottom(footer);
        scene = new Scene(layout);
        scene.getStylesheets().add(this.getClass().getResource("stylesheet.css").toExternalForm());
        window.setScene(scene);
        window.show();
        window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
                closeProgram();
            }
        });

    }

    @Override
    public void handle(ActionEvent event) {

    }

    public void closeProgram() {
        boolean result = ConfirmExit.display("Exit", "Are you sure close the Application?!");
        if (result) {
            window.close();
        }

    }
}
