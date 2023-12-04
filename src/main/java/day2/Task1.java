package day2;

import common.InputReader;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Task1 {

    public void solve(){
        InputReader inputReader = new InputReader();
        List<String> lines = inputReader.readInputLines("day2/1.txt");
        Map<Integer, List<Draw>> games = convertLinesToGames(lines);
        int sum = 0;
        for (var entry : games.entrySet()) {
            if(isValidGame(entry.getValue())){
                sum+= entry.getKey();
            }
        }
        System.out.println(sum);

    }

    private boolean isValidGame(List<Draw> draws) {
        AtomicBoolean isValid = new AtomicBoolean(true);
        draws.forEach(draw -> {
            if(draw.getBlueAmount() > 14 || draw.getGreenAmount() > 13 || draw.getRedAmount() > 12){
                isValid.set(false);
            }
        });
        return isValid.get();
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
        Task1 task1 = new Task1();
        task1.solve();
    }
}
