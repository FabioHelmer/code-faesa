package fila;

import dados.Item;

public class FilaCircular {
	private Item[] info;
	private int frente;
	private int tras;
	private int tamanho;

	public FilaCircular(int qte) {
		this.frente = 0;
		this.tras = 0;
		this.tamanho = 0;
		this.info = new Item[qte];
	}

	public Item getInfo() {
		return this.info[this.frente];
	}

	public int getFrente() {
		return this.frente;
	}

	public int getTras() {
		return this.tras;
	}

	public int getTamanho() {
		return this.tamanho;
	}

	public boolean isVazia() {
		return (this.tamanho == 0);
	}

	public boolean isCheia() {
		return (this.tamanho == this.info.length);
	}

	public boolean enfileirar(Item elem) {
		if (this.isCheia())
			return false;
		else {
			this.info[tras] = elem;
			this.tras = (++this.tras % this.info.length);
			this.tamanho++;
			return true;
		}
	}

	public Item desenfileirar() {
		Item no;
		if (this.isVazia())
			return null;
		else {
			no = this.info[this.frente];
			this.frente = (++this.frente % this.info.length);
			this.tamanho--;
			return no;
		}
	}

	public FilaCircular retiraNegativo() {
		FilaCircular filaCircular = new FilaCircular(this.tamanho);
		int aux = this.frente;
		Item valor;
		while (!this.isVazia()) {
			valor = this.desenfileirar();
			if (valor.getChave() >= 0) {
				filaCircular.enfileirar(valor);
			}
		}
		return filaCircular;
	}

	public int somaElem() {
		int soma = 0;
		if (!this.isVazia()) {
			Item valor;
			while (!this.isVazia()) {
				valor = this.desenfileirar();
				soma += valor.getChave();
			}
		}

		return soma;
	}

	@Override
	public String toString() { // imprimir o conteúdo da fila
		String msg = "";
		int aux = this.frente;
		for (int i = 1; i <= this.tamanho; i++) {
			msg += this.info[aux].getChave() + " ";
			aux = (++aux % this.info.length);
		}
		return msg;
	}
}
