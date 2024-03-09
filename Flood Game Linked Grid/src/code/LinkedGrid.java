package code;

public class LinkedGrid {

	private Node first;
	
	public LinkedGrid(int dimension)
	{
		int count = 1;
		
		Node temp = null;//to make it once
		
		first = new Node((int)(Math.random()*(6))+1);//making first node in grid
		count++;
		
		Node columnMarker = first;
		Node rowMarker = first;
		
		for(int x = 0; x < dimension-1; x++)//already have first node
		{
			temp = new Node((int)(Math.random()*(6))+1);
			count++;
			columnMarker.setRight(temp);
			temp.setLeft(columnMarker);
			columnMarker = temp;
		}
		
		for(int q = 0; q < dimension-1; q++)
		{
			temp = new Node((int)(Math.random()*(6))+1);//making first node in row
			count++;
			rowMarker.setDown(temp);
			temp.setUp(rowMarker);
			columnMarker = temp;
			
			for(int x = 0; x < dimension-1; x++)
			{
				temp = new Node((int)(Math.random()*(6))+1);
				count++;
				columnMarker.setRight(temp);
				temp.setLeft(columnMarker);
				temp.setUp(columnMarker.getUp().getRight());
				temp.getUp().setDown(temp);
				columnMarker = temp;
			}
			
			rowMarker = rowMarker.getDown();
		}
		
	}
	
	public void display() 
	{
		Node temp = first;
		Node rowMarker = first;
		
		int startHere = 0;
		
		while(temp != null)
		{
			if(startHere == 0 || startHere == 1 || startHere == 2)
			{
				if(startHere == 0)
				{
					System.out.print("1  2  3    Start Here ->");
				}
				else if(startHere == 1)
				{
					System.out.print("4  5  6                 ");
				}
				else
				{
					System.out.print("7: New game             ");
				}
			}
			if(startHere != 0 && startHere != 1 && startHere != 2)
			{
				System.out.print("                        ");
			}
			startHere++;
			while(temp != null)
			{
				System.out.print(temp.getData() + " ");
				temp = temp.getRight();
			}
			System.out.println();
			rowMarker = rowMarker.getDown();
			temp = rowMarker;
		}
	}
	
	public void flood(int newNumber)
	{
		flood(first, newNumber); //overload method to get access to node
	}
	
	public void flood(Node n, int newNumber)
	{
		int oldNumber = n.getData();
		n.setData(newNumber);
		
		try {
			if(n.getRight().getData() == oldNumber)
			flood(n.getRight(), newNumber);
		}
		catch(Exception e) {}
		
		try {
			if(n.getDown().getData() == oldNumber)
			flood(n.getDown(), newNumber);
		}
		catch(Exception e) {}
		
		try {
			if(n.getLeft().getData() == oldNumber)
			flood(n.getLeft(), newNumber);
		}
		catch(Exception e) {}
		
		try {
			if(n.getUp().getData() == oldNumber)
			flood(n.getUp(), newNumber);
		}
		catch(Exception e) {}
		
		//other method
//		if(n.getRight() != null && n.getRight().getData() == oldNumber) //&& checks if its false then wont run, & checks both even if false
//			flood(n.getRight(), newNumber);
//		if(n.getDown() != null && n.getDown().getData() == oldNumber)
//			flood(n.getDown(), newNumber);
//		if(n.getLeft() != null && n.getLeft().getData() == oldNumber)
//			flood(n.getLeft(), newNumber);
//		if(n.getUp() != null && n.getUp().getData() == oldNumber)
//			flood(n.getUp(), newNumber);	
	}
	
	public boolean win(int dimension)
	{
		boolean win = true;
		Node temp = first;
		Node rowMarker = first;
		
		for(int y = 0; y < dimension; y++)
		{
			temp = rowMarker;
			
			for(int x = 0; x < dimension - 1; x++)
			{
				
				if(temp.getData() != temp.getRight().getData())
				{
					return false;
				}
				
				temp = temp.getRight();
			}
			
			rowMarker = rowMarker.getDown();
		}

		return win;
	}
	
}
