package someBuffer;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.HashSet;
import java.util.Set;

public class JavaNIOReadWriteChannels {

    public static void main(String args[]) throws IOException {
        byteChannelRead();

        String string = "foo bar";
        byte[] byteArray = string.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        byteChannelWrite(byteBuffer);

        fileChannelRead();
        fileChannelWrite(byteBuffer);

    }

    public static void byteChannelRead() throws IOException {
//        Path filePath = FileSystems.getDefault().getPath("someBuffer/files", "temp.txt");
        File file = new File("13_IO/src/main/resources/someBuffer/files/temp.txt");
        Path filePath = Paths.get(file.getAbsolutePath());

        SeekableByteChannel byteChannel = Files.newByteChannel(filePath);
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        Charset charset = Charset.forName("US-ASCII");
        while (byteChannel.read(byteBuffer) > 0) {
            byteBuffer.rewind();
            System.out.print(charset.decode(byteBuffer));
            byteBuffer.flip();
        }
    }

    public static void byteChannelWrite(ByteBuffer byteBuffer)
            throws IOException {

        Set options = new HashSet();
        options.add(StandardOpenOption.CREATE);
        options.add(StandardOpenOption.APPEND);

        File file = new File("13_IO/src/main/resources/someBuffer/files/byByteChannel.txt");
        Path filePath = Paths.get(file.getAbsolutePath());

        SeekableByteChannel byteChannel = Files.newByteChannel(filePath, options);
        byteChannel.write(byteBuffer);
    }

    public static void fileChannelRead() throws IOException {
        File file = new File("13_IO/src/main/resources/someBuffer/files/temp.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file.getAbsolutePath(),
                "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        Charset charset = Charset.forName("US-ASCII");
        while (fileChannel.read(byteBuffer) > 0) {
            byteBuffer.rewind();
            System.out.print(charset.decode(byteBuffer));
            byteBuffer.flip();
        }
        fileChannel.close();
        randomAccessFile.close();
    }

    public static void fileChannelWrite(ByteBuffer byteBuffer)
            throws IOException {

        Set options = new HashSet();
        options.add(StandardOpenOption.CREATE);
        options.add(StandardOpenOption.APPEND);

        File file = new File("13_IO/src/main/resources/someBuffer/files/byFileChannel.txt");
        Path path = Paths.get(file.getAbsolutePath());

        FileChannel fileChannel = FileChannel.open(path, options);
        fileChannel.write(byteBuffer);
        fileChannel.close();
    }

}
