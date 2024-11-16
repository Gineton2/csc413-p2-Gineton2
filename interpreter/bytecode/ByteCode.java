package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public abstract class ByteCode {

    /**
     * Initializes each ByteCode.
     * @param args the arguments which make up each ByteCode instruction
     */
    public abstract void init(ArrayList<String> args);

    /**
     * Executes each ByteCode according to their specified behavior.
     * @param vm the virtual machine that will execute the ByteCodes
     */
    public abstract void execute(VirtualMachine vm);

    /**
     * Returns a String of the Bytecode and its arguments.
     * @return String containing the ByteCode and any arguments.
     */
    @Override
    public abstract String toString();
}
