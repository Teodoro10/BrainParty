package com.brainparty;

import java.util.*;

/**
 * Classe simplificada que gerencia a lógica do jogo.
 * Controla as cartas, verifica correspondências e rastreia o estado do jogo.
 */
public class Game {
    private List<Card> cards;
    private int moves;
    private long startTime;
    private int matchedPairs;

    public Game() {
        this.cards = new ArrayList<>();
        this.moves = 0;
        this.matchedPairs = 0;
        this.startTime = System.currentTimeMillis();
        initializeCards();
    }

    private void initializeCards() {
        // Pares de palavras em inglês e português
        String[][] wordPairs = {
            {"Cat", "Gato"},
            {"Dog", "Cachorro"},
            {"House", "Casa"},
            {"Tree", "Árvore"},
            {"Sun", "Sol"},
            {"Moon", "Lua"},
            {"Water", "Água"},
            {"Fire", "Fogo"}
        };

        // Criar duas cópias de cada par (uma para cada lado do tabuleiro)
        for (String[] pair : wordPairs) {
            cards.add(new Card(pair[0], pair[1]));
            cards.add(new Card(pair[0], pair[1]));
        }

        // Embaralhar as cartas
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void flipCard(int index) {
        if (index >= 0 && index < cards.size() && !cards.get(index).isMatched()) {
            cards.get(index).flip();
        }
    }

    public boolean checkMatch(int index1, int index2) {
        Card card1 = cards.get(index1);
        Card card2 = cards.get(index2);

        if (card1.getWord().equals(card2.getWord())) {
            card1.setMatched(true);
            card2.setMatched(true);
            matchedPairs++;
            return true;
        }
        return false;
    }

    public void unflipCards(int index1, int index2) {
        cards.get(index1).reset();
        cards.get(index2).reset();
    }

    public void incrementMoves() {
        moves++;
    }

    public int getMoves() {
        return moves;
    }

    public int getMatchedPairs() {
        return matchedPairs;
    }

    public int getTotalPairs() {
        return cards.size() / 2;
    }

    public long getElapsedTime() {
        return (System.currentTimeMillis() - startTime) / 1000;
    }

    public boolean isGameOver() {
        return matchedPairs == getTotalPairs();
    }

    public void reset() {
        cards.clear();
        moves = 0;
        matchedPairs = 0;
        startTime = System.currentTimeMillis();
        initializeCards();
    }
}

