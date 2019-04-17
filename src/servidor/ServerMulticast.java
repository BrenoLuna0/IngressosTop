package servidor;

import util.ConexaoMulticast;

import java.net.*;

public class ServerMulticast extends Thread{

    private ConexaoMulticast conexaoMulticast;
    private ServidorUnicast serv;

    private void responderRequisicoes() {
        conexaoMulticast = new ConexaoMulticast();

        /*Entrar no grupo*/
        conexaoMulticast.entrarNoGrupoMulticast();

        /*Aguardar requests*/
        System.out.println("Esperando conexões multicast...");
        while (conexaoMulticast != null){
            DatagramPacket recebido = conexaoMulticast.receberResposta();

            /*Cria uma thread para tratar cada conexão*/
            ThreadConn conn = new ThreadConn(conexaoMulticast, recebido);
            conn.start();
            serv = new ServidorUnicast(Servidor.getPortaUnicast());
            serv.start();
        }
    }

    public void matarServerMulticast(){
        /*Sair do grupo e fechar socket*/
        conexaoMulticast.abandonarGrupo();
        conexaoMulticast.fecharConexao();
        conexaoMulticast = null;
    }

    @Override
    public void run() {
        responderRequisicoes();
    }
}
