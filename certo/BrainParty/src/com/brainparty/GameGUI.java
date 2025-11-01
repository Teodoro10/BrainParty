package com.brainparty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interface gráfica simplificada do jogo BrainParty.
 * Usa Swing com layout simples e código minimalista.
 */
public class GameGUI extends JFrame {
    private Game game;
    private JButton[] cardButtons;
    private JLabel statsLabel;
    private int firstCardIndex = -1;
    private int secondCardIndex = -1;
    private boolean isChecking = false;

    public GameGUI() {
        setTitle("BrainParty - Jogo da Memória");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 700);
        setLocationRelativeTo(null);
        setResizable(false);

        game = new Game();

        // Painel principal
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(new Color(240, 248, 255));

        // Painel de estatísticas
        statsLabel = new JLabel();
        statsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        statsLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(statsLabel, BorderLayout.NORTH);

        // Painel de cartas (4x4)
        JPanel cardPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        cardPanel.setBackground(new Color(240, 248, 255));
        cardButtons = new JButton[16];

        for (int i = 0; i < 16; i++) {
            JButton btn = new JButton("?");
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.setBackground(new Color(100, 149, 237));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setOpaque(true);
            final int index = i;
            btn.addActionListener(e -> cardClicked(index));
            cardButtons[i] = btn;
            cardPanel.add(btn);
        }

        mainPanel.add(cardPanel, BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 248, 255));

        JButton resetBtn = new JButton("Reiniciar");
        resetBtn.setFont(new Font("Arial", Font.BOLD, 14));
        resetBtn.addActionListener(e -> resetGame());
        buttonPanel.add(resetBtn);

        JButton exitBtn = new JButton("Sair");
        exitBtn.setFont(new Font("Arial", Font.BOLD, 14));
        exitBtn.addActionListener(e -> System.exit(0));
        buttonPanel.add(exitBtn);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
        updateDisplay();
    }

    private void cardClicked(int index) {
        if (isChecking || game.getCards().get(index).isMatched() || 
            game.getCards().get(index).isFlipped()) {
            return;
        }

        if (firstCardIndex == -1) {
            firstCardIndex = index;
            game.flipCard(index);
            updateDisplay();
        } else if (secondCardIndex == -1 && index != firstCardIndex) {
            secondCardIndex = index;
            game.flipCard(index);
            game.incrementMoves();
            updateDisplay();

            isChecking = true;

            // Verificar correspondência após 800ms
            Timer timer = new Timer(800, e -> {
                if (game.checkMatch(firstCardIndex, secondCardIndex)) {
                    if (game.isGameOver()) {
                        JOptionPane.showMessageDialog(this,
                            "🎉 Parabéns! Você venceu!\n\n" +
                            "Movimentos: " + game.getMoves() + "\n" +
                            "Tempo: " + game.getElapsedTime() + "s",
                            "Jogo Concluído", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    game.unflipCards(firstCardIndex, secondCardIndex);
                }

                firstCardIndex = -1;
                secondCardIndex = -1;
                isChecking = false;
                updateDisplay();
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    private void updateDisplay() {
        // Atualizar estatísticas
        statsLabel.setText(String.format("Movimentos: %d | Tempo: %ds | Pares: %d/%d",
            game.getMoves(), game.getElapsedTime(), game.getMatchedPairs(), game.getTotalPairs()));

        // Atualizar botões
        for (int i = 0; i < cardButtons.length; i++) {
            Card card = game.getCards().get(i);
            JButton btn = cardButtons[i];

            if (card.isMatched()) {
                btn.setText(card.getWord() + "\n" + card.getTranslation());
                btn.setBackground(new Color(144, 238, 144));
                btn.setEnabled(false);
            } else if (card.isFlipped()) {
                btn.setText(card.getWord() + "\n" + card.getTranslation());
                btn.setBackground(new Color(255, 255, 153));
                btn.setForeground(Color.BLACK);
            } else {
                btn.setText("?");
                btn.setBackground(new Color(100, 149, 237));
                btn.setForeground(Color.WHITE);
                btn.setEnabled(true);
            }
        }
    }

    private void resetGame() {
        game.reset();
        firstCardIndex = -1;
        secondCardIndex = -1;
        isChecking = false;
        updateDisplay();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameGUI());
    }
}

