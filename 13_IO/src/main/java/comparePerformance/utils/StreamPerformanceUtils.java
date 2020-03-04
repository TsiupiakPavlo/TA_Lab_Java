package comparePerformance.utils;

import com.google.common.base.Stopwatch;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class StreamPerformanceUtils {
    private ClassLoader classLoader = getClass().getClassLoader();
    private File file = new File(classLoader.getResource("comparePerformance/text.txt").getFile());

    public long inputStreamReading() {
        Stopwatch stopWatch = Stopwatch.createStarted();
        try (InputStream inputStream = new FileInputStream(file.getAbsolutePath())) {
            int data = inputStream.read();
            while (data != -1) {
                data = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        stopWatch.stop();
        return stopWatch.elapsed(TimeUnit.MICROSECONDS);
    }

    public long bufferStreamReading() {
        Stopwatch stopWatch = Stopwatch.createStarted();
        try (DataInputStream inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file.getAbsolutePath())))) {
            while (inputStream.available() > 0) {
                inputStream.readByte();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        stopWatch.stop();
        return stopWatch.elapsed(TimeUnit.MICROSECONDS);
    }
}
