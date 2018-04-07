package net.thumbtack.school.matrix;

import java.util.*;
import java.util.stream.Collectors;


public class MatrixNonSimilarRows {
    private Map<Set<Integer>, int[]> matrixNonSimilarRows;
    private LinkedHashSet<int[]> setmatrix = new LinkedHashSet<>();

    public MatrixNonSimilarRows(int[][] matrix) {
        matrixNonSimilarRows = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            matrixNonSimilarRows.put(Arrays.stream(matrix[i]).boxed().collect(Collectors.toSet()), matrix[i]);
            setmatrix.add(matrix[i]);
        }
    }

    public Set<int[]> getNonSimilarRows() {
        HashSet<int[]> set1 = new HashSet<>();
        for (int[] elem : setmatrix) {
            Set<Integer> mySet1 = Arrays.stream(elem).boxed().collect(Collectors.toSet());
            if (matrixNonSimilarRows.containsKey(mySet1)) {
                matrixNonSimilarRows.remove(mySet1);
                set1.add(elem);
            }
        }
        return set1;
    }
}
