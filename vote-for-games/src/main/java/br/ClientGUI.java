package br;

import javax.swing.*;
import java.awt.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientGUI {

    public static void main(String[] args) {

        /*
        JFrame frame = new JFrame("Games do ano");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 350);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titulo = new JLabel("Melhor game", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(titulo, BorderLayout.NORTH);

        // painel da esquerda com FlowLayout para label + combo lado a lado
        JPanel panelEsquerda = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblSelecione = new JLabel("Selecione o jogo:");
        JComboBox<String> comboGames = getStringJComboBox();
        comboGames.setPreferredSize(new Dimension(200, 25));

        panelEsquerda.add(lblSelecione);
        panelEsquerda.add(comboGames);

        //  painel da direita com campo de votos e botões
        JPanel panelDireita = new JPanel(new BorderLayout(10, 10));

        JPanel painelCampoVotos = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblQtd = new JLabel("Quantidade de votos:");
        JTextField txtVotos = new JTextField(10); // 10 colunas visuais
        painelCampoVotos.add(lblQtd);
        painelCampoVotos.add(txtVotos);

        panelDireita.add(painelCampoVotos, BorderLayout.NORTH);

        JButton btnEnviar = new JButton("Enviar ao Servidor Central");
        JButton btnEncerrar = new JButton("Encerrar esta Urna");

        JPanel panelBotoes = new JPanel(new GridLayout(2, 1, 10, 10));
        panelBotoes.add(btnEnviar);
        panelBotoes.add(btnEncerrar);

        panelDireita.add(panelBotoes, BorderLayout.SOUTH);

        JLabel lblStatus = new JLabel(" ", SwingConstants.CENTER);
        lblStatus.setForeground(Color.RED);

        // adiciona os painéis principais
        mainPanel.add(panelEsquerda, BorderLayout.CENTER);
        mainPanel.add(panelDireita, BorderLayout.EAST);
        mainPanel.add(lblStatus, BorderLayout.SOUTH);

        frame.add(mainPanel);

        // ação do botão Enviar
        btnEnviar.addActionListener(e -> {
            try {
                if (comboGames.getSelectedIndex() == -1) {
                    lblStatus.setText("Selecione um jogo!");
                    return;
                }

                if (txtVotos.getText().trim().isEmpty()) {
                    lblStatus.setText("Digite a quantidade de votos!");
                    return;
                }

                Registry registry = LocateRegistry.getRegistry("localhost", 1099);
                VoteManager voteManager = (VoteManager) registry.lookup("VoteManager");

                String selecionado = (String) comboGames.getSelectedItem();
                int numero = Integer.parseInt(selecionado.split(" - ")[0]);
                int votos = Integer.parseInt(txtVotos.getText());

                voteManager.addVotes(numero, votos);

                lblStatus.setText("Dados enviados com sucesso!");
                lblStatus.setForeground(new Color(0, 128, 0));
                txtVotos.setText("");

            } catch (NumberFormatException ex) {
                lblStatus.setText("Erro: Digite apenas números!");
                lblStatus.setForeground(Color.RED);
            } catch (NotBoundException ex) {
                lblStatus.setText("Erro: Serviço não disponível no servidor");
                lblStatus.setForeground(Color.RED);
            } catch (RemoteException ex) {
                lblStatus.setText("Erro: Não foi possível conectar ao servidor");
                lblStatus.setForeground(Color.RED);
            } catch (Exception ex) {
                lblStatus.setText("Erro inesperado: " + ex.getMessage());
                lblStatus.setForeground(Color.RED);
                ex.printStackTrace();
            }
        });

        btnEncerrar.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }

    private static JComboBox<String> getStringJComboBox() {
        String[] games = {
                "1 - Astro Bot", "2 - Grand Theft Auto V", "3 - The Witcher 3", "4 - Elden RIng",
                "5 - Cyberpunk 2077", "6 - Gran Turismo 7", "7 - Alan Wake II", "8 - Ghost of Tsushima",
                "9 - Spider Man 2", "10 - Assassin's Creed Shadows"
        };

        JComboBox<String> comboGames = new JComboBox<>(games);
        comboGames.setPrototypeDisplayValue("10 - Assassin's Creed Shadows");
        return comboGames;
    }

         */

        JFrame frame = new JFrame("Games do ano");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);

        // Painel principal com margens
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título centralizado
        JLabel titulo = new JLabel("Melhor game", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(titulo, BorderLayout.NORTH);

        // Painel central: Combobox + Campo de votos
        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 10, 10));

        // Combobox
        JPanel panelCombo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblSelecione = new JLabel("Selecione o jogo:");
        JComboBox<String> comboGames = getStringJComboBox();
        panelCombo.add(lblSelecione);
        panelCombo.add(comboGames);

        // Campo de votos
        JPanel panelVotos = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblQtd = new JLabel("Quantidade de votos:");
        JTextField txtVotos = new JTextField(10);
        panelVotos.add(lblQtd);
        panelVotos.add(txtVotos);

        centerPanel.add(panelCombo);
        centerPanel.add(panelVotos);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Painel de botões (direita)
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        // Botão "Enviar" (estilizado)
        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.setBackground(new Color(70, 130, 180));
        btnEnviar.setForeground(Color.WHITE);
        btnEnviar.setFocusPainted(false);
        btnEnviar.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        btnEnviar.setPreferredSize(new Dimension(120, 30));

        // Botão "Encerrar" (estilizado)
        JButton btnEncerrar = new JButton("Encerrar");
        btnEncerrar.setBackground(new Color(220, 20, 60));
        btnEncerrar.setForeground(Color.WHITE);
        btnEncerrar.setFocusPainted(false);
        btnEncerrar.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        btnEncerrar.setPreferredSize(new Dimension(120, 30));

        buttonPanel.add(btnEnviar);
        buttonPanel.add(btnEncerrar);
        mainPanel.add(buttonPanel, BorderLayout.EAST);

        // Status (rodapé)
        JLabel lblStatus = new JLabel(" ", SwingConstants.CENTER);
        lblStatus.setForeground(Color.RED);
        mainPanel.add(lblStatus, BorderLayout.SOUTH);

        // Ação do botão "Enviar"
        btnEnviar.addActionListener(e -> {
            try {
                if (comboGames.getSelectedIndex() == -1) {
                    lblStatus.setText("Selecione um jogo!");
                    return;
                }

                if (txtVotos.getText().trim().isEmpty()) {
                    lblStatus.setText("Digite a quantidade de votos!");
                    return;
                }

                Registry registry = LocateRegistry.getRegistry("localhost", 1099);
                VoteManager voteManager = (VoteManager) registry.lookup("VoteManager");

                String selecionado = (String) comboGames.getSelectedItem();
                int numero = Integer.parseInt(selecionado.split(" - ")[0]);
                int votos = Integer.parseInt(txtVotos.getText());

                voteManager.addVotes(numero, votos);

                lblStatus.setText("Dados enviados com sucesso!");
                lblStatus.setForeground(new Color(0, 128, 0)); // Verde
                txtVotos.setText("");

            } catch (Exception ex) {
                lblStatus.setText("Erro: " + ex.getMessage());
                lblStatus.setForeground(Color.RED);
            }
        });

        // Ação do botão "Encerrar"
        btnEncerrar.addActionListener(e -> System.exit(0));

        frame.add(mainPanel);
        frame.setVisible(true);
    }


    private static JComboBox<String> getStringJComboBox() {
        String[] games = {
                "1 - Astro Bot", "2 - Grand Theft Auto V", "3 - The Witcher 3",
                "4 - Elden RIng", "5 - Cyberpunk 2077", "6 - Gran Turismo 7",
                "7 - Alan Wake II", "8 - Ghost of Tsushima", "9 - Spider Man 2",
                "10 - Assassin's Creed Shadows"
        };
        JComboBox<String> combo = new JComboBox<>(games);
        combo.setPrototypeDisplayValue("10 - Assassin's Creed Shadows"); // Largura automática
        return combo;
    }

}
