package cliente;

public class Cliente {

    public static void main(String[] args) {
        ClientMulticast multicast = new ClientMulticast();

        multicast.findServer();

        System.out.println("Servidor encontrado: "+ multicast.getIpServidor()+":"+multicast.getPortaUnicast());
    }



}
