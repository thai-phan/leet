package dpattern.creational.c4abstractfactory;


public class AbstractFactoryMain {

    public static void main(String[] args) {
        final GraphicsFactory graphicsFactory = new GraphicsFactoryImpl();
        final Graphics graphics = graphicsFactory.newGraphics();

    }
}
