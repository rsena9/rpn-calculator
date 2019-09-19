package edu.cnm.deepdive;

import java.io.InputStream;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.LinkedList;

public class Calculator {


  public static void main(String[] args) {
    Calculator calc = new Calculator();
    calc.process(System.in);
  }

  //REMOVE...operands = new LinkedList<>();

  public void process(InputStream in) {
    // in example throws comment above  here..throws NoSuchElementException
    private Deque<Double> operands = new LinkedList<>();

    try (Scanner scanner = new Scanner(in)) {

      while (scanner.hasNextDouble()) {
        operands.push(scanner.nextDouble());
      }
    } catch (NoSuchElementException ignored) {
      //end of input; complete processing
    } finally {

      System.out.println(operands);

    }
  }
}


