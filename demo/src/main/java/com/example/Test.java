package com.example;

import java.util.*;

public class Test {

  TestInput input = new TestInput();
  TestOutput output = new TestOutput();

  public String toString() {
    String s = "";

    s += String.format("input:\n");
    s += input.toString();

    s += String.format("output:\n");
    s += output.toString();

    return s;
  }
}
