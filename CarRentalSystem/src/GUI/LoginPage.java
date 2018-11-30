package GUI;

import carrentalsystem.CarRentSystemException;
import carrentalsystem.DBConnection;
import users.NormalUser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class LoginPage implements EventHandler<ActionEvent> {

    TextField EmailInput, passwordInput;
    Label Email, password,Title;
    Button login, signUp, forget;
    HBox footer;
    Stage window = new Stage();
    public LoginPage() {
        window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
                closeProgram();
            }
        });
        Image icon;
        icon = new Image(getClass().getResourceAsStream("logo.png"));
        window.getIcons().add(icon);
        window.setTitle("Login");
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("black.png")));
        imageView.setFitHeight(700);
        imageView.setFitWidth(1420);
        Title=new Label("Car Rental System");
        Email = new Label("E-Mail: ");
        password = new Label("Password: ");
        EmailInput = new TextField();
        EmailInput.setPromptText("Type Your Email...");
        passwordInput = new PasswordField();
        passwordInput.setPromptText("Type Your Password...");
        login = new Button("Login");
        login.setId("login");
        login.setOnAction(new EventHandler<ActionEvent>() {
            private NormalUser LoginUser;
            @Override
            public void handle(ActionEvent event) {
                login.setDisable(true);
                if (passwordInput.getText() != null && EmailInput.getText() != null) {
                    String Email = EmailInput.getText();
                    if (passwordInput.getText().equals("123") & Email.equals("Saied")) {
                        window.close();
                        //new AdminPage();
                        login.setDisable(false);
                    } else if (CarRentSystemException.isEmail(Email)) {
                        if (userExists(Email)) {
                            this.LoginUser = DBConnection.executeSelectUsersByEmail(Email).get(0);
                            String Password = passwordInput.getText();
                            if (LoginUser.getPassword().equals(Password)) {
                                window.close();
                                //new Profile(LoginUser);
                            } else {
                                CarRentSystemException.warningMessage("Password is not correct");
                                passwordInput.setText(null);
                                login.setDisable(false);
                            }
                        } else {
                            CarRentSystemException.warningMessage("Email isn't used");
                            EmailInput.setText(null);
                            login.setDisable(false);
                        }
                    } else {
                        CarRentSystemException.warningMessage("Enter a valid Email");
                        EmailInput.setText(null);
                        passwordInput.setText(null);
                        login.setDisable(false);
                    }
                } else if (passwordInput.getText() == null && EmailInput.getText() != null) {
                    CarRentSystemException.warningMessage("Please Enter Your Password");
                    passwordInput.setText(null);
                    login.setDisable(false);
                } else if (passwordInput.getText() != null && EmailInput.getText() == null) {
                    CarRentSystemException.warningMessage("Please Enter Your Email");
                    passwordInput.setText(null);
                    EmailInput.setText(null);
                    login.setDisable(false);

                } else {
                    CarRentSystemException.warningMessage("Enter a Valid Email and Password");
                    login.setDisable(false);
                }
            }
        });

        signUp = new Button("Sign Up >>");
        signUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.close();
                new SignUp();
            }
        });
        forget = new Button("Forgot Password");
        forget.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.close();
                //new forgetPassword();
            }
        });
        footer = new HBox();
        footer.setPadding(new Insets(5, 5, 5, 5));
        Label copyRight = new Label("all rights reserved. copyright © 2016");
        copyRight.setId("copyRight");
        footer.getChildren().add(copyRight);
        footer.setAlignment(Pos.CENTER);
        footer.setId("footer");
        GridPane glass = new GridPane();
        glass.setPadding(new Insets(20, 20, 20, 20));
        glass.setHgap(10);
        glass.setVgap(10);
        GridPane.setConstraints(Title, 1, 10);
        GridPane.setConstraints(Email, 0, 13);
        GridPane.setConstraints(EmailInput, 1, 13);
        GridPane.setConstraints(password, 0, 17);
        GridPane.setConstraints(passwordInput, 1, 17);
        GridPane.setConstraints(login, 0, 22);
        GridPane.setConstraints(forget, 1, 22);
        GridPane.setConstraints(signUp, 1, 23);
        Title.setId("Title");
        forget.setId("forget");
        signUp.setId("signUp");
        glass.setId("glass");
        glass.setMaxWidth(imageView.getFitWidth() - 60);
        glass.setMaxHeight(imageView.getFitHeight() - 40);
        glass.getChildren().addAll(Email, EmailInput, password, passwordInput, login, signUp, forget,Title);
        glass.setAlignment(Pos.CENTER);
        BorderPane layout = new BorderPane();
        layout.getChildren().addAll(imageView);
        layout.setBottom(footer);
        layout.setCenter(glass);
        layout.setId("layout");
        Scene scene = new Scene(layout);
        scene.getStylesheets().add(this.getClass().getResource("stylesheet.css").toExternalForm());
        window.setScene(scene);
        window.show();
    }

    public void closeProgram() {
        boolean result = ConfirmExit.display("Exit", "Are you sure close the Application?!");
        if (result) {
            window.close();
        }
    }

    @Override
    public void handle(ActionEvent event) {
    }

    private boolean userExists(String Email) {
        try {
            CarRentSystemException.isUserThere(Email);
            return true;
        } catch (Exception ex) {
        }
        return false;
    }
}
