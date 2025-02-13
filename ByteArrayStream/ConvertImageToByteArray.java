package Day3.ByteArrayStream;
import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

    public class ConvertImageToByteArray {

        public static byte[] readImageToBytes(String imagePath) throws IOException {
            FileInputStream fis = new FileInputStream(imagePath);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];  // Read in small chunks
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            fis.close();
            return baos.toByteArray();  // Convert to byte array
        }

        public static void writeBytesToImage(byte[] imageData, String outputPath) throws IOException {
            FileOutputStream fileOutputStream = new FileOutputStream(outputPath);
            fileOutputStream.write(imageData);
            fileOutputStream.close();
        }

        public static boolean compareFiles(String file1, String file2) throws IOException {
            byte[] file1Bytes = Files.readAllBytes(new File(file1).toPath());
            byte[] file2Bytes = Files.readAllBytes(new File(file2).toPath());
            return Arrays.equals(file1Bytes, file2Bytes);
        }

        public static void main(String[] args) {
            String inputImage = "C:\\College\\Capgemini\\Week04\\Day03\\src\\main\\java\\org\\example\\bytearraystream\\Image1.jpg";
            String outputImage = "C:\\College\\Capgemini\\Week04\\Day03\\src\\main\\java\\org\\example\\bytearraystream\\Image2.jpg";

            try {
                byte[] imageData = readImageToBytes(inputImage);

                writeBytesToImage(imageData, outputImage);

                boolean isSame = compareFiles(inputImage, outputImage);
                if (isSame) {
                    System.out.println("Identical");
                } else {
                    System.out.println("Not identical");
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

