package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * Lit ByteCode is used to push literal values to the runtime stack.
 * Lit optionally is accompanied by an id variable name the value belongs to.
 */
public class LitCode extends ByteCode {
    private int value;
    private String id;

    /**
     * Lit ByteCode takes one or two arguments to declare an integer.
     * LitCode arguments will include the literal values to be stored and,
     * optionally, a variable name to represent the value.
     * @param args string list with literal value and (optionally) a variable name.
     */
    @Override
    public void init(ArrayList<String> args) {
        // According to instructions, always assume lit is an int declaration
        // see Lecture Video 14:A2 Dumping Explanation and Hints
        if (args.isEmpty() || args.size() > 2) {
            throw new IllegalArgumentException(
                    "LIT ByteCode requires one or two arguments: " +
                            "an Integer value and, optionally, a variable name.");
        }
        this.value = Integer.parseInt(args.get(0));
        this.id = (args.size() > 1) ? args.get(1) : null;
    }

    /**
     * When executed, LitCode takes one or two arguments (literal value and id)
     * and pushes that one literal value to the top of the RunTimeStack.
     * @param vm the virtual machine that will execute the ByteCodes
     */
    @Override
    public void execute(VirtualMachine vm) {
        vm.pushRunTimeStack(this.value);
    }

    /**
     * @return a string containing the ByteCode and its arguments
     */
    @Override
    public String toString() {
        String base = "LIT " + value;
        return (id != null) ? base + " " + id + ("\tint " + id) : base;
    }
}