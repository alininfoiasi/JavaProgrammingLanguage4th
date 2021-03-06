package ch2;

import java.util.*;

public class Body {

    private long idNum;
    private String name = "<unnamed>";
    private Body orbits = null;
    private List<Body> orbiters = new ArrayList<Body>();
    private static long nextID = 0;

    // initializer blocks are executed any time a new instance is created,
    // just before the constructor
    {
        try {
            //idNum = 10/0;
            ;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Division by 0!");
        } finally {
            idNum = nextID++;
        }
    }

    public Body() {
    }
    
    public Body(String bodyName) {
        name = bodyName;
        orbits = null;
    }

    public Body(String bodyName, Body orbitsAround) {
        // always call the constructor (if needed) before any other instruction
        this(bodyName);
        orbits = orbitsAround;
    }

    @Override
    public String toString() {
        String description = idNum + " (" + name + ")";
        if (orbits != null) {
            description += " orbits: " + orbits.toString();
        }
        if (orbiters != null && orbiters.size() > 0) {
            description += " orbiters:";
            for (int i = 0; i < orbiters.size(); i++) {
                description += " " + orbiters.get(i).name;
            }
        }
        return description;
    }

    // variable number of String arguments, including 0
    // should be the last argument in the parameter list
    public void setOrbiters(Body... bodies) {
        for (int i = 0; i < bodies.length; i++) {
            orbiters.add(bodies[i]);
        }
    }

    public static void setCommonName(final Body bodyRef) {
        // final objects cannot be modified
        //bodyRef = null;
        // but they can be used to modify the referenced object
        bodyRef.name = "Astronomical object";
    }

    // access control is per class, not per object
    // the code of a method in a class can access all field from an object of
    //that class
    // so current object can access victim's private field orbits
    public void capture(Body victim) {
        victim.orbits = this;
    }

    // overloaded methods have different parameter type and/or arity
    public boolean orbitsAround(Body other) {
        return (orbits == other);
    }
    
    public boolean orbitsAround(long id) {
        return (orbits != null && orbits.idNum == id);
    }

    public static void main(String args[]) {
        Body sun = new Body("Sun", null);
        Body earth = new Body("Earth", sun);
        Body sirius = new Body("Sirius", null);
        System.out.println("before: " + sirius);
        Body.setCommonName(sirius);
        System.out.println("after: " + sirius);
        Body moon = new Body("Moon", earth);
        Body mars = new Body("Mars", sun);
        Body phobos = new Body("Phobos", mars);
        Body deimos = new Body("Deimos", mars);
        earth.setOrbiters(moon);
        //
        //Body[] marsMoons = { phobos, deimos };
        //mars.setOrbiters(marsMoons);
        // equivalent to:
        mars.setOrbiters(phobos, deimos);

        System.out.println(sun.toString());
        System.out.println(earth.toString());
        System.out.println(mars.toString());
    }
}