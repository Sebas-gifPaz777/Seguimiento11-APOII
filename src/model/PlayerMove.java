package model;

public class PlayerMove {

	private Square start;
	private Square last;
	
			
	public void createBoard(int n, int f) {
		start=new Square(1);
		start.setPlayer("J");
		last=start;
		int count=0;
		int numTable=2;
		
		while(count<((n*f)-1)) {
			last.setNext(new Square(numTable));
			last=last.getNext();
			numTable++;
			count++;
		}
		
		printBoard(n,f);
	}

	public void printBoard(int n, int f) { 
		Square temp=start;
		for(int i=0;i<f;i++) {
			System.out.println("");
			for(int j=0;j<n;j++) {
				if(!temp.getPlayer().equals("")) {
					System.out.print("["+temp.getPlayer()+"] ");
				}
				else {
					System.out.print("["+temp.getId()+"] ");
				}
				temp=temp.getNext();
			}
		}
		System.out.println("");
	}

	public boolean advanceSquare(int num,int n,int f) {
		
		
			int numf=searchPlayer();
			int lim=n*f;
			Square temp=start;
			
			if((num+numf)<=lim) {
				for(int i=0;i<numf-1;i++) {
					temp=temp.getNext();
				}
				temp.setPlayer("");
				for(int i=0;i<num;i++) {
					temp=temp.getNext();
				}
				temp.setPlayer("J");
			}
			else
				System.out.println("No se puede recorrer las suficientes casillas con este número");
			
			System.out.println("Dado: "+num);
			printBoard(n,f);
			
			if(temp.getNext()==null) {
				System.out.println("Se acabo el juego");
				return false;
			}
			else
				return true;
	}
	
	public int searchPlayer() {
		
		if(start.getPlayer().equalsIgnoreCase("J")) {
			return start.getId();
		}
		else {
			return start.searchNode();
		}
	}
}
