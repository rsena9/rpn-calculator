package edu.cnm.deepdive;

import java.util.Arrays;

/**
 * Enumerated values representing operator in a postfix (RPN) calculator. Each opreator has a token
 * that is used to recognize the operatior in a string and to recogognize the operator in an input
 * string and tor epresent the operator output dtring java doc comments
 */
public enum Operator {


  ADD("+"),

  SUBTRACT("-"),

  MULTIPLY("*"),

  DIVIDE("/"),

  SQUARE_ROOT("sqrt"),

  POWER("^"),

  MODULO("%");

  private String token;

  Operator(String token) {
    this.token = token;

  }


  public static void main(String[] args) {
    System.out.println(Arrays.toString(Operator.values()));
  }


  @Override
  public String toString() {
    return token;
  }

  public static String tokenPattern(){
    return "(?:^|\\s)(\\+|\\-|\\*|\\/|\\^|\\%|sqrt)( ?:\\s)";
  }
}
