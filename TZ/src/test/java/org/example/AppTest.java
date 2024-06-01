package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.jfree.ui.RefineryUtilities;

import java.io.*;
public class AppTest extends TestCase {

    public AppTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    private static void rewriteFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String data = reader.readLine();
        reader.close();
        data = (data + " ").repeat(10);
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(data.substring(0, data.length()-1));
        writer.close();
    }

    /**
     * Rigorous Test :-)
     */
    public void testApp() throws IOException{
        App app = new App("src/test/java/org/example/base_test.txt");
        String min = app._min();
        String max = app._max();
        String sum = app._sum();
        String mult = app._mult();

        assertEquals("1", min);
        assertEquals("5", max);
        assertEquals("15", sum);
        assertEquals("120", mult);
    }
    public void testSpeedAppMin() throws IOException{
        long duration;
        System.out.println("Тест скорости - минимум");
        for (int i = 0; i < 8; i++) {
            App app = new App("src/test/java/org/example/test.txt");
            duration = System.nanoTime();
            app._mult();
            duration = System.nanoTime() - duration;
            System.out.printf("1%s чисел - %d мс%n", "0".repeat(i), duration/1000000);

            rewriteFile("src/test/java/org/example/test.txt");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/java/org/example/test.txt"));
        writer.write("1");
        writer.close();
    }

    public void testSpeedAppMax() throws IOException{
        long duration;
        System.out.println("Тест скорости - максимум");
        for (int i = 0; i < 8; i++) {
            App app = new App("src/test/java/org/example/test.txt");
            duration = System.nanoTime();
            app._mult();
            duration = System.nanoTime() - duration;
            System.out.printf("1%s чисел - %d мс%n", "0".repeat(i), duration/1000000);

            rewriteFile("src/test/java/org/example/test.txt");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/java/org/example/test.txt"));
        writer.write("1");
        writer.close();
    }

    public void testSpeedAppSum() throws IOException{
        long duration;
        System.out.println("Тест скорости - сумма");
        for (int i = 0; i < 8; i++) {
            App app = new App("src/test/java/org/example/test.txt");
            duration = System.nanoTime();
            app._mult();
            duration = System.nanoTime() - duration;
            System.out.printf("1%s чисел - %d мс%n", "0".repeat(i), duration/1000000);

            rewriteFile("src/test/java/org/example/test.txt");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/java/org/example/test.txt"));
        writer.write("1");
        writer.close();
    }

    public void testSpeedAppMult() throws IOException, InterruptedException {
        long[] time = new long[8];
        int[] size = new int[8];
        long duration;
        System.out.println("Тест скорости - умножение");
        for (int i = 0; i < 8; i++) {
            App app = new App("src/test/java/org/example/test.txt");
            duration = System.nanoTime();
            app._mult();
            duration = System.nanoTime() - duration;
            time[i] = duration;
            size[i] = Integer.parseInt(String.format("1%s", "0".repeat(i)));
            System.out.printf("1%s чисел - %d мс%n", "0".repeat(i), duration/1000000);

            rewriteFile("src/test/java/org/example/test.txt");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/java/org/example/test.txt"));
        writer.write("1");
        writer.close();

//        final TimeComplexityGraph demo = new TimeComplexityGraph("Time Complexity", size, time);
//        demo.pack();
//        RefineryUtilities.centerFrameOnScreen(demo);
//        demo.setVisible(true);
//        Thread.sleep(5 * 60 * 1000);
    }

    public void testSizeDig() throws IOException{
        System.out.println("Тест размера чисел в файле - минимальное");
        for (int i = 1; i <= 20; i++) {
            App app = new App("src/test/java/org/example/test.txt");

            app._min();
            app._max();
            app._sum();
            app._mult();

            System.out.printf("%d-значные числа - ОК\n", i*5);

            BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/java/org/example/test.txt"));
            writer.write("1".repeat(i*5));
            writer.close();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/java/org/example/test.txt"));
        writer.write("1");
        writer.close();
    }
}