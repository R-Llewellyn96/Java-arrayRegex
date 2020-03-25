//Import regex libraries
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//class takes array as input and performs regex match and replace
public class arrayRegex {

    //input regular expression to match here
    private static final String REGEX = "(^\\s+)"; //(\\d+)(.*)";

    //what you want to replace your match with
    private static final String REPLACE = "";

    //function performs regex matching, if found replaces with specified
    public String do_regex(String str) {

        //try catch block, throws error if anything fails in regex matching
        try {

            // Create a Pattern object
            Pattern pattern = Pattern.compile(REGEX);

            // Now create matcher object.
            Matcher matcher = pattern.matcher(str);

            //if we find a match to our regex then enter and replace
            if (matcher.find( )) {

                //Replace matched regex with replace value and assign to newStr variable
                String newStr = matcher.replaceAll(Matcher.quoteReplacement(REPLACE));

                //Print new string with replacements to screen
                //System.out.println("New String  : \"" + newStr + "\"");

                //return a string with our replaced values to the function caller
                return newStr;

                //if we dont find a match, tell user and return original string
            } else {

                //if there's no match then display and return nothing
                //System.out.println("NO MATCH");

                //return original string to function caller
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

    public void print_array(String arr[]) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println("\"" + arr[i] + "\"");
        }
    }

    //main function, used for calling other functions and setup
    public static void main( String args[] ) {

        //creates instance of program class for dynamic function calling
        arrayRegex callFunc = new arrayRegex();

        //declares line string variable
        String line = "";  //This order was placed for QT3000! OK?

        //check if string array passed to main method is not zero
        if(args.length > 0) {


            System.out.println("\nOriginal Array:");
            callFunc.print_array(args);


            //assign passedArray variable to the values passed in args
            String[] passedArray = args;

            //loop through each string passed as argument to main method
            for(int i = 0; i < passedArray.length; i++) {

                //assign line to value of passed arg
                line = passedArray[i];

                //print the input string to terminal
                //System.out.println("Input String: \"" + line + "\"");

                //calls function to perform regex match and replace on input string
                String newStr = callFunc.do_regex(line);

                //assign returned string from function to array index value
                passedArray[i] = newStr;

            }

            System.out.println("\nModified Array:");
            callFunc.print_array(passedArray);

        } else {

            //display no arguments passed to terminal
            System.out.println("No Arguments passed to main method!");

        }

    }
}