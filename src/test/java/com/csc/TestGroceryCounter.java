package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGroceryCounter {

  GroceryCounter counter;

  @BeforeEach
  void setUp() {
    counter = new GroceryCounter();
  }

  // Put your tests here!

  @Test
  void itWorks() {
    assertEquals(true, true);
  }

  @Test
  void checkDefaultValue() {
    assertEquals("$0.00", counter.total());
  }
}
