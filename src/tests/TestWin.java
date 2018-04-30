package tests;

import com.ttt.enums.WinnerEnum;
import com.ttt.models.Board;
import com.ttt.models.Move;
import com.ttt.utils.MinMaxAlgo;

import java.util.Arrays;


public class TestWin {

    public static void main(String args[]) {
        String game[] = {
                            "X", null, "O",
                            "O", "O", null,
                            "X", null, "X"
                        };
        Board board = new Board(game);
        MinMaxAlgo algo = new MinMaxAlgo();
        Move move = algo.minMax(board, WinnerEnum.AI);
        System.out.print(move);
    }
}
