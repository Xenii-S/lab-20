package lab3;

import java.util.Arrays;

public class Matrix<T extends Number> {
    private final int rows;
    private final int columns;
    private final T[][] data;

    public Matrix(int rows, int columns, T[][] data) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException("Matrix dimensions must be positive");
        }

        this.rows = rows;
        this.columns = columns;
        this.data = data;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public T getElement(int i, int j) {
        return data[i][j];
    }

    public void setElement(int i, int j, T value) {
        data[i][j] = value;
    }

    public Matrix<T> add(Matrix<T> other) {
        if (rows != other.rows || columns != other.columns) {
            throw new IllegalArgumentException("Matrix dimensions must be the same for addition");
        }

        T[][] resultData = createArray(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultData[i][j] = addElements(data[i][j], other.getElement(i, j));
            }
        }

        return new Matrix<>(rows, columns, resultData);
    }

    public Matrix<T> multiply(Matrix<T> other) {
        if (columns != other.rows) {
            throw new IllegalArgumentException("Number of columns in the first matrix must be equal to the number of rows in the second matrix for multiplication");
        }

        T[][] resultData = createArray(rows, other.columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                T sum = zeroElement();
                for (int k = 0; k < columns; k++) {
                    sum = addElements(sum, multiplyElements(data[i][k], other.getElement(k, j)));
                }
                resultData[i][j] = sum;
            }
        }

        return new Matrix<>(rows, other.columns, resultData);
    }

    private T[][] createArray(int rows, int columns) {
        return (T[][]) new Number[rows][columns];
    }

    private T zeroElement() {
        return (T) Integer.valueOf(0);
    }

    private T addElements(T a, T b) {
        return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
    }

    private T multiplyElements(T a, T b) {
        return (T) Double.valueOf(a.doubleValue() * b.doubleValue());
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Integer[][] data1 = {{1, 2, 3}, {4, 5, 6}, {1,5,8}};
        Integer[][] data2 = {{7, 8, 1}, {9, 10, 4}, {11, 12, 6}};

        Matrix<Integer> matrix1 = new Matrix<>(3, 3, data1);
        Matrix<Integer> matrix2 = new Matrix<>(3, 3, data2);
        matrix1.printMatrix();
        System.out.println("*");
        matrix2.printMatrix();
        System.out.println("=");
        Matrix <Integer> res = matrix1.multiply(matrix2);
        res.printMatrix();
        System.out.println();
        matrix1.printMatrix();
        System.out.println("+");
        res.printMatrix();
        System.out.println("=");
        matrix1.add(res).printMatrix();


    }

}
