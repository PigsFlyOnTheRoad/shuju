package queue;

import com.sun.javafx.tk.TKPulseListener;
import sun.applet.Main;

public class CircleQueue {


    int maxSize ;
    int[] arr ;
    int font ;
    int rear ;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }


    public boolean isFull(){
       return rear == maxSize-1 && font==0 ? true : false;
    }
    public boolean isEmpty(){
       if(rear==0&&rear==font){
           return true;
       }
       return false;
    }

    public void addQueue(int val){

        if(isFull()){
            System.out.println("队列满");
            return;
        }
        if (rear == maxSize - 1) {
            rear = 0;
        }
        arr[rear] = val;
        rear++;
    }

    public int removeVal() throws Exception {
        if(isFull()){
            throw  new Exception("队列为空");
        }
        int val = arr[font];
        if(font==maxSize-1)
            font = 0;
        font++;
        return val;
    }

    public void showQueue(){
        for (int i = font;i<size();i++){
            System.out.println(arr[i]);
        }
    }

    public int size(){
       /* int temp = 0;
            for (int i =0 ;i<arr.length;i++) {
                if (arr[i] != 0)
                    temp++;
            }*/

        return (rear+maxSize-font)%maxSize;
    }

    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(10);
        circleQueue.addQueue(10);
        circleQueue.showQueue();
    }

}
