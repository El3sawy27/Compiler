package syntaxtest;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;


 class SyntaxAnalyzer {
    private List<String> tokens;
    private int TokenIndex;
    

    public SyntaxAnalyzer(List<String> tokens) {
        this.tokens = tokens;
        this.TokenIndex = 0;
    }
    
    

    public void parse() {
        while (TokenIndex < tokens.size()) {
            atom();
        }
   System.out.println("Syntax Analysis Successful: Input is syntactically correct!");
    }

    public void atom() {
       
        if (matchIdentifier() || matchLiteral() || matchNumbers()|| matchOperator()) {
            System.out.println("Atom: " + tokens.get(TokenIndex - 1));
        }else {
           
            System.out.println("Syntax Error: Unexpected token '" + tokens.get(TokenIndex) + "'");
            TokenIndex++; 
        }
    }

    private boolean matchIdentifier() {
        String token = tokens.get(TokenIndex);
        if (token.matches("[a-zA-Z][_a-zA-Z0-9]*")) {
            TokenIndex++;
            System.out.println("identifier");
            return true;
        }
        return false;
    }


      private boolean matchNumbers() {
        String token = tokens.get(TokenIndex);
        if (token.matches("[0-9]*")) {
            TokenIndex++;
            System.out.println("Numbers");
            return true;
        }
        return false;
    }
      
       private boolean matchOperator() {
        String token = tokens.get(TokenIndex);
        if (token.matches("\\+|\\-|\\*|\\/|\\%|\\=|\\>|\\<|\\!")) {
            TokenIndex++;
            System.out.println("Operators");
            return true;
        }
        return false;
    }
       
    private boolean matchLiteral() {
        String token = tokens.get(TokenIndex);
        if (token.matches("\"[^\"]*\"")) {
           TokenIndex++;
           System.out.println("Literal");
            return true;
        }
        
        return false;
    }
    
    
}

public class SyntaxTest {
    
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);

        List<String> tokens = new ArrayList<>();
        System.out.print("Enter num of words: ");
        
        int num=scanner.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.print("Enter words: ");
            String word=scanner.next();
            tokens.add(word);
        }
        
        
        SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer(tokens);
        syntaxAnalyzer.parse();
        

        
    }
  

}
