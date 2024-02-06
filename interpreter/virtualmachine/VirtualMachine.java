package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

// middleman bw programs and bytecode/runtimestack
public class VirtualMachine {

    // do not break encapsulation
    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;

    public VirtualMachine(Program program) {
        this.program = program;
    }

    // Obtained from given documentation
    public void executeProgram() {
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
}
