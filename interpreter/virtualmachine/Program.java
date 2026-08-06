package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.JumpByteCode;
import interpreter.bytecode.LabelCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The Program class stores ByteCodes and resolves symbolic addresses to absolute addresses.
 */
public class Program {

    private ArrayList<ByteCode> program; // Must stay private

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    /**
     * Maps labels from the compiler to absolute addresses in the program.
     * Initially, all labels look like `LABEL <<num>>`, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter.
     * It iterates through the program to store labels with their indices, then assigns
     * JumpByteCode types to appropriate addresses.
     */
    public void resolveAddress() {
        Map<String,Integer> labelAddressesMap = new HashMap<>();

        for (int i = 0; i < program.size(); i++) {
            if (program.get(i) instanceof LabelCode) {
                LabelCode currentLabelCode = (LabelCode) program.get(i);
                labelAddressesMap.put(currentLabelCode.getLabel(), i);
            }
        }
        for (ByteCode byteCode : program) {
            if (byteCode instanceof JumpByteCode) {
                JumpByteCode jumpCode = (JumpByteCode) byteCode;
                int jumpCodeAddress = labelAddressesMap.get(jumpCode.getLabel());
                jumpCode.setLabelAddress(jumpCodeAddress);
            }
        }
    }

    /**
     * @param bc ByteCode to be added to Program.
     */
    public void addCode(ByteCode bc) { program.add(bc); }

}
