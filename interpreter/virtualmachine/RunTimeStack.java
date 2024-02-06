package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.Stack;

class RunTimeStack {

    private ArrayList<Integer> runTimeStack; // values in program
    private Stack<Integer>     framePointer; // frame boundaries, should never be empty (less than size of 1)

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    private int lastIndex(){
        return this.runTimeStack.size()-1;
    }

    // cannot peek an empty stack, but not a concern for given test programs
    public int peek(){
        return this.runTimeStack.get(lastIndex());
    }

    public int push(int valueToPush){
        this.runTimeStack.add(valueToPush);
        return this.peek();
    }

    public int pop(){
        return this.runTimeStack.remove(lastIndex());
    }

    public static void  main(String[] args) {
        // testing push, pop, peek
        RunTimeStack rs = new RunTimeStack();
        rs.push(5);
        rs.push(4);
        rs.push(3);
        rs.push(2);
        rs.push(1);

        rs.runTimeStack.forEach(System.out::println);

        rs.push(10);

        System.out.println(rs.peek());
        rs.pop();
        System.out.println(rs.peek());
        rs.push(100);
        System.out.println(rs.peek());
        rs.pop();
        System.out.println(rs.peek());


    }
}
