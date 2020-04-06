package duplamente;

import dados.Item;

public class Main {
	public static void main(String[] args) {
		ListaDupla ld = new ListaDupla();

		ld.add(new Item(1), new Item(2), new Item(3), new Item(1001), new Item(15), new Item(100), new Item(1000),
				new Item(1500));

		System.out.println(ld.toString());

		ListaDupla ld2 = new ListaDupla();

		ld.copiaLista(ld2);
		System.out.println(ld2.toString());

	}
}
