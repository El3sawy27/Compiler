/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package syntaxtest;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lexicaTest {
    
       static String Keywords = "\\b(float|double|int|if|else|elseIf|while|for|System\\.out\\.println)\\b";
       static String Identifiers = "\\b[a-zA-Z_]\\w*\\b";
       static String Literals = "\"[^\"]*\"";
       static String Numeric_constant="\\b[0-9]+\\b";
       static String Operators = "\\+|\\-|\\*|\\/|\\%|\\=|\\>|\\<|\\!";


 
    public static void main(String[] args) {

       
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write The Code: ");
        String user_input = scanner.nextLine();
       
        String regular_expression = Keywords + "|" + Identifiers + "|" + Literals + "|" + Operators+"|"+Numeric_constant;
        Pattern pattern = Pattern.compile(regular_expression);

        Matcher matcher = pattern.matcher(user_input);
        while (matcher.find()) {
            String token = matcher.group();
            String Type = Get_type(token);
            System.out.println("Token: " + token + "        Type: " + Type);
        }
    }

    private static String Get_type(String token) {
        if (token.matches(Keywords)) {
            return "Keyword";
        } else if (token.matches(Identifiers)) {
            return "Identifier";
        } else if (token.matches(Literals)) {
            return "Literal";
        } else if (token.matches(Operators)) {
            return "Operator";
        }else if (token.matches(Numeric_constant )) {
            return "numeric constant";
        } else {
            return "error";
        }
    }
    
}