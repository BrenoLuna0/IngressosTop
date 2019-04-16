package util;

import java.io.IOException;
import java.net.*;

public class ConexaoMulticast {

    private int porta = 1234;
    private InetAddress ipGrupo = null;
    private MulticastSocket multicastSocket = null;

    public ConexaoMulticast() {}

    /**
     * Entra no grupo multicast com o ipGrupo e porta informados
     */
    public void entrarNoGrupoMulticast() {
        MulticastSocket multicastSocket = null;

        //noinspection TryWithIdenticalCatches
        try {
            this.setIpGrupo();
            multicastSocket = new MulticastSocket(this.porta);
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
     * Aguarda para receber uma resposta do grupo
     *
     * @return DatagramPacket com a resposta recebida
     */
    public DatagramPacket clienteReceberResposta(){
        byte[] buffer = new byte[1024];
        DatagramPacket recebido = new DatagramPacket(buffer, buffer.length);
        try {
            multicastSocket.setSoTimeout(3000);
            multicastSocket.receive(recebido);
        }catch (SocketTimeoutException d){
            return null;
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

    public int getPorta() {
        return porta;
    }

    public InetAddress getIpGrupo() {
        return ipGrupo;
    }

    private void setIpGrupo() {
        try {
            this.ipGrupo = InetAddress.getByName("230.231.232.233");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public MulticastSocket getMulticastSocket() {
        return multicastSocket;
    }
}
