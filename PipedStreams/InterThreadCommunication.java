package Day3.PipedStreams;
import java.io.*;

public class InterThreadCommunication {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            Writer writer = new Writer(pos);
            Thread writerThread = new Thread(writer);
            writerThread.start();

            Reader reader = new Reader(pis);
            Thread readerThread = new Thread(reader);
            readerThread.start();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class Writer implements Runnable {
    private PipedOutputStream outputStream;

    public Writer(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void run() {
        try {
            String message = "Hello from Writer!";
            outputStream.write(message.getBytes());
            System.out.println("Writer: Message sent.");
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Writer Error: " + e.getMessage());
        }
    }
}

class Reader implements Runnable {
    private PipedInputStream inputStream;

    public Reader(PipedInputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String receivedMessage = new String(buffer, 0, bytesRead);

            System.out.println("Reader received: " + receivedMessage);
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Reader Error: " + e.getMessage());
        }
    }
}
