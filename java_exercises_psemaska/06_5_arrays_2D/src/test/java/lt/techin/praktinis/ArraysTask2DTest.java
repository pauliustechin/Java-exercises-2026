package lt.techin.praktinis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Arrays Task Extended Tests")
class ArraysTask2DTest {

    static Stream<Arguments> provideArgumentsForMax() {
        return Stream.of(
                Arguments.of(new int[][]{{5, 4, 5}, {4, 9, 4}, {9, 4, 5}}, 9),
                Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 9),
                Arguments.of(new int[][]{{-1, -2, -3}, {-4, -5, -6}}, -1),
                Arguments.of(new int[][]{{10, 20}, {30, 40}, {50, 60}}, 60),
                Arguments.of(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0)
        );
    }

    static Stream<Arguments> provideArgumentsForRowSum() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 0, 6),
                Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1, 15),
                Arguments.of(new int[][]{{-1, -2, -3}, {-4, -5, -6}}, 1, -15),
                Arguments.of(new int[][]{{10, 20}, {30, 40}, {50, 60}}, 2, 110),
                Arguments.of(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0)
        );
    }

    static Stream<Arguments> provideArgumentsForColumnSum() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 0, 12),
                Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1, 15),
                Arguments.of(new int[][]{{-1, -2, -3}, {-4, -5, -6}}, 2, -9),
                Arguments.of(new int[][]{{10, 20}, {30, 40}, {50, 60}}, 1, 120),
                Arguments.of(new int[][]{{0, 0, 0}, {0, 0, 0}}, 2, 0)
        );
    }

    static Stream<Arguments> provideArgumentsForAllRowSums() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[]{6, 15, 24}),
                Arguments.of(new int[][]{{-1, -2, -3}, {-4, -5, -6}}, new int[]{-6, -15}),
                Arguments.of(new int[][]{{10, 20}, {30, 40}, {50, 60}}, new int[]{30, 70, 110}),
                Arguments.of(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, new int[]{0, 0, 0}),
                Arguments.of(new int[][]{{5, 5}, {10, 10}}, new int[]{10, 20})
        );
    }

    static Stream<Arguments> provideArgumentsForIsRowMagic() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, true),
                Arguments.of(new int[][]{{2, 3, 4}, {4, 2, 3}, {3, 4, 2}}, true),
                Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}}, false),
                Arguments.of(new int[][]{{1}, {1}, {1}}, true)
        );
    }

    static Stream<Arguments> provideArgumentsForIsColumnMagic() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, true),
                Arguments.of(new int[][]{{1, 2, 3}, {2, 2, 2}, {3, 2, 1}}, true),
                Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}}, false)
                //Arguments.of(new int[][]{{1}, {1}, {1}}, true)
        );
    }

    static Stream<Arguments> provideArgumentsForIsSquare() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, true),
                Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, true),
                Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}}, false),
                Arguments.of(new int[][]{{1}}, true)
        );
    }

    static Stream<Arguments> provideArgumentsForIsMagic() {
        return Stream.of(
                Arguments.of(new int[][]{{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}, true),
                Arguments.of(new int[][]{{16, 3, 2, 13}, {5, 10, 11, 8}, {9, 6, 7, 12}, {4, 15, 14, 1}}, true),
                Arguments.of(new int[][]{{1, 2}, {3, 4}}, false),
                Arguments.of(new int[][]{{1}}, true)
        );
    }

    static Stream<Arguments> provideArgumentsForIsLatin() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2, 3}, {3, 1, 2}, {2, 3, 1}}, true),
                Arguments.of(new int[][]{{1, 2}, {2, 1}}, true),
                Arguments.of(new int[][]{{1, 2, 3}, {2, 3, 4}, {3, 4, 1}}, false),
                Arguments.of(new int[][]{{1}}, true)
        );
    }

    static Stream<Arguments> provideArgumentsForIsSequence() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, true),
                Arguments.of(new int[][]{{1, 2}, {3, 4}}, true),
                Arguments.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 10}}, false),
                Arguments.of(new int[][]{{1}}, true)
        );
    }


    @ParameterizedTest(name = "{0} -> {1}")
    @MethodSource("provideArgumentsForMax")
    @DisplayName("Max value in 2D array")
    void maxTest(int[][] arr, int expected) {
        int actual = ArraysTask2D.max(arr);
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "{0}, {1} -> {2}")
    @MethodSource("provideArgumentsForRowSum")
    @DisplayName("Sum of elements in a row")
    void rowSumTest(int[][] arr, int row, int expected) {
        int actual = ArraysTask2D.rowSum(arr, row);
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "{0}, {1} -> {2}")
    @MethodSource("provideArgumentsForColumnSum")
    @DisplayName("Sum of elements in a column")
    void columnSumTest(int[][] arr, int column, int expected) {
        int actual = ArraysTask2D.columnSum(arr, column);
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @MethodSource("provideArgumentsForAllRowSums")
    @DisplayName("Sum of elements in all rows")
    void allRowSumsTest(int[][] arr, int[] expected) {
        int[] actual = ArraysTask2D.allRowSums(arr);
        assertArrayEquals(expected, actual);
    }



    @ParameterizedTest(name = "{0} -> {1}")
    @MethodSource("provideArgumentsForIsRowMagic")
    @DisplayName("Is Row Magic")
    void testIsRowMagic(int[][] arr, boolean expected) {
        assertEquals(expected, ArraysTask2D.isRowMagic(arr));
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @MethodSource("provideArgumentsForIsColumnMagic")
    @DisplayName("Is Column Magic")
    void testIsColumnMagic(int[][] arr, boolean expected) {
        assertEquals(expected, ArraysTask2D.isColumnMagic(arr));
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @MethodSource("provideArgumentsForIsSquare")
    @DisplayName("Is Square")
    void testIsSquare(int[][] arr, boolean expected) {
        assertEquals(expected, ArraysTask2D.isSquare(arr));
    }



    @ParameterizedTest(name = "{0} -> {1}")
    @MethodSource("provideArgumentsForIsMagic")
    @DisplayName("Is Magic Square")
    void testIsMagic(int[][] arr, boolean expected) {
        assertEquals(expected, ArraysTask2D.isMagic(arr));
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @MethodSource("provideArgumentsForIsLatin")
    @DisplayName("Is Latin Square")
    void testIsLatin(int[][] arr, boolean expected) {
        assertEquals(expected, ArraysTask2D.isLatin(arr));
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @MethodSource("provideArgumentsForIsSequence")
    @DisplayName("Is Sequence Square")
    void testIsSequence(int[][] arr, boolean expected) {
        assertEquals(expected, ArraysTask2D.isSequence(arr));
    }
}
