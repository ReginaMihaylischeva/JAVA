package net.thumbtack.school.matrix;

import java.util.*;


public class MatrixNonSimilarRows {
    List<int[]> matrixNonSimilarRows;

    public MatrixNonSimilarRows(int[][] matrix) {
        matrixNonSimilarRows = new ArrayList();
        for (int i = 0; i < matrix.length; i++) {
            matrixNonSimilarRows.add(matrix[i]);
        }
    }

    public Set<int[]> getNonSimilarRows() {
        int[] buff;
        int k = 0;
        int max = 0;
        LinkedHashSet<int[]> set3 = new LinkedHashSet<>();
        for (int i = 0; i < matrixNonSimilarRows.size(); i++) {
            buff = Arrays.stream(matrixNonSimilarRows.get(i)).boxed().distinct().mapToInt(x -> x).sorted().toArray();
            for (int j = i + 1; j < matrixNonSimilarRows.size(); j++) {
                int[] buff2 = Arrays.stream(matrixNonSimilarRows.get(j)).boxed().distinct().mapToInt(x -> x).sorted().toArray();
                if (Arrays.equals(buff2, buff)) {
                    k++;
                }
            }
            if (k >= max) {
                max = k;
                set3.add(matrixNonSimilarRows.get(i));
                k = 0;
            }

        }
        HashSet<int[]> set1 = new HashSet<>();


        for (int i = 0; i < matrixNonSimilarRows.size(); i++) {
            if (set3.contains(matrixNonSimilarRows.get(i))) {
                set1.add(matrixNonSimilarRows.get(i));
                matrixNonSimilarRows.remove(i);
                i--;
            }
        }

        for (int[] elem : matrixNonSimilarRows) {
            int z = 0;
            int[] elem2 = Arrays.stream(elem).boxed().distinct().mapToInt(x -> x).sorted().toArray();
            for (int[] elem1 : set3) {
                elem1 = Arrays.stream(elem1).boxed().distinct().mapToInt(x -> x).sorted().toArray();
                if (!Arrays.equals(elem2, elem1)) {
                    z++;
                    if (z == set3.size()) {
                        set1.add(elem);
                    }
                }
            }

        }

        return set1;
    }
}
