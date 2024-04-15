package com.example;

import java.util.*;

// output data
public class TestOutput {

  boolean hasGold;

  public String toString() {
    String s = "";
    s += String.format("hasGold: %s\n", hasGold);
    return s;
  }
}
