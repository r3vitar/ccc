/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package droneapplication;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Julian
 */
public class DroneApplication implements Runnable, changeListener{
    
    public static void main(String[] args) {
        new DroneApplication().start();
    }

    String ip = "127.0.0.1";

    public void start() {
            try {
                    this.socket = new Socket(ip, 8080);
                    new Thread(this).start();
                    Scanner scanner = new Scanner(System.in);

                    //DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            } catch (Exception e) {
                    e.printStackTrace();
            }

    }

    Socket socket;

    @Override
    public void run() {
        System.out.println("Run start");
        
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            System.out.println(in.readLine());
            String [] temp = in.readLine().split(" ");
            ArrayList<String> coordsStr = new ArrayList<String>(Arrays.asList(temp));
            int startX = Integer.parseInt(coordsStr.get(0));
            int startY = Integer.parseInt(coordsStr.get(1));
            int targetX = Integer.parseInt(coordsStr.get(2));
            int targetY = Integer.parseInt(coordsStr.get(3));
            
            Drone d = new Drone(startX, startY, targetX, targetY, this);
            d.moveToTarget(targetX, targetY);
            
            
        } catch (Exception e) {
                e.printStackTrace();
        }
        
    }    

    @Override
    public void statusChange(String str) {
        System.out.print(str);
    }
}
