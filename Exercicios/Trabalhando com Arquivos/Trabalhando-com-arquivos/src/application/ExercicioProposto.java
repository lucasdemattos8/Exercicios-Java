package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Products;

public class ExercicioProposto {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String[] infoProduto = new String[2];
		List<Products> listaDeProdutos = new ArrayList<>();
		String nomeDoArquivo = "";
		
		System.out.print("Insira o caminho do arquivo (.csv): ");
		String strPath = sc.nextLine();
		
		// Prepara o diretório de saída do documento.csv
		String strPathOut = new File(strPath).getParent() + "\\out";
		
		// Leitura de dados em relação ao path de arquivo informado
		try (BufferedReader bf = new BufferedReader(new FileReader(strPath))){
			String linha = bf.readLine();
			
			while(linha != null) {
				infoProduto = linha.strip().split(",");
				
				String nomeProduto = infoProduto[0];
				double valorProduto = Double.valueOf(infoProduto[1]);
				int quantidadeProduto = Integer.valueOf(infoProduto[2]);

				listaDeProdutos.add(new Products(nomeProduto, quantidadeProduto, valorProduto));
				
				linha = bf.readLine();
			}
			
			// Pasta de saída de dados
			new File(strPathOut).mkdir();
			LocalDateTime dataAtual = LocalDateTime.now();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
			
			String horarioDeSaida = dataAtual.format(formato);
			nomeDoArquivo = "\\out" + horarioDeSaida  + ".csv";
			
			// Escrita de dados em uma subpasta do diretório informado
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(strPathOut + nomeDoArquivo))){
				for (Products lista : listaDeProdutos) {
					bw.write(lista.getNome());
					bw.write(",");
					bw.write(String.format("%.2f" ,lista.valorTotal()));
					
					bw.newLine();
				}
			}
			catch (IOException e) {
				System.out.println("Erro: " + e.getMessage());
			}	
		}
		catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		System.out.println("");
		
		if (new File(strPathOut + nomeDoArquivo).exists()) {
			System.out.println("Arquivo criado com sucesso.");
		}
		else {
			System.out.println("Houve um problema, o arquivo não foi criado.");
		}
		
		sc.close();
	}

}
