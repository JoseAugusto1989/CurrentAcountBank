package CountBank;

import java.util.Scanner;

import Entities.Conta;

public class ContaCorrente {

	static Scanner read = new Scanner(System.in);
	static Conta conta = new Conta();
	
	public static void main(String[] args) {
			
		conta.cadastro();
			
		conta.menu();    
		   	
		read.close();



	}

}
