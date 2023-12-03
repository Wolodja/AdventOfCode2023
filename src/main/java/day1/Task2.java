package day1;

import common.InputReader;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Task2 {

    public void solve() {
        InputReader inputReader = new InputReader();
        List<String> lines = inputReader.readInputLines("day1/1.txt");
        AtomicInteger sum = new AtomicInteger();
        lines.forEach(line -> sum.addAndGet(makeNumberFromFirstAndLastDigit(line)));
        System.out.println(sum.get());
    }

    private int makeNumberFromFirstAndLastDigit(String line) {
        String replacedLine = replaceStringsWithDigits(line);
        String numberOnly = replacedLine.replaceAll("[^0-9]", "");
        var result = numberOnly.charAt(0) + "" + numberOnly.charAt(numberOnly.length() - 1);
        return Integer.parseInt(result);
    }

    private String replaceStringsWithDigits(String line) {
        line = line.replace("twone", "2ne");
        line = line.replace("eightwo", "8wo");

        // oneeight

        line = line.replace("one", "1");
        line = line.replace("two", "2");
        line = line.replace("three", "3");
        line = line.replace("four", "4");
        line = line.replace("five", "5");
        line = line.replace("six", "6");
        line = line.replace("seven", "7");
        line = line.replace("eight", "8");
        line = line.replace("nine", "9");
        return line;
    }


    public static void main(String[] args) {
        Task2 task2 = new Task2();
        task2.solve();
    }



}
