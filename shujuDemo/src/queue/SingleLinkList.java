package queue;

import jdk.nashorn.internal.ir.debug.PrintVisitor;

import javax.security.auth.callback.CallbackHandler;

public class SingleLinkList {

    public static void main(String[] args) {

        ChangeHello changeHello = new ChangeHello();
        changeHello.addHelloById(new HelloList(0,"a","a"));
        changeHello.addHelloById(new HelloList(1,"b","b"));
        //changeHello.addHelloById(new HelloList(2,"c","c"));


       changeHello.addHelloById(new HelloList(2,"a","a"));
        //changeHello.addHelloById(new HelloList(1,"a","a"));
        //changeHello.updateHello(new HelloList(1,"b","b"));
        changeHello.deleteHello(new HelloList(1,"a","a"));


        changeHello.showHello();

    }

}

//操作链表的类-----------工具类声明头结点。无任何作用，方便识别头结点

class ChangeHello {
    //头部初始化--无作用只是声明
    HelloList heard = new HelloList(0, "", "");

    public void showHello(){

        if(heard.nextHello==null){
            return;
        }
        HelloList temp = heard.nextHello;
        while (true){
            if(temp==null)
                break;
            System.out.println(temp);
            temp = temp.nextHello;
        }
    }


    public void addHello(HelloList helloList){

        HelloList temp = heard;
        //循环最后拿到最后一个节点
        while (true){

            //最后一个节点
            if(temp.nextHello==null){
                temp.nextHello =helloList;
                break;
            }
            //不是则往后面移动
            temp = temp.nextHello;
        }
    }


    public void addHelloById(HelloList helloList){
        //1,先拿到中间节点
        HelloList temp = heard;
        //2,拿到增加节点的id
        int id = helloList.no;

        while (true){
            if(temp.nextHello!=null){
                //该节点的上一名
                if(temp.nextHello.no+1==id){
                    //如果中间为空直接添加
                    if(temp.nextHello.nextHello==null){
                        temp.nextHello.nextHello = helloList;
                        break;
                    }
                    if(temp.nextHello.nextHello.no==id){
                        System.out.println("该排名已被占有");
                        break;
                    }

                    //中间不为空--后半段
                    HelloList change = temp.nextHello.nextHello;
                    temp.nextHello.nextHello = helloList;
                    helloList.nextHello = change;
                    break;
                }
                //不连续的节点添加，直接往后添加
                temp = temp.nextHello;
                temp.nextHello = helloList;
                break;
            }
            //如果下一个节点为空直接添加
            temp.nextHello = helloList;
            break;
        }
    }
    public HelloList updateHello(HelloList newHello){
        //1，拿到头结点
        HelloList temp = heard;
        int id = newHello.no;
        while (true){
            if(temp.nextHello==null){
                return temp;
            }

            if(temp.nextHello!=null){
                if(id == temp.nextHello.no){
                    temp.nextHello.name=newHello.name;
                    temp.nextHello.signName=newHello.signName;
                    break;
                }
                temp = temp.nextHello;
            }
        }
        return temp;
    }

    public void deleteHello(HelloList hello){
        HelloList temp = heard;
        int id = hello.no;

        while (true){

            if(temp.nextHello==null){
                return;
            }
            //删除该节点
            if(Integer.compare(id,temp.nextHello.no)==0){
                //1，拿到该节点的下一个元素
                //如果下一个节点为空，直接删除该节点
                if(temp.nextHello.nextHello==null){
                    temp.nextHello = null;
                    break;
                }
                //不为空
                HelloList changeHello = temp.nextHello.nextHello;
                temp = changeHello;
                break;
            }
            temp = temp.nextHello;
        }
    }

}

class HelloList{
    public  int no;

    public String name;

    public String signName;

    public HelloList nextHello;

    public HelloList(int no, String name, String signName) {
        this.no = no;
        this.name = name;
        this.signName = signName;
    }

    @Override
    public String toString() {
        return "HelloList{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", signName='" + signName + '\'' +
                '}';
    }
}
