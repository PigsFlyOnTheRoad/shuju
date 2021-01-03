package queue;

import java.security.PublicKey;
import java.util.Stack;

public class QueueTest {

    NodeList heard = new NodeList();
    NodeList temp = heard;

    public static void main(String[] args) {
        QueueTest queueTest = new QueueTest();
        int count = queueTest.getCount(new NodeList(1, new NodeList()));
        //NodeList node = queueTest.getNode(0, new NodeList(1, new NodeList(2,null)));
        //System.out.println(node);
       NodeList nodeList = new NodeList(1, new NodeList(2, new NodeList(3,null)));
       // queueTest.showNode(nodeList);
        NodeList nodeList1 = queueTest.changeQueue(nodeList);
        queueTest.showNode(nodeList1);


       // System.out.println(queueTest);
        System.out.println(count);
    }

    public void showNode(NodeList nodeList){
        if(nodeList==null || nodeList.node == null)
            return;

        NodeList temp = nodeList;
        while (true){
            System.out.println(temp);
            temp = temp.node;
            if(temp.node == null){
                System.out.println(temp);

                break;
            }
        }
    }


    public NodeList getNode(int key,NodeList nodeList){

        if(nodeList == null){
            return  null;
        }

        if(nodeList.node==null){
            return null;
        }


        int count = getCount(nodeList);
        if(key >count)
            return null;
        int resultCount = count -key;
        NodeList temp =  heard;
        if(resultCount==0){
            return nodeList;
        }
        while (count>0){

            temp = nodeList.node;
            count-- ;
        }
        return temp;
    }

    public int getCount(NodeList nodeList){
        NodeList node = nodeList.node;
        if(nodeList.node==null)
            return 1;
        int count = 1 ;
        while (true){
            if(node!=null){
                count++;
                node = node.node;
            }
            if(node==null){
                return count;
            }
        }
    }

    /**
     *
     * 链表的反转---用栈
     * @param nodeList
     */
    public NodeList changeQueue(NodeList nodeList){

        Stack stack = new Stack();
        //NodeList newNode = new NodeList(0,null);

        NodeList temp = nodeList;
        while (true){
            if(temp==null) {
                break;
            }
            stack.add(temp);
            temp = temp.node;
        }

       // NodeList newTemp = newNode.node;
        //NodeList  newTemp = (NodeList) stack.pop();

        NodeList cur = heard;
        System.out.println(heard);
        while (!stack.isEmpty()){
            //NodeList node = newNode.node;
            //node = (NodeList) stack.pop();
            //每次追加完毕往后面添加节点
           // newTemp = newTemp.node;
            NodeList node = (NodeList) stack.pop();
            //1，将数据进行清空，
            node.node = null;
            //2.给当前节点的下一个节点赋值
            cur.node = node;
            //3.将当前节点的地址赋值给cur指针---------------不明白
            //cur.node = node;

            cur = node;
        }
        return heard;
    }

    /*public void addNode(NodeList node){
       // NodeList temp = heard;

        while (true) {

            heard.node = node;
            while (true){
                heard = heard.node;
                if(heard==null){
                    heard  = node;
                    break;
                }

            }

        }

    }*/
}

class NodeList{

    public int no;

    public NodeList node;

    public NodeList(int no) {
        this.no = no;
    }

    public NodeList(int no, NodeList node) {
        this.no = no;
        this.node = node;
    }

    public NodeList() {
    }

    @Override
    public String toString() {
        return "NodeList{" +
                "no=" + no +
                '}';
    }
}
