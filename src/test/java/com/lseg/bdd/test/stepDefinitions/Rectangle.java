package com.lseg.bdd.test.stepDefinitions;

import java.io.*;

public class Rectangle implements Serializable {
        private double height;
        private double width;

        public Rectangle(double height, double width)
        {
            this.height = height;
            this.width = width;
        }

        public double Area()
        {
            return height * width;
        }

        public double Perimeter()
        {
            return 2 * (height + width);
        }



    public static void SerializeToFile(Object classObject, String fileName) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(classObject);
        objectOutputStream.close();
        fileOutputStream.close();

    }
    public static Object DeSerializeFromFileToObject(String fileName) throws IOException, ClassNotFoundException {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Object a= objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

        return a;
    }

    public static void main(String args[]){
        String file ="C:\\Users\\DELL\\Downloads\\empty.txt";
        Rectangle rectangle = new Rectangle(10,20);
        try {
            SerializeToFile(rectangle, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Rectangle deSerializedRect = (Rectangle) DeSerializeFromFileToObject(file);
            System.out.println(deSerializedRect.Area());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

