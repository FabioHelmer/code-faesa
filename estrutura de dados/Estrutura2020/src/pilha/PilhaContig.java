package pilha;

import dados.Item;

public class PilhaContig {
	private Item[] info;
	private int topo;

	public PilhaContig(int quant) {
		this.topo = 0;
		this.info = new Item[quant];
	}

	public Item[] getInfo() {
		return info;
	}

	public void setInfo(Item[] info) {
		this.info = info;
	}

	public int getTopo() {
		return topo;
	}

	public void setTopo(int topo) {
		this.topo = topo;
	}

	public boolean isVazia() {
		return (this.topo == 0);
	}

	public boolean isCheia() {
		return (this.topo == this.info.length);
	}

	// insira um novo dado no topo da pilha
	public boolean empilhar(Item item) {
		if (isCheia())
			return false;
		else {
			this.info[this.topo] = item;
			this.topo++;
			return true;
		}
	}

	// remove o dado que está no topo da pilha(somente um dado)
	public Item desempilhar() {
		if (this.isVazia())
			return null;
		else {
			this.topo--;
			return this.info[this.topo];
		}
	}

	public void retiraMaiorQue10() {
		PilhaContig aux = new PilhaContig(this.topo);
		Item valor;
		while (!this.isVazia()) {
			valor = this.desempilhar();
			if (valor.getChave() <= 10) {
				aux.empilhar(valor);
			}
		}
		while (!aux.isVazia()) {
			this.empilhar(aux.desempilhar());
		}

	}

	public int testarIgualdade(PilhaContig pilhaContig) {
		if (pilhaContig.getTopo() != this.topo)
			return 0;
		else {
			PilhaContig aux = new PilhaContig(this.topo);
			PilhaContig auxpilhaContig = new PilhaContig(pilhaContig.getTopo());

			Item valor1;
			Item valor2;

			boolean isDiferente = false;

			while (!this.isVazia()) {
				valor1 = this.desempilhar();
				valor2 = pilhaContig.desempilhar();

				aux.empilhar(valor1);
				auxpilhaContig.empilhar(valor2);

				if (valor1.getChave() != valor2.getChave())
					isDiferente = true;
			}

			while (!aux.isVazia()) {
				this.empilhar(aux.desempilhar());
				pilhaContig.empilhar(auxpilhaContig.desempilhar());
			}

			if (isDiferente == true)
				return 0;

			return 1;

		}

	}

}
