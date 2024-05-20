package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
	
	public static void main (String args[]) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch partidaXadrez = new ChessMatch();
		
		while(true) {
			try {
				UI.clearScreen();
				UI.printTabuleiro(partidaXadrez.getPecas());
				System.out.println();
				System.out.print("Origem: ");
				ChessPosition origem = UI.leituraDePosicao(sc);
				
				boolean[][] movimentosPossiveis = partidaXadrez.movimentosPossiveis(origem);
				UI.clearScreen();
				UI.printTabuleiro(partidaXadrez.getPecas(), movimentosPossiveis);
				System.out.println();
				System.out.print("Destino: ");
				ChessPosition destino = UI.leituraDePosicao(sc);
				
				ChessPiece pecaCapturada = partidaXadrez.performarMovimentoDeXadrez(origem, destino);
			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				System.out.print("\nPressione ENTER para sair: ");
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.print("\nPressione ENTER para sair: ");
				sc.nextLine();
			}
			
		}
	}
}
