import java.util.Scanner;
public class PokerHands
{
		private static Scanner scanner=new Scanner(System.in); static{scanner.useDelimiter(System.getProperty("line.separator"));}
	public static void main(String[] args)
	{
/** Initializations **/
String selectedCards[][] = new String[5][2];

/** The program **/
selectCards(selectedCards);
printSelectedCards(selectedCards);
printResults(selectedCards);

/** Auxiliary functions **/
} private static boolean selected(String suit, String rank, String array[][]) {
    for ( int i = 0; i < array.length; i++ ) {
        if ( array[i][0] == null ) {
            continue;
        }
        
        if ( suit.equals(array[i][0]) && rank.equals(array[i][1])) {
            return true;
        }
    }
    return false;
}

 private static void printSelectedCards( String array[][] ) {
    for( int i = 0; i < 5; i++ ) {
        if ( array[i][0] != null ) {
            System.out.println("Selected card: "+array[i][0].toString()+"("+array[i][1].toString()+")");
        }
    }
}

 private static boolean exists(String value, String array[]){
    for( int i = 0; i < array.length ; i++ ) {
        if ( value.equals(array[i]) ) {
            return true;
        }
    }
    return false;
}
 private static int indexOf(String value, String array[]){
    for( int i = 0; i < array.length ; i++ ) {
        if ( value.equals(array[i]) ) {
            return i;
        }
    }
    return -1;
}
 private static int indexOf(int value, int array[]){
    for( int i = 0; i < array.length ; i++ ) {
        if ( value == array[i] ) {
            return i;
        }
    }
    return -1;
}

