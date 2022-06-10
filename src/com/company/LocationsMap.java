package com.company;

public class LocationsMap {
    int numOfScanes;
    int[][] adjointMatrix;

   public LocationsMap(int[][] mat, int v){
        adjointMatrix = mat;
        numOfScanes = v;
   }

    void addRoad(int src, int dest, int edgeWeight) {
        adjointMatrix[src][dest] = edgeWeight;
        adjointMatrix[dest][src] = edgeWeight;
    }
}