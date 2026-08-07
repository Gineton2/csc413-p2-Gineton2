package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * Load Bytecode moves a value from an offset in the current frame
 * and pushes it to the top of the RunTimeStack.
 * The offset works from the beginning of the stack.
 * It is not allowed to operate across frame boundaries.
 * It must not remove values from the stack.
 */
public class LoadCode extends ByteCode{
    private int offset;
    private String id;

    /**
     * Initializes the LoadCode ByteCode.
     * @param args String array element containing the offset and, optionally, the id of the value being moved.
     */
    @Override
    public void init(ArrayList<String> args) {
        if (args.isEmpty() || args.size() > 2) {
            throw new IllegalArgumentException(
                    "Load ByteCode requires one or two arguments: " +
                            "an Integer value and, optionally, a variable name/id.");
        }
        this.offset = Integer.parseInt(args.get(0));
        this.id = (args.size() > 1) ? args.get(1) : null;
    }

    /**
     * Executes each ByteCode according to their specified behavior.
     * TODO: copy value at the offset in the current frame and push it to the top of the stack.
     *  Do not remove values from RTS, do not operate across frame boundaries.
     * @param vm the virtual machine that will execute the ByteCodes
     */
    @Override
    public void execute(VirtualMachine vm) {

    }

    /**
     * Returns a String of the Bytecode and its arguments.
     *
     * @return String containing the ByteCode and any arguments.
     */
    @Override
    public String toString() {
        return null;
    }
}
