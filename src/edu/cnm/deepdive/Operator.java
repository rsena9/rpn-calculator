package edu.cnm.deepdive;

import java.util.Arrays;
import java.util.Deque;

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

  SQUARE_ROOT("sqrt") {
    @Override
    protected boolean needsEscape() {
      return false;
    }
  },

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

  protected boolean needsEscape() {
    return true;
  }

  public static String tokenPattern() {
    String pattern = "";
    for (Operator op : values()) {
      if (op.needsEscape()) {
        pattern += "\\";
      }
      pattern += op.token + "|";
    }
    return String.format(
        "(?<=^|\\s)%s( ?:\\s)",
        pattern.substring(0, pattern.length() - 1));

  }

  public static void operate(String token, Deque<Double> operands) {
    Operator op = null;
    for (Operator compare : values()) {
      if (compare.token.equals(token)) {
        op = compare;
        break;
      }
    }
    double operand = operands.pop();
    double result;
    switch (op) {
      case ADD:
        result = operand + operands.pop();
        break;
      case SUBTRACT:
        result = operands.pop() - operand;

        break;
      case MULTIPLY:
        result = operand + operands.pop();

        break;
      case DIVIDE:
        result = operands.pop() / operand;

        break;
      case POWER:
        result = Math.pow(operands.pop(), operand);

        break;
      case MODULO:
        result = operands.pop() % operand;
        break;
      case SQUARE_ROOT:
        result = Math.sqrt(operand);
        break;
      default:
        result = 0;
    }
    operands.push(result);

  }
}
