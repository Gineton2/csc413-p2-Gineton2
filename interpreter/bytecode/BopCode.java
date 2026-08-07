package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
mds cause hyper wrong fucous
/**
 * Bop implements binary operations. The BopCode is the given operator itself.
 * Operators include: +, -, /, *, ==, !=, <=, >, >=, <, |, &.
 * Two values are removed from the runtime stack.the given operation is performed.
 * The result is pushed to the top of the stack.
 */
public class BopCode extends ByteCode {
    private String operator;
    /**
     * Initializes each ByteCode.
     *
     * @param args a string element containing the binary operator
     */
    @Override
    public void init(ArrayList<String> args) {
        if (args.size() != 1) {
            throw new IllegalArgumentException(
                    "BopCode only accepts one argument.");
        }
        this.operator = args.get(0);
    }

    /**
     * Pops two values from the runTimeStack and performs the BopCode's
     * operator on them. It then pushes the integer result back to the stack.
     *
     * @param vm the virtual machine that will execute the ByteCodes
     */
    @Override
    public void execute(VirtualMachine vm) {
        int b = vm.popRunTimeStack();
        int a = vm.popRunTimeStack();
        int result = performOperation(a, operator, b);
        vm.pushRunTimeStack(result);
    }

    /**
     * Performs the binary operation.
     * @param a the first operand, popped second
     * @param operator the given binary operator
     * @param b the second operand, popped first
     * @return an integer result, including 1 or 0 for boolean operators.
     */
    private int performOperation(int a, String operator, int b) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "/":
                return a / b;
            case "*":
                return a * b;
            case "==":
                return (a == b) ? 1:0;
            case "!=":
                return (a != b) ? 1:0;
            case "<=":
                return (a <= b) ? 1:0;
            case ">":
                return (a > b) ? 1:0;
            case ">=":
                return (a >= b) ? 1:0;
            case "<":
                return (a < b) ? 1:0;
            case "|":
                return ((a != 0) || (b != 0)) ? 1:0;
            case "&":
                return ((a != 0) && (b!=0)) ? 1:0;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    /**
     * Returns a String of the Bytecode and its arguments.
     *
     * @return String containing the ByteCode and any arguments.
     */
    @Override
    public String toString() {
        return ("BOP " + operator);
    }
}
