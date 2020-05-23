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

	public ListaSimples inverteLista() {
		ListaSimples listaSimples = new ListaSimples();
		No atual = this.prim;

		for (int i = 0; i < this.quantNos; i++) {
			listaSimples.addNoComeco(atual.getInfo());
			atual = atual.getProx();
		}
		return listaSimples;

	}

	public void insereListaNaLista(ListaSimples listaSimples, int n) {
		if (n <= this.quantNos) {
			if (n == this.quantNos) {
				this.concListas(listaSimples);
				this.ult = listaSimples.getUlt();
			} else {
				No atual = this.prim;

				for (int i = 1; i < n; i++) {
					atual = atual.getProx();
				}

				listaSimples.getUlt().setProx(atual.getProx());
				atual.setProx(listaSimples.getPrim());
				this.quantNos += listaSimples.getQuantNos();

			}
		}

	}

	public void inserirSomaDeImparesFinal() {
		if (!this.isVazia()) {
			int soma = 0;
			int quantElem = 0;
			No atual = this.prim;
			while (atual != null) {
				if (atual.getInfo().getChave() % 2 != 0) {
					soma += atual.getInfo().getChave();
					quantElem++;
				}
				atual = atual.getProx();
			}
			if (quantElem > 0) {
				No novoNo = new No(new Item(soma / quantElem));
				this.ult.setProx(novoNo);
				this.ult = novoNo;
				this.quantNos++;
			}
		}
	}

	public void separarMaiorQueXDeMenores(ListaSimples l2, ListaSimples l3, int x) {

		No atual = this.prim;

		while (atual != null) {
			if (atual.getInfo().getChave() >= x) {
				l3.add(atual.getInfo());
				l3.quantNos++;
			} else {
				l2.add(atual.getInfo());
				l2.quantNos++;
			}
			atual = atual.getProx();
			this.quantNos--;
		}

		this.prim = null;
		this.ult = null;

	}

	/*
	 * G21DI2- Dada a Lista Linear Simplesmente Encadeada contendo números inteiros,
	 * faça um método que caminhe na lista somando os elementos que maiores que o
	 * valor 100. Depois que percorreu toda a lista, altere o valor do último
	 * elemento da lista pelo valor da soma efetuada.
	 */

	public boolean SomarElemMaior() {

		if (this.isVazia()) {
			return false;
		} else {
			No noAtual = this.prim;
			int soma = 0;
			while (noAtual != null) {
				if (noAtual.getInfo().getChave() > 100) {
					soma += noAtual.getInfo().getChave();
				}
				noAtual = noAtual.getProx();
			}

			noAtual = this.prim;
			for (int i = 0; i < this.quantNos - 1; i++) {

				noAtual = noAtual.getProx();
			}

			if (soma > 0) {
				No novoNo = new No(new Item(soma));
				noAtual.setProx(novoNo);
				this.ult = novoNo;
				this.quantNos++;
			}
			return true;
		}

	}

	/*
	 * G22DI4-Escreva um método que a partir de uma Lista Simplesmente Encadeada
	 * denominada L1 (this – objeto do método), identifique nesta lista todos os
	 * alunos da Engenharia de Produção e insira-os em uma outra Lista Simplesmente
	 * Encadeada denominada L2. Considerações: A lista L1 não está vazia e a L2 já
	 * está instanciada e vazia (será passada por parâmetro); Se o valor do campo
	 * chave for maior do que 1000 são alunos do curso da engenharia de produção; A
	 * inserção na lista L2 será no início da estrutura (antes do primeiro). Não
	 * será necessário remover alunos da L1.
	 */

	public ListaSimples transferirAlunos(ListaSimples l2) {
		No atual = this.prim;

		while (atual != null) {
			if (atual.getInfo().getChave() > 1000) {
				l2.addNoComeco(new Item(atual.getInfo().getChave()));
				l2.quantNos++;
			}

			atual = atual.getProx();
		}
		return l2;
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
