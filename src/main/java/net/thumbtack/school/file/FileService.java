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
        writeByteArrayToBinaryFile(new File(fileName), array);
    }

    public static void writeByteArrayToBinaryFile(File file, byte[] array) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(array);

    }

    public static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {

        return readByteArrayFromBinaryFile(new File(fileName));
    }

    public static byte[] readByteArrayFromBinaryFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] b = new byte[fis.available()];
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) fis.read();

        }
        return b;
    }

    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) throws IOException {
        byte[] byteArray = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(array);
        byteArray = baos.toByteArray();

        byte[] b = new byte[byteArray.length / 2];
        ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
        for (int i = 0; i < byteArray.length / 2; i++) {
            b[i] = (byte) bais.read();
            bais.read();
        }
        return b;
    }

    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {

        writeByteArrayToBinaryFileBuffered(new File(fileName), array);
    }

    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(file));
        bw.write(array);
        bw.close();

    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {

        return readByteArrayFromBinaryFileBuffered(new File(fileName));
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file) throws IOException {
        BufferedInputStream bw = new BufferedInputStream(new FileInputStream(file));
        byte[] b = new byte[bw.available()];
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) bw.read();
        }
        return b;
    }

    public static void writeRectangleToBinaryFile(File file, Rectangle rect) throws IOException {
        DataOutputStream fos = new DataOutputStream(new FileOutputStream(file));
        fos.writeInt(rect.getTopLeft().getX());
        fos.writeInt(rect.getTopLeft().getY());
        fos.writeInt(rect.getBottomRight().getX());
        fos.writeInt(rect.getBottomRight().getY());

    }

    public static Rectangle readRectangleFromBinaryFile(File file) throws IOException, ColorException {

        DataInputStream fis = new DataInputStream(new FileInputStream(file));
        return new Rectangle(fis.readInt(), fis.readInt(), fis.readInt(), fis.readInt(), "RED");

    }

    public static void writeRectangleArrayToBinaryFile(File file, Rectangle[] rects) throws IOException {
        DataOutputStream fos = new DataOutputStream(new FileOutputStream(file));
        for (int i = 0; i < rects.length; i++) {
            fos.writeInt(rects[i].getTopLeft().getX());
            fos.writeInt(rects[i].getTopLeft().getY());
            fos.writeInt(rects[i].getBottomRight().getX());
            fos.writeInt(rects[i].getBottomRight().getY());
        }
    }

    public static Rectangle[] readRectangleArrayFromBinaryFileReverse(File file) throws IOException, ColorException {

        DataInputStream fis = new DataInputStream(new FileInputStream(file));

        Rectangle[] rects = new Rectangle[fis.available() / 16];
        for (int i = (rects.length - 1); i >= 0; i--) {
            rects[i] = new Rectangle(fis.readInt(), fis.readInt(), fis.readInt(), fis.readInt(), "RED");
        }
        return rects;

    }

    public static void writeRectangleToTextFileOneLine(File file, Rectangle rect) throws IOException {
        PrintWriter pw = new PrintWriter(file);
        pw.print(rect.getTopLeft().getX());
        pw.print(' ');
        pw.print(rect.getTopLeft().getY());
        pw.print(' ');
        pw.print(rect.getBottomRight().getX());
        pw.print(' ');
        pw.print(rect.getBottomRight().getY());

        pw.close();
    }

    public static Rectangle readRectangleFromTextFileOneLine(File file) throws IOException, ColorException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String s = br.readLine();
            String[] one = s.split(" ");
            return new Rectangle(Integer.parseInt(one[0]), Integer.parseInt(one[1]), Integer.parseInt(one[2]), Integer.parseInt(one[3]), Color.RED);
        }
    }

    public static void writeRectangleToTextFileFourLines(File file, Rectangle rect) throws IOException {
        PrintWriter pw = new PrintWriter(file);
        pw.println(rect.getTopLeft().getX());
        pw.println(rect.getTopLeft().getY());
        pw.println(rect.getBottomRight().getX());
        pw.print(rect.getBottomRight().getY());

        pw.close();
    }

    public static Rectangle readRectangleFromTextFileFourLines(File file) throws IOException, ColorException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String one = br.readLine();
        String two = br.readLine();
        String three = br.readLine();
        String four = br.readLine();
        return new Rectangle(Integer.parseInt(one), Integer.parseInt(two), Integer.parseInt(three), Integer.parseInt(four), "RED");


    }

    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
        bw.write(trainee.getFirstName());
        bw.write(' ');
        bw.write(trainee.getLastName());
        bw.write(' ');
        bw.write(trainee.getRating());

        bw.close();
    }

    public static Trainee readTraineeFromTextFileOneLine(File file) throws IOException, TrainingException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String s = br.readLine();
        String[] one = s.split(" ");
        return new Trainee(one[0], one[1], Integer.valueOf(one[2].codePointAt(0)));

    }

    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
        bw.write(trainee.getFirstName());
        bw.newLine();
        bw.write(trainee.getLastName());
        bw.newLine();
        bw.write(trainee.getRating());

        bw.close();
    }

    public static Trainee readTraineeFromTextFileThreeLines(File file) throws IOException, TrainingException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String one = br.readLine();
        String two = br.readLine();
        String three = br.readLine();
        return new Trainee(one, two, Integer.valueOf(three.codePointAt(0)));

    }

    public static Trainee deserializeTraineeFromBinaryFile(File file) throws IOException {
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))
        ) {
            return (Trainee) ois.readObject();

        } catch (ClassNotFoundException e) {
            throw new IOException();
        }
    }

    public static void serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException {
        ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file));

        ous.writeObject(trainee);

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

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        gson.toJson(trainee, bw);

        bw.close();
    }

    public static Trainee deserializeTraineeFromJsonFile(File file) throws IOException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader(file));
        return gson.fromJson(br, Trainee.class);

    }
}
