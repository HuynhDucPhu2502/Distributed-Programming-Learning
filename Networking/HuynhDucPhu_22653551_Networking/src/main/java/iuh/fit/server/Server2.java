package iuh.fit.server;

import iuh.fit.dao.SupplierDAO;
import iuh.fit.dao.SupplierDAOImpl;
import iuh.fit.model.Supplier;
import iuh.fit.util.MyJson;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

    public static void main(String[] args) throws Exception {
        try (ServerSocket serverSocket2 = new ServerSocket(8079)) {
            System.out.println("Server is ready!!!");

            while (true) {
                Socket socket = serverSocket2.accept();

                System.out.println("Client's hostname: " + socket.getInetAddress().getHostName());
                System.out.println("Client's IP address: " + socket.getInetAddress().getHostAddress());
                System.out.println("Client's port: " + socket.getPort());


                Thread thread = new Thread(new HandlingSocket2(socket));
                thread.start();
            }
        }
    }

}

class HandlingSocket2 implements Runnable {
    private final Socket socket;
    private final SupplierDAO supplierDAO;

    public HandlingSocket2(Socket socket) {
        this.socket = socket;
        this.supplierDAO = new SupplierDAOImpl();
    }


    @Override
    public void run() {
        try (
                DataInputStream in = new DataInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())
        ) {
            while(true) {
                // Nhận từ client
                int id = in.readInt();
                Supplier supplier = supplierDAO.findById(1);

                // Tìm
                supplier = supplierDAO.findById(id);

                // Convert to Json
                String json = MyJson.toJson(supplier);

                // Gửi từ server
                out.writeUTF(json);
//                out.writeObject(supplier);
                out.flush();

            }
        } catch (Exception e) {

        }
    }
}
