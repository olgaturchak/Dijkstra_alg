package com.company;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int numOfScanes = 6;

        Scene[] scene = new Scene[numOfScanes];
        scene[0] = new Scene(SceneSpecification.YELLOW, Event.of(LocalTime.of(16, 0), LocalTime.of(18, 20), "Iron Maiden", 130));
        scene[1] = new Scene(SceneSpecification.PINK, Event.of(LocalTime.of(17, 0), LocalTime.of(19, 50), "Judas Priest", 85.7));
        scene[2] = new Scene(SceneSpecification.ORANGE, Event.of(LocalTime.of(18, 50), LocalTime.of(20, 20), "Metallica", 110));
        scene[3] = new Scene(SceneSpecification.BLACK, Event.of(LocalTime.of(19, 30), LocalTime.of(22, 20), "AC~DC", 116));
        scene[4] = new Scene(SceneSpecification.GREEN, Event.of(LocalTime.of(20, 50), LocalTime.of(22, 30), "RHCP", 99));
        scene[5] = new Scene(SceneSpecification.PURPLE, Event.of(LocalTime.of(17, 0), LocalTime.of(19, 30), "Guns N` Roses", 78.5));


        int[][] adjointMatrix = new int[6][6];
        LocationsMap matrix = new LocationsMap(adjointMatrix, numOfScanes);
        matrix.addRoad(0, 1, 2);
        matrix.addRoad(0, 5, 3);
        matrix.addRoad(0, 4, 6);
        matrix.addRoad(1, 4, 3);
        matrix.addRoad(1, 2, 2);
        matrix.addRoad(2, 4, 6);
        matrix.addRoad(2, 3, 3);
        matrix.addRoad(3, 4, 2);
        matrix.addRoad(4, 5, 2);

        int[] distance = EventUtil.shortestPathBetweenScenes(matrix, 0);


        int priceForEvents = 0;
        double priceForTransfer = 0;
        System.out.println("VISITED EVENTS:");
        ArrayList<Scene> scenesFinal = (ArrayList<Scene>) EventUtil.createConcertPlan(scene);
        for (Scene s : scenesFinal) {
            System.out.printf("Scene ~ %-6s #%d  Event -- band <** %-11s **> price %-6.02f, start - %s, finish - %s, duration: %-3d min ***\n",
                    s.getSceneSpecification().getColor(),
                    s.getSceneSpecification().getNum(),
                    s.getEvent().getTitle(),
                    s.getEvent().getPrice(),
                    s.getEvent().getStart().toString(),
                    s.getEvent().getFinish().toString(),
                    s.getEvent().getDuration().toMinutes());

            priceForTransfer+=distance[s.getSceneSpecification().getNum()-1]*EventUtil.price_for_km;
            distance = EventUtil.shortestPathBetweenScenes(matrix, s.getSceneSpecification().getNum()-1);
            priceForEvents += s.getEvent().getPrice();
        }



        System.out.println("price for all events: "+ priceForEvents + " $");
        System.out.println("price for transfer: "+ priceForTransfer + " $");
        System.out.println("total price: " + (priceForEvents + priceForTransfer) + " $" );





    }
}
