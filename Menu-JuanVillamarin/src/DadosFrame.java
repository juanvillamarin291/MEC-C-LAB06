import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DadosFrame extends JFrame {

    private JLabel[] dadoLabels;
    private JLabel resultadoLabel;

    public DadosFrame() {
        setTitle("Tirada de Dados");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(102, 0, 153)); 

       
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBackground(new Color(102, 0, 153)); 

        
        JPanel dadosPanel = new JPanel(new FlowLayout());
        dadosPanel.setBackground(new Color(102, 0, 153)); 
        panel.add(dadosPanel, BorderLayout.CENTER);

        
        dadoLabels = new JLabel[2];
        for (int i = 0; i < 2; i++) {
            dadoLabels[i] = new JLabel();
            dadoLabels[i].setPreferredSize(new Dimension(150, 150));
            dadosPanel.add(dadoLabels[i]);
        }

        
        resultadoLabel = new JLabel("", SwingConstants.CENTER);
        resultadoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        resultadoLabel.setForeground(new Color(153, 51, 255)); // Letras moradas
        panel.add(resultadoLabel, BorderLayout.SOUTH);

        
        JButton lanzarButton = new JButton("Lanzar");
        lanzarButton.setBackground(new Color(255, 204, 0)); // Botones dorados
        lanzarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lanzarDados();
            }
        });
        panel.add(lanzarButton, BorderLayout.NORTH);

       
        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    private void lanzarDados() {
        
        int[] dados = new int[6];
        for (int i = 0; i < 6; i++) {
            dados[i] = (int) (Math.random() * 6) + 1;
        }

        // Cargar las imágenes de los dados
        ImageIcon[] iconosDados = new ImageIcon[2];
        iconosDados[0] = new ImageIcon("uno" + dados[0] + ".png");
        iconosDados[1] = new ImageIcon("seis" + dados[1] + ".png");
        

        
        dadoLabels[0].setIcon(iconosDados[0]);
        dadoLabels[1].setIcon(iconosDados[1]);

        
        int resultado = dados[0] + dados[1];

        
        resultadoLabel.setText("Resultado: " + resultado);
    }

        public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DadosFrame dadosFrame = new DadosFrame();
                dadosFrame.setVisible(true);
            }
        });
    }
}

