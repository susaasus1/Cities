package org.example.algotihms;

import java.util.*;

public class AStar {

    LinkedList<String> cities = new LinkedList<>();
    int[] heuritics = new int[27];
    int[][] graph = new int[27][27];

    HashMap<Integer, Integer> cit = new HashMap<>();

    public void addGraph(int i, int j, int k) {
        graph[i][j] = k;
        graph[j][i] = k;
    }

    public AStar() {
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                graph[i][j] = 0;
            }
        }
        for (int i = 0; i < 27; i++) {
            cit.put(i, null);
        }
        //граф заполнение
        addGraph(4, 15, 531);
        addGraph(15, 14, 638);
        addGraph(4, 14, 360);
        addGraph(14, 13, 869);
        addGraph(13, 11, 581);
        addGraph(11, 14, 1455);
        addGraph(14, 18, 911);
        addGraph(4, 5, 211);
        addGraph(15, 12, 699);
        addGraph(12, 4, 333);
        addGraph(4, 6, 102);
        addGraph(1, 4, 734);
        addGraph(1, 10, 131);
        addGraph(10, 20, 863);
        addGraph(10, 11, 1493);
        addGraph(1, 9, 467);
        addGraph(9, 20, 812);
        addGraph(19, 14, 602);
        addGraph(19, 12, 739);
        addGraph(19, 8, 641);
        addGraph(21, 24, 815);
        addGraph(21, 18, 411);
        addGraph(21, 22, 690);
        addGraph(21, 20, 1084);
        addGraph(21, 19, 664);
        addGraph(19, 23, 1412);
        addGraph(23, 22, 2238);
        addGraph(17, 14, 522);
        addGraph(17, 20, 709);
        addGraph(17, 21, 368);
        addGraph(0, 1, 487);
        addGraph(6, 8, 267);
        addGraph(7, 8, 308);
        addGraph(2, 1, 471);
        addGraph(2, 3, 639);
        addGraph(16, 13, 739);
        addGraph(16, 22, 940);
        addGraph(24, 25, 525);
        addGraph(25, 26, 461);
        //сами города
        cities.add("Одесса");//0 finish
        cities.add("Киев");//1
        cities.add("Харьков");//2
        cities.add("Симферополь");//3
        cities.add("Вильнюс");//4 start
        cities.add("Даугавпилс");//5
        cities.add("Каунас");//6
        cities.add("Таллин");//7
        cities.add("Рига");//8
        cities.add("Кишинев");//9
        cities.add("Житомир");//10
        cities.add("Волгоград");//11
        cities.add("Калининград");//12
        cities.add("Воронеж");//13
        cities.add("Витебск");//14
        cities.add("Брест");//15
        cities.add("Ярославль");//16
        cities.add("Орел");//17
        cities.add("Ниж.Новгород");//18
        cities.add("С.Петербург");//19
        cities.add("Донецк");//20
        cities.add("Москва");//21
        cities.add("Минск");//22
        cities.add("Мурманск");//23
        cities.add("Казань");//24
        cities.add("Уфа");//25
        cities.add("Самара");//26
        //длины эвристической
        heuritics[0] = 0;
        heuritics[1] = 442;
        heuritics[2] = 569;
        heuritics[3] = 312;
        heuritics[4] = 988;
        heuritics[5] = 1086;
        heuritics[6] = 1056;
        heuritics[7] = 1494;
        heuritics[8] = 1251;
        heuritics[9] = 154;
        heuritics[10] = 447;
        heuritics[11] = 1060;
        heuritics[12] = 1165;
        heuritics[13] = 845;
        heuritics[14] = 969;
        heuritics[15] = 807;
        heuritics[16] = 1395;
        heuritics[17] = 706;
        heuritics[18] = 1427;
        heuritics[19] = 1498;
        heuritics[20] = 723;
        heuritics[21] = 1137;
        heuritics[22] = 857;
        heuritics[23] = 2506;
        heuritics[24] = 1644;
        heuritics[25] = 1991;
        heuritics[26] = 1577;

//        heuritics[0] = 500;
//        heuritics[1] = 150;
//        heuritics[2] = 630;
//        heuritics[3] = 1700;
//        heuritics[4] = 1000;
//        heuritics[5] = 1200;
//        heuritics[6] = 940;
//        heuritics[7] = 1500;
//        heuritics[8] = 1200;
//        heuritics[9] = 450;
//        heuritics[10] = 0;
//        heuritics[11] = 1400;
//        heuritics[12] = 970;
//        heuritics[13] = 870;
//        heuritics[14] = 640;
//        heuritics[15] = 460;
//        heuritics[16] = 1300;
//        heuritics[17] = 680;
//        heuritics[18] = 1500;
//        heuritics[19] = 1300;
//        heuritics[20] = 870;
//        heuritics[21] = 1000;
//        heuritics[22] = 510;
//        heuritics[23] = 2600;
//        heuritics[24] = 1900;
//        heuritics[25] = 2200;
//        heuritics[26] = 1800;
    }

    public double search() {
        System.out.println("7)Astar");
        System.out.println("________________________________________________");
        ArrayList<String> path = new ArrayList<>();
        int start = 4;
        int goal = 0;
        Integer variable = goal;
        path.add(cities.get(goal));
        int[] distances = new int[graph.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        double[] priorities = new double[graph.length];
        Arrays.fill(priorities, Integer.MAX_VALUE);
        priorities[start] = heuritics[start];
        boolean[] visited = new boolean[graph.length];
        while (true) {
            double lowestPriority = Integer.MAX_VALUE;
            int lowestPriorityIndex = -1;
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] < lowestPriority && !visited[i]) {
                    lowestPriority = priorities[i];
                    lowestPriorityIndex = i;
                }
            }
            if (lowestPriorityIndex == -1) {
                return -1;
            } else if (lowestPriorityIndex == goal) {
                while (start != variable) {
                    path.add(cities.get(cit.get(variable)));
                    variable = cit.get(variable);
                }
                for (int i = path.size() - 1; i >= 0; i--) {
                    System.out.println(path.get(i));
                }
                System.out.println("________________________________________________");
                System.out.println("Алгоритм нашел путь!\n\n");
                return distances[lowestPriorityIndex];
            }
            for (int i = 0; i < graph.length; i++) {
                if (graph[lowestPriorityIndex][i] != 0 && !visited[i]) {
                    if (distances[lowestPriorityIndex] + graph[lowestPriorityIndex][i] < distances[i]) {
                        distances[i] = distances[lowestPriorityIndex] + graph[lowestPriorityIndex][i];
                        priorities[i] = distances[i] + heuritics[i];
                        cit.put(i, lowestPriorityIndex);
                    }
                }
            }
            visited[lowestPriorityIndex] = true;
        }
    }
}

