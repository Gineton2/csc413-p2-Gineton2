package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

/**
 * The VirtualMachine is the interface between a program and ByteCodes.
 */
public class VirtualMachine {
    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;

    public VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        // from given VirtualMachine class documentation/spec
        programCounter = 0;
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<Integer>();
        isRunning = true;
        while (isRunning){
            ByteCode code = program.getCode(programCounter);
            code.execute(this);
            programCounter++;
        }
    }

    public void haltProgram(){ isRunning = false; }

    public void pushRunTimeStack(int value) { runTimeStack.push(value); }

    public int popRunTimeStack() { return runTimeStack.pop(); }

    public int peekRunTimeStack() { return runTimeStack.peek(); }
}
