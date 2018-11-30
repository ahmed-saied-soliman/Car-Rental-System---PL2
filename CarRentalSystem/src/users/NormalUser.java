package users;

import java.io.FileInputStream;

public class NormalUser extends User {
    private FileInputStream fis;
            
            
            
    public void setfis(FileInputStream fis){
        this.fis=fis;
    } 
    public FileInputStream getfis(){
        return this.fis;
    }
}
