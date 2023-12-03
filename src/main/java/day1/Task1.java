package day1;

import common.InputReader;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {

    public void solve() {
        InputReader inputReader = new InputReader();
        List<String> lines = inputReader.readInputLines("day1/1.txt");
        AtomicInteger sum = new AtomicInteger();
        lines.forEach(line -> sum.addAndGet(makeNumberFromFirstAndLastDigit(line)));
        System.out.println(sum.get());
    }

    private int makeNumberFromFirstAndLastDigit(String line) {
        String numberOnly = line.replaceAll("[^0-9]", "");
        var result = numberOnly.charAt(0) + "" + numberOnly.charAt(numberOnly.length() - 1);
        return Integer.parseInt(result);
    }


    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.solve();
    }
}
