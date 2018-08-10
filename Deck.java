import java.util.Arrays;
import java.util.Random;
public class Deck {

public int Count=0;
public Card[] C_Deck= new Card[52];

public Deck(){
	int i;
	int j;
	for(i=1;i<5;i++){
		for(j=2;j<15;j++){
		    C_Deck[Count]=new Card(i,j);
			Count++;
		
		}
	}
}
public void Shuffle(){
	Random randInt = new Random();
	for(int i=0;i<52;i++){
		int random=randInt.nextInt(51)+1;
		
		Card temp=C_Deck[i];
		C_Deck[i]=C_Deck[i];
		C_Deck[random]=temp;
		

	}
	
	
}
public Card drawCard(){
	Card draw = this.C_Deck[0];
	this.C_Deck = Arrays.copyOfRange(C_Deck, 1, C_Deck.length-1);
	return draw;

}
}
