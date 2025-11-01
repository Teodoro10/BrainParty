package com.brainparty;

/**
 * Classe simplificada que representa uma carta do jogo.
 * Cada carta tem uma palavra em inglês e sua tradução em português.
 */
public class Card {
    private String word;
    private String translation;
    private boolean flipped;
    private boolean matched;

    public Card(String word, String translation) {
        this.word = word;
        this.translation = translation;
        this.flipped = false;
        this.matched = false;
    }

    public String getWord() {
        return word;
    }

    public String getTranslation() {
        return translation;
    }

    public boolean isFlipped() {
        return flipped;
    }

    public void flip() {
        this.flipped = !flipped;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public void reset() {
        this.flipped = false;
    }

    @Override
    public String toString() {
        if (matched) {
            return word + " (" + translation + ")";
        }
        return flipped ? word + " (" + translation + ")" : "?";
    }
}

