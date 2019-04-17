package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ThreadUnicast extends Thread {
	
	Socket socket;
	
	public ThreadUnicast(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			
			while(true) {
				InputStream is = this.socket.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				
				String msg = dis.readUTF();
				System.out.println(msg);
				
				OutputStream os = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				
				dos.flush();
				dos.writeUTF("TUDO ESTÀ FUNCIONANDO COMO PLANEJADO");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
