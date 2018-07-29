import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Scanner;


class Road implements Comparable<Road>{
    int start, end;
    Double distance;

    Road(int start, int end, Double distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    @Override
    public int compareTo(Road o) {
        int result = 0;

        if(this.distance.doubleValue() < o.distance.doubleValue()) {
            result = -1;
        } else if(this.distance.doubleValue() > o.distance.doubleValue()){
            result = 1;
        }

        return result;
    }
}

public class ConnectingPoints {

    private static Double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }


    private static void initializeDistance(List<Integer>[] cities, List<Double>[] roadLen, int[] x, int[] y, Road[] road) {
        int r = 0;
        for(int i = 0; i < cities.length; i++) {
            for(int j = 0; j < cities.length; j++) {
                if(i != j) {
                    Double distance = getDistance(x[i], y[i], x[j], y[j]);
                    roadLen[i].add(distance);
                    road[r++] = new Road(i, j, distance);
                }
            }
        }
    }

    // find the parent city of the set.
    private static int find(int[] parent, int i) {
        if(parent[i] < 0) {
            return i;
        }

        return find(parent, parent[i]);
    }

    // combine 2 sets.
    private static void union(int[] parent, int x, int y) {
        int rank = parent[x] + parent[y];

        if(parent[x] <= parent[y]) {
            parent[x] = rank;
            parent[y] = x;
        } else {
            parent[y] = rank;
            parent[x] = y;
        }
    }

    private static double minimumDistance(int[] x, int[] y) {
        double result = 0.;


        //write your code here
        int numberOfCities = x.length;
        List<Integer> cities[] = new ArrayList[numberOfCities];
        List<Double> roadLen[] = new ArrayList[numberOfCities];
        Road road[] = new Road[(int) (Math.pow(numberOfCities, 2)-numberOfCities)];
        Road res[] = new Road[numberOfCities-1];
        int parent[] = new int[numberOfCities];

        for(int i = 0; i < numberOfCities; i++) {
            cities[i] = new ArrayList<Integer>();
            roadLen[i] = new ArrayList<Double>();
        }

        initializeDistance(cities, roadLen, x, y, road);
        Arrays.sort(road);

        for(int i = 0; i < numberOfCities; i++) {
            parent[i] = -1;
        }

        int i = 0, e = 0;
        while(e < numberOfCities-1) {

            Road r = road[i++];

            int start = find(parent, r.start);
            int end = find(parent, r.end);

            if(start != end) {
                res[e++] = r;

                result += r.distance;
                union(parent, start, end);
            }
        }


        DecimalFormat six = new DecimalFormat("#0.0000000000"); // will round and display the number to four decimal places. No more, no less.

        String re = six.format(result);
        return Double.parseDouble(re);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        System.out.println(minimumDistance(x, y));
    }
}

