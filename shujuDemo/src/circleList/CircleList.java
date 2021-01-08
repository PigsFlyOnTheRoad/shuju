package circleList;

import com.sun.deploy.panel.WinUpdatePanel;

public class CircleList {

    //带头
    //private CircleList head = new CircleList();

    public static void main(String[] args) {

       /* //1.创造一个单链表的环
        //头
        CircleList first = new CircleList();
        CircleList curent = Curent(first, 5);

        CircleList circleList = JosePhu(curent, 3);
        System.out.println(circleList);*/

    }

    public static   CircleList Curent(CircleList head,int num){

        if(num<=0){
            return null;
        }
        //CircleList temp = null;
        CircleList cur = head;
        for (int i =1 ;i<=num;i++){
            //新宝贝
           CircleList newCircleList =  new CircleList(i);
           //当前cur的下一个节点赋值
           cur.next = newCircleList;
           //指针后移----（链表的特性）当前对象只能找下一个对象
           cur = newCircleList;
        }
        //收尾相连
        //由于其本身带有熟悉，因此将其下一个节点拿出---链表通过下一个节点找到下一个节点
        CircleList circleList = head.next;
        cur.next = circleList;
        return circleList;
    }


    /**
     * @param circleList   环
     * @param index   跳出数字
     * @return
     */
    public static  CircleList JosePhu(CircleList circleList,int index){
        //计数器
        int count = 1;
        //指针
        CircleList cur = circleList;
        //1,遍历链表
        while (true){
            if(cur.next == cur.next.next){
                cur.next = null;
                return cur;
            }
            //删除当前节点
            if(count == index){
                //下一个节点
                CircleList inCur  = cur;
                //如何拿到上一个节点？
                //第二次遍历的只指针
                while (true){
                    if(inCur.next.no == cur.no ){
                        count = 1;
                        break;
                    }
                    inCur = inCur.next;

                }
                //上一个节点与下一个节点相连
                //拿出当前节点
                cur = cur.next;
                inCur.next = cur;
            }
            //指针后移
            count++;
            cur = cur.next;
        }
    }


    private int no;

    private CircleList next;

    public CircleList() {
    }

    public CircleList(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "CircleList{" +
                "no=" + no +
                '}';
    }
}
