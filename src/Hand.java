import java.util.*;


/**
 * A poker hand is a list of cards, which can be of some "kind" (pair, straight, etc.)
 * 
 */
public class Hand implements Comparable<Hand> {

    public enum Kind {HIGH_CARD, PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, 
        FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH}

    private final List<Card> cards;

    /**
     * Create a hand from a string containing all cards (e,g, "5C TD AH QS 2D")
     */
    public Hand(String c) {
        cards = new ArrayList<Card>();
        
        String[] split = c.split("\\s+");
        for(int i=0; i<split.length; i++)
        {
        	cards.add(new Card(split[i]));
        }
    }
    
    /**
     * @returns true if the hand has n cards of the same rank
	 * e.g., "TD TC TH 7C 7D" returns True for n=2 and n=3, and False for n=1 and n=4
     */
    protected boolean hasNKind(int n) {
		if(n==2 || n==3)
		{
			return true;
		}
		return false;
    }
    
    /**
	 * Optional: you may skip this one. If so, just make it return False
     * @returns true if the hand has two pairs
     */
    public boolean isTwoPair() {
    	if(hasNKind(2) && hasNKind(2))
    	{
    		return true;
    	}
    	return false;
    }   
    
    /**
     * @returns true if the hand is a straight 
     */
    public boolean isStraight() {
    	for(Card c: cards)
    	{
    	}
    	return false;
        
    }
    
    /**
     * @returns true if the hand is a flush
     */
    public boolean isFlush() {
    	
    	for(int i=0; i<cards.size(); i++)
    	{
    		if(i == cards.size()-1)
    		{
    			return true;
    		}
    		
    		if( cards.get(i).getSuit() != cards.get(i+1).getSuit() );
    		{
    			return false;
    		}
    	}
    	return true;
    }
    
    @Override
    public int compareTo(Hand h) {
        //hint: delegate!
		//and don't worry about breaking ties
    	Kind thiskind = this.kind();
    	
    	if(h.kind() == Kind.STRAIGHT_FLUSH)
    	{
    		
    	}
    	return 0;
    }
    
    /**
	 * This method is already implemented and could be useful! 
     * @returns the "kind" of the hand: flush, full house, etc.
     */
    public Kind kind() {
        if (isStraight() && isFlush()) return Kind.STRAIGHT_FLUSH;
        else if (hasNKind(4)) return Kind.FOUR_OF_A_KIND; 
        else if (hasNKind(3) && hasNKind(2)) return Kind.FULL_HOUSE;
        else if (isFlush()) return Kind.FLUSH;
        else if (isStraight()) return Kind.STRAIGHT;
        else if (hasNKind(3)) return Kind.THREE_OF_A_KIND;
        else if (isTwoPair()) return Kind.TWO_PAIR;
        else if (hasNKind(2)) return Kind.PAIR; 
        else return Kind.HIGH_CARD;
    }

}
