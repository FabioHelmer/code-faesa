package simplismente;

public class ListaSimples {
	private No prim;
	private No ult;
	private int quantNos;

	public ListaSimples() {
		this.quantNos = 0;
	}

	public No getPrim() {
		return prim;
	}

	public void setPrim(No prim) {
		this.prim = prim;
	}

	public No getUlt() {
		return ult;
	}

	public void setUlt(No ult) {
		this.ult = ult;
	}

	public int getQuantNos() {
		return quantNos;
	}

	public void setQuantNos(int quantNos) {
		this.quantNos = quantNos;
	}

}
