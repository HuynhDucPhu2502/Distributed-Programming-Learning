package iuh.fit;

import iuh.fit.dao.MovieDAO;
import iuh.fit.model.Movie;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

/**
 * Admin 3/30/2025
 **/
public class HandlingClient implements Runnable {
    private Socket socket;
    private MovieDAO movieDAO;

    public HandlingClient(Socket socket) {
        this.socket = socket;
        this.movieDAO = new MovieDAO();
    }

    @Override
    public void run() {
        try (
                DataInputStream in = new DataInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())
        ) {

            while (true) {
                String command = in.readUTF();

                switch (command) {
                    case "CONTAINS_NAME" -> {

                    }
                    case "CREATE_MOVIE" -> {

                    }
                    case "LIST_MOVIES_BY_ACTOR_AND_RELEASED" -> {

                    }
                    case "GET_NO_MOVIES_PER_ACTOR_BY_RELEASED_YEAR" -> {

                    }
                    case "SEARCH" -> {

                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
