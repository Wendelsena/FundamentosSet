package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {
	
	// HashSet --> mais rápido (operações O(1) em tabela hash) e não ordenado.
	//TreeSet --> mais lento (operações O(log(n)) em árvore rubro-negra) e ordenado pelo compareTo do objeto (ou Comparator).
	//LinkedHashSet --> velocidade intermediária e elementos na ordem em que são adicionados.

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter file full path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			Set<LogEntry> set = new HashSet<>(); // hashSet pq é o mais rapido e a ordem não importa nessa situação.

			String line = br.readLine();
			
			while (line != null) {
				String[] filds = line.split(" ");
				String username  = filds[0];
				Date moment = Date.from(Instant.parse(filds[1]));
				
				set.add(new LogEntry(username, moment)); // se for inserido um lohEntry com algum nome repedito. a operação será barrada.
				
				line = br.readLine();
			}
			System.out.print("Total users: " + set.size());
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());

		}

		sc.close();

	}

}