 private static void selectCards(String selectedCards[][]) {
  String suits[] = {"spades","hearts","clubs","diamonds"};
  String ranks[] = {"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
  String rank = null, suit = null;
  int cards = 1;

  System.out.println("Please enter five cards: ");

  while( cards <= 5 ) {
    printSelectedCards(selectedCards);

    if ( suit == null ) {
      System.out.println("Please enter suit [spades, hearts, diamonds, clubs]: ");
      suit = System.console().readLine();

      if (! exists(suit,suits) ) {
        System.out.println(suit+" is not a valid suit, please try again: ");
        suit = null;
        continue;
      }
    }
    if ( rank == null ) {
      System.out.println("Please enter rank [1,2,3,4,5,6,7,8,9,10,J,Q,K]: ");
      rank = System.console().readLine();
      if (! exists(rank,ranks) ) {
        System.out.println(rank+" is not a valid rank, please try again: ");
        rank = null;
        continue;
      }
    }
    
    if ( suit != null && rank != null && !selected(suit,rank,selectedCards) ) {
      switch (cards) {
        case 1: selectedCards[0][0] = suit; selectedCards[0][1] = rank;
                suit = null; rank = null;
                break;
        case 2: selectedCards[1][0] = suit; selectedCards[1][1] = rank;
                suit = null; rank = null;
                break;
        case 3: selectedCards[2][0] = suit; selectedCards[2][1] = rank;
                suit = null; rank = null;
                break;
        case 4: selectedCards[3][0] = suit; selectedCards[3][1] = rank;
                suit = null; rank = null;
                break;
        case 5: selectedCards[4][0] = suit; selectedCards[4][1] = rank;
                suit = null; rank = null;
                break;
      }
      cards++;
    }
    else {
        System.out.println("Card already selected, please chose another.");
        suit = null; rank = null;
    }
  }
}

 private static void printResults(String selectedCards[][]) {
    String results[] = {"Straight flush","Poker","Full House","Flush","Straight","Three of a kind","Two pairs","Pair","Nothing"};
    int result = calculateResult(selectedCards);
    System.out.println("Congratulations! You have got: " + results[result]);
}

 private static int calculateResult(String selectedCards[][]) {
    if ( isStraightFlush(selectedCards) ) {
        return 0;
    }
    else if ( isPoker(selectedCards) ) {
        return 1;
    }
    else if ( isFullHouse(selectedCards) ) {
        return 2;
    }
    else if ( isFlush(selectedCards) ) {
        return 3;
    }
    else if ( isStraight(selectedCards) ) {
        return 4;
    }
    else if ( isThreeOfAKind(selectedCards) ) {
        return 5;
    }
    else if ( isTwoPairs(selectedCards) ) {
        return 6;
    }
    else if ( isPair(selectedCards) ) {
        return 7;
    }
    else {
        return 8;
    }
}

 private static boolean isStraightFlush(String selectedCards[][]){
  // All cards are of the same suit
  // Consecutive ranks
  String ranks[] = {"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
  String suits[] = {"spades","hearts","clubs","diamonds"};
  int rankCount[] = new int[ranks.length];
  int suitCount[] = new int[suits.length];

  for(int i = 0; i < selectedCards.length; i++ ) {
    String rank = selectedCards[i][1];
    int rankIndex = indexOf(rank,ranks);
    if ( rankIndex >= 0 ) {
      rankCount[rankIndex]++;
    }
    String suit = selectedCards[i][0];
    int suitIndex = indexOf(suit,suits);
    if ( suitIndex >= 0 ) {
      suitCount[suitIndex]++;
    }
  }

  // We should have a suitCount of 4 on one index
  int indexSuitCountFour = indexOf(4,suitCount);
  if (indexSuitCountFour < 0 ) {
      return false;
  }

  // Four suits of the same confirmed, checking for consecutive ranks
  // There should be a sequence of value 1 across the rankCount
  int previousValue = 0;
  int totalRanksInSequence = 0;
  for(int i = 0; i < rankCount.length; i++ ) {
      if ( rankCount[i] > 0 && previousValue == 0 ) {
          previousValue = 1;
          totalRanksInSequence++;
      }
      else if ( previousValue == 1 && rankCount[i] == 0 ) {
          return false;
      }
      else if ( totalRanksInSequence == 5 ) {
          return true;
      }
  }
  return false;
}

 private static boolean isPoker(String selectedCards[][]){
  // Four cards with the same rank
  String ranks[] = {"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
  int rankCount[] = new int[ranks.length];

  for(int i = 0; i < selectedCards.length; i++ ) {
    String rank = selectedCards[i][1];
    int rankIndex = indexOf(rank,ranks);
    if ( rankIndex >= 0 ) {
      rankCount[rankIndex]++;
    }
  }

  for(int i = 0; i < rankCount.length; i++ ) {
      if ( rankCount[i] > 3 ) {
          return true;
      }
  }
  return false;
}

 private static boolean isFullHouse(String selectedCards[][]){
  // Three of a kind plus two of a kind
  String ranks[] = {"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
  int rankCount[] = new int[ranks.length];
  
  for(int i = 0; i < selectedCards.length; i++ ) {
    String rank = selectedCards[i][1];
    int rankIndex = indexOf(rank,ranks);
    if ( rankIndex >= 0 ) {
      rankCount[rankIndex]++;
    }
  }

  boolean threeOfAKind = false;
  boolean twoOfAKind = false;
  for(int i = 0; i < rankCount.length; i++ ) {
    if ( rankCount[i] == 3 ) {
      threeOfAKind = true;
    }
    if ( rankCount[i] == 2 ) {
      twoOfAKind = true;
    }
  }
  if( threeOfAKind && twoOfAKind ) {
    return true;
  }
  return false;
}

 private static boolean isFlush(String selectedCards[][]){
  // All cards sharing same suit
  String suits[] = {"spades","hearts","clubs","diamonds"};
  int suitCount[] = new int[suits.length];
  for(int i = 0; i < selectedCards.length; i++ ) {
    String suit = selectedCards[i][0];
    int index = indexOf(suit,suits);
    if ( index >= 0 ) {
      suitCount[index]++;
    }
  }

  for(int i = 0; i < suitCount.length; i++ ) {
      if ( suitCount[i] > 4 ) {
          return true;
      }
  }
  return false;
}

 private static boolean isStraight(String selectedCards[][]){
  // All cards are consecutive independent of suit
  String ranks[] = {"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
  int rankCount[] = new int[ranks.length];
  
  for(int i = 0; i < selectedCards.length; i++ ) {
    String rank = selectedCards[i][1];
    int rankIndex = indexOf(rank,ranks);
    if ( rankIndex >= 0 ) {
      rankCount[rankIndex]++;
    }
  }

  // For consecutive ranks, there should be a sequence of value 1 across the rankCount
  int previousValue = 0;
  int totalRanksInSequence = 0;
  for(int i = 0; i < rankCount.length; i++ ) {
      if ( previousValue == 1 && rankCount[i] > 0 ) {
          totalRanksInSequence++;
      }
      if ( rankCount[i] > 0 && previousValue == 0 ) {
          previousValue = 1;
          totalRanksInSequence++;
      }
      if ( previousValue == 1 && rankCount[i] == 0 ) {
          return false;
      }
      if ( totalRanksInSequence == 5 ) {
          return true;
      }
  }
  return false;
}

 private static boolean isThreeOfAKind(String selectedCards[][]){
  // Any three cards with the same rank
  String ranks[] = {"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
  int rankCount[] = new int[ranks.length];
  for(int i = 0; i < selectedCards.length; i++ ) {
    String rnk = selectedCards[i][1];
    int index = indexOf(rnk,ranks);
    if ( index >= 0 ) {
      rankCount[index]++;
    }
  }

  for(int i = 0; i < rankCount.length; i++ ) {
      if ( rankCount[i] > 2 ) {
          return true;
      }
  }
  return false;
}

 private static boolean isTwoPairs(String selectedCards[][]){
  // Two pairs of cards with the same rank
  String ranks[] = {"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
  int rankCount[] = new int[ranks.length];
  int pairs = 0;
  for(int i = 0; i < selectedCards.length; i++ ) {
    String rnk = selectedCards[i][1];
    int index = indexOf(rnk,ranks);
    if ( index >= 0 ) {
      rankCount[index]++;
    }
  }

  for(int i = 0; i < rankCount.length; i++ ) {
      if ( rankCount[i] > 1 ) {
          pairs++;
      }
  }
  if ( pairs > 1 ) {
    return true;
  }
  return false;
}

 private static boolean isPair(String selectedCards[][]){
  // Any two cards with the same rank
  String ranks[] = {"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
  int rankCount[] = new int[ranks.length];
  for(int i = 0; i < selectedCards.length; i++ ) {
    String rnk = selectedCards[i][1];
    int index = indexOf(rnk,ranks);
    if ( index >= 0 ) {
      rankCount[index]++;
    }
  }

  for(int i = 0; i < rankCount.length; i++ ) {
      if ( rankCount[i] > 1 ) {
          return true;
      }
  }
  return false;
}
}

