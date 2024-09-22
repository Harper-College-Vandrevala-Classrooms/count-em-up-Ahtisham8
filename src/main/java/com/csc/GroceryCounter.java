package com.csc;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;

public class GroceryCounter {
  // Put your code here!
  ArrayList<Integer> counter = new ArrayList<>();
  int overFlows = 0;

  public GroceryCounter()
  {
    counter.add(0, 0);
    counter.add(1, 0);
    counter.add(2, 0);
    counter.add(3, 0);
  }
  public void tens(){
    counter.set(0, counter.get(0)+1);

    if (counter.get(0) >= 10) {
      counter.set(0, 0);
      overFlows++;
    }
  }

  public void ones(){
    counter.set(1, counter.get(1)+1);

    if (counter.get(1) >= 10) {
      counter.set(1, 0);
      tens();
    }
  }

  public void tenths(){
    counter.set(2, counter.get(2)+1);

    if (counter.get(2) >= 10) {
      counter.set(2, 0);
      ones();
    }
  }

  public void hundreths(){
    counter.set(3, counter.get(3)+1);

    if (counter.get(3) >= 10) {
      counter.set(3, 0);
      tenths();
    }
  }

  public String total()
  {
    String countString = "";
    NumberFormat nf = NumberFormat.getNumberInstance();
    nf.setGroupingUsed(true);
    nf.setMinimumFractionDigits(2);
    nf.setMaximumFractionDigits(2);

    for(int i = 0; i <= 3; i++)
    {
      int valAtIndex = counter.get(i);
      countString += Integer.toString(valAtIndex);
    }

    int countTotal = Integer.parseInt(countString);

    BigDecimal total = new BigDecimal(countTotal).movePointLeft(2);

    String output = "$" + nf.format(total.doubleValue());

    return output;
  }

  public int numberOfOverflows()
  {
    return overFlows;
  }

  public void clear()
  {
    counter.set(0, 0);
    counter.set(1, 0);
    counter.set(2, 0);
    counter.set(3, 0);

    overFlows = 0;
  }

  public static void main(String[] args) {
    GroceryCounter counter = new GroceryCounter();

System.out.println(counter.total()); // This would print out $0.00

counter.tens();
counter.tens();
counter.tens();
counter.hundreths();
counter.tenths();

System.out.println(counter.total()); // This would print out $84.11
System.out.println(counter.numberOfOverflows()); // This would print out 0

for(int i = 0; i < 54; i++) {
  counter.ones();
}

System.out.println(counter.total()); // This would print out $84.11
System.out.println(counter.numberOfOverflows()); // This would print out 0

for(int i = 0; i < 100; i++) {
  counter.ones();
}

System.out.println(counter.total()); // This would print out $84.11
System.out.println(counter.numberOfOverflows()); // This would print out 1

counter.clear();

System.out.println(counter.total()); // This would print out $0.00
System.out.println(counter.numberOfOverflows()); // This would print out 0
  }
}
