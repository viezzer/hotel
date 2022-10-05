package controller;

import view.InterfaceDeUsuario;

public class Principal {
	public static void main(String args[]) {
		boolean appRodando = true;
		InterfaceDeUsuario i = new InterfaceDeUsuario();
		
		while(appRodando) {
			if(i.efetuarLogin()) {
				System.out.println("Usuário autenticado.");
				i.menuPrincipal();
			} else {
				System.out.println("Usuário não autenticado");
			}
		}
	}
}
