/*
 * see license.txt 
 */
package seventh.shared;

import java.io.File;

import leola.vm.Args;
import leola.vm.Leola;
import seventh.math.Vector2f;
import seventh.server.SeventhScriptingCommonLibrary;

/**
 * Scripting runtime factory methods
 * 
 * @author Tony
 *
 */
public class Scripting {

    /**
     * Attempts to load a script file
     * 
     * @param runtime
     * @param scriptFile
     */
    public static void loadScript(Leola runtime, String scriptFile) {
        File file = new File(scriptFile);
        if(file.exists()) {
            try {                
                runtime.eval(file);
            }
            catch(Exception e) {
                Cons.println("*** ERROR -> Loading " + file.getName() + ":" + e);
            }
        }
    }
    
    /**
     * Creates a new {@link Leola} runtime that is in sandboxed mode.
     * 
     * @return the runtime
     */
    public static Leola newSandboxedRuntime() {        
        Leola runtime = Args.builder()
                            .setAllowThreadLocals(false)
                            .setIsDebugMode(true)
                            .setBarebones(true)
                            .setSandboxed(false) // TODO
                            .newRuntime();
        
        /* load some helper functions for objective scripts */
        runtime.loadStatics(SeventhScriptingCommonLibrary.class);
        runtime.loadStatics(Vector2f.class);
        runtime.put("console", Cons.getImpl());
        
        
        return runtime;
    }
    
    
    /**
     * Creates a new {@link Leola} runtime that is not in sandboxed mode.
     *  
     * @return the runtime
     */
    public static Leola newRuntime() {                
        Leola runtime = Args.builder()
                            .setIsDebugMode(true)
                            .setAllowThreadLocals(false)
                            .newRuntime();
        
        /* load some helper functions for objective scripts */
        runtime.loadStatics(SeventhScriptingCommonLibrary.class);
        runtime.loadStatics(Vector2f.class);
        runtime.put("console", Cons.getImpl());
        
        return runtime;
    }

}
