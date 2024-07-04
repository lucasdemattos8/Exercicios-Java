package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import entities.Comentario;
import entities.Postagem;

public class Program {
	
	public static void main (String args[]) throws ParseException {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	Comentario comentario1 = new Comentario("Tenha uma boa viagem!");
	Comentario comentario2 = new Comentario("Uau, isso é incrivel!");
	Postagem post1 = new Postagem(
			sdf.parse("21/06/2018 13:05:44"),
			"Viajando para Nova Zelandia",
			"Irei visitar este país maravilhoso!",
			12);
	post1.addComments(comentario1);
	post1.addComments(comentario2);
	
	System.out.println(post1);	
	}
}
