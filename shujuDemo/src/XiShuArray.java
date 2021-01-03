import com.sun.xml.internal.ws.util.StringUtils;

import java.io.*;
import java.util.Arrays;

public class XiShuArray {


    public static void main(String[] args) throws IOException {
        int[][] arr = {{1,2,3},{2,3,5},{4,5,3}};
        /*int[][] xiShuArray = xiShuArray(arr);
        System.out.println(xiShuArray.length);
        // System.out.println(arr.length);
        for (int i =0;i<xiShuArray.length;i++){
            for (int j=0;j<xiShuArray[i].length;j++){
                System.out.print(xiShuArray[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------------");
        int[][] ints = siShuToArray(xiShuArray);
        for (int i =0;i<ints.length;i++){
            for (int j=0;j<ints[i].length;j++){
                System.out.print(ints[i][j]);
            }
            System.out.println();
        }
        toText(arr);*/
        int[][] ints = textToArray("toText.text");
        for (int i =0;i<ints.length;i++){
            for (int j=0;j<ints[i].length;j++){
                System.out.print(ints[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 稀疏数组
     * @param arr
     * @return
     */
public static int[][] xiShuArray(int[][] arr){

    //创建一个稀疏数组进行记录，weigh 宽是3 row col  val
    //                      high 高是 存在val个数+1
    //new int[][];
    int high=0;
    for (int i=0;i<arr.length;i++){

        for (int j = 0;j<arr[i].length;j++){
            if(arr[i][j]!=0){
                high++;
            }
        }
    }
    int[][]  xiShu=  new int[high+1][3];
        xiShu[0][0]= arr.length;
        xiShu[0][1] = arr.length;
        xiShu[0][2]=high;
    int val=0;
    int temp = 0;
    for (int i=0;i<arr.length;i++){
        for (int j = 0;j<arr[i].length;j++){
            //控制行数
            if(arr[i][j]!=0){
                 val = arr[i][j];
                 xiShu[1+temp][0] = i;
                 xiShu[1+temp][1]=j;
                 xiShu[1+temp][2]=val;
                 temp++;
            }
        }
    }

    return xiShu;
}

    /**
     *稀疏转数组
     * @param xiShu
     * @return
     */
    public static int[][] siShuToArray(int[][] xiShu){
        int high = xiShu[0][0];
        int nums = xiShu[0][2];
        int[][] arr = new int[high][high];
        //棋盘初始化
        for(int i=0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                arr[i][j] = 0;
            }
        }
        int row = 0;
        int coll = 0;
        int val = 0;
        //获取稀疏中的值
        for (int i = 1;i<xiShu.length;i++){
                //row
            row  = xiShu[i][0];
                //coll
            coll  = xiShu[i][1];
                //val
            val  = xiShu[i][2];
            arr[row][coll] = val;

        }
        return arr;

    }
    public static void toText(int[][] arr) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("toText.text"));
        int len = 0;
        byte[] bytes = new byte[1024];
        String str = "";
        for (int i =0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                str+=arr[i][j];
            }
            bufferedWriter.write(str);
            str = "";
            bufferedWriter.write("\n");
            bufferedWriter.flush();
        }
        bufferedWriter.close();
    }
    public static int[][] textToArray(String path) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String readLine = bufferedReader.readLine();
        bufferedReader.close();
        int length = readLine.length();
        int count = 0;
        String high = "";
         bufferedReader = new BufferedReader(new FileReader(path));
        while (true){
            high = bufferedReader.readLine();
            if(high==null||high=="")
                break;
            count++;
        }
        bufferedReader.close();
        bufferedReader = new BufferedReader(new FileReader(path));
        int[][] ints = new int[length][count];
        int temp = 0;
        while (true){
            high = bufferedReader.readLine();
            if(high==null||high=="")
                break;
            char[] chars = high.toCharArray();
            for (int x = 0 ;x<chars.length;x++){
                int i = Integer.parseInt(chars[x]+"");
                ints[temp][x] = i;
            }
            temp++;
        }
        bufferedReader.close();

        return ints;

    }


}
