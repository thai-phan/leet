package dpattern.creational.c4abstractfactory.wild;


public class Graphics {

    String os = "windows";

    public void draw() {
        if (os.equals("windows")) {
            // draw for window
        } else {
            // draw for ubuntu
        }
    }
}