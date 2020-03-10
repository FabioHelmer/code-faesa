package simplismente;

import dados.Item;

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

	public boolean isVazia() {
		return (this.prim == null);
	}

	public void setQuantNos(int quantNos) {
		this.quantNos = quantNos;
	}

	// aidiona na primeira posição da lista
	public void addNoComeco(Item item) {
		No novoNo = new No(item);
		if (this.quantNos == 0) {
			this.prim = novoNo;
		} else {
			novoNo.setProx(this.prim);
			this.prim = novoNo;
		}
	}

	// adiciona item na ultimo posição
	public void add(Item item) {
		No novoNo = new No(item);
		if (this.isVazia()) {
			this.prim = novoNo;
		} else {
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}

	// adiciona no k-esimA posição
	public boolean addKesimo(int k, Item elem) {
		if (this.prim == null || this.quantNos < k) {
			return false;
		} else {
			No novoNo = new No(elem);
			this.quantNos++;
			if (k == 1) {
				novoNo.setProx(this.prim);
				this.prim = novoNo;
			} else {
				No atual = this.prim;
				for (int i = 0; i < k; i++) {
					atual = atual.getProx();
				}
				novoNo.setProx(atual.getProx());
				atual.setProx(novoNo);
			}
			return true;
		}

	}

	private No pes(int index) {
		No atual = this.prim;
		if (isVazia()) {
			return atual;
		} else {
			if (!(index > this.quantNos)) {
				for (int i = 0; i < index; i++) {
					atual = atual.getProx();
				}
			}
		}
		return atual;
	}

	private No pesInfo(int k) {
		No atual = this.prim;
		if (!isVazia()) {
			while ((atual != null) && (atual.getInfo().getChave() != k)) {
				atual = atual.getProx();
			}
		}
		return atual;
	}

	// adicona valorios itens a lista
	public void add(Item... items) {
		for (Item item : items) {
			add(item);
		}
	}

	// remove da k-esima posição
	public boolean removeKesima(int k) {
		No atual = this.prim;
		No ant = null;
		if (isVazia()) {
			return false;
		} else {
			while ((atual != null) && (atual.getInfo().getChave() != k)) {
				ant = atual;
				atual = atual.getProx();
			}
			if (atual == null) {
				return false;
			} else {
				if (atual == this.prim) {
					if (this.prim == this.ult) {
						this.ult = null;
					}
					this.prim = this.prim.getProx();
				} else {
					if (atual == this.ult) {
						this.ult = ant;
					}
					ant.setProx(atual.getProx());
				}
				this.quantNos--;
				return true;

			}
		}
	}

	// mostra o conteudo da lista
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

}
