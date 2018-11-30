package cars;

public class Car {
    private int CarID;
    private String Name;
    private byte[] Image;
    private String Color;
    private Engine Motor;
    private int MaxSpeed;
    private int Doors;
    private int FuelTank;
    private String CarType;
    private String CarModel;
    private String CarStatus;
    private About AboutCar;


    public Car() {
        this.CarID = 0;
        this.Name = "";
        this.Image = null;
        this.Color = "";
        this.Motor = new Engine();
        this.MaxSpeed = 0;
        this.Doors = 0;
        this.FuelTank = 0;
        this.CarType = "";
        this.CarModel = "";
        this.CarStatus = "";
        this.AboutCar = new About();
    }

    public void editCarProfile(int CarID, String Name, byte[] Image, String Color, Engine Motor, int MaxSpeed,
                               int Doors, int FuelTank, String CarType, String CarModel, String Choose,
                               About AboutCar) {
        this.CarID = CarID;
        this.Name = Name;
        this.Image = Image;
        this.Color = Color;
        this.Motor = Motor;
        this.MaxSpeed = MaxSpeed;
        this.Doors = Doors;
        this.FuelTank = FuelTank;
        this.CarType = CarType;
        this.CarModel = CarModel;
        this.CarStatus = Choose;
        this.AboutCar = AboutCar;
    }

    public void setCarID(int CarID) {
        this.CarID = CarID;
    }

    public int getCarID() {
        return CarID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public void setImage(byte[] Image) {
        this.Image = Image;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getColor() {
        return Color;
    }

    public void setMotor(Engine Motor) {
        this.Motor = Motor;
    }

    public Engine getMotor() {
        return Motor;
    }

    public void setMaxSpeed(int MaxSpeed) {
        this.MaxSpeed = MaxSpeed;
    }

    public int getMaxSpeed() {
        return MaxSpeed;
    }

    public void setDoors(int Doors) {
        this.Doors = Doors;
    }

    public int getDoors() {
        return Doors;
    }

    public void setFuelTank(int FuelTank) {
        this.FuelTank = FuelTank;
    }

    public int getFuelTank() {
        return FuelTank;
    }

    public void setCarType(String CarType) {
        this.CarType = CarType;
    }

    public String getCarType() {
        return CarType;
    }

    public void setCarModel(String CarModel) {
        this.CarModel = CarModel;
    }

    public String getCarModel() {
        return CarModel;
    }

    public void setCarStatus(String CarStatus) {
        this.CarStatus = CarStatus;
    }

    public String getCarStatus() {
        return CarStatus;
    }

    public void setAboutCar(About AboutCar) {
        this.AboutCar = AboutCar;
    }

    public About getAboutCar() {
        return AboutCar;
    }

}
