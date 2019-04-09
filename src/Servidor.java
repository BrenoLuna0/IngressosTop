import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		try {
			ServerSocket servidor = new ServerSocket(1234);
			System.out.println("Esperando conexões...");
			
			while(true) {
				Socket conexao = servidor.accept();
				System.out.println("Conexão feita com "+ conexao.getInetAddress().getHostAddress());
				
				ThreadConn conn = new ThreadConn(conexao, conexao.getInetAddress().getHostAddress());
				conn.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
