
public class Cadeira {
	private boolean ocupada;
	private boolean desocupada;
	
	public Cadeira() {
		this.desocupada = true;
		this.ocupada = false;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	public boolean isDesocupada() {
		return desocupada;
	}

	public void setDesocupada(boolean desocupada) {
		this.desocupada = desocupada;
	}
	
	

}
