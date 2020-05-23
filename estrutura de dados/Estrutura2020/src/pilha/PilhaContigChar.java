package pilha;

import dados.ItemChar;

public class PilhaContigChar {
	private ItemChar[] info;
	private int topo;

	public PilhaContigChar(int quant) {
		this.topo = 0;
		this.info = new ItemChar[quant];
	}

	public ItemChar[] getInfo() {
		return info;
	}

	public void setInfo(ItemChar[] info) {
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
	public boolean empilhar(ItemChar item) {
		if (isCheia())
			return false;
		else {
			this.info[this.topo] = item;
			this.topo++;
			return true;
		}
	}

	// remove o dado que está no topo da pilha(somente um dado)
	public ItemChar desempilhar() {
		if (this.isVazia())
			return null;
		else {
			this.topo--;
			return this.info[this.topo];
		}
	}

	public String invertePalavra(String palavra) {
		String resposta = "";
		for (int i = 0; i < palavra.length(); i++) {
			this.empilhar(new ItemChar(palavra.charAt(i)));
		}
		while (!this.isVazia()) {
			resposta += this.desempilhar().getChave();
		}
		return resposta;
	}

	public boolean verificaInverso(String palavra) {
		if (this.isVazia())
			return false;

		String str = "";
		while (!this.isVazia()) {
			str += this.desempilhar().getChave();
		}

		if (palavra.equals(str)) {
			str = invertePalavra(str);
			if (palavra.equals(str))
				return false;
		}

		return true;

	}

}
