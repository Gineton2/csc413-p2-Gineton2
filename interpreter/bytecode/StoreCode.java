package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * Store Bytecode moves values from the top of the RunTimeStack to an offset.
 * It takes one or two arguments:
 * - the offset in the current frame to store the popped value
 * - optionally, the variable id belonging to the value being moved (for dumping)
 * The offset starts from the beginning of the current frame.
 * It is not allowed to operate across frame boundaries.
 */
public class StoreCode extends ByteCode {
    private int offset;
    private String id;

    /**
     * @param args String array element containing the offset and, optionally, the id of the value being moved.
     */
    @Override
    public void init(ArrayList<String> args) {
        if (args.isEmpty() || args.size() > 2) {
            throw new IllegalArgumentException(
                    "Store ByteCode requires one or two arguments: " +
                            "an Integer value and, optionally, a variable name/id.");
        }
        this.offset = Integer.parseInt(args.get(0));
        this.id = (args.size() > 1) ? args.get(1) : null;
    }


    /**
     * Pops the top of the RunTimeStack and stores the value at the offset in the current frame.
     * Must not operate across frame boundaries.
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
