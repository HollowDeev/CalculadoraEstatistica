import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class CalculadoraTela {

    // variaveis globais
    static ArrayList<Double> listaDados = new ArrayList<>();
    static DefaultListModel<String> modeloLista = new DefaultListModel<>();

    static JList<String> listaVisual;
    static JTextField campoEntrada;
    static JLabel lblResultadoMedia;
    static JLabel lblResultadoMediana;
    static JLabel lblResultadoModa;
    static JLabel lblResultadoDesvio;
    static JLabel lblResultadoCV;
    static JLabel lblResultadoDispersao;

    // checkboxes
    static JCheckBox checkMedia;
    static JCheckBox checkMediana;
    static JCheckBox checkModa;
    static JCheckBox checkDesvio;
    static JCheckBox checkCV;

    public static void main(String[] args) {

        // janela principal
        JFrame janela = new JFrame("Calculadora Estatística — Versão Padrão (Aluno)");
        janela.setSize(750, 600);
        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // painel principal
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout(10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        janela.add(painelPrincipal);

        // titulo
        JLabel lblTitulo = new JLabel("Calculadora Estatística", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

        painelPrincipal.add(lblTitulo, BorderLayout.NORTH);


        // painel esquerdo

        JPanel painelEsquerdo = new JPanel();
        painelEsquerdo.setLayout(new BoxLayout(painelEsquerdo, BoxLayout.Y_AXIS));
        painelEsquerdo.setPreferredSize(new Dimension(300, 0));

        // entrada de dados
        JPanel painelEntrada = new JPanel(new BorderLayout(5, 5));
        painelEntrada.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(180, 180, 180)),
            "Inserir Dados",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 12)
        ));

        campoEntrada = new JTextField();
        campoEntrada.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel lblInstrucao = new JLabel("Digite um número e pressione Enter:");
        lblInstrucao.setFont(new Font("Arial", Font.PLAIN, 12));

        painelEntrada.add(lblInstrucao, BorderLayout.NORTH);
        painelEntrada.add(campoEntrada, BorderLayout.CENTER);

        JButton btnAdicionar = new JButton("Adicionar");
        painelEntrada.add(btnAdicionar, BorderLayout.EAST);

        painelEsquerdo.add(painelEntrada);

        // lista de dados
        JPanel painelLista = new JPanel(new BorderLayout(5, 5));
        painelLista.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(180, 180, 180)),
            "Dados Inseridos",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 12)
        ));

        listaVisual = new JList<>(modeloLista);
        listaVisual.setFont(new Font("Arial", Font.PLAIN, 14));

        JScrollPane scrollLista = new JScrollPane(listaVisual);
        scrollLista.setPreferredSize(new Dimension(280, 200));
        painelLista.add(scrollLista, BorderLayout.CENTER);

        // botoes da lista
        JPanel painelBotoesLista = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

        JButton btnEditar = new JButton("Editar");
        JButton btnRemover = new JButton("Remover");
        JButton btnLimpar = new JButton("Limpar Tudo");

        painelBotoesLista.add(btnEditar);
        painelBotoesLista.add(btnRemover);
        painelBotoesLista.add(btnLimpar);
        painelLista.add(painelBotoesLista, BorderLayout.SOUTH);

        painelEsquerdo.add(painelLista);
        painelPrincipal.add(painelEsquerdo, BorderLayout.WEST);


        // painel direito

        JPanel painelDireito = new JPanel();
        painelDireito.setLayout(new BorderLayout(5, 10));

        // selecao de metricas
        JPanel painelCheckboxes = new JPanel();
        painelCheckboxes.setLayout(new GridLayout(3, 2, 5, 5));
        painelCheckboxes.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(180, 180, 180)),
            "Selecione as Métricas",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 12)
        ));

        checkMedia = new JCheckBox("Média", true);
        checkMediana = new JCheckBox("Mediana", true);
        checkModa = new JCheckBox("Moda", true);
        checkDesvio = new JCheckBox("Desvio Padrão", true);
        checkCV = new JCheckBox("Coef. de Variação", true);

        checkMedia.setFont(new Font("Arial", Font.PLAIN, 13));
        checkMediana.setFont(new Font("Arial", Font.PLAIN, 13));
        checkModa.setFont(new Font("Arial", Font.PLAIN, 13));
        checkDesvio.setFont(new Font("Arial", Font.PLAIN, 13));
        checkCV.setFont(new Font("Arial", Font.PLAIN, 13));

        painelCheckboxes.add(checkMedia);
        painelCheckboxes.add(checkMediana);
        painelCheckboxes.add(checkModa);
        painelCheckboxes.add(checkDesvio);
        painelCheckboxes.add(checkCV);

        painelDireito.add(painelCheckboxes, BorderLayout.NORTH);

        // resultados
        JPanel painelResultados = new JPanel();
        painelResultados.setLayout(new GridLayout(7, 1, 5, 8));
        painelResultados.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(180, 180, 180)),
            "Resultados",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 12)
        ));

        lblResultadoMedia = new JLabel("Média:  —");
        lblResultadoMediana = new JLabel("Mediana:  —");
        lblResultadoModa = new JLabel("Moda:  —");
        lblResultadoDesvio = new JLabel("Desvio Padrão:  —");
        lblResultadoCV = new JLabel("Coef. de Variação:  —");
        lblResultadoDispersao = new JLabel("Dispersão:  —");

        Font fonteResultado = new Font("Arial", Font.PLAIN, 14);
        lblResultadoMedia.setFont(fonteResultado);
        lblResultadoMediana.setFont(fonteResultado);
        lblResultadoModa.setFont(fonteResultado);
        lblResultadoDesvio.setFont(fonteResultado);
        lblResultadoCV.setFont(fonteResultado);
        lblResultadoDispersao.setFont(new Font("Arial", Font.BOLD, 14));

        painelResultados.add(lblResultadoMedia);
        painelResultados.add(lblResultadoMediana);
        painelResultados.add(lblResultadoModa);
        painelResultados.add(lblResultadoDesvio);
        painelResultados.add(lblResultadoCV);
        painelResultados.add(new JLabel(" "));
        painelResultados.add(lblResultadoDispersao);

        painelDireito.add(painelResultados, BorderLayout.CENTER);
        painelPrincipal.add(painelDireito, BorderLayout.CENTER);


        // botao calcular

        JButton btnCalcular = new JButton("CALCULAR");
        btnCalcular.setFont(new Font("Arial", Font.BOLD, 16));
        btnCalcular.setPreferredSize(new Dimension(0, 45));
        btnCalcular.setBackground(new Color(34, 139, 34));
        btnCalcular.setForeground(Color.WHITE);
        btnCalcular.setFocusPainted(false);

        painelPrincipal.add(btnCalcular, BorderLayout.SOUTH);


        // eventos

        // enter no campo de texto
        campoEntrada.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    adicionarNumero(janela);
                }
            }
            public void keyReleased(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });

        // botao adicionar
        btnAdicionar.addActionListener(e -> {
            adicionarNumero(janela);
        });

        // botao remover
        btnRemover.addActionListener(e -> {

            int indiceSelecionado = listaVisual.getSelectedIndex();

            if (indiceSelecionado == -1) {
                JOptionPane.showMessageDialog(janela,
                    "Selecione um número na lista para remover.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                listaDados.remove(indiceSelecionado);
                modeloLista.remove(indiceSelecionado);
                atualizarListaVisual();
            }

        });

        // botao editar
        btnEditar.addActionListener(e -> {

            int indiceSelecionado = listaVisual.getSelectedIndex();
            if (indiceSelecionado == -1) {
                JOptionPane.showMessageDialog(janela,
                    "Selecione um número na lista para editar.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {

                String novoValor = JOptionPane.showInputDialog(janela,
                    "Digite o novo valor:",
                    listaDados.get(indiceSelecionado));

                if (novoValor != null) {
                    try {
                        double numero = Double.parseDouble(novoValor.replace(",", "."));
                        listaDados.set(indiceSelecionado, numero);
                        atualizarListaVisual();
                    } catch (NumberFormatException erro) {
                        JOptionPane.showMessageDialog(janela,
                            "Digite um número válido!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        });

        // botao limpar tudo
        btnLimpar.addActionListener(e -> {
            if (listaDados.isEmpty()) {
                JOptionPane.showMessageDialog(janela,
                    "A lista já está vazia.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                int resposta = JOptionPane.showConfirmDialog(janela,
                    "Tem certeza que deseja limpar todos os dados?",
                    "Confirmar", JOptionPane.YES_NO_OPTION);
                if (resposta == 0) {
                    listaDados.clear();
                    modeloLista.clear();
                    limparResultados();
                }
            }
        });

        // botao calcular
        btnCalcular.addActionListener(e -> {

            if (listaDados.isEmpty()) {
                JOptionPane.showMessageDialog(janela,
                    "Adicione pelo menos um número antes de calcular!",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!checkMedia.isSelected() && !checkMediana.isSelected() &&
                !checkModa.isSelected() && !checkDesvio.isSelected() &&
                !checkCV.isSelected()) {
                JOptionPane.showMessageDialog(janela,
                    "Selecione pelo menos uma métrica para calcular!",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            limparResultados();

            if (checkMedia.isSelected()) {
                double media = CalculosEstatisticos.calcularMedia(listaDados);
                lblResultadoMedia.setText("Média:  " + String.format("%.2f", media));
            }

            if (checkMediana.isSelected()) {
                double mediana = CalculosEstatisticos.calcularMediana(listaDados);
                lblResultadoMediana.setText("Mediana:  " + String.format("%.2f", mediana));
            }

            if (checkModa.isSelected()) {
                String moda = CalculosEstatisticos.calcularModa(listaDados);
                lblResultadoModa.setText(moda);
            }

            if (checkDesvio.isSelected()) {
                double desvio = CalculosEstatisticos.calcularDesvioPadrao(listaDados);
                lblResultadoDesvio.setText("Desvio Padrão:  " + String.format("%.2f", desvio));
            }

            if (checkCV.isSelected()) {
                double cv = CalculosEstatisticos.calcularCoeficienteVariacao(listaDados);
                lblResultadoCV.setText("Coef. de Variação:  " + String.format("%.2f", cv) + "%");

                String dispersao = CalculosEstatisticos.verificarDispersao(cv);
                lblResultadoDispersao.setText("» " + dispersao);

                if (cv <= 20) {
                    lblResultadoDispersao.setForeground(new Color(0, 128, 0));
                } else {
                    lblResultadoDispersao.setForeground(new Color(200, 0, 0));
                }
            }

        });

        janela.setVisible(true);
        campoEntrada.requestFocus();

    }

    // adicionar numero na lista
    public static void adicionarNumero(JFrame janela) {

        String texto = campoEntrada.getText().trim();
        if (texto.isEmpty()) {
            return;
        }

        try {

            double numero = Double.parseDouble(texto.replace(",", "."));
            listaDados.add(numero);
            modeloLista.addElement((listaDados.size()) + ".   " + numero);
            campoEntrada.setText("");

        } catch (NumberFormatException erro) {

            JOptionPane.showMessageDialog(janela,
                "'" + texto + "' não é um número válido!\nUse apenas números (ex: 10 ou 3,14)",
                "Erro de entrada", JOptionPane.ERROR_MESSAGE);
            campoEntrada.selectAll();

        }

    }

    // atualizar a lista visual com numeracao correta
    public static void atualizarListaVisual() {

        modeloLista.clear();

        for (int i = 0; i < listaDados.size(); i++) {
            modeloLista.addElement((i + 1) + ".   " + listaDados.get(i));
        }

    }

    // limpar resultados
    public static void limparResultados() {
        lblResultadoMedia.setText("Média:  —");
        lblResultadoMediana.setText("Mediana:  —");
        lblResultadoModa.setText("Moda:  —");
        lblResultadoDesvio.setText("Desvio Padrão:  —");
        lblResultadoCV.setText("Coef. de Variação:  —");
        lblResultadoDispersao.setText("Dispersão:  —");
        lblResultadoDispersao.setForeground(Color.BLACK);
    }

}
