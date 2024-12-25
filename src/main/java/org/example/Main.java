package org.example;

public class Main {
    public static void main(String[] args)
    {
        ListTimeComparator comparator = new ListTimeComparator();
        comparator.addingOperation(10000);
        comparator.gettingOperation(10000);
        comparator.deletingOperation(10000);
    }
}