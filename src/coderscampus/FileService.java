package coderscampus;


	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.LinkedHashSet;
	import java.util.Set;
	import java.util.Map;
	import java.util.HashMap;

	public class FileService {
	    public static Set<String> extractDataFromCSV(String fileName) {
			BufferedReader fileReader = null;
			try {
				String line = null;
				Set<String> cards = new LinkedHashSet<>();
	    		fileReader = new BufferedReader(new FileReader(fileName));
				while ((line = fileReader.readLine()) != null) {
					String[] lineData = line.split(",");
					String hand = new String(lineData[1]);
					cards.add(hand);
				}
				cards.remove("Winning Hand");
				fileReader.close();
				return cards;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (fileReader != null) {
						fileReader.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
	            }
			}
			return null;
		}

	    public static Map<String, Integer> extractDataForMap(String fileName) {
			BufferedReader fileReader = null;
			try {
				String line = null;
				Map<String, Integer> hands = new HashMap<>();
	    		fileReader = new BufferedReader(new FileReader(fileName));
				while ((line = fileReader.readLine()) != null) {
	                String lineFirst = fileReader.readLine();
	                System.out.println(lineFirst);
					String[] lineData = line.split(",");
					String key = new String(lineData[0]);
	                String value = new String(lineData[1]);
	                if (value != "Winning Hand") {
		                if(hands.isEmpty() && value !="Winning Hand") {
		                	System.out.println(value);
		                	hands.put(key, Integer.parseInt(value));
		                } else {
		                	for (String i : hands.keySet()) {
			                	if (i.equals(key)) {
			                		System.out.println("i: " + i + " key: " + key); 
			                		hands.put(key, (Integer.parseInt(value)+1));
			                	} else {
			                		hands.put(key,Integer.parseInt(value));
			                	}
		                	}
		                }
	                }
				}


				//hands.remove("Winning Hand");
	            System.out.println(hands);
				return hands;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (fileReader != null) {
						fileReader.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
	            }
			}
			return null;
		}
	}

