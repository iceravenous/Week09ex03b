package coderscampus;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;


public class SetApplication {
    protected static void setExcercise() {
		Set<String> deck = new LinkedHashSet<>();
		
		
		// extract the data from the CSV
		deck=FileService.extractDataFromCSV("PokerHands.csv");
		printSetToConsole(deck);


		// remove ACE HIGH and QUEEN HIGH
		deck.remove("ACE HIGH");
		deck.remove("QUEEN HIGH");
		System.out.println("-------------");
		printSetToConsole(deck);
		
		// Update PAIR to DEUCES
		deck.remove("PAIR");
		deck.add("DEUCES");
		System.out.println("-------------");
		printSetToConsole(deck);
		
		
	}

    protected static void mapExcercise(){

		Map<String, Integer> players = new HashMap<>();
		Map<String, Integer> tallys = new HashMap<>();
		Integer tally = 0;
		
		players=FileService.extractDataForMap("PokerHands.csv");
        for(String i: players.keySet()){
            System.out.println("key: " + i + " value: " + players.get(i));
        }
		
        System.out.println("-------------");
		System.out.println("Map Excercise");
        printMapToConsole(players);
        
    }
	
	public static void printSetToConsole(Set<String> cards) {
		for (String card : cards) {
			System.out.println(card);
		}
	}

    public static void printMapToConsole(Map<String, Integer> cards) {
		for (Map.Entry<String, Integer> card : cards.entrySet()) {
			System.out.println(card.getKey() + " :" + card.getValue());
		}
	}
}
