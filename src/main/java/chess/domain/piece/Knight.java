package chess.domain.piece;

import static chess.domain.piece.Direction.*;

import java.util.List;

import chess.domain.PieceType;
import chess.domain.board.Position;

public class Knight extends Piece {

    private static final List<Direction> POSSIBLE_DIRECTIONS = List.of(NNE, NEE, SEE, SSE, SSW, SWW, NWW, NNW);

    public Knight(final Color color) {
        super(PieceType.KNIGHT, color);
    }

    @Override
    public Direction findValidDirection(Position current, Position target) {
        int rowDifference = target.calculateRowDifference(current);
        int columnDifference = target.calculateColumnDifference(current);
        Direction direction = Direction.calculate(rowDifference, columnDifference);
        validateDirection(direction);
        return direction;
    }

    private void validateDirection(Direction direction) {
        if (!POSSIBLE_DIRECTIONS.contains(direction)) {
            throw new IllegalArgumentException("진행할 수 없는 방향입니다.");
        }
    }

}
