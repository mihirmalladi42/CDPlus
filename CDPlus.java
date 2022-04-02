//MUST HAVE AT MINIMUM 2 NUMBERS BEFORE C AND + DUE TO INDEXOUTOFBOUNDSEXCEPTION ERROR
//Lines 3 to 5 import necessary java.util packages
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
public class CDPlus {
    public static void main(String[] args) {
        //Lines 9 to 18 define the array for use. Line 19 prints the inputted array.
        Scanner makeNums = new Scanner(System.in);
        System.out.println("How many scores points are there? (Enter a number)");
        int ans = makeNums.nextInt();
        String[] chars = new String[ans];
        for (int maker = 0; maker < ans; maker++) {
            Scanner newNum = new Scanner(System.in);
            System.out.println("What is number " + (maker + 1) + "? (If you are entering 'C', make sure there are two numbers before it. Numbers include 'D' or '+') (AN ERROR MAY OCCUR IF THERE ARE NOT TWO NUMBERS BEFORE '+')");
            String resp = newNum.nextLine();
            chars[maker] = resp;
        }
        System.out.println(Arrays.toString(chars));
        //Line 21 defines the index of the arraylist throughout use. Line 22 is the sum of the resulting arraylist. Line 23 defines the arraylist.
        int indexNewChars = 0;
        int sum = 0;
        ArrayList<Integer>newNums = new ArrayList<Integer>();
        //Lines 25 to 39 check all the inputs and give an output. This is the main body of the code.
        for (int checker = 0; checker < chars.length; checker++) {
            if (!chars[checker].equalsIgnoreCase("C") && !chars[checker].equalsIgnoreCase("D") && !chars[checker].equalsIgnoreCase("+")) {
                newNums.add(Integer.parseInt(chars[checker]));
                indexNewChars++;
            } else if (chars[checker].equalsIgnoreCase("C")) {
                indexNewChars--;
                newNums.remove(indexNewChars);
            } else if (chars[checker].equalsIgnoreCase("D")) { 
                newNums.add((newNums.get(newNums.size()-1)) * 2);
                indexNewChars++;
            } else if (chars[checker].equals("+")) {
                newNums.add((newNums.get(indexNewChars-1)) + (newNums.get(indexNewChars-2)));
                indexNewChars++;
            }
        }
        //Lines 41, 42, and 43 add everything together
        for (int adder = 0; adder < newNums.size(); adder++) {
            sum += newNums.get(adder);
        }
        //Line 45 prints the result
        System.out.println("The result is " + sum + ".");
    }
}
