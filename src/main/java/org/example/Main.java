package org.example;

import org.example.algotihms.*;

public class Main {
    public static void main(String[] args) {
        Bfs bfs = new Bfs();
        bfs.search();
        Dfs dfs = new Dfs();
        dfs.search();
        DfsLimit dfsLimit = new DfsLimit();
        dfsLimit.search();
        DFSiter dfSiter = new DFSiter();
        dfSiter.search();
        DoubleBfs doubleBfs = new DoubleBfs();
        doubleBfs.search();
        Prima prima =new Prima();
        prima.search();
        AStar aStar = new AStar();
        System.out.println("Количество км= "+aStar.search());
    }
}