package cipher;

import java.util.Random;

public class HomophonicCipher {
	
	private String message;
	private String alphabet        = "abcdefghijklmnopqrstuvwxyz";  //Member variable for storing the original alphabet
	
	private String[][] alphaCipher = new String[26][];              //Cipher variable for storing a homophonic cipher
	                                                                //the first dimension is the amount of letters in the alphabet
	                                                                //the second dimension will be jagged to avoid frequency analysis
	private int[] frequencies      = new int[26];                   //Variable used for storing the frequencies of letters in the alphabet
	private String[][] ranSeqAlpha = {{"x"},
									  {"i"},
									  {"g"},
									  {"n"},
									  {"c"},
									  {"v"},
									  {"q"},
									  {"b"},
									  {"t"},
									  {"a"},
									  {"d"},
									  {"s"},
									  {"p"},
									  {"f"},
									  {"h"},
									  {"e"},
									  {"o"},
									  {"z"},
									  {"r"},
									  {"k"},
									  {"u"},
									  {"l"},
									  {"y"},
									  {"m"},
									  {"w"},
									  {"j"}};          
	
	public HomophonicCipher(String message) {
		this.message = message;
		initializeFrequencies();
		printFreqArray();
		System.out.println("///////////////////////////");
	}
	
	
	private void initializeFrequencies() {
		String c     = "";
		String messageVar = eliminateSpaces(this.message);
		int length   = messageVar.length();
		int position = 0;
		for(int i = 0; i < length; i++) {
			c = ("" + messageVar.charAt(i));
			position = this.alphabet.indexOf(c);
			System.out.println("Position -> " + position);
			this.frequencies[position]++;
		}
	}
	
	private String eliminateSpaces(String message) {
		String messRef = "";                                    //Use this variable to store the string without spaces
		message += " ";                                         //Prepend a space so it immediately positions the arrow (position of space immediately
		int arrow = 0;                                          //Position of space
		int length = message.length();                          //Length of the original message
		boolean isSpace = false;                                //Determine if there is a space

		//Loop through the entire message to find all spaces
		for (int i = 0; i < length; i++) {
			isSpace = ("" + message.charAt(i)).equals(" ");     //See if there is a space at the current character index
			if (isSpace) {                                      //If there is a space
				messRef += message.substring(arrow, i);         //Get the substring after the first space (See why it's necessary) and between 
				arrow = i + 1;
			}
		}
		return messRef;
	}
	
	private void printFreqArray() {
		for(int i = 0; i < 26; i++) {
			System.out.println(this.alphabet.charAt(i) + " -> " + this.frequencies[i]);
		}
	}
	
	
	public static void main(String[] args) {
		HomophonicCipher message = new HomophonicCipher("ian anna oden");
	}

}
