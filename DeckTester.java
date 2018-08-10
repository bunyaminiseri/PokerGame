public class DeckTester {
 
 public static void main(String[] args) {
  
  testShuffle();
  testbet();
  testwinnings();
  testplayer();
  testall();
 }
 public static void testShuffle(){
  
  Deck deck = new Deck();
  deck.Shuffle();
 }
 public static void testbet(){
  
  Player playerobject = new Player("Bun");
  playerobject.getBet(1500);
 }
 public static void testwinnings(){
  
  Player playerobject = new Player("Bun");
  playerobject.winnings(1500);
 }
 public static void testplayer(){
  
  Player playerobject = new Player("Bun");
  playerobject.playHand();
 }
 public static void testall(){
  testShuffle();
  testbet();
  testwinnings();
  testplayer();  
 }
}