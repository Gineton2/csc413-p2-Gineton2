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

    /**
     * TODO
     * Dumps the current state of the runTimeStack.
     * Prints portions of the stack based on respective frame markers.
     * Ex. [1,2,3] [4,5,6] [7,8]
     * Frame pointers would be 0, 3, 6
     */
    public void dump(){ //no params, use void or String

    }

    private int lastIndex(){
        return this.runTimeStack.size()-1;
    }


    /**
     * Returns the top of the runtime stack without removing it.
     * Cannot peek an empty stack, but not a concern for implementation.
     * @return copy of the top of the runtime stack
     */
    public int peek(){
        return this.runTimeStack.get(lastIndex());
    }

    /**
     * Push valueToPush to the top of the runTimeStack.
     * @param valueToPush value to be pushed
     * @return value that was pushed
     */
    public int push(int valueToPush){
        this.runTimeStack.add(valueToPush);
        return this.peek();
    }

    /**
     * Removes the top of the runtime stack
     * @return the value popped
     */
    public int pop(){
        return this.runTimeStack.remove(lastIndex());
    }

    /**
     * TODO
     * Take top item of the runTimeStack and stores it into an offset
     * starting from the current frame.
     * @param offset number of slots above current frame marker
     * @return the item just stored
     */
    public int store(int offset) { return 0; }

    /**
     * TODO
     * Take a value offset from the current frame marker and
     * push it to the top of the runTimeStack.
     * @param offset number of slots above current frame marker
     * @return item just loaded into the offset
     */
    public int load(int offset){ return 0; }

    /**
     * TODO
     * Create a new frame pointer at an offset index
     * from the top of the runTimeStack
     * @param offset slots offset down from the top of the runTimeStack
     */
    public void newFrameAt(int offset) {}

    /**
     * TODO
     * Pops the current frame off of the runTimeStack.
     * Removes the frame pointer value from the framePointerStack.
     */
    public void popFrame(){}

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
        // can use Stack class as a Vector (see Stack implementation in Java)
        //  eg, `nums.get(2)` works
    }
}
