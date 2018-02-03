package net.orb15.antlr4demo;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

  public static void main(String[] args) {

    String input = "(1+2)*3-(4+2)";

    //stream of chars (for a given code point / unicode thing)
    CodePointCharStream inputStream = CharStreams.fromString(input);

    //create a lexer to generate a stream of tokens
    ExprLexer exprLexer = new ExprLexer(inputStream);

    //...and actually generate those tokens
    CommonTokenStream tokenStream = new CommonTokenStream(exprLexer);

    //create the parser to process the token stream
    ExprParser exprParser = new ExprParser(tokenStream);

    //create a vistor for the parser
    DemoExprVisitor exprVisitor = new DemoExprVisitor();

    //kick off the visitor by starting with PROG token
    System.out.println();
    Double result = exprVisitor.visitProg(exprParser.prog());
    System.out.println();
    System.out.println(input + " = " + result);

    System.out.println();
    System.out.println("done!");
    System.out.println();

  }
}
