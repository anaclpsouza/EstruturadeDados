import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Gui extends JFrame implements ActionListener {
    JLabel jl = new JLabel("Escolha uma opção");
    JButton jbInc = new JButton("Incluir novo processo");
    JButton jbRet = new JButton("Retirar processo da fila");
    JButton jbVisu = new JButton("Visualizar processos da fila");
    JButton jbBuscar = new JButton("Buscar processo");
    JButton jbExc = new JButton("Excluir tudo");
    Fila fila = new Fila();
    int numP = -1;
    
    public Gui() {
        super("Gerenciador de processos");
        setLayout(new GridLayout(6, 1));
        setSize(250, 200);
        add(jl);
        add(jbInc);
        add(jbRet);
        add(jbVisu);
        add(jbBuscar);
        add(jbExc);
        setLocationRelativeTo(null);
        setVisible(true);
        jbInc.addActionListener(this);
        jbRet.addActionListener(this);
        jbVisu.addActionListener(this);
        jbBuscar.addActionListener(this);
        jbExc.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jbInc) {
            Processo p = new Processo(++numP, JOptionPane.showInputDialog("Digite o título do processo:"));
            try {
                fila.enfileirar(p); 
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao incluir processo: " + ex.getMessage());
            }
        }
        
        if (e.getSource()==jbRet) {
            try {
                Processo p =  fila.desenfileirar();
                JOptionPane.showMessageDialog(this, "Processo removido: \n Título: " + p.titulo + "\n Número: " + p.num);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao remover processo: " + ex.getMessage());
            }
        }

        if (e.getSource() == jbVisu) {
            try {
                ArrayList<Processo> processos = fila.getAll();
                JOptionPane.showMessageDialog(this, "Lista de processos: \n" + processos.toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao mostrar processo: " + ex.getMessage());
            }
        }

        if (e.getSource() == jbBuscar) {
            try {
                int n = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do processo: "));
                if (fila.find(n) == null) {
                    JOptionPane.showMessageDialog(this, "Processo não encontrado");
                } else {
                    JOptionPane.showMessageDialog(this, "Processo: \n " + fila.find(n));
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao mostrar processo: " + ex.getMessage());
            }
        }

        if (e.getSource()==jbExc) {
            try {
                fila.delete();
                JOptionPane.showMessageDialog(this, "Processos excluídos com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir processos: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Gui();
    }
}

