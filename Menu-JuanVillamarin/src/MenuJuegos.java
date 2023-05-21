import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuJuegos extends JFrame {

    public MenuJuegos() {
        setTitle("Fercho's Casino");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(51, 0, 102)); // Fondo morado oscuro
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        JLabel titleLabel = new JLabel("Fercho's Casino");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(255, 204, 0)); // Letras doradas
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Color buttonTextColor = new Color(102, 0, 153); // Letras moradas oscuras
        Color buttonBackgroundColor = new Color(255, 204, 0); // Botones dorados

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton tragamonedasButton = new JButton("Tragamonedas");
        tragamonedasButton.setFont(buttonFont);
        tragamonedasButton.setForeground(buttonTextColor);
        tragamonedasButton.setBackground(buttonBackgroundColor);
        tragamonedasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTragamonedas();
            }
        });
        buttonPanel.add(tragamonedasButton);

        JButton dadosButton = new JButton("Tirar los Dados");
        dadosButton.setFont(buttonFont);
        dadosButton.setForeground(buttonTextColor);
        dadosButton.setBackground(buttonBackgroundColor);
        dadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirDados();
            }
        });
        buttonPanel.add(dadosButton);

        panel.add(buttonPanel);

        getContentPane().add(panel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private void abrirTragamonedas() {
        Tragamonedas frame = new Tragamonedas();
        frame.setVisible(true);
        dispose();
    }

    private void abrirDados() {
        DadosFrame frame = new DadosFrame();
        frame.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MenuJuegos menu = new MenuJuegos();
                menu.setVisible(true);
            }
        });
    }
}
