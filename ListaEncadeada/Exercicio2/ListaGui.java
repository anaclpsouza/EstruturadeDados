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
    JPanel panelEntrada = new JPanel(new GridLayout(7, 2, 5, 5));
    JLabel lblPlaca = new JLabel("Placa:");
    JTextField txtPlaca = new JTextField();
    JLabel lblMarca = new JLabel("Marca:");
    JTextField txtMarca = new JTextField();
    JLabel lblModelo = new JLabel("Modelo:");
    JTextField txtModelo = new JTextField();
    JLabel lblValor = new JLabel("Valor: R$");
    JTextField txtValor = new JTextField();
    JTextField txtExc = new JTextField();
    JButton btnAdicionar = new JButton("Adicionar Veiculo");
    JPanel panelBotoes = new JPanel(new FlowLayout());
    JButton btnExcluir = new JButton("Excluir pela placa");
    JButton btnExibir = new JButton("Exibir Veículos");
    JTextArea textArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(textArea);

    public ListaGui() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        panelEntrada.add(lblPlaca);
        panelEntrada.add(txtPlaca);
        panelEntrada.add(lblMarca);
        panelEntrada.add(txtMarca);
        panelEntrada.add(lblModelo);
        panelEntrada.add(txtModelo);
        panelEntrada.add(lblValor);
        panelEntrada.add(txtValor);
        panelEntrada.add(new JLabel());
        panelEntrada.add(btnAdicionar);
        panelEntrada.add(new JLabel("Placa:"));
        panelEntrada.add(new JLabel());
        panelEntrada.add(txtExc);
        panelEntrada.add(btnExcluir);

        textArea.setEditable(false);

        panelBotoes.add(btnExibir);
       

        this.add(panelEntrada, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(panelBotoes, BorderLayout.SOUTH);

        btnAdicionar.addActionListener(this);
        btnExibir.addActionListener(this);
        btnExcluir.addActionListener(this);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdicionar) {
            try {
                String placa = txtPlaca.getText();
                String marca = txtMarca.getText();
                String modelo = txtModelo.getText();
                double valor = Double.parseDouble(txtValor.getText());

                if (placa.isEmpty() || marca.isEmpty() || modelo.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Veiculo Veiculo = new Veiculo(placa, marca, modelo, valor);
                lista.add(Veiculo);
                JOptionPane.showMessageDialog(this, "Veiculo adicionado com sucesso!");
                txtPlaca.setText("");
                txtMarca.setText("");
                txtModelo.setText("");
                txtValor.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "O valor deve ser um número.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == btnExibir) {
            textArea.setText(lista.exibir());
        }

        if (e.getSource()==btnExcluir) {
            try {
                lista.excluir(txtExc.getText());
                JOptionPane.showMessageDialog(this, "Veiculo excluído com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
