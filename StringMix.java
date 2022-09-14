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
        ArrayList<String> arr = new ArrayList<String>(); // The arrayList that the permutations of the user input will go into
        ArrayList<String> out = new ArrayList<String>(); // The arrayList that will contain successfully matched strings
        String [] two, three, four, five, six, seven, eight, nine, ten; // Arrays containing strings of specific lengths
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
                // Iterate over ever value in the array "arr"
                for (String value : arr) {
                    if (Objects.equals(value, data)) {
                        // Check to make sure we didn't already match this string
                        if (!out.contains(data)) {
                            out.add(data); // add successfully matched string to the output arrayList
                        }
                    }
                }
            }
        }
        scanner.close(); // Closes the file

        // Just for testing: print out the "out" array
        System.out.println(Arrays.toString(out.toArray()));
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
