//Import regex libraries
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

//class takes array as input and performs regex match and replace
public class arrayRegex {

    //input regular expression to match here
    private static final String REGEX = "(^\\s+)";

    //what you want to replace your match with
    private static final String REPLACE = "";

    //function performs REGEX matching, if found replaces with specified REPLACE value
    public String do_regex(String str) {

        //try catch block, throws error if anything fails in regex matching
        try {

            // Create a Pattern object
            Pattern pattern = Pattern.compile(REGEX);

            // Now create matcher object.
            Matcher matcher = pattern.matcher(str);

            //if we find a match to our regex then enter and replace
            if (matcher.find( )) {

                //return a string with our replaced values to the function caller
                return matcher.replaceAll(Matcher.quoteReplacement(REPLACE));

                //if we dont find a match, tell user and return original string
            } else {

                //return original string to function caller without modification
                return str;

            }

            //try catch block, catches errors and prints error message to terminal
        } catch(Exception e) {

            //If there's an Error catch it and display the exception message
            System.out.println("Exception: " + e.getMessage());
        }

        //return original string to function caller if anything goes wrong
        return str;

    }

    //function to print a string array in order
    public void print_array(String[] arr) {

        //loops through each string in passed array and prints
        for (String s : arr) {
            System.out.println("\"" + s + "\"");
        }
    }

    //main function, used for calling other functions and setup
    public static void main( String[] args) {

        //creates instance of program class for dynamic function calling
        arrayRegex callFunc = new arrayRegex();

        //check if string array passed to main method is not zero
        if(args.length > 0) {

            //Print out original array passed to program
            System.out.println("\nOriginal Array:");
            callFunc.print_array(args);

            //create an arrayList of strings to hold input string values
            List<String> listOfStr = new ArrayList<>();

            //copy contents of args to arrayList
            Collections.addAll(listOfStr, args);

            //create an arrayList of strings to hold modified string values
            List<String> newStr = new ArrayList<>();

            //Create parallel streams for each value in arrayList of input strings
            listOfStr.parallelStream().forEachOrdered( s -> {

                //call regex function on current input string
                        // and add to newStr arrayList holding our modified strings
                newStr.add(callFunc.do_regex(s));

            }
            );

            //create new string array the same size as our arrayList of new strings
            String[] strArray = new String[newStr.size()];

            //asssign all values from arraylist to our new string array
            strArray = newStr.toArray(strArray);

            //Print out modified array
            System.out.println("\nModified Array:");
            callFunc.print_array(strArray);

        } else {

            //display no arguments passed to terminal
            System.out.println("No Arguments passed to main method!");

        }

    }
}