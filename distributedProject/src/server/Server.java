/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import distributedproject.persona;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author mario
 */
public class Server {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket ss;
        Socket so;
        DataOutputStream salida;
        BufferedInputStream bis;
        BufferedOutputStream bos;
        byte[] recibido;
        int i;
        String archivo="";
        persona per = null;
        
  
//            //write from socket onto the file
//            
//               do {
//         bytesRead =
//            sock.getInputStream().read(byteArray, current, (byteArray.length-current));
//         if(bytesRead >= 0) 
//             current += bytesRead;
//      } while(bytesRead > -1);
//            
//            bos.write(byteArray, 0, current);
//            bos.flush();
//            bos.close();
//            sock.close();
        
        try{
            ss = new ServerSocket(666);
           while(true){
               System.out.println("Esperando una conexion...");
               so = ss.accept();
               recibido = new byte[1024];
               
               int bytesRead=so.getInputStream().read(recibido, 0, recibido.length);
               i=bytesRead;
               
               
                //prepare an an output file
            FileOutputStream fos=new FileOutputStream("C:\\practica distribuidos\\recibido.json");
            bos=new BufferedOutputStream (fos);
               
                //write from socket onto the file           
               do {
         bytesRead =
            so.getInputStream().read(recibido, i, (recibido.length-i));
         if(bytesRead >= 0) 
             i += bytesRead;
      } while(bytesRead > -1);
            
            bos.write(recibido, 0, i);
            bos.flush();
            bos.close();
            so.close();
               
            } 
        }catch(Exception ex){
    System.err.println(ex);
        }
    }
    
}
