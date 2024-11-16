package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode {
    /**
     * Initializes each ByteCode.
     *
     * @param args the arguments which make up each ByteCode instruction
     */
    @Override
    public void init(ArrayList<String> args) {

    }

    /**
     * Executes each ByteCode according to their specified behavior.
     *
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
