package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * Alerts the virtual machine that program execution is to be stopped.
 * It may not itself kill or stop execution fo the program.
 */
public class HaltCode extends ByteCode {
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
        vm.haltProgram();
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
