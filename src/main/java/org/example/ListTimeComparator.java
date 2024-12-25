package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import static java.lang.Math.abs;

/**
 * Класс для сравнения времени выполнения одинаковых задач - добавление, чтение и удаление элементов - у ArrayList и LinkedList
 *
 */
public class ListTimeComparator
{
    private ArrayList<String> AL;
    private LinkedList<String> LL;

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

    /**
     * Метод позволяет сравнить время добавления элементов в списки
     *
     * @param iterations количество элементов, с которым будет проводиться сравнение
     */
    public void addingOperation(int iterations)
    {
        double ALtime = 0, LLtime = 0;

        ALtime = System.currentTimeMillis();
        for(int i = 0; i < iterations; i++) { AL.add("Dancing Waves"); }
        ALtime = abs(System.currentTimeMillis() - ALtime);

        LLtime = System.currentTimeMillis();
        for(int i = 0; i < iterations; i++) { LL.add("Dancing Waves"); }
        LLtime = abs(System.currentTimeMillis() - LLtime);

        plot("Adding", iterations, ALtime, LLtime);

        AL.clear();
        LL.clear();
    }

    /**
     * Метод позволяет сравнить время чтения элементов из списков
     *
     * @param iterations количество элементов, с которым будет проводиться сравнение
     */
    public void gettingOperation(int iterations)
    {
        double ALtime = 0, LLtime = 0;

        for(int i = 0; i < iterations; i++) { AL.add("Dancing Waves"); }
        for(int i = 0; i < iterations; i++) { LL.add("Dancing Waves"); }

        ALtime = System.currentTimeMillis();
        for(int i = 0; i < iterations; i++) { AL.get(i); }
        ALtime = abs(System.currentTimeMillis() - ALtime);

        LLtime = System.currentTimeMillis();
        for(int i = 0; i < iterations; i++) { LL.get(i); }
        LLtime = abs(System.currentTimeMillis() - LLtime);

        plot("Getting", iterations, ALtime, LLtime);

        AL.clear();
        LL.clear();
    }

    /**
     * Метод позволяет сравнить время удаления элементов из списков
     *
     * @param iterations количество элементов, с которым будет проводиться сравнение
     */
    public void deletingOperation(int iterations)
    {
        double ALtime = 0, LLtime = 0;

        for(int i = 0; i < iterations; i++) { AL.add("Dancing Waves"); }
        for(int i = 0; i < iterations; i++) { LL.add("Dancing Waves"); }

        ALtime = System.currentTimeMillis();
        for(int i = 0; i < iterations; i++) { AL.remove(0); }
        ALtime = abs(System.currentTimeMillis() - ALtime);

        LLtime = System.currentTimeMillis();
        for(int i = 0; i < iterations; i++) { LL.remove(0); }
        LLtime = abs(System.currentTimeMillis() - LLtime);

        plot("Deleting", iterations, ALtime, LLtime);

        AL.clear();
        LL.clear();
    }
}
