package Grafy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class ZnajdowanieSciezkiDFS {
    public static void main(String[] args) throws FileNotFoundException {
        ZnajdowanieSciezkiDFS znajdowanieSciezkiDFS = new ZnajdowanieSciezkiDFS();
        znajdowanieSciezkiDFS.znajdzSciezke();
    }

    private HashMap<Integer, ArrayList<Integer>> graf;
    private Stack<Integer> S = new Stack<>();
    private boolean[] visited;
    private int vk = -1;
    private int vs = -1;

    public void znajdzSciezke() throws FileNotFoundException {
        parse();
        if(DFS(vs)){
            while (!S.empty()){
                System.out.println(S.pop());
            }
        }
        else {
            System.out.println("BRAK Ścieżki");
        }
    }

    private void parse() throws FileNotFoundException {
        File in = new File("./src/Grafy/Files/input.in");
        Scanner sc = new Scanner(in);

        String[] firstLine = sc.nextLine().split(" "); //tutaj liczba wierzchołków i krawędzi
        int amountOfVertex = Integer.parseInt(firstLine[0]); //parsujemy liczbę wierzchołków
        int amountOfEdges = Integer.parseInt(firstLine[1]); //parsujemy liczbę krawędzi

        visited = new boolean[amountOfVertex]; //tablica odwiedzonych

        graf = new HashMap<>();

        int edgesCounter = 0;
        for (int i = 0; i < amountOfVertex; i++) { //dopóki mamy wierzchołki
            String[] line = sc.nextLine().split(" "); //dzilimy linie po spacjach
            for (int j = 0; j < line.length; j+=2) { //i przeskakujemy co 2 jakby było więcej sąsiadów
                int key = Integer.parseInt(line[j]); //sczytujemy wierzchołek
                int value = Integer.parseInt(line[j+1]); //i jego sąsiada
                if (!graf.containsKey(key)) { //jeżeli jeszcze nie mamy w grafie naszego wierzchołka
                    graf.put(key, new ArrayList<>()); //dodajemy i tworzymy nową listę sąsiadów
                }

                graf.get(key).add(value);
            }
        }
        vs = Integer.parseInt(sc.nextLine()); //parsujemy wierzchołek początkowy
        vk = Integer.parseInt(sc.nextLine()); //parsujemu wierzchołek końcowy
    }

    public boolean DFS(int currentVertex){
        visited[currentVertex] = true; //oznaczamy wierzchołek jako odwiedzony
        S.push(currentVertex); //wrzucamy go na stos

        if(currentVertex == vk){ //jeżeli jesteśmy w wierzchołku końcowym
            return true; //kończymy zwracając true
        }

        ArrayList<Integer> sasiedzi = graf.get(currentVertex); //rozpakowujemy sąsiadów

        for (int i = 0; i < sasiedzi.size(); i++) { //dla każdego sąsiada
            if(visited[sasiedzi.get(i)]){ //jeżeli został już odwiedzony to pomijamy
                continue;
            }
            if(DFS(sasiedzi.get(i))){ //rekurencyjnie wywołujemy przeszukiwanie i jeżeli uda się znaleźć zwracamy true
                return true;
            }
        }

        S.pop(); //jeżeli nie udało się znaleźć zwracamy false i ściągamy dany wierzchołek ze stosu
        return false;
    }
}
