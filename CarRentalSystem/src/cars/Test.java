package cars;

import GUI.LoginPage;
import carrentalsystem.DBConnection;
import users.NormalUser;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Test extends Application implements EventHandler<Event>{
    public static void main(String[] args) throws Exception {
        launch(args);
        //carrentalsystem.CarRentSystemException.isUserThere("ahmed@gmail.com");
//        Car car1 = new Car();
//        About AboutCar = new About();
//        Engine Motor = new Engine();
//        Motor.setCC(6000);
//        Motor.setCylinder("6*6");
//        AboutCar.setAbout("This Is A Car");
//        car1.setAboutCar(AboutCar);
//        car1.setCarStatus("For Sell");
//        car1.setCarType("SUV");
//        car1.setColor("Red");
//        car1.setDoors(4);
//        car1.setCarModel("55455F");
//        car1.setMotor(Motor);
//        car1.setMaxSpeed(400);
//        car1.setName("rolls");
//        JFileChooser picchooser = new JFileChooser();
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "png");
//        picchooser.setFileFilter(filter);
//        picchooser.setDialogTitle("Select Image");
//        picchooser.showOpenDialog(null);
//        File pic = picchooser.getSelectedFile();
//        String path = pic.getAbsolutePath();
//        path = path.replace('\\', '/');
//        File image = new File(path);
//        FileInputStream fis = new FileInputStream(image);
        //        String sql = "insert into imgtst (username,image) values (?, ?)";
        //        s = cnn.prepareStatement(sql);
        //        s.setBinaryStream(2, fis);

//        DBConnection.testDriver("com.mysql.jdbc.Driver");
//        DBConnection.testConnection("jdbc:mysql://localhost:3306/Car Rental?autoReconnect=true&useSSL=false", "root",
//                                    "1234");
//        DBConnection.TestandConnect("root","1234");
//        cnn=DBConnection.getConnection();
//        s = cnn.prepareStatement("insert into Car(Name,Image,Color,CC,Cylinder,MaxSpeed,Doors,FuelTank,CarType,CarModel,CarStatus,AboutCar) values (?,?,?,?,?,?,?,?,?,?,?,?)");
//        s.setString(1, car1.getName());
//        s.setBinaryStream(2, fis);
//        s.setString(3, car1.getColor());
//        s.setInt(4, Motor.getCC());
//        s.setString(5, Motor.getCylinder());
//        s.setInt(6, (int) car1.getMaxSpeed());
//        s.setInt(7, car1.getDoors());
//        s.setFloat(8, (float) 7.5);
//        s.setString(9, car1.getCarType());
//        s.setString(10, car1.getCarModel());
//        s.setString(11, "For Sell");
//        s.setString(12, AboutCar.getAbout());
//        s.executeUpdate();
//        s.close();
//        cnn.close();
//        ArrayList<Car> cars=new ArrayList<Car>();
//        cars=DBConnection.executeSelectAllCars();
//        System.out.println(cars.get(0).getCarID());
//        byte[] image = cars.get(0).getImage();
//        JFileChooser jfc = new JFileChooser();
//        int retVal = jfc.showSaveDialog(null);
//        if(retVal==JFileChooser.APPROVE_OPTION){
//            File f = jfc.getSelectedFile();
//            FileOutputStream fos = new FileOutputStream(f);
//            fos.write(image);
//            fos.close();
//        }
//        System.exit(0);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginPage obj=new LoginPage();
    }

    @Override
    public void handle(Event event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
