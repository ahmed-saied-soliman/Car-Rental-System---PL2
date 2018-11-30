package carrentalsystem;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageHandling {

    public static FileInputStream ReadImage() {
        JFileChooser picchooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "png");
        picchooser.setFileFilter(filter);
        picchooser.setDialogTitle("Select Image");
        picchooser.showOpenDialog(null);
        File pic = picchooser.getSelectedFile();
        String path = pic.getAbsolutePath();
        path = path.replace('\\', '/');
        File image = new File(path);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(image);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImageHandling.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fis;
    }

    public static void SaveImage(byte[] Image) {
        JFileChooser jfc = new JFileChooser();
        int retVal = jfc.showSaveDialog(null);
        if (retVal == JFileChooser.APPROVE_OPTION) {
            File f = jfc.getSelectedFile();
            FileOutputStream fos;
            try {
                fos = new FileOutputStream(f);
                fos.write(Image);
                fos.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ImageHandling.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ImageHandling.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public byte[] ToByte(byte[] byteImage) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            bos.write(byteImage);
            bos.close();
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
        return byteImage;
    }
}
