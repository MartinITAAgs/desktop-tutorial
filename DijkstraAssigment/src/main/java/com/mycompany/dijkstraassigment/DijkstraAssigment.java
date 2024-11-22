package com.mycompany.dijkstraassigment;
import java.util.*;//ahorrarme todos los imports

public class DijkstraAssigment {

    static class Graph {
        private final Map<String, Map<String, Integer>> adjacenList = new HashMap<>();//grafo no dirigido, {City A, City B, X distance}

        public void addEdge(String city1, String city2, int distance)
        {
            adjacenList.putIfAbsent(city1, new HashMap<>());
            adjacenList.putIfAbsent(city2, new HashMap<>());
            adjacenList.get(city1).put(city2, distance);//ida
            adjacenList.get(city2).put(city1, distance);//regreso
        }

        public Map<String, Integer> getNeighbors(String city) {
            return adjacenList.getOrDefault(city, new HashMap<>());
        }

        public Set<String> getCities() {
            return adjacenList.keySet();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Mi grafo, las ciudades y distancias
        Graph graph = new Graph();
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 5);
        graph.addEdge("B", "C", 3);
        graph.addEdge("C", "D", 2);
        graph.addEdge("D", "E", 3);
        graph.addEdge("E", "F", 3);
        graph.addEdge("E", "H", 10);
        graph.addEdge("F", "G", 3);
        graph.addEdge("G", "H", 1);
        graph.addEdge("G", "I", 2);
        graph.addEdge("H", "I", 5);
        
        

        // Pedir entrada al usuario
        System.out.println("Ciudades disponibles: " + graph.getCities());
        System.out.print("Ingrese la ciudad de inicio: ");
        String InicioCity = sc.nextLine().toUpperCase();

        System.out.print("Ingrese la ciudad de destino: ");
        String FinalCity = sc.nextLine().toUpperCase();

        // Validar ciudades ingresadas
        if (!graph.getCities().contains(InicioCity) || !graph.getCities().contains(FinalCity)) 
        {
            System.out.println("Una o ambas ciudades no existen en el grafo.");
            return;
        }

        //Dijkstra
        Map<String, Integer> shortestDistances = new HashMap<>();
        Map<String, String> previousCities = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (String city : graph.getCities()) {
            shortestDistances.put(city, Integer.MAX_VALUE);}
        
        shortestDistances.put(InicioCity, 0);
        priorityQueue.offer(new AbstractMap.SimpleEntry<>(InicioCity, 0));

        while (!priorityQueue.isEmpty()) {
            Map.Entry<String, Integer> currentEntry = priorityQueue.poll();
            String currentCity = currentEntry.getKey();
            int currentDistance = currentEntry.getValue();

            if (currentDistance > shortestDistances.get(currentCity)) {
                continue;
            }

            for (Map.Entry<String, Integer> neighbor : graph.getNeighbors(currentCity).entrySet()) {
                String neighborCity = neighbor.getKey();
                int edgeDistance = neighbor.getValue();
                int newDistance = currentDistance + edgeDistance;

                if (newDistance < shortestDistances.get(neighborCity)) {
                    shortestDistances.put(neighborCity, newDistance);
                    previousCities.put(neighborCity, currentCity);
                    priorityQueue.offer(new AbstractMap.SimpleEntry<>(neighborCity, newDistance));
                }
            }
        }

        // resultados
        if (shortestDistances.get(FinalCity) == Integer.MAX_VALUE) {
            System.out.println("No hay conexión entre " + InicioCity + " y " + FinalCity + ".");//si no hay forma de llegar
        } else {
            System.out.println("Distancia más corta: " + shortestDistances.get(FinalCity));

            List<String> path = new ArrayList<>();
            String currentCity = FinalCity;
            while (currentCity != null) {
                path.add(currentCity);
                currentCity = previousCities.get(currentCity);
            }
            Collections.reverse(path);

            System.out.println("Ruta: " + String.join(" -> ", path));
        }

        sc.close();
    }
}
