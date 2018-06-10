/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch16;

import java.lang.reflect.*;
import static java.lang.System.out;
import static java.lang.System.err;

public class TypeBrowser {

    public static void main(String[] args) {
        Class type = null;
        try {
            //type = Class.forName(args[0]);
            //type = Class.forName("java.lang.Class");
            type = Class.forName("java.lang.Object");
        } catch (ClassNotFoundException e) {
            err.println(e);
            return;
        }
        out.print("class " + type.getSimpleName());
        Class superclass = type.getSuperclass();
        if (superclass != null) {
            out.println(" extends "
                    + superclass.getCanonicalName());
        } else {
            out.println();
        }
        Method[] methods = type.getDeclaredMethods();
        for (Method m : methods) {
            if (Modifier.isPublic(m.getModifiers())) {
                out.println(" " + m);
            }
        }
    }
    
}