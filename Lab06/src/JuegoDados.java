import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JuegoDados extends JFrame implements ActionListener {
    private JLabel dado1Label, dado2Label, resultadoLabel;
    private JButton lanzarButton;
    private Random random;
    private ImageIcon[] imagenesDados;
    
    public JuegoDados() {
        super("WELCOME TO FERCHOS CASINO !!");
        
        // Inicializar variables
        random = new Random();
        imagenesDados = new ImageIcon[6];
        
        
        for (int i = 0; i < 6; i++) {
            imagenesDados[i] = new ImageIcon("dado" + (i+1) + ".png");
        }
        
        
        
        dado1Label = new JLabel(imagenesDados[0]);
        dado2Label = new JLabel(imagenesDados[0]);
        resultadoLabel = new JLabel("Cayo: ");
        lanzarButton = new JButton("Prueba tu suerte");
        lanzarButton.addActionListener(this);
        
        // Crear paneles
        JPanel dadosPanel = new JPanel(new GridLayout(1, 2));
        dadosPanel.add(dado1Label);
        dadosPanel.add(dado2Label);
        
        JPanel resultadoPanel = new JPanel(new BorderLayout());
        resultadoPanel.add(resultadoLabel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(lanzarButton);
        
        resultadoPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Agregar componentes al marco
        add(dadosPanel, BorderLayout.CENTER);
        add(resultadoPanel, BorderLayout.SOUTH);
        
        // Configurar el marco
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(350, 200));
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
    // Lanzar los dados y actualizar las imágenes
    int dado1 = random.nextInt(6) + 1;
    int dado2 = random.nextInt(6) + 1;
    int resultado = dado1 + dado2;
    dado1Label.setIcon(imagenesDados[dado1 - 1]);
    dado2Label.setIcon(imagenesDados[dado2 - 1]);
    resultadoLabel.setText("Resultado: " + resultado);
}
 
    private int lanzarDados() {
        int dado1 = random.nextInt(6) ;
        int dado2 = random.nextInt(6);
        return dado1 + dado2;
    }
    
    public static void main(String[] args) {
        new JuegoDados();
    }
}
