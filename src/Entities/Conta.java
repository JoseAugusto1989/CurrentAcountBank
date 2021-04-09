package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Conta {
	
	Date dat = new Date();
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	//Date y2 = sdf2.parse("04/02/2021 19:40:12");
	
	Scanner read = new Scanner(System.in);
	public String nome;
	public String numConta;
	public String agencia;
	public int menu;
	public double saque;
	public double deposito;
	public double saldo = 0;
	public double limiteEspecial;
	public boolean especial;
	
	public double sacar(double quantiaSacar) {
		
		if (this.saldo >= quantiaSacar) { //have money in account
			this.saldo -= quantiaSacar;
			System.out.println("Saque efetuado com sucesso!");
			    return quantiaSacar;
			
		} else { //don't have money in account
			if (this.especial) { //check if the account has balance
				this.limiteEspecial += this.saldo;
				if (this.limiteEspecial >= quantiaSacar) {
					this.saldo -= quantiaSacar;
					System.out.println();
					System.out.println("Saque efetuado com sucesso!");
					    return quantiaSacar;
					
				} else {
					System.out.println();
					System.out.println("Valor excede seu limite!");
					return quantiaSacar;
					
				}
				
			} else {
				System.out.println();
				System.out.println("Não foi possível realizar saque, saldo insuficiente.");
				return quantiaSacar; //not special and has no money in account 
			}
			
		}
		
	}
	public void depositar(double valorDepositado) {
		
		this.saldo += valorDepositado;
	}
    public void consultarSaldo() {
    	
    	System.out.println(sdf2.format(dat));
    	System.out.println(this.nome);
    	System.out.println("Conta: " + this.numConta + " Agência: " + this.agencia);
    	System.out.printf("Saldo atual da conta corrente: R$ %.2f%n", this.saldo);
    	verificarLimite();
    	System.out.println();
    	
    }
    public void verificarLimite() {
    	
    	if (this.saldo < 0) {
    		System.out.println("Está usando seu limite");
    		
    	} else {
    		System.out.println("Não está usando o seu limite");
    	}
    
    }
    public void menu() {
    	
    	System.out.println("   \n Bem vindo ao menu   ");
    	System.out.println();
    	System.out.println("Digite 1 - saque, 2 - deposito, 3 - conferir saldo, 4 - sair ");
    	System.out.print("Digite a opção desejada: ");
    	    menu = read.nextInt();
    	
    	if (menu == 1) {
    		System.out.print("Digite um valor para sacar: ");
		        this.saque = read.nextDouble();    read.nextLine();
		        sacar(this.saque);
		            System.out.println();
    		    consultarSaldo();
    		    menu();
    		
    	} else if (menu == 2) {
    		System.out.print("Digite um valor para depositar: ");
		        this.deposito = read.nextDouble();   read.nextLine();
		        depositar(this.deposito);
		            System.out.println();
		        consultarSaldo();
		        menu();
    		
    	} else if (menu == 3) {
    		consultarSaldo();
    		
    	} else if (menu == 4) {
    		System.out.println("Fim");
    		
    	} else {
    		
    		System.out.println("Opção inválida, digite novamente");
    		menu();
    	}
    	
    }
    public void cadastro() {
    	
    	System.out.println("   Cadastro de cliente   ");
        System.out.println();
		System.out.print("Digite o nome do cliente: ");
		    this.nome = read.nextLine();
		System.out.print("Digite o número da conta: ");
		    this.numConta = read.nextLine();
		System.out.print("Digite o numero da agência: ");
		    this.agencia = read.nextLine();
	    System.out.print("Digite se o limite especial esta liberado (true - sim, false - não): ");
	        this.especial = read.nextBoolean();   read.nextLine();
	    System.out.print("Digite o limite de credito: ");   
	        this.limiteEspecial = read.nextDouble();   read.nextLine();
	        
    }


}
