package iuh.fit.demo2;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

/**
 * Admin 3/3/2025
 **/
public class MyNotepad extends JFrame {

    public MyNotepad() {
        super("My Notepad");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

//        Tao thanh menu voi nut open, save, exit
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        JProgressBar jProgressBar = new JProgressBar();
        jProgressBar.setStringPainted(true);
        add(jProgressBar, BorderLayout.SOUTH);


        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);


//        Xu ly su kien nut open, mo file txt bat ky
        openMenuItem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                String fileName = fileChooser.getSelectedFile().getAbsolutePath();

                // 1. Without Thread
//                loadingWithoutThread(fileName, textArea);
                // 2. With thread
//                loadingWithThread(fileName, textArea);
                // 3. Do in background
                loadingWithSwingWorker(fileName, textArea, jProgressBar);
            }
        });

    }

    private void loadingWithoutThread(String fileName, JTextArea textArea) {
        try (
                FileReader reader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(reader)
        ) {
            textArea.setText("");
            int i = 0;
            while (bufferedReader.ready()) {
                textArea.append(i++ + " " + bufferedReader.readLine() + "\n");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void loadingWithThread(String fileName, JTextArea textArea) {
        textArea.setText("");
        new Thread(() -> {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
                textArea.setText("");
                int i = 0;
                while (bufferedReader.ready()) {
                    textArea.append(i++ + " " + bufferedReader.readLine() + "\n");

                }
            } catch (Exception e) {
                SwingUtilities.invokeLater(() ->
                        JOptionPane.showMessageDialog(null, "Lỗi khi đọc file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE)
                );
            }
        }).start();
    }

    private void loadingWithSwingWorker(String fileName, JTextArea textArea, JProgressBar jProgressBar) {
        textArea.setText("");
        new Thread(() -> {
            SwingWorker<String, Integer> worker = new SwingWorker<>() {
                @Override
                protected String doInBackground() throws Exception {
                    int totalLines = 0;

                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
                        while (bufferedReader.readLine() != null) totalLines++;
                    }

                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
                        textArea.setText("");
                        int i = 0;
                        while (bufferedReader.ready()) {
                            textArea.append(i++ + " " + bufferedReader.readLine() + "\n");
                            int progress = (int) ((i * 100.0) / totalLines);
                            publish(progress);
                        }
                    }
                    return String.valueOf(totalLines);
                }

                @Override
                protected void process(List<Integer> chunks) {
                    jProgressBar.setValue(chunks.get(chunks.size() - 1));
                }

                @Override
                protected void done() {
                    try {
                        jProgressBar.setValue(100);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Lỗi khi đọc file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            };

            worker.execute();
        }).start();
    }







    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyNotepad());
    }
}

