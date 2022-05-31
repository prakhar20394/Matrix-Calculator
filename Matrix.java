package Assignment3;

import java.util.Iterator;
import java.util.Scanner;

public class Matrix {
    private static Scanner sc = new Scanner(System.in);
    private int columns;
    private int rows;
    private double matrix[][] = new double[rows][columns];

    public Matrix(int rows, int columns, double matrix[][]){
        this.rows = rows;
        this.columns = columns;
        this.matrix = matrix;
    }

    void print(){
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++){
                System.out.print(this.matrix[i][j] + "  ");
            } System.out.println();
        }
    }
    
    static void findByType() {
        System.out.println("Enter the type of matrix you want to find");
        System.out.println("1. Rectangular Matrix");
        System.out.println("2. Row Matrix");
        System.out.println("3. Column Matrix");
        System.out.println("4. Square Matrix");
        System.out.println("5. Symmetric Matrix"); 
        System.out.println("6. Skew-symmetric Matrix");
        System.out.println("7. Upper-triangular Matrix");
        System.out.println("8. Lower-triangular Matrix");
        System.out.println("9. Singular Matrix");
        System.out.println("10. Diagonal Matrix");
        System.out.println("11. Scalar Matrix");
        System.out.println("12. Identity Matrix");
        System.out.println("13. Singleton Matrix");
        System.out.println("14. Ones Matrix");
        System.out.println("15. Null Matrix");
        int choice = Integer.parseInt(sc.nextLine());
        // run the iterator and check if the matrix isinstance of the choice, then print the matrix
        Iterator<Matrix> it = MatrixCalculator.matrixArrayList.iterator();
        int counter = 0;
        while (it.hasNext()) {
            Matrix matrix = it.next();
            if (choice == 1 && matrix instanceof RectangleMatrix) {
                System.out.println("Matrix " + ++counter + ":");
                matrix.print();
            } else if (choice == 2 && matrix instanceof RowMatrix) {
                System.out.println("Matrix " + ++counter + ":");
                matrix.print();
            } else if (choice == 3 && matrix instanceof ColumnMatrix) {
                System.out.println("Matrix " + ++counter + ":");
                matrix.print();
            } else if (choice == 4 && matrix instanceof SquareMatrix) {
                System.out.println("Matrix " + ++counter + ":");
                matrix.print();
            } else if (choice == 5 && matrix instanceof SymmetricMatrix) {
                System.out.println("Matrix " + ++counter + ":");
                matrix.print();
            } else if (choice == 6 && matrix instanceof SkewSymmetricMatrix) {
                System.out.println("Matrix " + ++counter + ":");
                matrix.print();
            } else if (choice == 7 && matrix instanceof UpperTriangularMatrix) {
                System.out.println("Matrix " + ++counter + ":");
                matrix.print();
            } else if (choice == 8 && matrix instanceof LowerTriangularMatrix) {
                System.out.println("Matrix " + ++counter + ":");
                matrix.print();
            } else if (choice == 9 && matrix instanceof SingularMatrix) {
                System.out.println("Matrix " + ++counter + ":");
                matrix.print();
            } else if (choice == 10 && matrix instanceof DiagonalMatrix) {
                System.out.println("Matrix " + ++counter + ":");
                matrix.print();
            } else if (choice == 11 && matrix instanceof ScalarMatrix) {
                System.out.println("Matrix " + ++counter + ":");
                matrix.print();
            } else if (choice == 12 && matrix instanceof IdentityMatrix) {
                System.out.println("Matrix " + ++counter + ":");
                matrix.print();
            } else if (choice == 13 && matrix instanceof SingletonMatrix) {
                System.out.println("Matrix " + ++counter + ":");
                matrix.print();
            } else if (choice == 14 && matrix instanceof OnesMatrix) {
                System.out.println("Matrix " + ++counter + ":");
                matrix.print();
            } else if (choice == 15 && matrix instanceof NullMatrix) {
                System.out.println("Matrix " + ++counter + ":");
                matrix.print();
            } else {
                System.out.println("");
            }
        } System.out.println("Done!");

    } 
        
    static double[][] computeMean(Matrix matrixObject1, Matrix matrixObject2) {
        // add the 2 matrix and multiply by scaler 0.5 and return the 2d array
        int rows1 = matrixObject1.rows;
        int columns1 = matrixObject1.columns;
        int rows2 = matrixObject2.rows;
        int columns2 = matrixObject2.columns;
        double sum = 0;
        if (rows1 != rows2 || columns1 != columns2) {
            System.out.println("The matrices are not of same size");
            return null;
        }
        double meanMatrix[][] = new double[rows1][rows2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns1; j++) {
                sum = matrixObject1.matrix[i][j] + matrixObject2.matrix[i][j];
                meanMatrix[i][j] = sum * 0.5f;
            }
        }
        return meanMatrix;
    }
    
    static double[][] computeRowMean(Matrix matrixObject) {
        int rows = matrixObject.getRows();
        int columns = matrixObject.getColumns();
        double sum = 0;
        double rowMean[][] = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum += matrixObject.matrix[i][j];
            }
            rowMean[i][0] = sum / rows;
            sum = 0;
        }
        return rowMean;
    }
    
    static double[][] computeColumnMean(Matrix matrixObject) {
        int rows = matrixObject.getRows();
        int columns = matrixObject.getColumns();
        double sum = 0;
        double columnMean[][] = new double[rows][columns];
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                sum += matrixObject.matrix[j][i];
            }
            columnMean[0][i] = sum / columns;
            sum = 0;
        }
        return columnMean;
    }

    static double[][] transposeMatrix(Matrix matrixObject) {
        int rows = matrixObject.getRows();
        int columns = matrixObject.getColumns();
        double[][] transposeMatrix = new double[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposeMatrix[j][i] = matrixObject.matrix[i][j];
            }
        }
        return transposeMatrix;
    }

    static double[][] addTwoMatrix(Matrix matrixObject1, Matrix matrixObject2) {
        int row1 = matrixObject1.rows;
        int column1 = matrixObject1.columns;
        int row2 = matrixObject2.rows;
        int column2 = matrixObject2.columns;
        double[][] solution = new double[row1][column1];

        if (row1==row2){
            if (column1 == column2){
            for (int i = 0; i < row1; i++){
                for (int j = 0; j < column1; j++){
                    solution[i][j] = matrixObject1.getMatrix()[i][j] + matrixObject2.getMatrix()[i][j];
                }
            }
            } else {
                System.err.println("Columns not same!!");}
        
        } else {
            System.err.println("Rows not same!!");
        }
        return solution;
    }

    static double[][] subTwoMatrix(Matrix matrixObject1, Matrix matrixObject2) {
        int row1 = matrixObject1.rows;
        int column1 = matrixObject1.columns;
        int row2 = matrixObject2.rows;
        int column2 = matrixObject2.columns;
        double[][] solution = new double[row1][column1];

        if ((row1==row2) && (column1 == column2)){
            for (int i = 0; i < row1; i++){
                for (int j = 0; j < column1; j++){
                    solution[i][j] = matrixObject1.getMatrix()[i][j] - matrixObject2.getMatrix()[i][j];
                }
            }
        } else {
            System.err.println("Rows or Columns not same!!");
        }
        return solution;
    }

    static double[][] mulTwoMatrix(Matrix matrixObject1, Matrix matrixObject2) {
        int row1 = matrixObject1.rows;
        int column1 = matrixObject1.columns;
        int row2 = matrixObject2.rows;
        int column2 = matrixObject2.columns;
        double[][] solution = new double[row1][column2];

        if (row2 != column1){
            if (row1 == 1 && column1 == 1){
                double[][] sol = mulByScalar(matrixObject2, matrixObject1.getMatrix()[0][0]);
                return sol;
            } else {
                if (row2 == 1 && column2 == 1){
                    return mulByScalar(matrixObject1, matrixObject2.getMatrix()[0][0]);
            } else {
                System.err.println("Rows or Columns not same!!");
            }
            System.out.println("Cannot be multiplied!");
            return null;}
        } else {
            if (matrixObject1 instanceof NullMatrix || matrixObject2 instanceof NullMatrix) {
                System.out.println("Multiplication with Null gives Zero!");
                return null;
            }
            if (matrixObject1 instanceof IdentityMatrix || matrixObject2 instanceof IdentityMatrix) {
                return matrixObject1.getMatrix();
            }
            for (int i = 0; i < row1; i++){
                for (int j = 0; j < column2; j++){
                    for (int k = 0; k<row2; k++){
                        solution[i][j] = matrixObject1.getMatrix()[i][k] * matrixObject2.getMatrix()[k][j];
                    }
                }
            }  return solution;
        }

    }

    static double[][] elementWiseOperation(Matrix matrixObject1, Matrix matrixObject2){

        //1. Addition
        //2. Subtraction
        //3. Multiplication
        //4. division
        System.out.println("Enter the operation you want to perform");
        System.out.println("1 --> Addition");
        System.out.println("2 --> Subtraction");
        System.out.println("3 --> Multiplication");
        System.out.println("4 --> Division");
        int choice = Integer.parseInt(sc.nextLine());
        if (choice == 1){
            System.out.println("Addition of two matrix");
            return addTwoMatrix(matrixObject1, matrixObject2);
        } else if (choice == 2){
            System.out.println("Subtraction of two matrix");
            return subTwoMatrix(matrixObject1, matrixObject2);
        } else if (choice == 3){
            System.out.println("Element wise Multiplication of two matrix");
            return elementWiseMultiplication(matrixObject1, matrixObject2);
        } else if (choice == 4){
            System.out.println("Element wise Division of two matrix");
            double[][] output = elementWiseDivision(matrixObject1, matrixObject2);
            return output;
        } else {
            System.out.println("Invalid choice");
            return null;
        }

    }

    private static double[][] elementWiseDivision(Matrix matrixObject1, Matrix matrixObject2) {
        int row1 = matrixObject1.rows;
        int column1 = matrixObject1.columns;
        int row2 = matrixObject2.rows;
        int column2 = matrixObject2.columns;
        double[][] solution = new double[row1][column2];
        if ((row2 != row1)&&(column2 != column1)){
            System.out.println("Cannot be multiplied!!!");
            return null;
        } else {
            for (int i = 0; i < row1; i++){
                for (int j = 0; j < column1; j++){
                    solution[i][j] = matrixObject1.getMatrix()[i][j] / matrixObject2.getMatrix()[i][j];
                }
            }
        }  return solution;
    }

    private static double[][] elementWiseMultiplication(Matrix matrixObject1, Matrix matrixObject2) {
        int row1 = matrixObject1.rows;
        int column1 = matrixObject1.columns;
        int row2 = matrixObject2.rows;
        int column2 = matrixObject2.columns;
        double[][] solution = new double[row1][column2];
        if ((row2 != row1)&&(column2 != column1)){
            System.out.println("Cannot be multiplied!!!");
            return null;
        } else {
            for (int i = 0; i < row1; i++){
                for (int j = 0; j < column1; j++){
                    solution[i][j] = matrixObject1.getMatrix()[i][j] * matrixObject2.getMatrix()[i][j];
                }
            }
        }  return solution;

    }

    public int getColumns() {
        return this.columns;
    }

    public double[][] getMatrix() {
        return this.matrix;
    }

    public int getRows() {
        return this.rows;
    }

    public String getMatrixType(Matrix matrixObject) {
        if( matrixObject instanceof NullMatrix){
            return "Null Matrix";
        } else if (matrixObject instanceof SingletonMatrix){
            return "Singleton Matrix";
        } else if (matrixObject instanceof RowMatrix){
            return "Row Matrix";
        } else if (matrixObject instanceof ColumnMatrix){
            return "Column Matrix";
        } else if (matrixObject instanceof OnesMatrix){
            return "Ones Matrix";
        } else if (matrixObject instanceof IdentityMatrix){
            return "Identity Matrix";
        } else if (matrixObject instanceof ScalarMatrix){
            return "Scalar Matrix";
        } else if (matrixObject instanceof DiagonalMatrix){
            return "Diagonal Matrix";
        } else if (matrixObject instanceof SkewSymmetricMatrix){
            return "Skew Symmetric Matrix";
        } else if (matrixObject instanceof UpperTriangularMatrix){
            return "Upper Triangular Matrix";
        } else if (matrixObject instanceof LowerTriangularMatrix){
            return "Lower Triangular Matrix";
        } else if (matrixObject instanceof SingularMatrix){
            return "Singular Matrix";
        } else if (matrixObject instanceof SquareMatrix){
            return "Square Matrix";
        } else if (matrixObject instanceof RectangleMatrix){
            return "Rectangle Matrix";
        } else return null;
    }

    static double[][] mulByScalar(Matrix matrixObject, double scalar) {
        int row = matrixObject.getRows();
        int column = matrixObject.getColumns();
        double[][] solution = new double[row][column];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                solution[i][j] = matrixObject.getMatrix()[i][j] * scalar;
            }
        }
        return solution;
    }

    static double[][] divMatrixByScaler(Matrix matrixObject, double scalar) {
        int rows = matrixObject.getRows();
        int column = matrixObject.getColumns();
        double[][] solution = new double[rows][column];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < column; j++){
                solution[i][j] = matrixObject.getMatrix()[i][j] / scalar;
            }
        }
        return solution;
    }
}