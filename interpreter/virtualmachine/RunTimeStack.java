package interpreter.virtualmachine;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

class RunTimeStack {

    private ArrayList<Integer> runTimeStack; // values in program
    private Stack<Integer>     framePointer; // frame boundaries, should never be empty (less than size of 1)

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entrypoint
        // of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    /*
     * Dumps the current state of the runTimeStack.
     * Prints portions of the stack based on respective frame markers.
     * Ex. [1,2,3] [4,5,6] [7,8]
     * Frame pointers would be 0, 3, 6
     */
    public void dump(){ //no params, use void or String
        StringBuilder stackDump = new StringBuilder();
        for (int i = 0; i < framePointer.size(); i++) {
            int frameStart = framePointer.get(i);
            int frameEnd = (i == lastFramePointerIndex()) ? runTimeStack.size() : framePointer.get(i + 1);
            stackDump.append("[");
            for (int j = frameStart; j < frameEnd; j++) {
                stackDump.append(runTimeStack.get(j));
                if (j < (frameEnd - 1)) {
                    stackDump.append(",");
                }
            }
            stackDump.append("]");
            if (i < lastFramePointerIndex()) {
                stackDump.append(" ");
            }
        }
        System.out.println(stackDump);
    }

    private int lastIndex(){
        return (this.runTimeStack.size() - 1);
    }

    private int lastFramePointerIndex() {
        return (this.framePointer.size() - 1);
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
     * Take top item of the runTimeStack and stores it into an offset
     * starting from the current frame.
     * @param offset number of slots above current frame marker
     * @return the item just stored
     */
    public int store(int offset) {
        int storeIndex = framePointer.peek() + offset;
        int valueToStore = pop();
        runTimeStack.set(storeIndex, valueToStore);
        return valueToStore;
    }

    /**
     * Take a value offset from the current frame marker and
     * push it to the top of the runTimeStack.
     * @param offset number of slots above current frame marker
     * @return item just loaded into the offset
     */
    public int load(int offset) {
        int loadIndex = ((offset + framePointer.peek()));
        int valueToLoad = runTimeStack.get(loadIndex);
        return push(valueToLoad);
    }

    /**
     * Create a new frame pointer at an offset index
     * from the top of the runTimeStack.
     * @param offset slots offset down from the top of the runTimeStack
     */
    public void newFrameAt(int offset) {
        framePointer.push(this.runTimeStack.size() - offset);
//        this implementation seems to be off by one:
//        framePointer.push(lastIndex() - offset);
    }

    /**
     * Pops the current frame off of the runTimeStack.
     * Removes the frame pointer value from the framePointerStack.
     */
    public void popFrame(){
        int poppedFramePointer = framePointer.pop();
        while (runTimeStack.size() > poppedFramePointer) {
            runTimeStack.remove(lastIndex());
        }
    }
}
