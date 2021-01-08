package List;

public class DoubleList {


    private DoubleList head = new DoubleList();

    //默认添加到末尾节点
    public void addList(DoubleList doubleList){

        //定义空节点进行替换
        DoubleList temp  = null;
        temp = head;

        if(temp==null)
            return;

        //1.进行遍历
        while (true){

            if(temp.next==null){
                temp.next = doubleList;
                break;
            }
            temp = temp.next;
        }
    }


    public void deleteList(int no){
        //1.定义一个空节点进行交换

        DoubleList temp = head;

        //2.进行遍历
        while (true){


            //将下一个引用赋值给自己的引用---指针相当于引用的赋值

            if(no==temp.no){
                temp.pre.next = temp.next;
                break;
            }

            temp=  temp.next;
        }
    }


    public void  updateList(DoubleList doubleList){

        DoubleList temp = head;

        while (true){

            if(temp.no == doubleList.no){

                //......

            }

        }


    }










    public int no;

    public DoubleList pre;

    public DoubleList next;

    public DoubleList(int no) {
        this.no = no;
    }

    public DoubleList(){}
}

