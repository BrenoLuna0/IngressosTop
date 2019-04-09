import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Cliente {
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",1234);
			
			while(true) {
				InputStream is = socket.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				
				String mensagem = dis.readUTF();
				System.out.println(mensagem);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
