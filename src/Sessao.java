import java.util.ArrayList;

public class Sessao {
	private int hora;
	private int quantidadeCadeiras;
	private Cadeira[] cadeiras;
	
	
	
	public Sessao(int hora, int quantidadeCadeiras) {
		this.hora = hora;
		this.quantidadeCadeiras = quantidadeCadeiras;
		cadeiras = cadeiraGenerator(quantidadeCadeiras);
	}
	
	
	
	
	public int getHora() {
		return hora;
	}



	public void setHora(int hora) {
		this.hora = hora;
	}



	public int getQuantidadeCadeiras() {
		return quantidadeCadeiras;
	}



	public void setQuantidadeCadeiras(int quantidadeCadeiras) {
		this.quantidadeCadeiras = quantidadeCadeiras;
	}



	public Cadeira[] getCadeiras() {
		return cadeiras;
	}



	public void setCadeiras(Cadeira[] cadeiras) {
		this.cadeiras = cadeiras;
	}



	public Cadeira[] cadeiraGenerator(int quantidade) {
		Cadeira cadeiras[] = new Cadeira[quantidade];
		for(int i = 0; i < quantidade; i++) {
			cadeiras[i].setDesocupada(true);
		}
		return cadeiras;
	}
	
	public ArrayList<Integer> cadeirasVagas(){
		ArrayList<Integer> cadeirasVagas = new ArrayList<Integer>();
		for(int i = 0; i < this.quantidadeCadeiras; i++) {
			if(this.cadeiras[i].isDesocupada()) {
				cadeirasVagas.add(i);
			}
		}
		return cadeirasVagas;
	}

}
