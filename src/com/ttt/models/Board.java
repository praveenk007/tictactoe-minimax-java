package com.ttt.models;

import com.sun.deploy.util.ArrayUtil;
import com.sun.deploy.util.StringUtils;
import com.sun.tools.javac.util.ArrayUtils;
import com.ttt.enums.PlayerEnum;
import com.ttt.enums.WinnerEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board implements Cloneable {

    private int[][] win_rules = {
            {0,1,2},
            {0,3,6},
            {0,4,8},
            {1,4,7},
            {2,5,8},
            {2,4,6},
            {3,4,5},
            {6,7,8}
    };

    private int score;

    private String board[] = {};

    public Board() {
    }

    public Board(String[] board) {
        this.board = board;
    }

    public boolean findIfBlockMoveFor(PlayerEnum player, PlayerEnum opponent, int move) {
        makeMove(move, player.getSymbol());
        for(int index = 0; index < win_rules.length; index++) {
            int[] win_rule = win_rules[index];
            if(!Arrays.stream(win_rule).anyMatch(elem -> elem == move) || board[win_rule[0]] == null || board[win_rule[1]] == null || board[win_rule[2]] == null) {
                continue;
            }
            String win_string = board[win_rule[0]] + board[win_rule[1]] + board[win_rule[2]];
            if(win_string.startsWith(opponent.getSymbol() + opponent.getSymbol()) ||
                    win_string.endsWith(opponent.getSymbol() + opponent.getSymbol()) ||
                    (win_string.charAt(0) == opponent.getSymbol().charAt(0) && win_string.charAt(2) == opponent.getSymbol().charAt(0))) {
                undoMove(move, player.getSymbol());
                return true;
            }
        }
        undoMove(move, player.getSymbol());
        return false;
    }

    public void makeMove(int index, String move) {
        board[index] = move;
    }

    public void undoMove(int index, String move) {
        if(board[index] != null && board[index].equalsIgnoreCase(move)) {
            board[index] = null;
        }
    }

    public boolean isFull() {
        if(board.length == 9) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Board{" +
                ", score=" + score +
                ", board=" + Arrays.toString(board) +
                '}';
    }

    public boolean isEmpty() {
        if(board.length == 0) {
            return true;
        }
        return false;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String[] getBoard() {
        return board;
    }

    public void setBoard(String[] board) {
        this.board = board;
    }

    public List<Integer> get_avail_spots() {
        List<Integer> indexes = new ArrayList<>();
        for(int index = 0; index < board.length; index++) {
            if(board[index] == null) {
                indexes.add(index);
            }
        }
        return indexes;
    }

    public WinnerEnum whoWon() {
        for(int[] win_rule: win_rules) {
            String win_string = board[win_rule[0]] + board[win_rule[1]] + board[win_rule[2]];
            if(win_string.equalsIgnoreCase("xxx")) {
                return  WinnerEnum.HUMAN;
            } else if (win_string.equalsIgnoreCase("ooo")) {
                return  WinnerEnum.AI;
            }
        }
        return WinnerEnum.NO_ONE;
    }

    public void print_board() {
        System.out.println(" ========= =========");
        for(int index = 0; index < board.length; index++) {
            if(board[index] == null) {
                System.out.print("-" + "\t");
            } else {
                System.out.print(board[index] + "\t");
            }
            if(index == 2 || index == 5 || index == 8) {
                System.out.println();
            }
        }
        System.out.println(" ========= =========");
        System.out.println();
    }
}
