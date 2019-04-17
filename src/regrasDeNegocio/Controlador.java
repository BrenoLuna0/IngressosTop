package regrasDeNegocio;
import java.util.ArrayList;

public class Controlador {
	
	private ArrayList<Sessao> sessoes;
	
	public Controlador(ArrayList<Sessao> sessoes) {
		this.sessoes = sessoes;
	}
	
	public String enviarSessoes(){
		String msg = "";
		
		for(int i = 0; i < this.sessoes.size(); i++) {
			msg = msg.concat("Filme: " + this.sessoes.get(i).getFilme());
			msg = msg.concat("\n");
			msg = msg.concat("Sala: " + this.sessoes.get(i).getSala());
			msg = msg.concat("\n");
			msg = msg.concat("Hora : " + this.sessoes.get(i).getHora());
			msg = msg.concat("\n");
			msg = msg.concat("~~~~~~~~\n");
			
		}
		
		return msg;
	}
	
	public String enviarSessao (String filme) {
		String msg = "";
		int save = 0;
		for(int i = 0; i < this.sessoes.size(); i++) {
			if(this.sessoes.get(i).getFilme() == filme) {
				save  = i;
				break;
			}
		}
		if(save == 0 ) {
			return "Nome do filme errado. Escreva novamente";
		}else {
			
			msg = msg.concat("Cadeiras disponíveis \n");
			int j = 0;
			for(int i = 0; i < this.sessoes.get(save).cadeirasVagas().size(); i++) {
				j++;
				msg = msg.concat(this.sessoes.get(save).cadeirasVagas().get(i).toString() + " ");
				if(j == 10) {
					msg = msg.concat("\n");
					j = 0;
				}
			}
			
			return msg;
		}
		
		
	}
	
	public synchronized Ingresso comprar(int numeroCadeira, Sessao sessao) {
		
		Ingresso ingresso;
		
		if(sessao.getCadeiras().get(numeroCadeira).isDesocupada() == false) {
			System.out.println("Cadeira já esta ocupada");
			return null;
		}else {
			sessao.getCadeiras().get(numeroCadeira).setDesocupada(false);
			ingresso = new Ingresso(sessao, numeroCadeira);
			return ingresso;
		}
		
		
		
	}
	
	public Sessao pegarSessao(String filme) {
		
		String msg = "";
		int save = 0;
		for(int i = 0; i < this.sessoes.size(); i++) {
			if(this.sessoes.get(i).getFilme() == filme) {
				save  = i;
				break;
			}
		}
		return this.sessoes.get(save);
	}
	
	public String tratamento (String completa) {
		Ingresso i;
		Sessao s;
		String filme;
		String[] t = completa.split(",", 3);
		
		if(Integer.parseInt(t[1]) == 1) {
			filme = "Vingadores Ultimato";
		}else {
			filme = "Jogador Numero 1";
		}
		
		s = pegarSessao(filme);
		
		i = comprar(Integer.parseInt(t[2]), s);
		
		return i.ingressoPronto();
		
	}

}
