/**
 * An enum representing the four possible suits of a card. 
 * 
 * @author pku
 *
 */
		
public enum Suit {
  Clubs(1), Diamonds(2), Spades(3), Hearts(4);
  private int value;
  
  private Suit(int v) {
	  this.value = v;
  }
}
