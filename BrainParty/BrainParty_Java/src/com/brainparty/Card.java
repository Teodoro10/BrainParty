package com.brainparty;

/**
 * Classe que representa uma carta do jogo.
 * Cada carta agora mostra APENAS uma palavra (inglês OU português).
 */
public class Card {
    private String word;           // A palavra exibida (inglês ou português)
    private String pairWord;       // A palavra correspondente (para verificar match)
    private boolean flipped;      // Indica se a carta está virada
    private boolean matched;
    private boolean isEnglish;     // true = inglês, false = português

    public Card(String word, String pairWord, boolean isEnglish) {
        this.word = word;
        this.pairWord = pairWord;
        this.isEnglish = isEnglish;
        this.flipped = false;
        this.matched = false;
    }

    public String getWord() {
        return word;  // retorna a palavra da carta 
    }

    public String getPairWord() {
        return pairWord;
    }

    public boolean isEnglish() {
        return isEnglish; //Diz se a carta está em inglês
    }

    public boolean isFlipped() {
        return flipped;    //Vira a carta (se estiver virada, desvira; se estiver oculta, revela)
    }

    public void flip() {
        this.flipped = !flipped;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;   //Marca a carta como combinada ou não
    }

    public void reset() {
        this.flipped = false;
    }

    @Override
    public String toString() {
        if (matched) {
            return word;
        }
        return flipped ? word : "?";   // para mostrar o estado da carta, fliped = combinada ou virada ou escondida
    }
}
