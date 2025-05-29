package dpattern.creational.c7objectpool;

public class App {
//    @AllArgsConstructor
//    public static class ReusableObject {
//        private final ObjectPool objectPool;
//
//        public void release() {
//            objectPool.offerObject(this);
//        }
//
//    }
//
//    public static class ObjectPool {
//        private final Queue<ReusableObject> objects = new LinkedList<>();
//
//        public synchronized ReusableObject provideObject() {
//            return objects.isEmpty() ? new ReusableObject(this) : objects.poll();
//        }
//
//        public synchronized void offerObject(ReusableObject object) {
//            objects.offer(object);
//        }
//    }
//
//    private static void useObject(ReusableObject object) {
//        System.out.println(object);
//    }
//
//    public static void main(String[] args) {
//        final ObjectPool objectPool = new ObjectPool();
//        final ReusableObject object = objectPool.provideObject();
//        try {
//            useObject(object);
//        } finally {
//            object.release();
//        }
//    }
}
