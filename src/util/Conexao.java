package util;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class Conexao {

    private int porta;
    private InetAddress ipGrupo = null;
    private MulticastSocket multicastSocket = null;

    public Conexao() {}

    /**
     * Entra no grupo multicast com o ipGrupo e porta informados
     * @param porta porta de conexão do grupo
     * @param ipGrupo ip do grupo multicast
     */
    public void entrarNoGrupoMulticast(int porta, String ipGrupo) {
        MulticastSocket multicastSocket = null;

        //noinspection TryWithIdenticalCatches
        try {
            this.porta = porta;
            multicastSocket = new MulticastSocket(this.porta);

            this.ipGrupo = InetAddress.getByName(ipGrupo);
            multicastSocket.joinGroup(this.ipGrupo);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.multicastSocket = multicastSocket;
    }

    /**
     * Envia uma mensagem para o grupo
     * @param msg mensagem a ser enviada
     */
    public void enviarParaGrupo(String msg) {

        DatagramPacket request = new DatagramPacket(msg.getBytes(), msg.length(), this.ipGrupo, this.porta);

        try {
            this.multicastSocket.send(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Envia uma mensagem para o grupo
     * @param datagramPacket datagramPacket a ser enviado.
     */
    public void responder(DatagramPacket datagramPacket) {

        try {
            this.multicastSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Aguarda para receber uma resposta do grupo
     *
     * @return DatagramPacket com a resposta recebida
     */
    public DatagramPacket receberResposta(){
        byte[] buffer = new byte[1024];
        DatagramPacket recebido = new DatagramPacket(buffer, buffer.length);
        try {
            multicastSocket.receive(recebido);
        }catch (IOException e) {
            e.printStackTrace();
        }

        return recebido;
    }

    /**
     * Sai do grupo multicast atual
     */
    public void abandonarGrupo(){
        try {
            multicastSocket.leaveGroup(this.ipGrupo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fecha o socket da conexão
     */
    public void fecharConexao(){
        if (multicastSocket != null){
            multicastSocket.close();
        }
    }
}
