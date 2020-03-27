package simplismente;

import dados.Item;

public class Main {
	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();
		ListaSimples simples = new ListaSimples();
		lista.add(new Item(2), new Item(3), new Item(10), new Item(88), new Item(89));
		simples.add(new Item(2), new Item(3), new Item(10), new Item(88));

		if (lista.estaContida(simples))
			System.out.println("deu certo");
		System.out.println("lista 1->" + lista.toString());
	}

}
