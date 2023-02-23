package exercism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SaddlePoints {
  public static void main(String[] args) {
    Matrix matrix = new Matrix(new ArrayList<>());

    System.out.println(matrix.getSaddlePoints().toString());
  }
}

class Matrix {

  private List<List<Integer>> values;

  Matrix(List<List<Integer>> values) {
    this.values = values;
  }

  Set<MatrixCoordinate> getSaddlePoints() {
    if (values.size() <= 0)
      return Set.of();

    Set<MatrixCoordinate> out = new HashSet<>();
    int[][] temp = new int[values.size()][values.get(0).size()];

    for (int i = 0; i < values.size(); i++) {
      List<Integer> tempList1 = new ArrayList<>();
      int rowMax = 0;
      for (int j = 0; j < values.get(i).size(); j++) {
        int val = values.get(i).get(j);
        if (val > rowMax) {
          tempList1.clear();
          tempList1.add(j);
          rowMax = val;
        } else if (val == rowMax) {
          tempList1.add(j);
        }
      }

      for (Integer x : tempList1) {
        temp[i][x] = rowMax;
      }
    }

    for (int i = 0; i < values.get(0).size(); i++) {
      List<Integer> tempList2 = new ArrayList<>();
      int colMin = 99;
      for (int j = 0; j < values.size(); j++) {
        int val = values.get(j).get(i);
        if (val < colMin) {
          tempList2.clear();
          tempList2.add(j);
          colMin = val;
        } else if (val == colMin) {
          tempList2.add(j);
        }
      }

      for (Integer x : tempList2) {
        if (temp[x][i] == colMin)
          out.add(new MatrixCoordinate(x + 1, i + 1));
        temp[x][i] = colMin;
      }
    }

    return out;
  }

}

// don't change this class
class MatrixCoordinate implements Comparable<MatrixCoordinate> {
  private final int row;
  private final int col;

  MatrixCoordinate(final int row, final int col) {
    this.row = row;
    this.col = col;
  }

  @Override
  public String toString() {
    return "Row: " + row + ", Column: " + col;
  }

  // Generated equals and hashcode.

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final MatrixCoordinate that = (MatrixCoordinate) o;

    return row == that.row && col == that.col;
  }

  @Override
  public int hashCode() {
    int result = row;
    result = 31 * result + col;
    return result;
  }

  @Override
  public int compareTo(MatrixCoordinate o) {
    int rowComparison = Integer.compare(row, o.row);
    return (rowComparison == 0) ? Integer.compare(col, o.col) : rowComparison;
  }
}