package cars;

public class Engine {
    private int CC;
    private String Cylinder;
    
    public Engine(){
        this.CC=0;
        this.Cylinder="";
    }
    public void setCC(int CC) {
        this.CC = CC;
    }

    public int getCC() {
        return CC;
    }

    public void setCylinder(String Cylinder) {
        this.Cylinder = Cylinder;
    }

    public String getCylinder() {
        return Cylinder;
    }
}
