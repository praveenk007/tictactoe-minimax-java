package com.ttt.enums;

public enum PlayerEnum {
    AI("O"),
    HUMAN("X");

    private String symbol;

    PlayerEnum(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
