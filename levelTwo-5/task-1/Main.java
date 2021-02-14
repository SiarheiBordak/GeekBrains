public class Main {
    private static final int size = 10000000;
    private static final int h = size / 2;
    private static final float[] arr = new float[size];

    public static void main(String[] args) {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        methodOne(arr);
        methodTwo(arr);
    }

    public static void methodOne(float[] arr) {
        long a = System.currentTimeMillis();

        arrayChanges(arr);

        System.out.println("running time of one thread: " + (System.currentTimeMillis() - a));
    }

    public synchronized static void methodTwo(float[] arr) {
        long a = System.currentTimeMillis();

        final float[] a1 = new float[h];
        final float[] a2 = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(() -> arrayChanges(a1));
        Thread t2 = new Thread(() -> arrayChanges(a2));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println("running time of two threads:: " + (System.currentTimeMillis() - a));
    }

    public static void arrayChanges(float[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
