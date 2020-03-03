/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mario
 */
public class hiloSocket extends Thread{
    Socket conexion;
    
    hiloSocket(Socket conexion){
        this.conexion = conexion;
    }
        public void run(){
            PrintWriter salida=null; 
        try {
            System.out.println("Cliente conectado");
            //Escribir mensaje para que lo lea el cliente
            salida = new PrintWriter(conexion.getOutputStream(),true);
            salida.println("Hola. Gracias por conectarte..."+ new Date());
            
            
            
            //Obtener dirección remota del cliente conectado
            System.out.println(conexion.getRemoteSocketAddress().toString());
           
            
            //cerrar streams y conexion de socket
            salida.close();
            conexion.close();
        } catch (IOException ex) {
            Logger.getLogger(hiloSocket.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            salida.close();
        }
    }
}
