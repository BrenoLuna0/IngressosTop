package servidor;

public class Servidor {

    private static final String ipUnicast = "192.168.0.178"; //TODO Definir quando mudar de rede/maquina
    private static final String ipMulticast = "230.231.232.233";
    private static final int portaUnicast = 5555;
    private static final int portaMulticast = 1234;

    public static void main(String[] args) {
        ServerMulticast serverMulticast = new ServerMulticast();
        serverMulticast.run();
    }

    public static String getIpUnicast() {
        return ipUnicast;
    }

    public static String getIpMulticast() {
        return ipMulticast;
    }

    public static int getPortaUnicast() {
        return portaUnicast;
    }

    public static int getPortaMulticast() {
        return portaMulticast;
    }
}
