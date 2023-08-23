import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPairs = scanner.nextInt();
        scanner.nextLine();
        Graph graph = new Graph();
        for(int i = 0; i < numberOfPairs; i++){
            String pair = scanner.nextLine();
            String[] numbers = pair.split(" ");
            String num1 = numbers[0];
            String num2 = numbers[1];

            graph.addVertex(num1);
            graph.addVertex(num2);
            graph.addEdge(num1, num2);
        }
        System.out.println(graph.countConnectedComponents());

    }
}
