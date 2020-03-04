package inputStream.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamInputStream extends InputStream implements AutoCloseable {
    private final Stream<byte[]> source;

    private Spliterator<byte[]> spliterator;
    private ByteArrayInputStream currentItemByteStream = null;

    public StreamInputStream(Stream<byte[]> source) {
        this.source = source;
    }

    @Override
    public int read() throws IOException {
        if (spliterator==null){
            spliterator = source.spliterator();
        }
        try {
            if (currentItemByteStream == null) {
                if (!spliterator.tryAdvance(bytes -> currentItemByteStream = new ByteArrayInputStream(bytes))) {
                    source.close();
                    return -1;
                }
            }
            int ret = currentItemByteStream.read();
            if (ret == -1) {
                currentItemByteStream = null;
                return read();
            }
            return ret;
        }
        catch (Throwable t){
            source.close();
            throw t;
        }
    }

    @Override
    public void close() throws IOException {
        try {
            source.close();
        }
        finally {
            super.close();
        }
    }
}
