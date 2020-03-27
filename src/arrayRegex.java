// Import regex libraries
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Import array and list libraries for parallelization
import java.util.List;
import java.util.ArrayList;

// Class takes array as input and performs regex match and replace
public class arrayRegex {

    // Input regular expression to match here
    private static final String REGEX = "(^\\s+)";

    // What you want to replace your match with
    private static final String REPLACE = "";

    // Function performs REGEX matching, if found replaces with specified REPLACE value
    public String do_regex(String str) {

        // Try catch block, throws error if anything fails in regex matching
        try {

            // Create a Pattern object, containing our REGEX
            Pattern pattern = Pattern.compile(REGEX);

            // Create Matcher object, run against passed string
            Matcher matcher = pattern.matcher(str);

            // If we find a match to our regex then enter and replace
            if (matcher.find( )) {

                // Return a string with our replaced values to the function caller
                return matcher.replaceAll(Matcher.quoteReplacement(REPLACE));

                // If we dont find a match, return original string
            } else {

                // Return original string to function caller without modification
                return str;

            }

            // Try catch block, catches errors and prints error message to terminal
        } catch(Exception e) {

            // If there's an Error catch it and display the exception message
            System.out.println("Exception: " + e.getMessage());
        }

        // Return original string to function caller if anything goes wrong
        return str;

    }

    // Function to print a string array in order
    public void print_array(String[] arr) {

        // Loops through each string in passed array and prints
        for (String s : arr) {
            System.out.println("\"" + s + "\"");
        }
    }

    // Main function, used for calling other functions and setup
    public static void main( String[] args) {

        // Creates instance of program class for dynamic function calling
        arrayRegex callFunc = new arrayRegex();

        // Check if string array passed to main method is not zero
        if(args.length > 0) {

            // Print out original array passed to program
            System.out.println("\nOriginal Array:");
            callFunc.print_array(args);

            // Create an arrayList of strings to hold input string values
            List<String> listOfStr = new ArrayList<>();

            // Copy contents of args to arrayList
            Collections.addAll(listOfStr, args);

            // Create an arrayList of strings to hold modified string values
            List<String> newStr = new ArrayList<>();

            // Create parallel streams for each value in arrayList of input strings
            listOfStr.parallelStream().forEachOrdered( s -> {

                // Call REGEX function on current input string
                        // and add to newStr arrayList holding our modified strings
                newStr.add(callFunc.do_regex(s));

            });

            // Create new string array the same size as our arrayList of new strings
            String[] strArray = new String[newStr.size()];

            // Assign all values from arrayList to our new string array
            strArray = newStr.toArray(strArray);

            // Print out modified array
            System.out.println("\nModified Array:");
            callFunc.print_array(strArray);

            // If arguments passed to main method are zero, tell user and terminate
        } else {

            // Display no arguments passed to main method, to terminal
            System.out.println("Error: No Arguments passed to main method!");

            // Terminate program
            System.exit(0);

        }

    }
}