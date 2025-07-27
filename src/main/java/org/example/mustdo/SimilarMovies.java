package org.example.mustdo;

import java.util.*;
import java.util.stream.Collectors;

public class SimilarMovies {


    public static void main(String[] args) {
        // Example input
        Map<String, Integer> movieRatings = new HashMap<>();
        movieRatings.put("MOVIE A", 4);
        movieRatings.put("MOVIE B", 6);
        movieRatings.put("MOVIE C", 8);
        movieRatings.put("MOVIE D", 2);

        Map<String, List<String>> movieGraph = new HashMap<>();
        movieGraph.put("MOVIE A", Arrays.asList("MOVIE B"));
        movieGraph.put("MOVIE B", Arrays.asList("MOVIE A", "MOVIE C"));
        movieGraph.put("MOVIE C", Arrays.asList("MOVIE B", "MOVIE D"));
        movieGraph.put("MOVIE D", Arrays.asList("MOVIE C"));

        String movieName = "MOVIE A";
        int n = 2;

        List<String> result = findHighestRatedSimilarMovies(movieName, n, movieRatings, movieGraph);
        System.out.println("Result: " + result);
    }

    private static List<String> findHighestRatedSimilarMovies(String movieName, int n, Map<String, Integer> movieRatings, Map<String, List<String>> movieGraph) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
    //    Map<String, Integer> level = new HashMap<>();

        queue.add(movieName);
        visited.add(movieName);
//        level.put(movieName, 0);

        List<String> similarMovies = new ArrayList<>();

        while (!queue.isEmpty()) {
            String current = queue.poll();
       //     int currentLevel = level.get(current);

            if (!movieName.equals(current)) {
                similarMovies.add(current);
            }

            for (String neighbor : movieGraph.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
               //     level.put(neighbor, currentLevel + 1);
                }
            }
        }

// Sort the similar movies by their ratings in descending order
        similarMovies.sort((m1, m2) -> movieRatings.get(m2) - movieRatings.get(m1));

// Return only the top n movies
        return similarMovies.stream().limit(n).collect(Collectors.toList());
    }
}


