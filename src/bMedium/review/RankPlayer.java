package bMedium.review;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class RankPlayer {
    public static List<Integer> climbingLeaderboardAuthor(List<Integer> ranked, List<Integer> players) {

        int[] rankArr = new int[ranked.size()];

        for (int i = 0; i < ranked.size(); i++) {
            if (i == 0) {
                rankArr[i] = 1;
            } else if (Objects.equals(ranked.get(i), ranked.get(i - 1))) {
                rankArr[i] = rankArr[i - 1];
            } else {
                rankArr[i] = rankArr[i - 1] + 1;
            }
        }

        int index = ranked.size()-1;

        List<Integer> result = new ArrayList<>();
        for (Integer player : players) {
            int playerRank;

            while (index >= 0 && player > ranked.get(index)) {
                index--;
            }

            if (index == -1) {
                playerRank = 1;
            } else if (player < ranked.get(index)) {
                playerRank = rankArr[index] + 1;
            } else {
                playerRank = rankArr[index];
            }

            result.add(playerRank);
        }


        return result;
    }


    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

        List<Integer> rankSetList = new ArrayList<>(new TreeSet<>(ranked));
        List<Integer> result = new ArrayList<>();

        int playIdx = 0;
        int rankIdx = 0;
        int rankSetSize = rankSetList.size();

        while (rankIdx < rankSetSize) {
            int bbb = rankSetList.get(rankIdx);
            while (playIdx < player.size() && player.get(playIdx) < bbb) {
                result.add(rankSetSize - rankIdx + 1);
                playIdx++;
            }
            while (playIdx < player.size() && player.get(playIdx) > rankSetList.get(rankSetSize - 1)) {
                result.add(1);
                playIdx++;
            }
            rankIdx++;
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input_rank.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Rank.txt"));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = climbingLeaderboardAuthor(ranked, player);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
