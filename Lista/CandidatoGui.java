import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CandidatoGui extends JFrame implements ActionListener {

    JMenuItem jmiCriarcandidato = new JMenuItem("Adicionar novo candidato");
    JMenuItem jmiRemovercandidato = new JMenuItem("Apagar candidato");
    JMenuItem jmiBuscarcandidato = new JMenuItem("Buscar candidatos");
    JMenuItem jmiVercandidato = new JMenuItem("Ver candidatos cadastrados");
    JMenu op = new JMenu("Ações");
    JMenuBar jmbar = new JMenuBar();

    JLabel jlnome = new JLabel("Nome do Candidato");
    JLabel jlnota = new JLabel("Nota do Candidato");
    JTextField jtnome = new JTextField(20);
    JTextField jtnota = new JTextField(20);

    JButton jbSalvar = new JButton("Salvar");

    JButton jbCons = new JButton("Consultar Candidatos");

    JLabel jlCodF3 = new JLabel("Insira o número de inscrição: ");
    JTextField jtCodF3 = new JTextField();
    JButton jbExc = new JButton("Excluir");

    JTextField ta = new JTextField(20);
    JButton jbB = new JButton("Buscar");

    JPanel jPanel2 = new JPanel();

    JPanel panel1 = new JPanel();
    JPanel jPanel3 = new JPanel();
    JPanel jPanelMain = new JPanel();

    ListaCandidato listaC = new ListaCandidato();
    int insc = 0;

    public CandidatoGui() {
        super("Cadastro de candidatos");
        op.add(jmiCriarcandidato);
        op.add(jmiBuscarcandidato);
        op.add(jmiRemovercandidato);
        op.add(jmiVercandidato);
        jmbar.add(op);
        setJMenuBar(jmbar);

        jmiBuscarcandidato.addActionListener(this);
        jmiCriarcandidato.addActionListener(this);
        jmiRemovercandidato.addActionListener(this);
        jmiVercandidato.addActionListener(this);

        panel1.setLayout(new GridLayout(3, 2));
        panel1.add(jlnome);
        panel1.add(jtnome);
        panel1.add(jlnota);
        panel1.add(jtnota);
        panel1.add(jbSalvar);

        jPanel2.add(new JLabel("Digite o nome do filme que deseja buscar"), BorderLayout.NORTH);
        jPanel2.add(ta, BorderLayout.CENTER);
        jPanel2.add(jbB, BorderLayout.SOUTH);
        jbB.addActionListener(this);

        jPanel3.setLayout(new GridLayout(2, 2));
        jPanel3.add(jlCodF3);
        jPanel3.add(jtCodF3);
        jPanel3.add(jbExc);
        
        jbExc.addActionListener(this);

        add(panel1, BorderLayout.CENTER);
        jbCons.addActionListener(this);

        jbSalvar.addActionListener(this);

        jPanelMain.setLayout(new BorderLayout());
        add(jPanelMain);

        setVisible(true);
        setSize(400, 200);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jmiCriarcandidato) {
            updatePanel(panel1);
        }

        if (e.getSource() == jbSalvar) {
            try {
                insc++;
                int nota = Integer.parseInt(jtnota.getText());
                Candidato c = new Candidato(jtnome.getText(), nota, insc);
                listaC.add(c);
                JOptionPane.showMessageDialog(this, "Candidato Salvo com Sucesso!");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }


        if (e.getSource()==jmiVercandidato) {
            JPanel painelCand = new JPanel();
            painelCand.setLayout(new GridLayout(listaC.tamanho(), 2));
            try {
                for (int i = 0; i < listaC.tamanho(); i++) {
                    JLabel filmeLabel = new JLabel("Inscrição: " + listaC.get(i).getInsc() + " Nome: "+ listaC.get(i).getNome() + " Nota: " + listaC.get(i).getNota());
                    painelCand.add(filmeLabel);
                }
            } catch (Exception er) {
                System.out.println(er.getMessage());
            }

            updatePanel(painelCand);
        }

        if (e.getSource()==jmiRemovercandidato) {
            updatePanel(jPanel3);
        }

        if (e.getSource()==jbExc) {
            try {
                int cod = Integer.parseInt(jtCodF3.getText());
                listaC.remove(cod);
                jtCodF3.setText(" ");
            } catch (Exception exe) {
                JOptionPane.showMessageDialog(this, "Insira apenas números");
            }
        }

        if (e.getSource()==jmiBuscarcandidato) {
            updatePanel(jPanel2);
        }

        if (e.getSource()==jbB) {
            String nomeB = ta.getText();
            try {
                JLabel jl = new JLabel(listaC.getbyCandidato(nomeB).getNome() + listaC.getbyCandidato(nomeB).getInsc() + listaC.getbyCandidato(nomeB).getNota());
                jPanel2.add(jl);
            } catch (Exception er) {
                System.out.println(er.getMessage());
            }
        } 
        
    }

    private void updatePanel(JPanel newPanel) {
        jPanelMain.removeAll();
        jPanelMain.add(newPanel, BorderLayout.CENTER);
        jPanelMain.revalidate();
        jPanelMain.repaint();
    }
}
