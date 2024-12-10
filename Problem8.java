/*
 * Problem8.java
 */
   
public class Problem8 {
    public static boolean isPal(String s) {
        // replace the following return statement with your implementation
        // of the method.

        ArrayList listString = new ArrayList(s.length());
        for (int i = 0; i < s.length(); i++) {
            listString.addItem(s.charAt(i), i);
        }

        if (listString.length() == 0) {
            return true; //Base case
        }
        else if (listString.length() == 1) {
            /*If the string only has one character, we check if the character is a letter. */
            char ch = (char)listString.getItem(0);
            ch = Character.toLowerCase(ch);
            if (ch >= 97 && ch <= 122) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            /*Trimming any character that is NOT a letter*/
            int first = 0, last = s.length() - 1 ;
            while ( !( Character.toLowerCase( (char)listString.getItem(first) ) >=97 && Character.toLowerCase( (char)listString.getItem(first) ) <= 122) && first < listString.length()) first++;
            while ( !( Character.toLowerCase( (char)listString.getItem(last) ) >=97 && Character.toLowerCase( (char)listString.getItem(last) ) <= 122) && last > 0) last--;

            if (last - first <= 1 ) { 
                /*Check if we are in the base case with one character*/
                if ( last == first) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else if ( Character.toLowerCase( (char)listString.getItem(first) ) == Character.toLowerCase( (char)listString.getItem(last) ) ) { /*Comparing the first alphabetic characters found */
                return isPal(s.substring(first + 1, last));
            }
            else {
                return false;
            }

        }
    }
    
    
    public static void main(String[] args) {
        System.out.println("--- Testing method isPal ---");
        System.out.println();

        System.out.println("(0) Testing on \"A man, a plan, a canal, Panama!\"");
        try {
            boolean results = isPal("A man, a plan, a canal, Panama!");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests
        
        /*
         * We encourage you to add more unit tests below that test a variety 
         * of different cases, although doing so is not required.
         */
    }
}