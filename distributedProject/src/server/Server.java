/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import distributedproject.persona;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import server.hiloSocket;
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
        ServerSocket ss = new ServerSocket(666);
        Socket so = null;
        ObjectInputStream entrada = null;
        System.out.println("Servidor");
        persona per = null;
        try{
            
           while(true){
               System.out.println("Esperando una conexion...");
               so = ss.accept(); 
                
                //Recibimos el objeto desde el cliente
                if(so.getInputStream()!=null){
                entrada = new ObjectInputStream(so.getInputStream());
                per = (persona)entrada.readObject();
                
                //Confirmamos que recibimos el objeto
                System.out.println("Recibi la persona con el nombre "+per.getNombre());
                }
           } 
        }finally{
            ss.close();
            so.close();
            entrada.close();
        }
    }
    
}
