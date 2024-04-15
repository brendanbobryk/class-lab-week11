package com.example;

import java.util.*;

// input data
public class TestInput {

  String river;
  char[] water;
  char[] elements;

  public String toString() {
    String s = "";
    s += String.format("river: %s\n", river);
    s += String.format("water: %s\n", Arrays.toString(water));
    s += String.format("elements: %s\n", Arrays.toString(elements));
    return s;
  }
}
