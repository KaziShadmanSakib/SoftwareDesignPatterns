import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.lang.Math;

/* Interface of a Sentence Generator */
interface ISentenceGenerator{
	public void addWordToVocabulary(String word);
	public String generateSentence();
}


/* Random Sentence Generator - RSG Type */
class RandomSentenceGenerator implements ISentenceGenerator{
	private ArrayList<String> internalVocabularyRSG = new ArrayList<String>();
	private String[] wordsToBeAddedRSG;
	private int randomAmountOfWordsRSG;
	private String generatedSentenceRSG = "";
	/* Singleton */
	private static RandomSentenceGenerator instance;

	private RandomSentenceGenerator(){
		System.out.println("Random Sentence Generator Initiated.\n");
	}

	public static RandomSentenceGenerator getInstance() {
        // if the class is not created before then it will be created
        if (instance == null) {      
            instance = new RandomSentenceGenerator();
        }
        return instance;
    }

	@Override
	public void addWordToVocabulary(String words){
		
		/* Lower casing all the input words */
		words = words.toLowerCase(Locale.ROOT);
		
		/* Here we are splitting a number of words from a given input String
		of words based on the space between them */
		wordsToBeAddedRSG = words.split(" ");

		/* Here we are adding all the words to the internal vocabulary */
		for(String word : wordsToBeAddedRSG){

			/* Here we are checking if the internal vocabulary already
			contains the word or not, if it does then we simply continue by
			not adding the word to vocabulary */
			if(internalVocabularyRSG.contains(word)){
				continue;
			}
			/* If the internal vocabulary does not contain the word, then we
			add it to the internal vocabulary */
			else{
				internalVocabularyRSG.add(word);
	
			}

		}

		if(wordsToBeAddedRSG.length == 1){
			System.out.println("Successfully added a word.\n");
		}
		else{
			System.out.println("Successfully added " + wordsToBeAddedRSG.length + " words.\n");
		}

	}

	@Override
	public String generateSentence(){
		Random random = new Random();
		generatedSentenceRSG = "";
		/* using random for getting random amount of words that
		generates our sentences where minimum amount of word would be 1
		and maximum amount of word would be internalVocabularyRSG.size() + 1 */
		if (internalVocabularyRSG.size() > 0){
			randomAmountOfWordsRSG = random.nextInt(internalVocabularyRSG.size() + 1 - 1) + 1;	
		}
		else{
			randomAmountOfWordsRSG = 0;
			return generatedSentenceRSG;
		}
		
		System.out.println(randomAmountOfWordsRSG + " words are in the generated sentence.\n");

		/* Concatenating random amount of words randomly from internal 
		vocabulary */
		for(int i=0;i<randomAmountOfWordsRSG;i++){
			int randomIndex = random.nextInt(internalVocabularyRSG.size());
			generatedSentenceRSG = generatedSentenceRSG + internalVocabularyRSG.get(randomIndex) + " ";
		}

		return generatedSentenceRSG;
	}


}

/* Sorted Sentence Generator - SSG Type */
class SortedSentenceGenerator implements ISentenceGenerator{
	private ArrayList<String> internalVocabularySSG = new ArrayList<String>();
	private String[] wordsToBeAddedSSG;
	private int randomAmountOfWordsSSG;
	private String generatedSentenceSSG = "";
	/* Singleton */
	private static SortedSentenceGenerator instance;

	private SortedSentenceGenerator(){
		System.out.println("Sorted Sentence Generator Initiated.\n");
	}

	public static SortedSentenceGenerator getInstance() {
        // if the class is not created before then it will be created
        if (instance == null) {
            instance = new SortedSentenceGenerator();
        }
        return instance;
    }

	@Override
	public void addWordToVocabulary(String words){
		
		/* Lower casing all the input words */
		words = words.toLowerCase(Locale.ROOT);
		
		/* Here we are splitting a number of words from a given input String
		of words based on the space between them */
		wordsToBeAddedSSG = words.split(" ");

		/* Here we are adding all the words to the internal vocabulary */
		for(String word : wordsToBeAddedSSG){

			/* Here we are checking if the internal vocabulary already
			contains the word or not, if it does then we simply continue by
			not adding the word to vocabulary */
			if(internalVocabularySSG.contains(word)){
				continue;
			}
			/* If the internal vocabulary does not contain the word, then we
			add it to the internal vocabulary */
			else{
				internalVocabularySSG.add(word);
	
			}

		}

		if(wordsToBeAddedSSG.length == 1){
			System.out.println("Successfully added a word.\n");
		}
		else{
			System.out.println("Successfully added " + wordsToBeAddedSSG.length + " words.\n");
		}

	}

	@Override
	public String generateSentence(){
		Random random = new Random();
		generatedSentenceSSG = "";
		/* using random for getting random amount of words that
		generates our sentences where minimum amount of word would be 1
		and maximum amount of word would be internalVocabularySSG.size() + 1 */
		if (internalVocabularySSG.size() > 0){
			randomAmountOfWordsSSG = random.nextInt(internalVocabularySSG.size() + 1 - 1) + 1;	
		}
		else{
			randomAmountOfWordsSSG = 0;
			return generatedSentenceSSG;
		}

		System.out.println(randomAmountOfWordsSSG + " words are in the generated sentence.\n");

		/* Concatenating random amount of words randomly from internal 
		vocabulary */
		for(int i=0;i<randomAmountOfWordsSSG;i++){
			int randomIndex = random.nextInt(internalVocabularySSG.size());
			generatedSentenceSSG = generatedSentenceSSG + internalVocabularySSG.get(randomIndex) + " ";
			
		}

		/* Now sorting will be done according to the sentence generated randomly*/
		ArrayList<String> sortGeneratedSentenceSSG = new ArrayList<String>();

		/* Slitting the randomly generated sentence */
		String[] generatedSentenceWord = generatedSentenceSSG.split(" ");

		/* Adding the words to an arraylist to sort them later */
		for(String word : generatedSentenceWord){

			sortGeneratedSentenceSSG.add(word);

		}

		/* Collections.sort() sorts the words */
		Collections.sort(sortGeneratedSentenceSSG);
		
		generatedSentenceSSG = "";

		for(int i=0;i<sortGeneratedSentenceSSG.size();i++){
			generatedSentenceSSG = generatedSentenceSSG + sortGeneratedSentenceSSG.get(i) + " ";
			
		}

		return generatedSentenceSSG;

	}



}

