public class Node {
    int[] values;

    public Node(int[] v){
        values = v;

    }
    //returns the amount of mill for that day
    public int get(int day){
        return values[day%values.length];
    }
    //Prints values
    public void print(){
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]+" ");
        }
        System.out.println();
    }

}
