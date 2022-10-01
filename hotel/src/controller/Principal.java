package controller;

import view.InterfaceDeUsuario;

public class Principal {
	public static void main(String args[]) {
		InterfaceDeUsuario i = new InterfaceDeUsuario();
		if(i.login()) {
			i.menuPrincipal();
		}
		System.out.println("Tchau!");
	}
}
