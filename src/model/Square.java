package model;

public class Square {
	
	private int id;
	private String player;
	private Square next;
	
	public Square(int id) {
		this.id=id;
		player="";
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public int getId() {
		return id;
	}
	
	public Square getNext() {
		return next;
	}
	
	public void setNext(Square newNext) {
		next=newNext;
	}

	public int searchNode() {
		
		if(next.getPlayer().equalsIgnoreCase("J")) {
			return next.getId();
		}
		else 
			return next.searchNode();
	}
}
