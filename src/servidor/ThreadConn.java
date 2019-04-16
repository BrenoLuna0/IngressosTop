package servidor;

import util.ConexaoMulticast;

import java.net.DatagramPacket;

public class ThreadConn extends Thread {
	private ConexaoMulticast conexaoMulticast; //Conexão do lado do servidor
	private DatagramPacket dtgpct; //Primeiro datagrama recebido

	ThreadConn(ConexaoMulticast conexaoMulticast, DatagramPacket datagramPacket) {
		this.conexaoMulticast = conexaoMulticast;
		this.dtgpct = datagramPacket;
	}

	public void run() {
		try {
			if ((new String(dtgpct.getData()).trim()).equalsIgnoreCase("SERVIDOR?")){
				System.out.println("Requisição multicast recebida...");

				String resposta = Servidor.getIpUnicast()+":"+Servidor.getPortaUnicast();

				DatagramPacket resp = new DatagramPacket(resposta.getBytes(), resposta.length(), conexaoMulticast.getIpGrupo(), conexaoMulticast.getPorta());
				conexaoMulticast.responder(resp);
				System.out.println("Requisição multicast respondida...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
