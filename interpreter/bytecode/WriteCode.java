package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

/**
 * Write ByteCode is used to display the top value of the RunTimeStack to the console.
 */
public class WriteCode extends ByteCode {
    /**
     * Initializes each ByteCode.
     *
     * @param args the arguments which make up each ByteCode instruction
     */
    @Override
    public void init(ArrayList<String> args) {}

    /**
     * Displays the top value of the runTimeStack.
     *
     * @param vm the virtual machine that will execute the ByteCodes
     */
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println(vm.peekRunTimeStack());
    }

    /**
     * Returns a String of the Bytecode and its arguments.
     *
     * @return String containing the ByteCode and any arguments.
     */
    @Override
    public String toString() {
        return "WRITE";
    }
}
