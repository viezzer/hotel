package controller;

import view.InterfaceDeUsuario;

public class Principal {
	public static void main(String args[]) {
		int tentativas = 3;
		InterfaceDeUsuario i = new InterfaceDeUsuario();
		
		while(tentativas>0) {
			if(i.efetuarLogin()) {
				tentativas = 3;
				System.out.println("Usuario autenticado.");
				i.menuPrincipal();
			} else {
				System.out.println("Usuario nao autenticado");
				tentativas--;
			}
		}
		System.out.println("Número de tentativas de autenticacao excedido. Sistema finalizado.");
	}
}
