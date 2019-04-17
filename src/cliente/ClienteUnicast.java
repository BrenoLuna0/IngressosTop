package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteUnicast {
	private Socket s;
	private String address;
	private int port;
	Scanner entrada = new Scanner(System.in);
	
	public ClienteUnicast(String address, int port) {
		this.address = address;
		this.port = port;
	}
	
	public void start() {
		
		try {
			
			s = new Socket(this.address, this.port);
			while(true) {
				OutputStream os = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				
				String msg = entrada.nextLine();
				dos.flush();
				dos.writeUTF(msg);
				
				
				InputStream is = s.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				
				System.out.println(dis.readUTF());
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
