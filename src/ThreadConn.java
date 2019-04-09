import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ThreadConn extends Thread {
	private Socket socket;
	private String hostAdress;

	public ThreadConn(Socket socket, String hostAdress) {
		this.socket = socket;
		this.hostAdress = hostAdress;
	}

	public void run() {
		try {

			OutputStream os = this.socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);

			dos.flush();
			dos.writeUTF("Bem vindo ao sistema mais top de ingressos que vc respeita " + hostAdress);
			
			while(true) {
				
			}
		
		

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
