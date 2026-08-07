package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * Pop ByteCode removes values from the RunTimeStack.
 * It is not allowed to remove values across frame boundaries.
 * It takes in one argument, which is the number of values to pop.
 */
public class PopCode extends ByteCode {
    int numValuesToPop;
    /**
     * Pop ByteCode is initialized with one argument:
     * the (strictly positive) number of values to pop from the RunTimeStack.
     * @param args string array element containing the number of values to pop from the RunTimeStack
     */
    @Override
    public void init(ArrayList<String> args) {
        if (args.size() != 1) {
            throw new IllegalArgumentException(
                    "PopCode only accepts one argument.");
        }
        this.numValuesToPop = Integer.parseInt(args.get(0));
    }

    /**
     * Executes each ByteCode according to their specified behavior.
     * TODO: loop around single pop, making sure to not pop through frame boundaries.
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
