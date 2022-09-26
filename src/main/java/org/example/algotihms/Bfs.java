package org.example.algotihms;

import java.util.*;

public class Bfs {
    Map<String, LinkedList<String>> graph = new HashMap<>();
    Map<String, Boolean> visited = new HashMap<>();
    String cit = "Вильнюс";

    public void addGraph(String city1, String city2) {
        if (graph.get(city1) == null) {
            graph.put(city1, new LinkedList<>());
        }
        if (graph.get(city2) == null) {
            graph.put(city2, new LinkedList<>());
        }
        LinkedList<String> c1 = graph.get(city1);
        c1.add(city2);
        graph.put(city1, c1);
        LinkedList<String> c2 = graph.get(city2);
        c2.add(city1);
        graph.put(city2, c2);
        visited.put(city1, false);
        visited.put(city2, false);
    }

    public Bfs() {
        addGraph("Вильнюс", "Брест");
        addGraph("Витебск", "Брест");
        addGraph("Витебск", "Вильнюс");
        addGraph("Воронеж", "Витебск");
        addGraph("Воронеж", "Волгоград");
        addGraph("Волгоград", "Витебск");
        addGraph("Витебск", "Ниж.Новгород");
        addGraph("Вильнюс", "Даугавпилс");
        addGraph("Калининград", "Брест");
        addGraph("Калининград", "Вильнюс");
        addGraph("Каунас", "Вильнюс");
        addGraph("Киев", "Вильнюс");
        addGraph("Киев", "Житомир");
        addGraph("Житомир", "Донецк");
        addGraph("Житомир", "Волгоград");
        addGraph("Кишинев", "Киев");
        addGraph("Кишинев", "Донецк");
        addGraph("С.Петербург", "Витебск");
        addGraph("С.Петербург", "Калининград");
        addGraph("С.Петербург", "Рига");
        addGraph("Москва", "Казань");
        addGraph("Москва", "Ниж.Новгород");
        addGraph("Москва", "Минск");
        addGraph("Москва", "Донецк");
        addGraph("Москва", "С.Петербург");
        addGraph("Мурманск", "С.Петербург");
        addGraph("Мурманск", "Минск");
        addGraph("Орел", "Витебск");
        addGraph("Орел", "Донецк");
        addGraph("Орел", "Москва");
        addGraph("Одесса", "Киев");
        addGraph("Рига", "Каунас");
        addGraph("Таллинн", "Рига");
        addGraph("Харьков", "Киев");
        addGraph("Харьков", "Симферополь");
        addGraph("Ярославль", "Воронеж");
        addGraph("Ярославль", "Минск");
        addGraph("Уфа", "Казань");
        addGraph("Уфа", "Самара");
    }

    public void search() {
        System.out.println("1)BFS");
        System.out.println("________________________________________________");
        String city1 = "Вильнюс";
        String city2 = "Одесса";
        Queue<String> q = new ArrayDeque<>();
        LinkedList<LinkedList<String>> paths = new LinkedList<>();
        visited.put(city1, true);
        paths.add(new LinkedList<>());
        paths.get(0).add(city1);
        q.add(city1);

        while (!q.isEmpty()) {
            city1 = q.poll();
            paths.add(new LinkedList<>());
            paths.getLast().add(city1);
            for (String i : graph.get(city1)) {
                paths.getLast().add(i);
            }
            System.out.println(city1 + ":" + graph.get(city1));
            for (String i : graph.get(city1)) {
                if (!visited.get(i)) {
                    visited.put(i, true);
                    q.add(i);
                }
            }
            if (q.contains(city2)) {
                break;
            }

        }
        Stack k = new Stack();
        while (true) {
            for (LinkedList<String> i : paths) {
                if (i.contains(city2)) {
                    k.push(city2);
                    city2 = i.getFirst();
                    break;
                }
            }
            if (city2.equals(cit)) {
                k.push(cit);
                System.out.println("");
                System.out.print("Путь :");
                while(!k.isEmpty()) {
                    System.out.print(k.pop() + " ");
                }
                System.out.println("\n________________________________________________");
                System.out.println("Алгоритм нашел путь!\n\n");
                break;
            }
        }

    }
}
