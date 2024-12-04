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
    JPanel panelEntrada = new JPanel(new GridLayout(4, 2, 5, 5));
    JLabel lblCodigo = new JLabel("Código:");
    JTextField txtCodigo = new JTextField();
    JLabel lblNome = new JLabel("Nome:");
    JTextField txtNome = new JTextField();
    JLabel lblTelefone = new JLabel("Telefone:");
    JTextField txtTelefone = new JTextField();
    JButton btnAdicionar = new JButton("Adicionar Cliente");
    JPanel panelBotoes = new JPanel(new FlowLayout());
    JButton btnExibirCrescente = new JButton("Exibir Crescente");
    JButton btnExibirDecrescente = new JButton("Exibir Decrescente");
    JTextArea textArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(textArea);

    public ListaGui() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        panelEntrada.add(lblCodigo);
        panelEntrada.add(txtCodigo);
        panelEntrada.add(lblNome);
        panelEntrada.add(txtNome);
        panelEntrada.add(lblTelefone);
        panelEntrada.add(txtTelefone);
        panelEntrada.add(new JLabel());
        panelEntrada.add(btnAdicionar);

        textArea.setEditable(false);

        panelBotoes.add(btnExibirCrescente);
        panelBotoes.add(btnExibirDecrescente);

        this.add(panelEntrada, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(panelBotoes, BorderLayout.SOUTH);

        btnAdicionar.addActionListener(this);
        btnExibirCrescente.addActionListener(this);
        btnExibirDecrescente.addActionListener(this);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdicionar) {
            try {
                int codigo = Integer.parseInt(txtCodigo.getText());
                String nome = txtNome.getText();
                String telefone = txtTelefone.getText();

                if (nome.isEmpty() || telefone.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Cliente cliente = new Cliente(codigo, nome, telefone);
                lista.add(cliente);
                JOptionPane.showMessageDialog(this, "Cliente adicionado com sucesso!");
                txtCodigo.setText("");
                txtNome.setText("");
                txtTelefone.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "O código deve ser um número.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == btnExibirCrescente) {
            textArea.setText(lista.exibirCrescente());
        }

        if (e.getSource()==btnExibirDecrescente) {
            textArea.setText(lista.exibirDecrescente());
        }
    }

}
