package day2;

import common.InputReader;

import java.util.*;

public class Task2 {

    public void solve(){
        InputReader inputReader = new InputReader();
        List<String> lines = inputReader.readInputLines("day2/1.txt");
        Map<Integer, List<Draw>> games = convertLinesToGames(lines);
        int sum = 0;
        for (var entry : games.entrySet()) {
            sum+= getPowerOfGame(entry.getValue());
        }
        System.out.println(sum);

    }

    private int getPowerOfGame(List<Draw> value) {
        Draw powerDraw = new Draw();
        value.forEach(draw -> {
            if(powerDraw.getRedAmount() < draw.getRedAmount()){
                powerDraw.setRedAmount(draw.getRedAmount());
            }
            if(powerDraw.getGreenAmount() < draw.getGreenAmount()){
                powerDraw.setGreenAmount(draw.getGreenAmount());
            }
            if(powerDraw.getBlueAmount() < draw.getBlueAmount()){
                powerDraw.setBlueAmount(draw.getBlueAmount());
            }
        });
        return powerDraw.getBlueAmount() * powerDraw.getRedAmount() * powerDraw.getGreenAmount();
    }

    private Map<Integer, List<Draw>> convertLinesToGames(List<String> lines) {
        var map = new HashMap<Integer, List<Draw>>();
        lines.forEach(line -> {
            line = line.replace("Game ", "");
            String[] numberAndGames = line.split(":");
            var game = numberAndGames[1].split(";");
            List<Draw> draws = new ArrayList<>();
            Arrays.stream(game).forEach(drawsSplit -> {
                draws.add(convertGameStringToGame(drawsSplit));
            });
            map.put(Integer.valueOf(numberAndGames[0]), draws);
        });
        return map;
    }

    private Draw convertGameStringToGame(String game) {
        String[] split = game.split(",");
        Draw draw = new Draw();
        Arrays.stream(split).forEach(oneColor -> {
            String[] numberAndColor = oneColor.split(" ");
            var color = numberAndColor[2];
            switch (color) {
                case "blue" -> draw.setBlueAmount(Integer.parseInt(numberAndColor[1]));
                case "red" -> draw.setRedAmount(Integer.parseInt(numberAndColor[1]));
                case "green" -> draw.setGreenAmount(Integer.parseInt(numberAndColor[1]));
            }
        });
        return draw;
    }


    public static void main(String[] args) {
        Task2 task2 = new Task2();
        task2.solve();
    }
}
