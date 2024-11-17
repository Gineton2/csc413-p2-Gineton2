package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.JumpByteCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Program {

    private ArrayList<ByteCode> program; //must stay private

    public Program() {
        program = new ArrayList<>();
    }


    protected ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently, all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     */
    public void resolveAddress() {
        // simple solution would be run for loop twice over program, there are O(n) solution(s) however
        Map<String,Integer> labelAddressesMap = new HashMap<>();
        // 1st pass through arraylist, keeping track of label codes & their labels
        for (ByteCode currentByteCode : program) {
            if (currentByteCode instanceof JumpByteCode) {
            }
        }
        // 2nd pass through arrayList, look for call, goto, and falsebranch codes
        // then, look at stored label codes and find matching label value
        // ex " val || (address)index " >> " (str)continue<<6>> || (int)(line)10 "

    }

    /**
     * Program is where ByteCodes are prepared
     * @param bc ByteCode to be added to Program.
     */
    public void addCode(ByteCode bc) { program.add(bc); }

}
