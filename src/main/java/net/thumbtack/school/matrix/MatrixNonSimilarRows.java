package net.thumbtack.school.matrix;

import java.util.*;
import java.util.stream.Collectors;


public class MatrixNonSimilarRows {
    private Map<Set<Integer>, int[]> matrixNonSimilarRows;

    public MatrixNonSimilarRows(int[][] matrix) {
        matrixNonSimilarRows = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            matrixNonSimilarRows.putIfAbsent(Arrays.stream(matrix[i]).boxed().collect(Collectors.toSet()), matrix[i]);
        }
    }

    public Set<int[]> getNonSimilarRows() {
        return new HashSet<>(matrixNonSimilarRows.values());
    }
}
