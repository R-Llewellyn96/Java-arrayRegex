//Import regex libraries
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        //declares line string variable
        String line;

        //check if string array passed to main method is not zero
        if(args.length > 0) {

            //Print out original array passed to program
            System.out.println("\nOriginal Array:");
            callFunc.print_array(args);

            //loop through each string passed as argument to main method
            for(int i = 0; i < args.length; i++) {

                //assign line to value of passed arg
                line = args[i];

                //calls function to perform regex match and replace on input string
                String newStr = callFunc.do_regex(line);

                //assign returned string from function to array index value
                args[i] = newStr;

            }

            //Print out modified array
            System.out.println("\nModified Array:");
            callFunc.print_array(args);

        } else {

            //display no arguments passed to terminal
            System.out.println("No Arguments passed to main method!");

        }

    }
}