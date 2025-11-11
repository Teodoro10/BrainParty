package com.brainparty;

import java.util.*;  // importa ultilitarios: list, arrayList e Collections.shuffle para embaralhar 

/**
 * Classe que gerencia a lógica do jogo.
 * Agora cria cartas separadas: uma com palavra em inglês e outra com português.
 */
public class Game {
    private List<Card> cards;
    private int moves; // quantas moviementações 
    private long startTime; // tempo que começou
    private int matchedPairs;

    public Game() {
        this.cards = new ArrayList<>();
        this.moves = 0;
        this.matchedPairs = 0;
        this.startTime = System.currentTimeMillis();
        initializeCards(); // essa classe inicia o jogo e embaralha 
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

        // Criar cartas separadas: uma em inglês e outra em português
        for (String[] pair : wordPairs) {
            String english = pair[0];
            String portuguese = pair[1];
            
            // Carta com palavra em inglês
            cards.add(new Card(english, portuguese, true));
            
            // Carta com palavra em português
            cards.add(new Card(portuguese, english, false));
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

        // Verifica se as palavras correspondem (inglês com português)
        boolean match = card1.getWord().equals(card2.getPairWord()) && 
                       card2.getWord().equals(card1.getPairWord());

        if (match) {
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
    } // reinicia o game
}
