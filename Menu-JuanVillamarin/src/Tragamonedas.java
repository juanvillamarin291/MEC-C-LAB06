import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Tragamonedas extends JFrame {

    private Timer timer1, timer2, timer3;

    public Tragamonedas() {
        setTitle("Tragamonedas South Park");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(51, 0, 102)); // Fondo morado oscuro
        panel.setLayout(new GridLayout(1, 3, 10, 10));

        ImageIcon[] iconosOriginales = {
                new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\Menu-JuanVillamarin\\src\\Imagenes\\cartmann.png"),
                new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\Menu-JuanVillamarin\\src\\Imagenes\\toalin.png"),
                new ImageIcon("C:\\Users\\Acer\\Documents\\NetBeansProjects\\Menu-JuanVillamarin\\src\\Imagenes\\papadestan.png")
        };

        ImageIcon[] iconos = new ImageIcon[3];
        for (int i = 0; i < iconosOriginales.length; i++) {
            iconos[i] = resizeImage(iconosOriginales[i], 100, 100);
        }

        JLabel imagen1 = new JLabel(iconos[0]);
        JLabel imagen2 = new JLabel(iconos[1]);
        JLabel imagen3 = new JLabel(iconos[2]);

        panel.add(imagen1);
        panel.add(imagen2);
        panel.add(imagen3);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(51, 0, 102)); // Fondo morado oscuro
        buttonPanel.setLayout(new GridLayout(1, 3, 10, 10));

        Font buttonFont = new Font("Arial", Font.BOLD, 12);
        Color buttonTextColor = new Color(25, 25, 112); // Letras azules oscuras
        Color buttonBackgroundColor = new Color(255, 255, 255); // Botón blanco

        JButton pausaButton1 = new JButton("Pausar");
        pausaButton1.setFont(buttonFont);
        pausaButton1.setForeground(buttonTextColor);
        pausaButton1.setBackground(buttonBackgroundColor);
        pausaButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pausarImagen(timer1);
            }
        });
        buttonPanel.add(pausaButton1);

        JButton pausaButton2 = new JButton("Pausar");
        pausaButton2.setFont(buttonFont);
        pausaButton2.setForeground(buttonTextColor);
        pausaButton2.setBackground(buttonBackgroundColor);
        pausaButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pausarImagen(timer2);
            }
        });
        buttonPanel.add(pausaButton2);

        
        JButton pausaButton3 = new JButton("Pausar");
                pausaButton3.setFont(buttonFont);
        pausaButton3.setForeground(buttonTextColor);
        pausaButton3.setBackground(buttonBackgroundColor);
        pausaButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pausarImagen(timer3);
            }
        });
        buttonPanel.add(pausaButton3);

        
        JPanel iniciarPanel = new JPanel();
        iniciarPanel.setBackground(new Color(135, 206, 235)); // Fondo azul clarito
        iniciarPanel.setLayout(new FlowLayout());

        
        Font iniciarButtonFont = new Font("Arial", Font.BOLD, 12);

        JButton iniciarButton = new JButton("Iniciar");
        iniciarButton.setFont(iniciarButtonFont);
        Color iniciarButtonTextColor = new Color(25, 25, 112); // Letras azules oscuras
        iniciarButton.setForeground(iniciarButtonTextColor);
        Color iniciarButtonBackgroundColor = new Color(255, 255, 255); // Botón blanco
        iniciarButton.setBackground(iniciarButtonBackgroundColor);
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarTragamonedas(iconos, imagen1, imagen2, imagen3);
            }
        });
        iniciarPanel.add(iniciarButton);

        
        getContentPane().add(iniciarPanel, BorderLayout.NORTH);

       
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

      
        getContentPane().add(panel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);

        
        setVisible(true);
    }

    private ImageIcon resizeImage(ImageIcon iconoOriginal, int width, int height) {
        Image image = iconoOriginal.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    private void pausarImagen(Timer timer) {
        timer.stop();
    }

    private void iniciarTragamonedas(ImageIcon[] iconos, JLabel imagen1, JLabel imagen2, JLabel imagen3) {
        Random random = new Random();

        
        int index1 = random.nextInt(iconos.length);
        int index2 = random.nextInt(iconos.length);
        int index3 = random.nextInt(iconos.length);

        
        imagen1.setIcon(iconos[index1]);
        imagen2.setIcon(iconos[index2]);
        imagen3.setIcon(iconos[index3]);

        
        timer1 = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = random.nextInt(iconos.length);
                imagen1.setIcon(iconos[index]);
            }
        });
        timer1.start();

        timer2 = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = random.nextInt(iconos.length);
                imagen2.setIcon(iconos[index]);
            }
        });
        timer2.start();

                timer3 = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = random.nextInt(iconos.length);
                imagen3.setIcon(iconos[index]);
            }
        });
        timer3.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Tragamonedas frame = new Tragamonedas();
            }
        });
    }
}


