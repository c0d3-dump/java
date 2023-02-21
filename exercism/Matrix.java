package exercism;

import java.util.Arrays;

public class Matrix {

  private int[][] list;

  Matrix(String matrixAsString) {
    list = Arrays.stream(matrixAsString.split("\n"))
        .map(i -> Arrays.stream(i.split(" ")).mapToInt(Integer::parseInt).toArray())
        .toArray(int[][]::new);
  }

  int[] getRow(int rowNumber) {
    return list[rowNumber - 1];
  }

  int[] getColumn(int columnNumber) {
    return Arrays.stream(list).mapToInt(i -> i[columnNumber - 1]).toArray();
  }
}
