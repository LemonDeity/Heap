import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("goat.dat"));

        int testCases = Integer.parseInt(input.nextLine().substring(0));

        int numGoats = Integer.parseInt(input.nextLine());

        ArrayList<Node> list = new ArrayList<Node>();

        while(input.hasNextLine()){
            String[] arr = input.nextLine().split(" ");
            int[] values = new int[arr.length];
            for (int i = 0; i < values.length; i++) {
                values[i] = Integer.parseInt(arr[i]);
            }
            list.add(new Node(values));
        }

        while(list.size()>0){
            int day = 0;
            ArrayList<Integer> milk = new ArrayList<Integer>();
            for(Node n : list){
                milk.add(n.get(day));
            }
            int milkSize = milk.size();

            int[] m = new int[milkSize];
            for (int i = 0; i < m.length; i++) {
                m[i] = milk.get(i);
            }

            Heap h = new Heap(m);

            //This represents that days lowest amount of milk
            int dayLow = h.peek();

            while(h.peek() == dayLow){
                milk.remove(h.remove());
                if (day == 0){
                    System.out.print(milkSize-h.size+" ");
                }
            }
            System.out.println(day);

        }
    }
}
