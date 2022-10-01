package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Reserva {
	
	/*
	private Cliente = new Cliente();
	private Quarto = new Quarto();
	*/

	public void verificaReserva() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = new GregorianCalendar(2022, Calendar.OCTOBER, 10);
		Calendar c3 = new GregorianCalendar(2022, Calendar.OCTOBER, 5);
		// Verificar se a data especificada está entre duas datas
		/*
		if(c3.compareTo(c1)>=0 && c3.compareTo(c2)<=0) {
			System.out.println(sdf.format(c3.getTime())+"Data está entre  as duas");
		}
		*/
		if(c3.after(c1) && c3.before(c2)) {
			System.out.println(sdf.format(c3.getTime())+"Data está entre  as duas");
		}
	}
}
