import java.util.Scanner;
public class Player {
Scanner userInput = new Scanner(System.in);
private int bankroll;
private int amount;
private String playerName;
private int select;



public Player(String name){
		playerName=name;
		bankroll=10000;
}
public int getBet(int betAmount){
	bankroll-=betAmount;
	return bankroll;
		
}
void winnings(int winAmount){
	bankroll+=winAmount;
}
void playHand(){
	
	do{
	HandCheck rankCPU = new HandCheck();
	HandCheck rankPlayer = new HandCheck();
	Deck playDeck = new Deck();
	printDeck(playDeck.C_Deck);
	playDeck.Shuffle();
	System.out.println("\nShuffled Deck\n");
	printDeck(playDeck.C_Deck);
	System.out.println("You wanna play?");
	Card  playerCard [] = new Card[5];
	Card CPU_Card[] = new Card[5];
	
	
	while (userInput.nextLine().equals("yes")){
	
		
		for(int i=0;i<5;i++){
			playerCard[i] = playDeck.drawCard();
			CPU_Card[i] = playDeck.drawCard();
		}
		 printDeck(playerCard);
		System.out.println("Do you want to redraw? ");
		  if (userInput.nextLine().equals("yes")){
			  System.out.println("Which cards do you want to change?");
			  select=userInput.nextInt();
			  while(select!=0){
				  playerCard[select-1]=playDeck.drawCard();
				  System.out.println("Select another card to change. Enter 0 if you are ok.");
				  select=userInput.nextInt();
			  }
			 
			  printDeck(playerCard);
		  }
		  
		  System.out.println("How much do you want to bet? ");
		  amount = userInput.nextInt();
		  getBet(amount);
		 
		  
		  int RankOfPlayer = rankPlayer.check(playerCard); 
		  int RankOfCPU = rankCPU.check(CPU_Card);
		  
		  if(RankOfCPU<100){
			  System.out.println("\nComputer redraws.");
			  for (int i=0;i<5;i++){
				  
				  CPU_Card[i]=playDeck.drawCard();
				  
			  }
		  }
		  System.out.println("Computer's hand: \n");  
			printDeck(CPU_Card);
		  
		  
			  if(RankOfPlayer>=RankOfCPU){
				  
				  winnings(amount*2);
				  System.out.println("You win!\nYour bankroll is: "+bankroll);
				  
			  }
				  else{ 
					  System.out.println("You lost.\n Your bankroll is: "+bankroll);
				  }
		
			  
			  
		  
	}

		System.out.println("Another turn?");
	}while (userInput.nextLine().equals("yes"));
		
}

public void printDeck(Card[] array){
	   for(int i=0;i<array.length;i++){
		System.out.println((i+1)+". ");
	    if(array[i].getValue()==14)
	     System.out.print("Ace");
	    else if(array[i].getValue()==13)
	     System.out.print("King");
	    else if(array[i].getValue()==12)
	     System.out.print("Queen");
	    else if(array[i].getValue()==11)
	     System.out.print("Jack");
	    else
	     System.out.print(array[i].getValue());
	    
	    if(array[i].getSuit()==1)
	     System.out.println(" of Clubs");
	    else if(array[i].getSuit()==2)
	     System.out.println(" of Spades");
	    else if(array[i].getSuit()==3)
	     System.out.println(" of Diamond");
	    else if(array[i].getSuit()==4)
	     System.out.println(" of Hearts");
	   
	  }
	}
}
		  
	


