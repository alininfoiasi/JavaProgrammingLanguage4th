package ch6;

import java.util.Set;

// implicitly extend java.lang.Enum
// is implicitely final, Serializable and Comparable
// is not allowed to override finalize
enum Suit {

    CLUBS, DIAMONDS, HEARTS, SPADES;
}

class Position {
}

class ChessRules {

    static Set<Position> pawnReachable(Position p) {
        return null;
    }

    static Set<Position> rookReachable(Position p) {
        return null;
    }

    static Set<Position> bishopReachable(Position p) {
        return null;
    }
    
    static Set<Position> knightReachable(Position p) {
        return null;
    }
    
    static Set<Position> kingReachable(Position p) {
        return null;
    }

    static Set<Position> queenReachable(Position p) {
        return null;
    }
}

enum ChessPiece {

    PAWN {
        @Override
        Set<Position> reachable(Position current) {
            return ChessRules.pawnReachable(current);
        }
    },
    ROOK {
        @Override
        Set<Position> reachable(Position current) {
            return ChessRules.rookReachable(current);
        }
    },
    BISHOP {
        @Override
        Set<Position> reachable(Position current) {
            return ChessRules.bishopReachable(current);
        }
    },
    KNIGHT {
        @Override
        Set<Position> reachable(Position current) {
            return ChessRules.knightReachable(current);
        }
    },
    KING {
        @Override
        Set<Position> reachable(Position current) {
            return ChessRules.kingReachable(current);
        }
    },
    QUEEN {
        @Override
        Set<Position> reachable(Position current) {
            return ChessRules.queenReachable(current);
        }
    };

    // declare the methods defined by this enum
    abstract Set<Position> reachable(Position current);
}

public class Enums {

    public static void testImplicitMethods() {
        System.out.println(Suit.values().toString());
        System.out.println(Suit.valueOf("HEARTS"));
    }

    public static void main(String args[]) {
        Enums.testImplicitMethods();
        
    }
}
