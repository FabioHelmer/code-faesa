package duplamente;

import dados.Item;

public class ListaDupla {
	private No prim;
	private No ult;
	private int quantNos;

	public ListaDupla() {
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

	public boolean isVazia() {
		return (this.quantNos == 0);
	}

	public void add(Item item) {
		No novoNo = new No(item);
		if (this.isVazia()) {
			this.prim = novoNo;
		} else {
			novoNo.setAnt(this.ult);
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}

	public void add(Item... items) {
		for (Item item : items) {
			No novoNo = new No(item);
			if (this.isVazia()) {
				this.prim = novoNo;
			} else {
				novoNo.setAnt(this.ult);
				this.ult.setProx(novoNo);
			}
			this.ult = novoNo;
			this.quantNos++;
		}

	}

	public void addInicio(Item item) {
		No novoNo = new No(item);
		if (this.quantNos == 0) {
		} else {
			novoNo.setProx(this.prim);
			this.prim.setAnt(novoNo);
			this.prim = novoNo;
		}
		this.quantNos++;
	}

	public boolean isPalindroma() {
		if (this.isVazia()) {
			return false;
		} else {
			No atualCrescente = this.prim;
			No atualDecresente = this.ult;
			String msg1 = "";
			String msg2 = "";
			for (int i = 0; i < this.quantNos; i++) {
				msg1 += atualCrescente.getInfo().getChaveChar();
				msg2 += atualDecresente.getInfo().getChaveChar();
				atualCrescente = atualCrescente.getProx();
				atualDecresente = atualDecresente.getAnt();
			}
			if (!msg1.equals(msg2))
				return false;
			return true;
		}
	}

	public void copiaLista(ListaDupla listaDupla) {
		No atual = this.prim;
		for (int i = 0; i < this.quantNos; i++) {
			if (atual.getInfo().getChave() > 1000)
				listaDupla.add(atual.getInfo());
			atual = atual.getProx();
		}
	}

	@Override
	public String toString() {
		String msg = "";
		No atual = this.prim;
		while (atual != null) {
			msg += atual.getInfo().getChave() + "\n";
			atual = atual.getProx();
		}
		return msg;
	}

	public String toStringChar() {
		String msg = "";
		No atual = this.prim;
		while (atual != null) {
			msg += atual.getInfo().getChaveChar();
			atual = atual.getProx();
		}
		return msg;
	}

}
