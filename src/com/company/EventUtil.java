package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EventUtil {

    public static final double price_for_km = 2.5;

    public static List<Scene> createConcertPlan(Scene[] scene){

        ArrayList<Scene> scenes = new ArrayList<>();
        int i, j;
        i = 0;
        scenes.add(scene[i]);
        for (j = 1; j < scene.length; j++) {
            if (scene[j].getEvent().getStart().isAfter(scene[i].getEvent().getFinish())) {
                scenes.add(scene[j]);
                i = j;
            }
        }
        return scenes;

    }

    public static int[] shortestPathBetweenScenes(LocationsMap matrix, int src) {
        int[] distance = new int[matrix.numOfScanes];
       //initial distance is infinite
       Arrays.fill(distance, Integer.MAX_VALUE);
       boolean[] visited = new boolean[matrix.numOfScanes];
       Arrays.fill(visited, false);
       distance[src] = 0;
       for (int i = 0; i < matrix.numOfScanes; i++) {
           int closestVertex = getClosestLocation(distance, visited);
           visited[closestVertex] = true;
           for (int j = 0; j < matrix.numOfScanes; j++) {
               if (!visited[j]) {
                   if (matrix.adjointMatrix[closestVertex][j] != 0) {
                       int d = distance[closestVertex] + matrix.adjointMatrix[closestVertex][j];
                       if (d < distance[j])
                           distance[j] = d;
                   }
               }
           }
       }
       return distance;
    }

    public static int getClosestLocation(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] < min)
                if (!visited[i]) {
                    min = distance[i];
                    minIdx = i;
                }
        }
        return minIdx;
    }


}
