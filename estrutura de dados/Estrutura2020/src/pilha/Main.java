package pilha;

import dados.ItemChar;

public class Main {

	public static void main(String[] args) {
		PilhaContigChar contig = new PilhaContigChar(5);
		PilhaContig c2 = new PilhaContig(5);

		contig.empilhar(new ItemChar('f'));
		contig.empilhar(new ItemChar('a'));
		contig.empilhar(new ItemChar('b'));
		contig.empilhar(new ItemChar('i'));
		contig.empilhar(new ItemChar('o'));

		if (contig.verificaInverso("oibaf")) {
			System.out.println("inverso");
		} else {
			System.out.println("ta igual");
		}

	}

}
