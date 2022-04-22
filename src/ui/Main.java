package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.PlayerMove;

public class Main {
	
	public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	public static PlayerMove pm= new PlayerMove();
	public static int n=0;
	public static int f=0;
	
	public static void main(String[]args) {
		try {
			playGame();
		} catch (NumberFormatException | IOException e) {
			System.out.println("Error en entrada\n");
			e.printStackTrace();
		}
		
	}
	
	public static void playGame() throws NumberFormatException, IOException {
		System.out.println("Escribe la cantidad de columnas del tablero");
		n=Integer.parseInt(br.readLine());
		System.out.println("Escribe la cantidad de filas del tablero");
		f=Integer.parseInt(br.readLine());
		
		pm.createBoard(n,f);
		boolean next=true;
		while(next) {
			System.out.println("Escoge una opción:\n1:Tirar los dados\n2:Ver tablero\n3:Salir");
			
			switch(Integer.parseInt(br.readLine())) {

			case 1:
				int num=(int)(Math.random()*6+1);
				next=pm.advanceSquare(num,n,f);
				break;

			case 2:
				System.out.print("\n");
				pm.printBoard(n,f);
				break;

			case 3:
				next=false;
				System.out.println("El juego ha finalizado");
			break;
			
			default:
				System.out.println("Esta opción no existe");
			}
			
		}
	}
}
