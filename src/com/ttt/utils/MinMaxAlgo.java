package com.ttt.utils;

import com.ttt.enums.PlayerEnum;
import com.ttt.enums.WinnerEnum;
import com.ttt.models.Board;
import com.ttt.models.Move;

import java.util.List;

public class MinMaxAlgo {

    private int max_score = 10;

    private int min_score = -10;

    public Move minMax(Board board, WinnerEnum player) {
        System.out.println();
        List<Integer> availSpots = board.get_avail_spots();
        WinnerEnum winner = board.whoWon();
        if (WinnerEnum.HUMAN == winner) {
            return new Move(-10);
        }
        else if (WinnerEnum.AI == winner) {
            return new Move(10);
        }
        if (availSpots.size() == 0) {
            return new Move(0);
        }

        Move[] moves = new Move[availSpots.size()];
        for(int index = 0; index < availSpots.size(); index++) {
            Move move = new Move();
            move.setIndex(availSpots.get(index));

            if(player == WinnerEnum.AI) {
                board.makeMove(availSpots.get(index), PlayerEnum.AI.getSymbol());
                move.setScore(minMax(board, WinnerEnum.HUMAN).getScore());
            } else {
                board.makeMove(availSpots.get(index), PlayerEnum.HUMAN.getSymbol());
                move.setScore(minMax(board, WinnerEnum.AI).getScore());
            }
            moves[index] = move;
        }
        Move best_move = null;
        if(player == WinnerEnum.HUMAN) {
            int best_score = 1000;
            for(Move move: moves) {
                if(move.getScore() < best_score) {
                    best_score = move.getScore();
                    best_move = move;
                }
            }
        } else if (player == WinnerEnum.AI) {
            int best_score = -1000;
            for(Move move: moves) {
                if(move.getScore() > best_score) {
                    best_score = move.getScore();
                    best_move = move;
                }
            }
        }
        return best_move;
    }
}
