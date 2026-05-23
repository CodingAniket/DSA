public class Stack{
   private class Node{
        int data;
        Node next;
        Node(int data){
        this.data=data;
        this.next=null;
        }
    }
    private Node top;
    private int height;

    public int heightInfo(){
        return this.height;
    }
    public int topInfo(){
        return top==null?-1:this.top.data;
    }
    public void push(int data){
        Node newNode=new Node(data);
        if(top==null){ 
        top=newNode;
        System.out.println("The data "+data+" is successfully pushed into the stack");
    } else{
        newNode.next=top;
        top=newNode;
        System.out.println("The data "+data+" is successfully pushed into the stack");
    }
    height++;
    }
    public int pop(){
      if(top==null) return -1;
      else{
      Node temp=top;
      top=top.next;
      temp.next=null;
      System.out.println("The pop operation is successfully execute");
      height--;
      return temp==null?-1:temp.data;}
    }
    public void printStack(){
        Node temp=top;
        while(temp!=null){ 
        System.out.println(temp.data);
        temp=temp.next;
    }
    }
    public static void main(String[] args) {
        Stack stack=new Stack();
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println("The height of the stack is: "+stack.heightInfo());
        System.out.println("The top of the stack is: "+stack.topInfo());
        stack.printStack();
        System.out.println();
        System.out.println("The poped value is: "+stack.pop());
        System.out.println("The height of the stack is: "+stack.heightInfo());
        System.out.println("The top of the stack is: "+stack.topInfo());
        stack.printStack();
    }
}