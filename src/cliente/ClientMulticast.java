package cliente;

import util.Conexao;

import java.net.*;

public class ClientMulticast {

    public static void main(String[] args) {

        int porta = 1234;
        String ipGrupo = "230.231.232.233";
        Conexao conexao = new Conexao();

        /*Entrar no grupo*/
        conexao.entrarNoGrupoMulticast(porta, ipGrupo);

        conexao.enviarParaGrupo("msg default");

        //Receber resposta
        while (true){
            DatagramPacket resposta = conexao.receberResposta();
            System.out.println("recebido >> ("+ resposta.getAddress() + ":" + resposta.getPort() + ") : "+ new String(resposta.getData()).trim());
        }

        /*Sair do grupo e fechar socket*/
       /* conexao.abandonarGrupo();
        conexao.fecharConexao();*/

    }

}
