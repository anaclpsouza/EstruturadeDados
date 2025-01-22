import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {
    JLabel jl = new JLabel("Escolha uma opção");
    JButton jbSolicitar = new JButton("Solicitar Senha");
    JButton jbAtendimento = new JButton("Solicitar Atendimento");
    JLabel senhasD = new JLabel("Senhas disponíveis: 50");
    JLabel senhasA = new JLabel("Senha em atendimento: Nenhuma");
    Fila fila = new Fila();
    int senhas = 50;
    int atendimento = -1;
    
    public Gui() {
        super("Gerenciador de senhas");
        setLayout(new GridLayout(5, 1));
        setSize(250, 200);
        add(jl);
        add(senhasD);
        add(senhasA);
        add(jbSolicitar);
        add(jbAtendimento);
        setLocationRelativeTo(null);
        setVisible(true);
        jbSolicitar.addActionListener(this);
        jbAtendimento.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jbSolicitar) {
            Senha s = new Senha(JOptionPane.showInputDialog("Digite seu nome"));
            try {
                fila.enfileirar(s);
                senhas--; 
                senhasD.setText("Senhas disponíveis: " + senhas);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao solicitar senha: " + ex.getMessage());
            }
        }
        
        if (e.getSource()==jbAtendimento) {
            try {
                String s =  fila.desenfileirar().senha;
                JOptionPane.showMessageDialog(this, "Senha sendo atendida: " + s);
                senhasA.setText("Senha sendo atendida: " + s);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao solicitar atendimento: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Gui();
    }
    
}
