package queue;

import java.util.Arrays;

public class ArrayQueue {

    int maxSize ;
    int[] arr ;
    int font = 0;
    int rear = 0;



    public ArrayQueue(int length) {
        arr = new int[length];
        maxSize = length;
    }
    public void addQueue(int val) throws Exception {
        if(rear > maxSize-1){
            throw new Exception("队列已经满了");
        }
        arr[rear] = val;
        rear++;
    }
    //取数据
    public int removeVal(){
        if(font==rear){
            System.out.println("队列为空");
            return -1;
        }
        int num = arr[font];
        int[] ints = new int[maxSize];
        for (int i =0 ;i<maxSize-1;i++){
            ints[i]=arr[i+1];
        }
        arr = ints;

        return  num;
    }

    public static void main(String[] args) throws Exception {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        arrayQueue.addQueue(10);
        int i = arrayQueue.removeVal();
        System.out.println(i);
        System.out.println(arrayQueue.maxSize);

    }
}

