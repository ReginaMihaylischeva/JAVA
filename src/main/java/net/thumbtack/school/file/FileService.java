package net.thumbtack.school.file;

import com.google.gson.Gson;
import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;
import net.thumbtack.school.figures.v3.Rectangle;
import net.thumbtack.school.ttschool.Trainee;
import net.thumbtack.school.ttschool.TrainingException;

import java.io.*;


public class FileService {
    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(array);
        } catch (IOException e) {
            throw new IOException();
        }

    }

    public static void writeByteArrayToBinaryFile(File file, byte[] array) throws IOException {
        writeByteArrayToBinaryFile(file.getAbsolutePath(), array);

    }

    public static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {

        try (FileInputStream fis = new FileInputStream(fileName)) {
            byte[] b = new byte[fis.available()];
            for (int i = 0; i < b.length; i++) {
                b[i] = (byte) fis.read();

            }
            return b;
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public static byte[] readByteArrayFromBinaryFile(File file) throws IOException {
        return readByteArrayFromBinaryFile(file.getAbsolutePath());
    }

    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) throws IOException {
        byte[] byteArray = null;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            baos.write(array);
            byteArray = baos.toByteArray();
        } catch (IOException e) {
            throw new IOException();
        }
        byte[] b = new byte[byteArray.length / 2];
        try (ByteArrayInputStream bais = new ByteArrayInputStream(byteArray)) {
            for (int i = 0; i < byteArray.length / 2; i++) {
                b[i] = (byte) bais.read();
                bais.read();
            }
            return b;
        } catch (IOException e) {
            throw new IOException();
        }


    }

    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {
        try (BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(fileName))) {
            bw.write(array);
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        writeByteArrayToBinaryFileBuffered(file.getAbsolutePath(), array);
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {
        try (BufferedInputStream bw = new BufferedInputStream(new FileInputStream(fileName))) {
            byte[] b = new byte[bw.available()];
            for (int i = 0; i < b.length; i++) {
                b[i] = (byte) bw.read();
            }
            return b;
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file) throws IOException {
        return readByteArrayFromBinaryFileBuffered(file.getAbsolutePath());
    }

    public static void writeRectangleToBinaryFile(File file, Rectangle rect) throws IOException {
        try (DataOutputStream fos = new DataOutputStream(new FileOutputStream(file.getAbsolutePath()))) {
            fos.writeInt(rect.getTopLeft().getX());
            fos.writeInt(rect.getTopLeft().getY());
            fos.writeInt(rect.getBottomRight().getX());
            fos.writeInt(rect.getBottomRight().getY());
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public static Rectangle readRectangleFromBinaryFile(File file) throws IOException, ColorException {
        try (DataInputStream fis = new DataInputStream(new FileInputStream(file.getAbsolutePath()))) {
            return new Rectangle(fis.readInt(), fis.readInt(), fis.readInt(), fis.readInt(), "RED");
        } catch (IOException e) {
            throw new IOException();
        }

    }

    public static void writeRectangleArrayToBinaryFile(File file, Rectangle[] rects) throws IOException {
        try (DataOutputStream fos = new DataOutputStream(new FileOutputStream(file.getAbsolutePath()))) {
            for (int i = 0; i < rects.length; i++) {
                fos.writeInt(rects[i].getTopLeft().getX());
                fos.writeInt(rects[i].getTopLeft().getY());
                fos.writeInt(rects[i].getBottomRight().getX());
                fos.writeInt(rects[i].getBottomRight().getY());
            }
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public static Rectangle[] readRectangleArrayFromBinaryFileReverse(File file) throws IOException, ColorException {

        try (DataInputStream fis = new DataInputStream(new FileInputStream(file.getAbsolutePath()))) {
            Rectangle[] rects = new Rectangle[fis.available() / 16];
            for (int i = (rects.length - 1); i >= 0; i--) {
                rects[i] = new Rectangle(fis.readInt(), fis.readInt(), fis.readInt(), fis.readInt(), "RED");
            }
            return rects;
        } catch (IOException e) {
            throw new IOException();
        }

    }

    public static void writeRectangleToTextFileOneLine(File file, Rectangle rect) throws IOException {
        try (PrintWriter pw = new PrintWriter(file.getAbsoluteFile())) {
            pw.print(rect.getTopLeft().getX());
            pw.print(' ');
            pw.print(rect.getTopLeft().getY());
            pw.print(' ');
            pw.print(rect.getBottomRight().getX());
            pw.print(' ');
            pw.print(rect.getBottomRight().getY());
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public static Rectangle readRectangleFromTextFileOneLine(File file) throws IOException, ColorException {
        try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            String s = br.readLine();
            return new Rectangle(Integer.parseInt(s.split(" ")[0]), Integer.parseInt(s.split(" ")[1]), Integer.parseInt(s.split(" ")[2]), Integer.parseInt(s.split(" ")[3]), Color.RED);
        }
    }

    public static void writeRectangleToTextFileFourLines(File file, Rectangle rect) throws IOException {
        try (PrintWriter pw = new PrintWriter(file.getAbsolutePath())) {
            pw.println(rect.getTopLeft().getX());
            pw.println(rect.getTopLeft().getY());
            pw.println(rect.getBottomRight().getX());
            pw.print(rect.getBottomRight().getY());
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public static Rectangle readRectangleFromTextFileFourLines(File file) throws IOException, ColorException {
        try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            return new Rectangle(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), "RED");
        } catch (IOException e) {
            throw new IOException();
        }

    }

    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getAbsolutePath()), "UTF-8"))) {
            bw.write(trainee.getFirstName());
            bw.write(' ');
            bw.write(trainee.getLastName());
            bw.write(' ');
            bw.write(trainee.getRating());
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public static Trainee readTraineeFromTextFileOneLine(File file) throws IOException, TrainingException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()), "UTF-8"))) {
            String s = br.readLine();
            return new Trainee(s.split(" ")[0], s.split(" ")[1], Integer.valueOf(s.split(" ")[2].codePointAt(0)));
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getAbsolutePath()), "UTF-8"))) {
            bw.write(trainee.getFirstName());
            bw.newLine();
            bw.write(trainee.getLastName());
            bw.newLine();
            bw.write(trainee.getRating());
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public static Trainee readTraineeFromTextFileThreeLines(File file) throws IOException, TrainingException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()), "UTF-8"))) {
            return new Trainee(br.readLine(), br.readLine(), Integer.valueOf(br.readLine().codePointAt(0)));
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public static Trainee deserializeTraineeFromBinaryFile(File file) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file.getAbsolutePath()))) {
            return (Trainee) ois.readObject();
        } catch (IOException e) {
            throw new IOException();
        } catch (ClassNotFoundException e) {
            throw new IOException();
        }
    }

    public static void serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException {
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file.getAbsolutePath()))) {
            ous.writeObject(trainee);
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public static String serializeTraineeToJsonString(Trainee trainee) {
        Gson gson = new Gson();
        return gson.toJson(trainee);
    }

    public static Trainee deserializeTraineeFromJsonString(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Trainee.class);
    }

    public static void serializeTraineeToJsonFile(File file, Trainee trainee) throws IOException {
        Gson gson = new Gson();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(file.getName())))) {
            gson.toJson(trainee, bw);
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public static Trainee deserializeTraineeFromJsonFile(File file) throws IOException {
        Gson gson = new Gson();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(file.getName())))) {
            return gson.fromJson(br, Trainee.class);
        } catch (IOException e) {
            throw new IOException();
        }
    }
}
