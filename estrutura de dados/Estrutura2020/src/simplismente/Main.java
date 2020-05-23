package simplismente;

import dados.Item;

public class Main {
	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();
		ListaSimples l2 = new ListaSimples();
		ListaSimples l3 = new ListaSimples();
		lista.add(new Item(1), new Item(2), new Item(101), new Item(4), new Item(5));

		lista.SomarElemMaior();
		System.out.println(lista.toString());

	}

}
