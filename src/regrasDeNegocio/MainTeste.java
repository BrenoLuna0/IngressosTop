package regrasDeNegocio;
import java.util.ArrayList;

public class MainTeste {

	public static void main(String[] args) {
		Sessao s1 = new Sessao("15:00",40,"Vingadores Ultimato", 4);
		Sessao s2 = new Sessao("19:00",60,"Jogador Numero 1", 2);
		
		ArrayList<Sessao> sessoes = new ArrayList<Sessao>();
		
		sessoes.add(s1);
		sessoes.add(s2);
		
		Controlador c = new Controlador(sessoes);
		
		Ingresso i = c.comprar(15, s1);
		
		i.ingressoPronto();

	}

}
