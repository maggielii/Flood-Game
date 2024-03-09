package code;

import java.util.Scanner;

public class Flood {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);	
		
		int change = 0;
		int dimension = 20;
		
		do
		{
			LinkedGrid board = new LinkedGrid(dimension);
			
			int turn = 1;
			
			for(int x = 0; x < 25; x++)
			{
				
				if(board.win(dimension))
				{
					System.out.println("You win");
					break;
				}
				
				board.display();
				System.out.println("Turn: " + turn + "/25");
				turn++;
				System.out.print("Change the colour: ");
				change = input.nextInt();
				
				if(change == 7)
				{
					break;
				}
				
				board.flood(change);
			}
			
			if(!board.win(dimension) && change!= 7)
			{
				System.out.println("You lose");
			}
			
		}while(change == 7);
	}

}
