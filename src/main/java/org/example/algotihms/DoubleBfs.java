package org.example.algotihms;

import java.util.*;

public class DoubleBfs {
    Map<String, LinkedList<String>> graph = new HashMap<>();
    Map<String, Boolean> visited = new HashMap<>();
    Map<String, Boolean> visited2 = new HashMap<>();
    String cit = "Вильнюс";
    String cit2 = "Одесса";

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
        visited2.put(city1, false);
        visited2.put(city2, false);
    }

    public DoubleBfs() {
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
        System.out.println("5)DoubleBFS");
        System.out.println("________________________________________________");
        String city1 = cit;
        String city2 = cit2;
        Queue<String> q = new ArrayDeque<>();
        LinkedList<LinkedList<String>> paths = new LinkedList<>();
        Queue<String> q2 = new ArrayDeque<>();
        LinkedList<LinkedList<String>> paths2 = new LinkedList<>();
        visited.put(city1, true);
        visited2.put(city2, true);
        paths.add(new LinkedList<>());
        paths.get(0).add(city1);
        paths2.add(new LinkedList<>());
        paths2.get(0).add(city2);
        q.add(city1);
        q2.add(city2);
        String cio = "";
        String cio2 = "";
        boolean t = false;
        while (!q.isEmpty() && !q2.isEmpty()) {
            city1 = q.poll();
            city2 = q2.poll();
            paths.add(new LinkedList<>());
            paths.getLast().add(city1);
            for (String i : graph.get(city1)) {
                paths.getLast().add(i);
            }
            paths2.add(new LinkedList<>());
            paths2.getLast().add(city2);
            for (String i : graph.get(city2)) {
                paths2.getLast().add(i);
            }
            for (String i : graph.get(city1)) {
                if (!visited.get(i)) {
                    visited.put(i, true);
                    q.add(i);
                }
            }
            for (String i : graph.get(city2)) {
                if (!visited2.get(i)) {
                    visited2.put(i, true);
                    q2.add(i);
                }
            }
            for (LinkedList<String> i : paths) {
                for (LinkedList<String> j : paths2) {
                    for (String c : j) {
                        if (i.contains(c)) {
                            cio = c;
                            cio2 = c;
                            t = true;
                            break;
                        }
                    }
                    if (t == true) {
                        break;
                    }
                }
                if (t == true) {
                    break;
                }
            }
            if (t == true) {
                Stack k = new Stack();
                while (true) {
                    for (LinkedList<String> i : paths) {
                        if (i.contains(cio)) {
                            k.push(cio);
                            cio = i.getFirst();
                            break;
                        }
                    }
                    if (cio.equals(cit)) {
                        k.push(cit);
                        break;
                    }
                }
                LinkedList<String> k2 = new LinkedList<>();
                while (true) {
                    for (LinkedList<String> i : paths2) {
                        if (i.contains(cio2)) {
                            k2.add(cio2);
                            cio2 = i.getFirst();
                            break;
                        }
                    }
                    if (cio2.equals(cit2)) {
                        k2.add(cit2);
                        break;
                    }
                }
                while (!k.isEmpty()) {
                    System.out.print(k.pop() + " ");
                }
                k2.remove(0);
                for (String i : k2) {
                    System.out.print(i + " ");
                }

                System.out.println("\n________________________________________________");
                System.out.println("Алгоритм нашел путь!\n\n");
                return;
            }


        }

    }
}