/* Ordered Sentence Generator - OSG Type */
class OrderedSentenceGenerator implements ISentenceGenerator{
	private ArrayList<String> internalVocabularyOSG = new ArrayList<String>();
	private String[] wordsToBeAddedOSG;
	private String generatedSentenceOSG = "";
	/* Singleton */
	private static OrderedSentenceGenerator instance;

	private OrderedSentenceGenerator(){
		System.out.println("Ordered Sentence Generator Initiated.\n");
	}

	public static OrderedSentenceGenerator getInstance() {
        // if the class is not created before then it will be created
        if (instance == null) {      
            instance = new OrderedSentenceGenerator();
        }
        return instance;
    }


	@Override
	public void addWordToVocabulary(String words){
		
		/* Lower casing all the input words */
		words = words.toUpperCase(Locale.ROOT);
		
		/* Here we are splitting a number of words from a given input String
		of words based on the space between them */
		wordsToBeAddedOSG = words.split(" ");

		/* We will use StringBuilder reverseString to reverse a word*/
		StringBuilder reverseWord = new StringBuilder();

		/* Here we are adding all the words to the internal vocabulary */
		for(String word : wordsToBeAddedOSG){

			/* Adding the word to string builder */
			reverseWord.append(word);
			/* Reversing the word using string builder */
			reverseWord.reverse();

			/* Here we are checking if the internal vocabulary already
			contains the word or not, if it does then we simply continue by
			not adding the word to vocabulary */
			if(internalVocabularyOSG.contains(reverseWord.toString())){
				continue;
			}
			/* If the internal vocabulary does not contain the word, then we
			add it to the internal vocabulary */
			else{
				internalVocabularyOSG.add(reverseWord.toString());
	
			}

			/* Deleteing the word from the StringBuilder after the word is 
			added successfully */
			reverseWord.delete(0, word.length());

		}

		if(wordsToBeAddedOSG.length == 1){
			System.out.println("Successfully added a word.\n");
		}
		else{
			System.out.println("Successfully added " + wordsToBeAddedOSG.length + " words.\n");
		}

	}

	@Override
	public String generateSentence(){
		generatedSentenceOSG = "";
		for(int i=0;i<internalVocabularyOSG.size();i++){
			generatedSentenceOSG = generatedSentenceOSG + internalVocabularyOSG.get(i) + " ";
		}

		return generatedSentenceOSG;
	}

}

class SentenceGeneratorAdapter{
    private Scanner scan = new Scanner(System.in);
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Boolean exitQuery;
    private String words;
    private int choice;
    
    // Here ISG represent Sentence Generator
    public void process(ISentenceGenerator ISG) throws IOException {
        exitQuery = false;
        while (!exitQuery) {
            System.out.println( "Please choose an instruction!" + "\n" +
                                "1. Add words " + "\n" +
                                "2. Generate sentence " + "\n" +
                                "3. Exit " + "\n");
            System.out.print("Choice of input: ");
            choice = scan.nextInt();
            System.out.print("\n");
            if (choice == 1) {
                System.out.print("Please add words separated by space : ");
                words = reader.readLine();
                System.out.print("\n");
                ISG.addWordToVocabulary(words);
            } 
            else if (choice == 2) {
                String generatedSentence = ISG.generateSentence();
                if (generatedSentence == "") {
                    System.out.println("The vocabulary is empty. Please add some words.\n");
                } 
                else {
                    System.out.println("Generated Sentence : " + generatedSentence + "\n");
                }
            } 
            else if (choice == 3) {
                exitQuery = true;
            }
        }
    }
}

public class SentenceGenerator97{
	private static int choice;
	private static ISentenceGenerator sentenceGeneratorType;
    private static SentenceGeneratorAdapter sentenceGeneratorAdapter = new SentenceGeneratorAdapter();
    private static Boolean exitQuery;
	
	public static void initiateUI(){
		System.out.println("Which Sentence Generator type would you like to choose?\n" +

							"1. Random Sentence Generator\n" +
							"2. Sorted Sentence Generator\n" +
							"3. Ordered Sentence Generator\n" +
							"4. Exit\n");
	}

	public static void main(String[] args) throws IOException, IllegalArgumentException {
		
		Scanner choiceScan = new Scanner(System.in);
		exitQuery = false;
        while (!exitQuery){
        	initiateUI();
			System.out.print("Choice of input: ");
			choice = choiceScan.nextInt();
			System.out.print("\n");
			switch(choice) {
			  
			  case 1:
			    sentenceGeneratorType = RandomSentenceGenerator.getInstance();
			    break;
			  
			  case 2:
			    sentenceGeneratorType = SortedSentenceGenerator.getInstance();
			    break;
			 
			  case 3:
			    sentenceGeneratorType = OrderedSentenceGenerator.getInstance();
			    break;
			  
			  case 4:
			    System.out.println("Have a good day!!");
			    exitQuery = true;
			    return;

			  default:
			    break;
			}

			sentenceGeneratorAdapter.process(sentenceGeneratorType);
		}
	}
}