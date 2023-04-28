package language.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static String replace(String str) {
        String s = str.replaceAll("(?i)[pqr]", "");
        return str.equals(s) ? "Not found." : s;
    }

    public static boolean validate(String text) {
        return text.matches("^[\\w]+$");
    }

    public static void main(String[] args) {
        Pattern patterninput = Pattern.compile("^[a-zA-Z_.-]+[0-9]+$");
        String problem1 = "abcd.135";
        Matcher match1= patterninput.matcher(problem1);
        Matcher matchinput1= patterninput.matcher("f4.12b");
        Matcher matchinput2= patterninput.matcher("kjisl.22");
        System.out.println("Question 1: ");
        System.out.println("Match status: " + match1.matches());
        System.out.println("Match status: " + matchinput1.matches());
        System.out.println("Match status: " + matchinput2.matches());
        System.out.println();

        String problem2 = "abcd.135uvqz.7tzik.888";
        Pattern match2 = Pattern.compile("[0-9]+");
        Matcher matcher = match2.matcher(problem2);
        System.out.println("Question 2: ");
        while (matcher.find()){
            System.out.println(matcher.group());
        }
        System.out.println();

        String problem3 = "abcd.135\tuvqz.7\ttzik.888\n";
        Pattern match3 = Pattern.compile("\\d+");
        Matcher match4 = match3.matcher(problem3);
        System.out.println("Question 3: ");
        while (match4.find()) {
            System.out.println(match4.group());
        }
        System.out.println();

        Pattern match5 = Pattern.compile("[0-9]+");
        Matcher match6 = match5.matcher(problem3);
        System.out.println("Question 4: ");
        while (match6.find()){
            System.out.println(match6.start() + ","+(match6.end()-1));
        }
        System.out.println();

        String problem4 = "{0, 2}, {0, 7}, {1, 3}, {2, 4}";
        Pattern match7 = Pattern.compile("\\d, \\d+");
        Matcher match8 = match7.matcher(problem4);
        System.out.println("Question 5: ");
        while (match8.find()){
            System.out.println(match8.group());
        }
        System.out.println();

        Scanner s = new Scanner(System.in);
        System.out.println("Original Text: ");

        String str = s.nextLine();
        System.out.println("Remove p,q,r characters from the said string(if present): " + replace(str));
        System.out.println();

        Scanner text = new Scanner(System.in);
        System.out.println("Sample input: ");

        String text1 = text.nextLine();
        System.out.println("Sample output: " + validate(text1));
    }
}


