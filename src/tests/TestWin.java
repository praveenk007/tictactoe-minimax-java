package tests;

import com.ttt.enums.PlayerEnum;
import com.ttt.enums.WinnerEnum;
import com.ttt.models.Board;
import com.ttt.models.Move;
import com.ttt.utils.MinMaxAlgo;

public class TestWin {

    public static void main(String args[]) {
        String game[] = {null, null, "O",
                            "X", "X", "X",
                         null, null, "O"};
        Board board = new Board(game);
        MinMaxAlgo algo = new MinMaxAlgo();
        Move move = algo.minMax(board, WinnerEnum.AI);
        System.out.print(move);
    }
}
