package servidor;

import util.Conexao;
import java.net.DatagramPacket;

public class ThreadConn extends Thread {
	private Conexao conexao;
	private DatagramPacket dtgpct;

	ThreadConn(Conexao conexao, DatagramPacket datagramPacket) {
		this.conexao = conexao;
		this.dtgpct = datagramPacket;
	}

	public void run() {
		try {
			System.out.println("recebido >> ("+ dtgpct.getAddress() + ":" + dtgpct.getPort() + ") : "+ new String(dtgpct.getData()).trim());

			String resposta = "Bem vindo ao sistema mais top de ingressos que vc respeita";

			dtgpct = new DatagramPacket(resposta.getBytes(), resposta.length(), dtgpct.getAddress(), dtgpct.getPort());
			conexao.enviarParaGrupo(dtgpct);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
