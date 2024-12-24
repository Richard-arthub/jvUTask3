package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListTimeComparator
{
    private ArrayList<Character> AL;
    private LinkedList<Character> LL;

    public ListTimeComparator()
    {
        AL = new ArrayList<>();
        LL = new LinkedList<>();
    }

    private void plot(String testedMethod, int iterations, double ALtime, double LLtime)
    {
        JFrame frame = new JFrame();
        frame.setTitle("Comparation Results");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Object[][] data = { {"Tested Operation", testedMethod}, {"Iterations Number", iterations}, {"ArrayList Time", ALtime}, {"LinkedList Time", LLtime} };
        String[] columnNames = {"Parameter", "Value"};
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public void addingOperation(int iterations)
    {
        //add, measure time
        plot("Adding", iterations, 0, 0);
        // delete nodes
    }
}
