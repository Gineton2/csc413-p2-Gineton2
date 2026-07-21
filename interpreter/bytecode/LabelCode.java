package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * Label ByteCode marks locations in the program where other ByteCodes can jump to.
 * It takes one argument, which is the label denoting a location in the program.
 * Dumping implementation is optional according to spec.
 */
public class LabelCode extends ByteCode {

    private String label;

    /**
     * Initializes the Label ByteCode with a location in the program.
     *
     * @param args a single-element list with a String containing the label.
     */
    @Override
    public void init(ArrayList<String> args) {
        if (args.size() != 1) {
            throw new IllegalArgumentException(
                    "LABEL ByteCode requires one argument: a label denoting a location in the program.");
        }
        this.label = args.get(0);
    }

    /**
     * Executes each ByteCode according to their specified behavior.
     * Label ByteCode has no functionality.
     * @param vm the virtual machine that will execute the ByteCodes
     */
    @Override
    public void execute(VirtualMachine vm) {}

    /**
     * Returns a String of the ByteCode and its arguments.
     *
     * @return String containing the ByteCode and any arguments.
     */
    @Override
    public String toString() { return "LABEL " + label; }

    public String getLabel() { return label; }
}
