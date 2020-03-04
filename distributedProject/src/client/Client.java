
package client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import distributedproject.persona;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 *
 * @author mario
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Creamos las variables necesarias para enviar el archivo
         DataInputStream dis;
         BufferedInputStream bis;
         BufferedOutputStream bos;
         int i;
         byte[] byteArray;
         String ruta = "C:\\practica distribuidos\\enviar.json";
         
               
         try{
           File archivo = new File(ruta);
           Socket sc=new Socket("localhost",666);
           bis = new BufferedInputStream(new FileInputStream(archivo));
           bos = new BufferedOutputStream(sc.getOutputStream());
           
           //Leemos el archivo a enviar
            byteArray=new byte[(int)archivo.length()];
            bis.read(byteArray, 0, byteArray.length);
            
             /** now that the file is read, we write it on our socket **/
            /** instead of object streams or files streams we build a generic outputstream**/
            OutputStream os=sc.getOutputStream();
            os.write(byteArray, 0, byteArray.length);
            os.flush();
           
            //CLOSE
            
           //cerramos el input y output stream
           bis.close();
           bos.close();
           os.close();
           sc.close();
         }catch (Exception ex){
             System.err.println(ex);
         }
    }
    
}
