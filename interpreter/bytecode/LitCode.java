package interpreter.bytecode;

import java.util.ArrayList;

public class LitCode extends ByteCode {
    int value;
    String id;

    @Override
    public void init(ArrayList<String> args) {
        // TODO for resolving address
        // see Lecture Video 14:A2 Dumping Explanation and Hints
        this.value = Integer.parseInt(args.get(0));
        if (args.size() > 1) this.id = args.get(1);
    }

    @Override
    public String toString() {
        // see Lecture Video 14:A2 Dumping Explanation and Hints
        String base = "LIT " + value;
        if(id != null) {
            base += (" int " + id);
        }
        return base;
        // ternary operator example:
        // return (id != null) ? base += (" int " + id) : base;
    }
}

// dumping in args code
// return "ARGS " + value;