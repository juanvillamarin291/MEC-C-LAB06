import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class Tragamonedas implements Runnable {
    private ImageIcon[] imagenes;
    private JLabel[] labels;
    private boolean girando;
    private int[] resultados;

    public Tragamonedas(ImageIcon[] imagenes, JLabel[] labels) {
        this.imagenes = imagenes;
        this.labels = labels;
        girando = false;
        resultados = new int[3];
    }

    public boolean isGirando() {
        return girando;
    }

    public int[] getResultados() {
        return resultados;
    }

    @Override
    public void run() {
        girando = true;
        Random random = new Random();

        for (int i = 0; i < labels.length; i++) {
            int indice = random.nextInt(imagenes.length);
            resultados[i] = indice;
            ImageIcon imagen = imagenes[indice];
            labels[i].setIcon(imagen);
        }

        girando = false;
    }
}

public class TragamonedasGame implements ActionListener {
    private JFrame frame;
    private JLabel[] labels;
    private JButton jugarButton;
    private Tragamonedas tragamonedas;
    private Thread hilo;

    public TragamonedasGame() {
        frame = new JFrame("Tragamonedas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        labels = new JLabel[3];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
            labels[i].setHorizontalAlignment(SwingConstants.CENTER);
        }

        JPanel panel = new JPanel(new GridLayout(1, 3));
        for (JLabel label : labels) {
            panel.add(label);
        }

        jugarButton = new JButton("Jugar");
        jugarButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(jugarButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setSize(500, 300);
        frame.setVisible(true);

        ImageIcon[] imagenes = {
            new ImageIcon("imagen1.png"),
            new ImageIcon("imagen2.png"),
            new ImageIcon("imagen3.png"),
           
        };

        tragamonedas = new Tragamonedas(imagenes, labels);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!tragamonedas.isGirando()) {
            if (hilo != null) {
                hilo.interrupt();
            }

            hilo = new Thread(tragamonedas);
            hilo.start();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TragamonedasGame());
    }
}
