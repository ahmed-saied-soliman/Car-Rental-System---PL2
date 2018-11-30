package carrentalsystem;

import static carrentalsystem.ImageHandling.ReadImage;
import cars.About;
import cars.Car;
import cars.Engine;
import users.NormalUser;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class DBConnection {

    private static final String mySqlDriver = "com.mysql.jdbc.Driver";
    private static final String urlMySql = "jdbc:mysql://localhost:3306/carrental?autoReconnect=true&useSSL=false"; //jdbc:mysql://hostname:portNumber/databaseName
    private static Connection cnn = null;
    private static final String Username = "root";
    private static final String Password = "1234";
    private static Statement s = null;
    private static PreparedStatement ps=null;
    private static String _SQLStatement = null;
    private static ResultSet rs = null;

    public static void testDriver(String Driver) {
        System.out.println("================ Testing Driver ==================");
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=============== Driver Registered Successfully =================");
    }

    public static void testConnection(String URLDB, String Username, String Password) {
        try {

            System.out.println("=========== Start Connect To Database =============");
            cnn = DriverManager.getConnection(URLDB, Username, Password);
            System.out.println("============== Connected Successefully ==============");
            cnn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.getMessage();
        }

    }

    public static Connection TestandConnect(String Username, String Password) {
        try {
            Class.forName(mySqlDriver).newInstance();
            System.out.println("================ Testing Driver ==================");
            cnn = DriverManager.getConnection(urlMySql, Username, Password);
            System.out.println("Connected To Car Rental Database");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Not Loaded");
        } catch (IllegalAccessException | InstantiationException e) {
            System.out.println("Driver Not Loaded Retry");
        } catch (SQLException e) {
            System.out.println("Not Connected To Any DB");
        } 
        return cnn;
    }

    public static void executeCreationSchema(String SchemaName) {
        cnn = TestandConnect(Username, Password);
        try {
            ps = cnn.prepareStatement("CREATE Schema ?");
            ps.setString(1,SchemaName);
            System.out.println("Schema Created Successfully");
            ps.close();
            cnn.close();
        } catch (SQLException e) {
            System.out.println("Nothing Created " + e.getMessage());
        }
    }

    public static void executeCreationTable(String TableName) {
        cnn = TestandConnect(Username, Password);
        try {
            _SQLStatement = "CREATE TABLE ?" + "(EMP_ID INT NOT NULL,NAME VARCHAR(30),SALARY DOUBLE )";
            ps = cnn.prepareStatement(_SQLStatement); 
            ps.setString(1, TableName);
            System.out.println("Table Created Successfully");
            ps.close();
            cnn.close();
        } catch (SQLException e) {
            System.out.println("Nothing Created " + e.getMessage());
        }
    }

    public static void executeDropTable(String TableName) {
        cnn = TestandConnect(Username, Password);
        try {
            ps=cnn.prepareStatement("DROP TABLE ?");
            ps.setString(1, TableName);
            System.out.println("Table Dropped Successfully");
            ps.close();
            cnn.close();
        } catch (SQLException e) {
            System.out.println("Nothing Dropped " + e.getMessage());
        }
    }
//Insert Car

    public static void executeInsertCar(FileInputStream fis, String Color, int CC, String Cylinder, int MaxSpeed,
            int Doors, String CarType, String ModelType, String Name, String About,
            String Status) {
        cnn = TestandConnect(Username, Password);
        try {
            ps = cnn.prepareStatement("insert into Car(Image,Color,CC,Cylinder,Speed,Doors,Type,Model,Name,About,Status) values (?,?,?,?,?,?,?,?,?,?,?)");
            ps.setBinaryStream(1, fis);
            ps.setString(2, Color);
            ps.setInt(3, CC);
            ps.setString(4, Cylinder);
            ps.setInt(5, MaxSpeed);
            ps.setInt(6, Doors);
            ps.setString(7, CarType);
            ps.setString(8, ModelType);
            ps.setString(9, Name);
            ps.setString(10, About);
            ps.setString(11, Status);
            ps.executeUpdate();
            System.out.println("Row Inserted Successfully");
            ps.close();
            cnn.close();
        } catch (SQLException e) {
            System.out.println("Nothing Inserted " + e.getMessage());
        }
    }

    public static void executeDeleteCar(int ID, String TableName) {
        cnn = TestandConnect(Username, Password);
        try {
            ps = cnn.prepareStatement("Delete From ? Where Car_ID = ?");
            ps.setString(1, TableName);
            ps.setInt(2, ID);
            System.out.println("Row Deleted");
            ps.close();
            cnn.close();
        } catch (SQLException e) {
            System.out.println("Nothing Deleted " + e.getMessage());
        }

    }

    public static void executeDeleteForRentedCar(int ID, String TableName) {
        cnn = TestandConnect(Username, Password);
        try {
            ps = cnn.prepareStatement("Delete From ? Where Car_ID = ?");
            ps.setString(1, TableName);
            ps.setInt(2, ID);
            System.out.println("Deleted 1");
            ps.close();
            cnn.close();
        } catch (SQLException e) {
            System.out.println("Not Deleted " + e.getMessage());
        }

    }
//Update Car

    public static void executeUpdateCar(int ID, FileInputStream fis, String Color, int CC, String Cylinder, int MaxSpeed,
            int Doors, String CarType, String ModelType, String Name, String About,
            String Status) {
        cnn = TestandConnect(Username, Password);
        try {
            ps = cnn.prepareStatement("UPDATE Car SET Name=?,Image=?,Color=?,CC=?,Cylinder=?,MaxSpeed=?,Doors=?,CarType=?,CarModel=?,CarStatus=?,AboutCar=? Where CarID =?");
            ps.setString(1, Name);
            ps.setBinaryStream(2, fis);
            ps.setString(3, Color);
            ps.setInt(4, CC);
            ps.setString(5, Cylinder);
            ps.setInt(6, MaxSpeed);
            ps.setInt(7, Doors);
            ps.setString(8, CarType);
            ps.setString(9, ModelType);
            ps.setString(10, Status);
            ps.setString(11, About);
            ps.setInt(12, ID);
            System.out.println("Updated 1");
            ps.close();
            cnn.close();
        } catch (SQLException e) {
            System.out.println("Not Updated " + e.getMessage());
        }
    }
//Retrive All Cars

    public static ArrayList<Car> executeSelectAllCars() throws FileNotFoundException, IOException {
        ArrayList<Car> CarData = new ArrayList<Car>();
        cnn = TestandConnect(Username, Password);
        try {
            s = cnn.createStatement();
            int i = 0;
            rs = s.executeQuery("SELECT * FROM Car");
            while (rs.next()) {
                Car car1 = new Car();
                Engine Motor = new Engine();
                About AboutCar = new About();
                Blob b;
                byte[] img;
                int id = rs.getInt("CarID");
                System.out.println("Data Loaded : \nID : " + id + " " + rs.getString("CarStatus"));
                b = rs.getBlob("Image");
                img = b.getBytes(1, (int) b.length());
                Motor.setCC(rs.getInt("CC"));
                Motor.setCylinder(rs.getString("Cylinder"));
                AboutCar.setAbout(rs.getString("AboutCar"));
                car1.setCarID(id);
                car1.setColor(rs.getString("Color"));
                car1.setImage(img);
                car1.setName(rs.getString("Name"));
                car1.setDoors(rs.getInt("Doors"));
                car1.setMotor(Motor);
                car1.setMaxSpeed(rs.getInt("MaxSpeed"));
                car1.setCarType(rs.getString("CarType"));
                car1.setCarModel(rs.getString("CarModel"));
                car1.setAboutCar(AboutCar);

                if (rs.getString("CarStatus").equals("For Sell")) {
                    car1.setCarStatus("For Sell");
                } else {
                    car1.setCarStatus("For Rent");
                }
                //FileOutputStream fout=new FileOutputStream("d:\\sonoo.jpg");
                //fout.write(img);
                CarData.add(car1);
                i++;
            }
            //ps.close();
            cnn.close();
        } catch (SQLException e) {
            System.out.println("Nothing Selected " + e.getMessage());
        }
        return CarData;
    }
//Retrieve All Uers

    public static ArrayList<NormalUser> executeSelectAllUsers() {
        ArrayList<NormalUser> UserData = new ArrayList<NormalUser>();
        cnn = TestandConnect(Username, Password);
        try {
            int i = 0;
            ps = cnn.prepareStatement("SELECT * FROM User");
            rs = ps.executeQuery();
            while (rs.next()) {
                Blob b;
                byte[] img;
                NormalUser User = new NormalUser();
                User.setUserID(rs.getInt("UserID"));
                int id = rs.getInt("UserID");
                System.out.println("Data Loaded : \nID : " + id);
                User.setFirstName(rs.getString("FirstName"));
                User.setLastName(rs.getString("LastName"));
                User.setUsername(rs.getString("Username"));
                b = rs.getBlob("Image");
                img = b.getBytes(1, (int) b.length());
                User.setImage(img);
                User.setEmail(rs.getString("Email"));
                User.setPassword(rs.getString("Password"));
                String gender = rs.getString("UserGender");
                if (gender.equals("Male")) {
                    User.setUserGender("Male");
                } else {
                    User.setUserGender("Female");
                }
                User.setAge(rs.getInt("Age"));
                User.setPhone(rs.getString("Phone"));
                String Status = rs.getString("UserStatus");
                if (Status.equals("Online")) {
                    User.setUserStatus("Online");
                } else {
                    User.setUserStatus("Offline");
                }
                String Type = rs.getString("UserType");
                if (Type.equals("Normal User")) {
                    User.setUserType("Normal User");
                } else if (Type.equals("Driver")) {
                    User.setUserType("Driver");
                } else {
                    User.setUserType("Admin");
                }
                i++;
                UserData.add(User);
            }
            ps.close();
            cnn.close();
        } catch (SQLException e) {
            System.out.println("Nothing Selected " + e.getMessage());
        }
        return UserData;
    }

    public static ArrayList<NormalUser> executeSelectUsersByEmail(String Email) {
        cnn = TestandConnect(Username, Password);
        ArrayList<NormalUser> Users = new ArrayList<NormalUser>();
        try {
            ps = cnn.prepareStatement("SELECT * FROM User WHERE Email = ?");
            ps.setString(1, Email);
            rs = ps.executeQuery();
            while (rs.next()) {
                Blob b;
                byte[] img;
                NormalUser User = new NormalUser();
                User.setUserID(rs.getInt("UserID"));
                int id = rs.getInt("UserID");
                System.out.println("Data Loaded : \nID : " + id);
                User.setFirstName(rs.getString("FirstName"));
                User.setLastName(rs.getString("LastName"));
                User.setUsername(rs.getString("Username"));
                b = rs.getBlob("Image");
                img = b.getBytes(1, (int) b.length());
                User.setImage(img);
                User.setEmail(rs.getString("Email"));
                User.setPassword(rs.getString("Password"));
                String gender = rs.getString("UserGender");
                if (gender.equals("Male")) {
                    User.setUserGender("Male");
                } else {
                    User.setUserGender("Female");
                }
                User.setAge(rs.getInt("Age"));
                User.setPhone(rs.getString("Phone"));
                String Status = rs.getString("UserStatus");
                if (Status.equals("Online")) {
                    User.setUserStatus("Online");
                } else {
                    User.setUserStatus("Offline");
                }
                String Type = rs.getString("UserType");
                if (Type.equals("Normal User")) {
                    User.setUserType("Normal User");
                } else if (Type.equals("Driver")) {
                    User.setUserType("Driver");
                } else {
                    User.setUserType("Admin");
                }
                Users.add(User);
            }
            ps.close();
            cnn.close();
        } catch (SQLException e) {
            System.out.println("Nothing Selected " + e.getMessage());
        }
        return Users;
    }

    public static void executeInsertUser(NormalUser NewUser) {
        cnn = TestandConnect(Username, Password);
        try {
            ps = cnn.prepareStatement("insert into User(FirstName,LastName,Username,Image,Email,Password,UserGender,Age,Phone) values (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, NewUser.getFirstName());
            ps.setString(2, NewUser.getLastName());
            ps.setString(3, NewUser.getUsername());
//            FileInputStream fis=ReadImage();
            ps.setBinaryStream(4, NewUser.getfis());
            ps.setString(5, NewUser.getEmail());
            ps.setString(6, NewUser.getPassword());
            ps.setString(7, NewUser.getUserGender());
            ps.setInt(8, NewUser.getAge());
            ps.setString(9, NewUser.getPhone());
            ps.executeUpdate();
            System.out.println("Inserted Successfully");
            ps.close();
            cnn.close();
        } catch (SQLException e) {
            System.out.println("Nothing Inserted " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        try {
            Class.forName(mySqlDriver);
            cnn = DriverManager.getConnection(urlMySql, "root", "1234");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error Occured While Getting the Connection: - " + e);
        }
        return cnn;
    }
}
