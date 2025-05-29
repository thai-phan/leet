package theory.dpattern.creational.c4abstractfactory;

public class GraphicsFactoryImpl implements GraphicsFactory {

    private final GraphicsFactory windowsGraphicsFactory = new WindowsGraphicsFactory();

    private final GraphicsFactory ubuntuGraphicsFactory = new UbuntuGraphicsFactory();

    @Override
    public Graphics newGraphics() {
        final String os = System.getProperty("os.name");
        if ("windows".equals(os)) {
            return windowsGraphicsFactory.newGraphics();
        }
        return ubuntuGraphicsFactory.newGraphics();
    }
}
