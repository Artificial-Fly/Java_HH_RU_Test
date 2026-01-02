package org.second;
import java.util.*;

public class Main {
    static List<Integer>[] edges;
    static int[] colors;
    static int answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }


        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges[u].add(v);
            edges[v].add(u);
        }


        colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = scanner.nextInt();
        }

        answer = 1;//min size
        findMaxSize(0, -1);

        System.out.println(answer);
        scanner.close();
    }


    static Pair findMaxSize(int u, int parent) {
        int totalSize = 1;
        boolean allSame = true;

        for (int point : edges[u]) {
            if (point == parent)
                continue;

            Pair childResult = findMaxSize(point, u);
            totalSize += childResult.size;


            if (!childResult.sameColor || colors[point] != colors[u]) {
                allSame = false;
            }
        }

        if (allSame) {
            answer = Math.max(answer, totalSize);
        }

        return new Pair(totalSize, allSame);
    }

    static class Pair {
        int size;
        boolean sameColor;

        Pair(int size, boolean sameColor) {
            this.size = size;
            this.sameColor = sameColor;
        }
    }
}