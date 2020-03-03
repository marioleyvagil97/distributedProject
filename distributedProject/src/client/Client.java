/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import distributedproject.persona;

/**
 *
 * @author mario
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
         // TODO code application logic here
         Socket sc=new Socket("localhost",666);//conectarse al Server con IP/nombre y puerto
         
         //Enviar el objeto
        persona per = new persona("Juan",1.80,80.0);
        ObjectOutputStream objeto = new ObjectOutputStream(sc.getOutputStream()); 
        objeto.writeObject(per);
         
        //Cerramos el socket
        objeto.close();
       sc.close();
    }
    
}
