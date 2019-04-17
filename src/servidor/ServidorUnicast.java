package servidor;

import java.net.ServerSocket;
import java.net.Socket;

public class ServidorUnicast extends Thread {
	
	private ServerSocket servidor;
	private int port;
	
	public ServidorUnicast(int port) {
		this.port = port;
	}
	
	public void run() {
		
		try {
			
			servidor = new ServerSocket(port);
			while(true) {
				Socket conection = servidor.accept();
				System.out.println("Conexao unicast recebida");
				
				ThreadUnicast t = new ThreadUnicast(conection);
				t.start();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
