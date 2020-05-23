package fila;

import dados.Item;

public class Main {

	public static void main(String[] args) {
		FilaCircular filaCircular = new FilaCircular(10);
		filaCircular.enfileirar(new Item(1));
		filaCircular.enfileirar(new Item(2));
		filaCircular.enfileirar(new Item(3));
		filaCircular.enfileirar(new Item(4));
		filaCircular.enfileirar(new Item(5));
		System.out.println(filaCircular.toString());
		System.out.println(filaCircular.somaElem());
		System.out.println(filaCircular.toString());
	}

}
