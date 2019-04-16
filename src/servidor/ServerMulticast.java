package servidor;

import util.Conexao;

import java.net.*;

public class ServerMulticast {

    public static void main(String[] args) {

        int porta = 1234;
        String ipGrupo = "230.231.232.233";
        Conexao conexao = new Conexao();

        /*Entrar no grupo*/
        conexao.entrarNoGrupoMulticast(porta, ipGrupo);

        /*Aguardar requests*/
        System.out.println("Esperando conexoes...");
        while (true){
            DatagramPacket recebido = conexao.receberResposta();

            /*Cria uma thread para tratar cada conexão*/
            ThreadConn conn = new ThreadConn(conexao, recebido);
            conn.start();
        }

        /*Sair do grupo e fechar socket*/
       /* conexao.abandonarGrupo();
        conexao.fecharConexao();*/

    }
}
