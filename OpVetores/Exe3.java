import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.Event;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exe3 extends JFrame implements ActionListener{
    JLabel nome = new JLabel("Insira o nome do convidado");
    JTextField jtnome = new JTextField(100);
    JButton jbcad = new JButton("Cadastrar");
    JMenu jm = new JMenu("Opções");
    JMenuBar jmbar = new JMenuBar();
    JMenuItem jmiExibir = new JMenuItem("Exibir lista");
    JMenuItem jmiExcluir = new JMenuItem("Excluir convidado");
    GridBagConstraints cons = new GridBagConstraints();
    GridBagLayout layout = new GridBagLayout();

    JLabel vagas = new JLabel("Vagas restantes: 10");
    String[] lista = new String[10];
    int uP = -1;

    public Exe3() {
        super("Lista de convidados");
        setLayout(layout);

        jm.add(jmiExibir);
        jm.add(jmiExcluir);
        jmbar.add(jm);
        setJMenuBar(jmbar);

        jmiExcluir.addActionListener(this);
        jmiExibir.addActionListener(this);

        cons.insets = new Insets(5, 5, 5, 5);
        cons.fill = GridBagConstraints.HORIZONTAL;
        addC(nome, 0, 0, 1, 4);
        addC(jtnome, 1, 0, 1, 4);
        addC(jbcad, 2, 2, 1, 4);
        addC(vagas, 3, 0, 1, 4);

        jbcad.addActionListener(this);

        setSize(300, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addC(Component c, int r, int col, int h, int w) {
        cons.gridx = col;
        cons.gridy = r;
        cons.gridheight = h;
        cons.gridwidth = w;
        cons.weightx = 1.0;
        cons.anchor = GridBagConstraints.CENTER;
        layout.setConstraints(c, cons);
        add(c);
    }

    

    public static void main(String[] args) {
        new Exe3();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jbcad) {
            String nome = jtnome.getText();
            if (uP == lista.length - 1) {
                jtnome.setText(" ");
                JOptionPane.showMessageDialog(this, "Você ja atingiu o limite de 10 convidados.");
            } else {
                lista[++uP] = nome;
                jtnome.setText("");
                JOptionPane.showMessageDialog(this, "Convidado cadastrado: " + nome);
                atualizarVagas();
            }
        }

        if (e.getSource()==jmiExibir) {
            String listaConvidados = "Lista de Convidados: \n";
            for (int i = 0; i <= uP; i++) {
                listaConvidados += (i+1) + ". " + lista[i] + "\n";
            }
            JOptionPane.showMessageDialog(this, listaConvidados, "Lista de Convidados", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource()==jmiExcluir) {
            String nomeExcluir = JOptionPane.showInputDialog(this, "Insira o nome do convidado a ser excluído:");
            boolean achou = false;
            for (int i = 0; i <= uP; i++) {
                if (lista[i].equalsIgnoreCase(nomeExcluir)) {
                    achou = true;
                    for (int j = i; j < uP; j++) {
                        lista[j] = lista[j + 1];
                    }
                    --uP;
                    JOptionPane.showMessageDialog(this, "Convidado excluído: " + nomeExcluir);
                    atualizarVagas();
                    break;
                }
            }
            if (!achou) {
                JOptionPane.showMessageDialog(this, "Convidado não encontrado.");
            }
        }
        
    }

    public void atualizarVagas() {
        int vagasRest = lista.length - (uP + 1);
        vagas.setText("Vagas restantes: " + vagasRest);
    }
}
