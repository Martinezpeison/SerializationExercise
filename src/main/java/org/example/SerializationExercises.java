package org.example;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.model.Movie;
import org.example.model.Session;
import org.example.model.Theater;

import java.io.*;

public class SerializationExercises {
    /*
        Should define the class for the concepts Movie, Theater and Session.
        A session is a play of movie in a theater.
        Create 2 instances of each class and relate among them.
        Serialize to Json all objects and save then in different files.
     */
    public static class Exercise1 {
        public static void main(String[] args) {
            Movie movie = new Movie("Megalodon 2", 2023);
            Session session = new Session(113, 5);
            Theater theater = new Theater("Yelmo cines", "CC las arenas");

            Gson gson = new Gson();
            String jsonString = gson.toJson(movie);
            String jsonString1 = gson.toJson(session);
            String jsonString2 = gson.toJson(theater);
            System.out.println(jsonString + "\n" +  jsonString1 + "\n" + jsonString2);
            try {
                PrintWriter pw = new PrintWriter(new File("movie.json"));
                PrintWriter pw1 = new PrintWriter(new File("session.json"));
                PrintWriter pw2 = new PrintWriter(new File("theater.json"));
                pw.write(jsonString);
                pw.flush();
                pw1.write(jsonString1);
                pw1.flush();
                pw2.write(jsonString2);
                pw2.flush();

            } catch (Exception e) {
            }
        }
    }

    /*
        Deserialize the objects created in exercise 1.
        Now serialize them using ObjectOutputStream
     */
    public static class Exercise2 {

        public static void main(String[] args) {
            JsonParser parser = new JsonParser();
            Gson gsonInput = new Gson();

            try {
                Object obj = parser.parse(new FileReader("movie.json"));
                JsonObject jsonObject = (JsonObject) obj;
                Movie movie = gsonInput.fromJson(jsonObject, Movie.class);
                ObjectOutputStream fichero = new ObjectOutputStream(new FileOutputStream("C:\\Users\\PC\\OneDrive\\Escritorio\\Pruebas DACD\\movie.txt"));
                fichero.writeObject(movie);
                fichero.close();

                Object obj1 = parser.parse(new FileReader("session.json"));
                JsonObject jsonObject1 = (JsonObject) obj1;
                Session session = gsonInput.fromJson(jsonObject1, Session.class);
                ObjectOutputStream fichero1 = new ObjectOutputStream(new FileOutputStream("C:\\Users\\PC\\OneDrive\\Escritorio\\Pruebas DACD\\session.txt"));
                fichero1.writeObject(session);
                fichero1.close();

                Object obj2 = parser.parse(new FileReader("theater.json"));
                JsonObject jsonObject2 = (JsonObject) obj2;
                Theater theater = gsonInput.fromJson(jsonObject2, Theater.class);
                ObjectOutputStream fichero2 = new ObjectOutputStream(new FileOutputStream("C:\\Users\\PC\\OneDrive\\Escritorio\\Pruebas DACD\\theater.txt"));
                fichero2.writeObject(theater);
                fichero2.close();
            } catch (Exception e) {}
        }
    }
    /* Deserialize the objects from the binary files created in exercise 2.*/
    public static class Exercise3 {

        public static void main(String[] args) throws IOException, ClassNotFoundException {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\PC\\OneDrive\\Escritorio\\Pruebas DACD\\movie.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Movie movieInFile = (Movie) objectInputStream.readObject();
            objectInputStream.close();

            FileInputStream fileInputStream1 = new FileInputStream("C:\\Users\\PC\\OneDrive\\Escritorio\\Pruebas DACD\\session.txt");
            ObjectInputStream objectInputStream1 = new ObjectInputStream(fileInputStream1);
            Session sessionInFile = (Session) objectInputStream1.readObject();
            objectInputStream1.close();

            FileInputStream fileInputStream2 = new FileInputStream("C:\\Users\\PC\\OneDrive\\Escritorio\\Pruebas DACD\\theater.txt");
            ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream2);
            Theater theaterInFile = (Theater) objectInputStream2.readObject();
            objectInputStream2.close();

            System.out.println(movieInFile.getTitle() + " del año " + movieInFile.getYear());
            System.out.println("La sesión tiene una duración de  " + sessionInFile.getDayTime() + " y es en la sala " + sessionInFile.getRoom());
            System.out.println("Se emitirá en " + theaterInFile.getName() + " dentro de " + theaterInFile.getLocation());
        }
    }
}
