package comparePerformance;

import comparePerformance.utils.StreamPerformanceUtils;

public class Application {
    public static void main(String[] args) {
        StreamPerformanceUtils performanceUtils = new StreamPerformanceUtils();
        System.out.println("InputStream time: " +
                performanceUtils.inputStreamReading() + " MICROSECONDS");
        System.out.println("BufferedInputStream time: " +
                performanceUtils.bufferStreamReading() + " MICROSECONDS");
    }
}
