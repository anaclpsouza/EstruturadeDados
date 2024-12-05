import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class ListaGui extends JFrame implements ActionListener {
    ListaEncadeada lista = new ListaEncadeada();
    No noAtual = lista.cabeca;

    JPanel panelEntrada = new JPanel(new GridLayout(11, 2, 5, 5));
    JLabel lblInc = new JLabel("Incluir cidade");
    JLabel lblNome = new JLabel("Nome:");
    JTextField txtNome = new JTextField();
    JLabel lblPais = new JLabel("Pais:");
    JTextField txtPais = new JTextField();
    JLabel lblAtrativos = new JLabel("Principais Atrativos:");
    JTextField txtAtrativos = new JTextField();
    JLabel lblNota = new JLabel("Nota:");
    JTextField txtNota = new JTextField();
    JTextField txtExcNome = new JTextField();
    JTextField txtExcPais = new JTextField();
    JButton btnAdicionar = new JButton("Adicionar Cidade");
    JPanel panelBotoes = new JPanel(new FlowLayout());
    JLabel lblExc = new JLabel("Excluir Cidade");
    JButton btnExcluir = new JButton("Excluir Cidade");
    JButton btnExibir = new JButton("Exibir");
    JTextArea textArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(textArea);

    JButton btnProx = new JButton("Próxima");
    JButton btnAnt = new JButton("Anterior");

    public ListaGui() {
        super("Indicação de cidades turísticas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        panelEntrada.add(lblInc);
        panelEntrada.add(new JLabel());
        panelEntrada.add(lblNome);
        panelEntrada.add(txtNome);
        panelEntrada.add(lblPais);
        panelEntrada.add(txtPais);
        panelEntrada.add(lblAtrativos);
        panelEntrada.add(txtAtrativos);
        panelEntrada.add(lblNota);
        panelEntrada.add(txtNota);
        panelEntrada.add(new JLabel());
        panelEntrada.add(btnAdicionar);
        panelEntrada.add(new JLabel());
        panelEntrada.add(new JLabel());
        panelEntrada.add(lblExc);
        panelEntrada.add(new JLabel());
        panelEntrada.add(new JLabel("Nome:"));
        panelEntrada.add(txtExcNome);
        panelEntrada.add(new JLabel("País:"));
        panelEntrada.add(txtExcPais);
        panelEntrada.add(new JLabel());
        panelEntrada.add(btnExcluir);

        textArea.setEditable(false);

        panelBotoes.add(btnAnt);
        panelBotoes.add(btnProx);
        btnProx.setEnabled(false);
        btnAnt.setEnabled(false);

        this.add(panelEntrada, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(panelBotoes, BorderLayout.SOUTH);

        btnAdicionar.addActionListener(this);
        btnExcluir.addActionListener(this);

        btnProx.addActionListener(this);
        btnAnt.addActionListener(this);

        setVisible(true);

    }

    public void exibe() {
        if (lista.tamanho == 0) {
            textArea.setText("Lista Vazia");
        } else {
            textArea.setText("Nota: " + noAtual.elemento.getNota() + " \n Nome da cidade: " + noAtual.elemento.getNome()
                    + "\n País: " + noAtual.elemento.getPais() + "\n Principais Atrativos: " + noAtual.elemento.getPontos());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdicionar) {
            try {
                String Nome = txtNome.getText();
                String Pais = txtPais.getText();
                String Atrativos = txtAtrativos.getText();
                int Nota = Integer.parseInt(txtNota.getText());
                if (Nota > 10 || Nota < 0) {
                    JOptionPane.showMessageDialog(this, "As Notas devem ser entre 1-10.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (Nome.isEmpty() || Pais.isEmpty() || Atrativos.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Cidade Cidade = new Cidade(Nome, Pais, Atrativos, Nota);
                lista.add(Cidade);
                JOptionPane.showMessageDialog(this, "Cidade adicionado com sucesso!");
                txtNome.setText("");
                txtPais.setText("");
                txtAtrativos.setText("");
                txtNota.setText("");
                btnProx.setEnabled(true);
                btnAnt.setEnabled(true);
                noAtual = noAtual.proximo;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "A Nota deve ser um número.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == btnProx) {
            if (noAtual.proximo != null) {
                noAtual = noAtual.proximo;
            }
            exibe();
        }

        if (e.getSource() == btnAnt) {
            if (noAtual.anterior != null && noAtual.anterior != lista.cabeca) {
                noAtual = noAtual.anterior;
            }
            exibe();
        }

        if (e.getSource() == btnExcluir) {
            try {
                String Nome = txtExcNome.getText();
                String Pais = txtExcPais.getText();

                if (Nome.isEmpty() || Pais.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                lista.excluir(Nome, Pais);
                JOptionPane.showMessageDialog(this, "Cidade excluído com sucesso!");
                txtExcNome.setText("");
                txtExcPais.setText("");
                if (lista.tamanho <= 0) {
                    btnProx.setEnabled(false);
                    btnAnt.setEnabled(false);
                }
                exibe();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
