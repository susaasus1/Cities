package org.example.algotihms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Prima {
    Map<String, LinkedList<String>> graph = new HashMap<>();
    Map<String, Integer> length = new HashMap<>();
    Map<String, Boolean> visited = new HashMap<>();
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
    }

    public Prima() {
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

        length.put("Одесса", 0);
        length.put("Киев", 442);
        length.put("Харьков", 442);
        length.put("Симферополь", 312);
        length.put("Вильнюс", 988);
        length.put("Даугавпилс", 1086);
        length.put("Каунас", 1056);
        length.put("Таллин", 1494);
        length.put("Рига", 1251);
        length.put("Кишинев", 154);
        length.put("Житомир", 447);
        length.put("Волгоград", 1060);
        length.put("Калининград", 1165);
        length.put("Воронеж", 845);
        length.put("Витебск", 969);
        length.put("Брест", 807);
        length.put("Ярославль", 1395);
        length.put("Орел", 706);
        length.put("Ниж.Новгород", 1427);
        length.put("С.Петербург", 1498);
        length.put("Донецк", 723);
        length.put("Москва", 1137);
        length.put("Минск", 857);
        length.put("Мурманск", 2506);
        length.put("Казань", 1644);
        length.put("Уфа", 1991);
        length.put("Самара", 1577);

    }

    public void search() {
        System.out.println("6)Жадный Алгоритм");
        System.out.println("________________________________________________");
        String curCity = "";
        ArrayList<String> path = new ArrayList<>();
        curCity = cit;
        visited.put(cit, true);
        path.add(cit);
        while (true) {
            int min = Integer.MAX_VALUE;
            String s = "";
            for (String i : graph.get(cit)) {
                if (length.get(i) < min && !visited.get(i)) {
                    min = length.get(i);
                    s = i;
                }
            }
            visited.put(s, true);
            cit = s;
            path.add(cit);
            if (cit.equals(cit2)){
                break;
            }
        }
        System.out.println(path);
        System.out.println("________________________________________________");
        System.out.println("Алгоритм нашел путь!\n\n");
    }
}
