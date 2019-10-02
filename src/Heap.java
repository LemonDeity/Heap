public class Heap {
    int[] heap;
    int size;
    //-1 in an index means nothing is there.
    public Heap(int[] h){
        heap = h;
        size = heap.length;

        build();
    }

    public void build(){
        for (int i = size/2; i >= 0; i--) {
            heapifyUp(i,heap[i]);
        }
    }

    public void add(int num){
        if(size == heap.length) resize();
        int ind = getNextOpenIndex();
        heapifyUp(ind, num);
    }

    public void insertAtEnd(int num){
        if (size == heap.length-1){
            resize();
        }
        int ind = size+1;
        heap[ind] = num;
        heapUp();
    }
    //this is to prevent overflow or outOfBounds Errors
    private void resize(){
        int[] heap2 = new int[size*2];
        for (int i = 0; i < heap.length; i++) {
            heap2[i] = heap[i];
        }
        heap = heap2;
    }

    public int peek(){
        return heap[0];
    }
    //returns heap[0] & removes that index from the heap;
    public int remove(){
        int min = peek();
        heapDown();
        return min;
    }

    public void heapUp(){
        int ind = heap.length-1;
        int num = heap[ind];//This is the farthest integer in the Heap
        //This means it is a right node
        while(ind >= 0){
            if(ind % 2 == 0){
                if (heap[(ind-2)/2] > num){
                    //This means the parent is greater than the child meaning they must be switched
                    heap[ind] = heap[(ind-2)/2];
                    heap[(ind-2)/2] = num;
                    ind = (ind-2)/2;
                }
                else{
                    break;
                }
            }
            else{
                //This means it is a left Node
                if (heap[ind-1]/2 > num){
                    heap[ind] = heap[(ind-1)/2];
                    heap[(ind-1)/2] = num;
                    ind = (ind-1)/2;
                }
                else{
                    break;
                }
            }
        }
    }

    public void heapDown(){
        int num = heap[size-1];//This is the very last node in the Heap
        int ind = 0;
        heap[ind] = num;

        heap[size-1] = -1;
        //condition will be as long as ind is less than size/2;
        while(ind < size/2){
            if (heap[ind] > heap[(2*ind)+1]){
                //This means that the parent and the Left node must be switched
                heap[ind] = heap[(2*ind)+1];
                heap[(2*ind)+1] = num;
                ind = (2*ind)+1;
            }else if(heap[ind] > heap[(2*ind)+2]){
                //This means that the parent and the Right node must be switched
                heap[ind] = heap[(2*ind)+2];
                heap[(2*ind)+2] = num;
                ind = (2*ind)+2;
            }else{
                break;
            }
        }
    }

    //This is for Insertion
    //With insertion you maintain shape and then order
    public void heapifyUp(int ind, int num){
        //When last index is odd that means it is in a right node
        //When last index is even that means it is a left node
        // [1,2,3]
        //  0 1 2
        //left = 2n+1 right = 2n+2
        while(ind > 1 && num < heap[ind/2]){
            heap[ind] = heap[ind/2];
            ind /= 2;
        }
        heap[ind] = num;

    }
    //for removing and rebuilding the Heap
    public void heapifyDown(int ind){
        int t = heap[ind];
        int g = -1;
        while(2*ind <= size){
            g = 2*ind;

            if (g != size && heap[g] > heap[g+1]){
                g++;
            }

            if (t > heap[g]){
                heap[ind] = heap[g];
            }else{
                break;
            }
            heap[ind] = t;
        }

    }
    //this returns where in the heap a new spot is open
    public int getNextOpenIndex(){
        //may need to implement resizing
        int num = heap.length;
        for (int i = 0; i < heap.length; i++) {
            if (heap[i] == -1){
                num = heap[i];
                break;
            }
        }
        return num;
    }

    public boolean isEmpty(){
        boolean h = false;
        if(heap == null)return true;
        return h;
    }
}
