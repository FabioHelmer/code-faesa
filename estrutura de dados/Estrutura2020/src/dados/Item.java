package dados;

public class Item {
	private int chave;
	private char chaveChar;

	public Item() {
	}

	public Item(int chave) {
		this.chave = chave;
	}

	public Item(char chaveChar) {
		this.chaveChar = chaveChar;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public char getChaveChar() {
		return chaveChar;
	}

	public void setChaveChar(char chaveChar) {
		this.chaveChar = chaveChar;
	}

}
