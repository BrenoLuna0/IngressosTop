package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import regrasDeNegocio.Controlador;
import regrasDeNegocio.Sessao;

public class ThreadUnicast extends Thread {
	
	Sessao s1 = new Sessao("15:00",40,"Vingadores Ultimato", 4);
	Sessao s2 = new Sessao("19:00",60,"Jogador Numero 1", 2);
	
	ArrayList<Sessao> sessoes = new ArrayList<Sessao>();
	
	
	Socket socket;
	
	public ThreadUnicast(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			sessoes.add(s1);
			sessoes.add(s2);
			
			Controlador c = new Controlador(sessoes);
			
			dos.flush();
			dos.writeUTF(c.enviarSessoes());
			
			while(true) {
				InputStream is = this.socket.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				
				String msg = dis.readUTF();
				if(msg.startsWith("c")) {
					dos.flush();
					dos.writeUTF(c.tratamento(msg));
					break;
				}
				switch(msg) {
				case "1":
					dos.flush();
					dos.writeUTF(c.enviarSessao("Vingadores Ultimato"));
					break;
					
				case "2":
					dos.flush();
					dos.writeUTF(c.enviarSessao("Jogador Numero 1")); 
					break;
					
				}
				
				
			}
			socket.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
