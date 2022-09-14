// Names: Eddie Lemmon and Ted Laesch
// Course: Computer Science 4500 Introduction to the Software Profession
// Due date: September 16, 2022
// Purpose of program: To take a string of characters and see what words can be formed from said characters.

import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws FileNotFoundException {
        String S;
        int wordcount = 0;//Counts the total number of words.
        ArrayList<String> arr = new ArrayList<String>(); // The arrayList that the permutations of the user input will go into
        ArrayList<String> out = new ArrayList<String>(); // The arrayList that will contain successfully matched strings
        //The following nine arrayLists will contain strings of specific sizes.
        ArrayList<String> two = new ArrayList<String>(); 
        ArrayList<String> three = new ArrayList<String>();
        ArrayList<String> four = new ArrayList<String>();
        ArrayList<String> five = new ArrayList<String>();
        ArrayList<String> six = new ArrayList<String>();
        ArrayList<String> seven = new ArrayList<String>();
        ArrayList<String> eight = new ArrayList<String>();
        ArrayList<String> nine = new ArrayList<String>();
        ArrayList<String> ten = new ArrayList<String>();
        String alphafile = "src/words_alpha.txt"; // The name of the file
        File f = new File(alphafile); // The actual file
        Scanner sc= new Scanner(System.in);
        do
        {
            System.out.println("Enter a string that contains only letters and is no less than 3, and no greater than ten");
            S = sc.nextLine(); // The string the user will enter
            if (S.length() >= 3 && S.length() <= 10) // Checking to see if the string length is between 3 and 10, inclusive
            {
                if(!S.matches("[a-zA-Z]+")) // Checking if string contains only letter characters
                    System.out.println("Sorry, that string is not valid");
            }
            else
                System.out.println("Sorry, that string is not valid"); // if string does not between 3 and 10, inclusive
        }
        while(S.length() < 3 || 10 < S.length() || !S.matches("[a-zA-Z]+")); // The string cannot be greater than 10, less than 3, or contain a non-letter character
        String s = S.toLowerCase(); // Converts any uppercase letters to lowercase ones
        findPermutations(s, "", arr);
        Scanner scanner = new Scanner(f); // This is the scanner used to check the lines of the file
        while (scanner.hasNextLine()) // This will read every line of the file
        {
            String data = scanner.nextLine(); // Data string is used to check individual lines in a file
            if(data.length() <= s.length()) // Checking if line in a file matches or is less than the length of the input string
            {
                // Iterate over every value in the array "arr"
                for (String value : arr) {
                    if (Objects.equals(value, data)) {
                        // Check to make sure we didn't already match this string
                        if (!out.contains(data)) {
                            wordcount++; //adds to the word count
                            out.add(data); // add successfully matched string to the output arrayList
                            switch(data.length())//Switch statement adds data to size-based arrayLists
                            {
                                case 2:
                                    two.add(data);
                                    break;
                                case 3:
                                    three.add(data);
                                    break;
                                case 4:
                                    four.add(data);
                                    break;
                                case 5:
                                    five.add(data);
                                    break;
                                case 6:
                                    six.add(data);
                                    break;
                                case 7:
                                    seven.add(data);
                                    break;
                                case 8:
                                    eight.add(data);
                                    break;
                                case 9:
                                    nine.add(data);
                                    break;
                                case 10:
                                    ten.add(data);
                                    break;
                                        
                            }
                                
                        }
                    }
                }
            }
        }
        scanner.close(); // Closes the file
        int wordplace = 0;//Keeps count of a word's place when listed.
        //If statements will ensure that only lists that have elements will print.
        if(two.length() > 0)
        if(three.length() > 0)
        if(four.length() > 0)
        if(five.length() > 0)
        if(six.length() > 0)
        if(seven.length() > 0)
        if(eight.length() > 0)
        if(nine.length() > 0)
        if(ten.length() > 0)
        // Just for testing: print out the "out" array
        System.out.println(Arrays.toString(out.toArray()));
        //Prints the total amount of the array
        System.out.println("Total number of words: " + wordcount);
    }

    // From https://www.geeksforgeeks.org/print-all-permutations-of-a-string-in-java/
    // Website code helped us find all the permutations of a user-entered string to compare against the text file
    static void findPermutations(String str, String ans, ArrayList<String> arr) {

        // Base case: if string is empty
        if (str.length() == 0) {
            arr.add(ans);
            return;
        }

        // For every character in the string
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            // Grabbing every character except for the ith character
            String remainingString = str.substring(0, i) + str.substring(i + 1);

            // Recursive call!
            findPermutations(remainingString, ans + currentChar, arr);
        }
    }
}
