package cliente;

public class Cliente {

    public static void main(String[] args) {
        ClientMulticast multicast = new ClientMulticast();
        ClienteUnicast unicast;

        multicast.findServer();

        System.out.println("Servidor encontrado: "+ multicast.getIpServidor()+":"+multicast.getPortaUnicast());
        
        unicast = new ClienteUnicast(multicast.getIpServidor(), multicast.getPortaUnicast());
        unicast.start();
    }



}
