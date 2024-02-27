
package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.virtualmachine.Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Array;
import java.util.ArrayList;


public class ByteCodeLoader {

    private final BufferedReader byteSource;

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN loadCodes.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }

    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     * Tokenize string to break it into parts. Can also use the split function in the String class.
     * Grab THE correct class name for the given ByteCode from CodeTable
     * Create an instance of the ByteCode class name returned from code table.
     * Parse any additional arguments for the given ByteCode and send them to
     * the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        String line;
        String[] items;
        ArrayList<String> args = new ArrayList<>();
        String byteCodeName; // ByteCode from .x.cod
        String className; // class after mapped from name in source code
        Class classBlueprint;
        Program program = new Program();
        ByteCode bc;
        try {
            while (this.byteSource.ready()) {
                // tokenize read line
                line = this.byteSource.readLine();
                items = line.split("\\s+");
                // grab first token of each line (bytecode)
                byteCodeName = items[0];
                // grab class name from token
                className = CodeTable.getClassName(byteCodeName);
                // load class blueprint from classname
                classBlueprint = Class.forName("interpreter.bytecode." + className);
                // get declared constructor (should be no-arg constructor)
                // create a new instance of bytecode using constructor
                bc = (ByteCode) classBlueprint.getDeclaredConstructor().newInstance();
                // TODO: grab remaining args

                // pass args to bytecode init fn
                bc.init(args);
                // TODO: add bytecode to program
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
            System.exit(255);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            // throw new RuntimeException(e);
            e.printStackTrace();
        }
        program.resolveAddress(); // breakpoint here and ensure all bytecodes are loaded and initialized correctly
        return program;
    }
}
