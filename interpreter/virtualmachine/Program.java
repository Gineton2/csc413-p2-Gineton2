package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;

import java.util.ArrayList;

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
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     */
    public void resolveAddress() {
        // simple solution would be run for loop twice over program, there are O(n) solution(s) however

        // 1st pass through arraylist, keeping track of label codes & their labels


        // 2nd pass through arrayList, look for call, goto, and falsebranch codes
        // then, look at stored label codes and find matching label value
        // ex " val || (address)index " >> " (str)continue<<6>> || (int)(line)10 "

    }

    // write AddCode function to add byte codes to Program array list


}
