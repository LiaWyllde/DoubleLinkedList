package Model;

public class No <generic> {
	
	public No <generic> proximo;
	public No <generic> anterior;
	public generic brinquedo;
	
	public No(generic b) {
		proximo = null;
		anterior = null;
		this.brinquedo = b;
	}
	
	public No <generic> getProximo() {
		return proximo;
	}
	
	public generic getBrinquedo() {
		return brinquedo;
	}
	
	public No <generic> getAnterior() {
		return anterior;
	}
	
	public void setAnterior(No <generic> newAnterior) {
		this.anterior = newAnterior;
	}
	
	public void setBrinquedo(generic newBrinquedo) {
		this.brinquedo = newBrinquedo;
	}
	
	public void setProximo(No <generic> newProximo) {
		this.proximo = newProximo;
	}
	
	
}
