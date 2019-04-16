package servidor;

import util.Conexao;
import java.net.DatagramPacket;

public class ThreadConn extends Thread {
	private Conexao conexao; //Conexão do lado do servidor
	private DatagramPacket dtgpct; //Primeiro datagrama recebido

	ThreadConn(Conexao conexao, DatagramPacket datagramPacket) {
		this.conexao = conexao;
		this.dtgpct = datagramPacket;
	}

	public void run() {
		try {
			if ((new String(dtgpct.getData()).trim()).equalsIgnoreCase("SERVIDOR?")){
				System.out.println("recebido >> ("+ dtgpct.getAddress() + ":" + dtgpct.getPort() + ") : "+ new String(dtgpct.getData()).trim());

				String resposta = "Bem vindo ao sistema mais top de ingressos que vc respeita";

				DatagramPacket resp = new DatagramPacket(resposta.getBytes(), resposta.length(), dtgpct.getAddress(), dtgpct.getPort());
				conexao.responder(resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
