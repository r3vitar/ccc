/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package droneapplication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Julian
 */
public class DroneApplication implements Runnable{
    
    public static void main(String[] args) {
		new DroneApplication().start();
	}

	String ip = "0.0.0.0";

	public void start() {
		try {
			this.socket = new Socket(ip, 80);
			new Thread(this).start();
			Scanner scanner = new Scanner(System.in);

			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                        
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	Socket socket;
	String name = "";

	@Override
	public void run() {
		try {
			DataInputStream in = new DataInputStream(socket.getInputStream());
			while (true) {
				String line = in.readUTF();
				if (line == null) {
					Thread.sleep(10);
				}else {
					messageRecieved(line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void messageRecieved(String line) {
		String[] splitted = line.split("`");
		if (!splitted[0].equals(name))
			System.out.println(splitted[0] + ":   " + splitted[1]);
	}
    
}
