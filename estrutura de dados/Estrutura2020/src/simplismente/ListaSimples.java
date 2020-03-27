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
		this.quantNos++;
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

	// adiciona no k-esima posição
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

	// pesquisa no pela posição
	public No pes(int index) {
		No atual = this.prim;
		if (isVazia()) {
			return atual;
		} else {
			if (!(index > this.quantNos)) {
				for (int i = 1; i < index; i++) {
					atual = atual.getProx();
				}
			}
		}
		return atual;
	}

	// pesquisa no pela informação
	public No pesInfo(int k) {
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

	// concatena a lista no final
	public boolean concListas(ListaSimples listaSimples) {
		if (listaSimples.isVazia()) {
			return false;
		}
		if (isVazia()) {
			this.prim = listaSimples.getPrim();
			this.ult = listaSimples.getUlt();
			this.quantNos = listaSimples.getQuantNos();
			return true;
		} else {
			this.ult.setProx(listaSimples.getPrim());
			this.quantNos += listaSimples.getQuantNos();
			this.ult = listaSimples.getUlt();

		}
		listaSimples.setPrim(null);
		listaSimples.setUlt(null);
		listaSimples.setQuantNos(0);
		return true;
	}

	// divide a lista e poe metade na segunda lista
	public boolean partirDistribuir(ListaSimples listaSimples) {
		if (this.isVazia()) {
			return false;
		} else {

			if (listaSimples.isVazia()) {
				No meioList = this.pes(this.quantNos / 2);
				this.ult = meioList;
				No atual = meioList.getProx();
				meioList.setProx(null);

				for (int i = (this.quantNos / 2); i < this.quantNos; i++) {
					listaSimples.add(atual.getInfo());

					atual = atual.getProx();
				}
				listaSimples.setUlt(atual);
			}
		}

		return true;
	}

	// media dos valores da lista
	public double mediaDaLista() {
		double soma = 0;
		if (isVazia()) {
			return 0;
		} else {
			No atual = this.prim;

			for (int i = 0; i < this.quantNos; i++) {
				soma += atual.getInfo().getChave();
				atual = atual.getProx();
			}
		}
		return soma / this.quantNos;
	}

	public int addSeNãoExiste(int value) {
		Item item = new Item(value);
		if (isVazia()) {
			this.add(item);
			return 1;
		} else {
			No no = new No(item);
			this.ult.setProx(no);
			this.ult = no;
			this.quantNos++;

			int quant = 0;
			No atual = this.prim;
			for (int i = 0; i < this.quantNos; i++) {
				if (no.getInfo().getChave() == atual.getInfo().getChave()) {
					quant++;
				}
				atual = atual.getProx();
			}
			return quant;
		}
	}

	public boolean estaContida(ListaSimples listaSimples) {
		if (this.isVazia() || listaSimples.isVazia()) {
			return false;
		}

		if (this.quantNos > listaSimples.getQuantNos()) {
			return false;
		}

		No atual = this.prim;
		int quantidadeIguais = 0;

		int max = 0;
		while (max != this.quantNos) {
			No no = listaSimples.getPrim();
			boolean controle = true;
			for (int i = 0; i < listaSimples.getQuantNos(); i++) {
				if (atual.getInfo().getChave() == no.getInfo().getChave()) {
					if (controle == true) {
						quantidadeIguais++;
						controle = false;
					}
				}
				no = no.getProx();
			}
			atual = atual.getProx();
			max++;
		}

		if (quantidadeIguais != this.quantNos) {
			return false;
		}

		return true;
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
