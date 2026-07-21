package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * Jump ByteCode is an abstraction of Call, Goto, and FalseBranch ByteCodes.
 * These ByteCodes take one argument, a given label, which they jump to.
 * Address resolution is performed in Program for these ByteCodes to correctly jump to the expected label.
 */
public abstract class JumpByteCode extends ByteCode {
    private int labelAddress;
    private String label;

    /**
     * Initializes a Jump ByteCode such as Call, Goto, or FalseBranch.
     * JumpByteCodes take one argument containing the label to be jumped to.
     * @param args a single-element list containing a String of the label to be jumped to.
     */
    @Override
    public void init(ArrayList<String> args) {
        if (args.size() != 1) {
            throw new IllegalArgumentException(
                    "Jump ByteCodes require one argument: a label denoting a location to jump to.");
        }
        this.label = args.get(0);
    }

    public String getLabel(){ return this.label; }

    /**
     * Address resolution is performed by Program.resolveAddress() and set here.
     * @param labelAddress the resolved address of this Jump-type ByteCode
     */
    public void setLabelAddress(int labelAddress) { this.labelAddress = labelAddress; }

    public int getLabelAddress(){ return this.labelAddress; }
}
