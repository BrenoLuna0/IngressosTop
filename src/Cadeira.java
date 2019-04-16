
public class Cadeira {
	private boolean desocupada;
	
	public Cadeira() {
		this.desocupada = true;
	}

	public boolean isDesocupada() {
		return desocupada;
	}
	
	public String mostrarCadeira() {
		if(this.desocupada == true) {
			return "0";
		}else {
			return "1";
		}
	}

	public void setDesocupada(boolean desocupada) {
		this.desocupada = desocupada;
	}
	
	

}
