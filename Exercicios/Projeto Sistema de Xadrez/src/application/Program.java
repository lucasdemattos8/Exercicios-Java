package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
	
	public static void main (String args[]) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch partidaXadrez = new ChessMatch();
		List<ChessPiece> capturadas = new ArrayList<>();

		while(!partidaXadrez.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printPartida(partidaXadrez, capturadas);
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
				
				if (pecaCapturada != null) {
					capturadas.add(pecaCapturada);
				}
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
		UI.clearScreen();
		UI.printPartida(partidaXadrez, capturadas);
	}
}
