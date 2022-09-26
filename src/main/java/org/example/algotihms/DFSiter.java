package org.example.algotihms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DFSiter {
    Map<String, LinkedList<String>> graph = new HashMap<>();
    Map<String, Boolean> visited = new HashMap<>();
    String city1 = "Вильнюс";
    String city2 = "Одесса";
    String city3 = "";
    ;
    int count = -1;

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

    public DFSiter() {
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
        System.out.println("4)DFSiter");
        System.out.println("________________________________________________");
        Map<String, Boolean> visited2 = new HashMap<>();
        for (int i = 1; i <= 4; i++) {
            count=-1;
            visited2.putAll(visited);
            DFS(city1, visited2, i);
            if (!city3.equals(city2)) {
                System.out.println("Нельзя добраться!");
            }
        }
        System.out.println("________________________________________________");
        System.out.println("Алгоритм нашел путь!\n\n");
    }

    public boolean DFS(String city, Map<String, Boolean> visited, int limit) {
        count++;
        visited.put(city, true);
        if (city.equals(city2)) {
            System.out.println(city + " deep" + count);
            city3 = city;
            return true;
        }
        System.out.print(city + " deep" + count + "->");
        for (String cit : graph.get(city)) {
            if (!visited.get(cit)) {
                if (count == limit) {
                    return false;
                }
                boolean res = DFS(cit, visited, limit);
                if (res == true) {
                    return true;
                }
                System.out.print("\u001B[31m" + "Возврат на " + city + "->" + "\u001B[0m");
                count--;
            }
        }
        return false;
    }
}
