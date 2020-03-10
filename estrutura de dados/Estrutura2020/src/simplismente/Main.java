package simplismente;

import dados.Item;

public class Main {
	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();
		lista.add(new Item(5), new Item(6), new Item(2));

		System.out.println(lista.toString());
		lista.addNoComeco(new Item(0));

		System.out.println(lista.toString());
		System.out.println("2-> ");
		System.out.println(lista.toString());

	}
}
