package cliente;

import util.ConexaoMulticast;

import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientMulticast {

    private int portaUnicast;
    private String ipServidor = null;
    private ConexaoMulticast conexaoMulticast = null;

    public void findServer() {
        getServerAddress();
        closeConexaoMulticast();
    }

    /**
     * Entra no grupo multicast e retorna o endereço do servidor
     * @return (No arrayList, pos0: IP, pos1: porta)
     */
    private void getServerAddress() {
        conexaoMulticast = new ConexaoMulticast();

        /*Entrar no grupo*/
        conexaoMulticast.entrarNoGrupoMulticast();

        conexaoMulticast.enviarParaGrupo("SERVIDOR?"); //Mensagem que o servidor vai ler e responder

        //Receber resposta
        while (true){
            DatagramPacket resposta = conexaoMulticast.clienteReceberResposta();

            if (resposta == null){
                conexaoMulticast.enviarParaGrupo("SERVIDOR?"); //Mensagem que o servidor vai ler e responder
                continue;
            }

            System.out.println("recebido >> ("+ resposta.getAddress() + ":" + resposta.getPort() + ") : "+ new String(resposta.getData()).trim());

            if (!(new String(resposta.getData()).trim()).equalsIgnoreCase("SERVIDOR?")){
                splitNameServer(new String(resposta.getData()).trim());
                break;
            }
        }
    }

    private void splitNameServer(String server){
        String[] endereco = server.split(":");

        setIpServidor(endereco[0]);
        setPortaUnicast(Integer.parseInt(endereco[1]));
    }

    public void closeConexaoMulticast(){
        /*Sair do grupo e fechar socket*/
        conexaoMulticast.abandonarGrupo();
        conexaoMulticast.fecharConexao();
    }

    private int setPortaUnicast(int portaUnicast) {
        return this.portaUnicast = portaUnicast;
    }

    private String setIpServidor(String ipServidor) {
        this.ipServidor = ipServidor;

        return this.ipServidor;
    }

    public int getPortaUnicast() {
        return portaUnicast;
    }

    public String getIpServidor() {
        return ipServidor;
    }
}
