package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
	
	public static void main (String args[]) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch partidaXadrez = new ChessMatch();
		
		while(true) {
			UI.printTabuleiro(partidaXadrez.getPecas());
			System.out.println();
			System.out.print("Origem: ");
			ChessPosition origem = UI.leituraDePosicao(sc);
			
			System.out.println();
			System.out.print("Destino: ");
			ChessPosition destino = UI.leituraDePosicao(sc);
			
			ChessPiece pecaCapturada = partidaXadrez.performarMovimentoDeXadrez(origem, destino);
		}
		
	}
}
