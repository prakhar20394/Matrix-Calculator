package Assignment3;

import java.util.*;
    
public class MatrixCalculator{
    private static int choice;
    static ArrayList<Matrix> matrixArrayList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
public static void main(String[] args){
    System.out.print("======Welcome to your Matrix Calculator=======");
    
    menu();
    
    while (choice != 17){
        if (choice == 1){
            takeMatrixAsInput();
            menu();
        } else if (choice == 2){
            changeElementsOfMatrix();
            menu();
        } else if (choice == 3){
            displayLabelofMatrix();
            System.out.print("Enter the Index of 1st Matrix you wish to see labels of: ");
            int matrixLabel = Integer.parseInt(sc.nextLine());
            printLabel(matrixArrayList.get(matrixLabel).getMatrix());
            menu();
        } else if(choice == 4){
            displayLabelofMatrix();
            System.out.print("Enter the Index of 1st Matrix you wish to add: ");
            int matrixLabel1 = Integer.parseInt(sc.nextLine());
            System.out.print("Enter the Index of 2nd Matrix you wish to add: ");
            int matrixLabel2 = Integer.parseInt(sc.nextLine());
            double[][] output = Matrix.addTwoMatrix(matrixArrayList.get(matrixLabel1), matrixArrayList.get(matrixLabel2));
            try { printMatrix(output);} catch (Exception e){
                System.out.print("Error");
            }
            menu();
        } else if(choice == 5){
            displayLabelofMatrix();
            System.out.print("Enter the Index of 1st Matrix you wish to Subtract from: ");
            int matrixLabel1 = Integer.parseInt(sc.nextLine());
            System.out.print("Enter the Index of 2nd Matrix you wish to Subtract: ");
            int matrixLabel2 = Integer.parseInt(sc.nextLine());
            double[][] output = Matrix.subTwoMatrix(matrixArrayList.get(matrixLabel1), matrixArrayList.get(matrixLabel2));
            try { printMatrix(output);} catch (Exception e){
                System.out.print("Error");
            }
            menu();
        } else if (choice == 6){
            displayLabelofMatrix();
            System.out.print("Enter the Index of 1st Matrix you wish to Multiply: ");
            int matrixLabel1 = Integer.parseInt(sc.nextLine());
            System.out.print("Enter the Index of 2nd Matrix you wish to Multiply: ");
            int matrixLabel2 = Integer.parseInt(sc.nextLine());
            double[][] output = Matrix.mulTwoMatrix(matrixArrayList.get(matrixLabel1), matrixArrayList.get(matrixLabel2));
            try { printMatrix(output);} catch (Exception e){
                System.out.print("Error");
            }
            menu();
        } else if (choice == 7){
            displayLabelofMatrix();
            System.out.print("Enter the Index of 1st Matrix you wish to Divide: ");
            int matrixLabel1 = Integer.parseInt(sc.nextLine());
            System.out.print("Enter the Index of 2nd Matrix you wish to Divide: ");
            int matrixLabel2 = Integer.parseInt(sc.nextLine());
            if ((matrixArrayList.get(matrixLabel1).getColumns() == 1) && (matrixArrayList.get(matrixLabel1).getRows() == 1)){
                double[][] output = Matrix.divMatrixByScaler(matrixArrayList.get(matrixLabel1), matrixArrayList.get(matrixLabel2).getMatrix()[0][0]);
                printMatrix(output);
            } else if ((matrixArrayList.get(matrixLabel2).getRows() == 1) && (matrixArrayList.get(matrixLabel2).getColumns() == 1)){
                double[][] output = Matrix.divMatrixByScaler(matrixArrayList.get(matrixLabel1), matrixArrayList.get(matrixLabel2).getMatrix()[0][0]);
                printMatrix(output);
            } else if (matrixArrayList.get(matrixLabel1).getRows() == matrixArrayList.get(matrixLabel2).getRows() && matrixArrayList.get(matrixLabel1).getColumns() == matrixArrayList.get(matrixLabel2).getColumns()){
                double[][] output = SquareMatrix.divideTwoVector(matrixArrayList.get(matrixLabel1), matrixArrayList.get(matrixLabel2));
                printMatrix(output);
            } else {
                System.out.print("The two matrices are not of the same size");
            }
            menu();

        } else if (choice == 8){
            displayLabelofMatrix();
            System.out.print("Enter the Index of 1st Matrix you wish to perform element wise operations on: ");
            int matrixLabel1 = Integer.parseInt(sc.nextLine());
            System.out.print("Enter the Index of 2nd Matrix you wish to perform element wise operations on: ");
            int matrixLabel2 = Integer.parseInt(sc.nextLine());
            double[][] output = Matrix.elementWiseOperation(matrixArrayList.get(matrixLabel1), matrixArrayList.get(matrixLabel2));
            printMatrix(output);
            try { printMatrix(output);} catch (Exception e){
                System.out.print("rror");
            }
            menu();
        } else if (choice == 9){
            displayLabelofMatrix();
            System.out.print("Enter the Index of Matrix you wish to transpose: ");
            int matrixLabel = Integer.parseInt(sc.nextLine());
            double[][] output = Matrix.transposeMatrix(matrixArrayList.get(matrixLabel));
            try { printMatrix(output);} catch (Exception e){
                System.out.print("Error");
            }
            menu();
        }else if (choice == 10){
            displayLabelofMatrix();
            System.out.print("Enter the Index of Matrix you wish to find inverse for: ");
            int matrixLabel = Integer.parseInt(sc.nextLine());
            double[][] output = SquareMatrix.inverseMatrix(matrixArrayList.get(matrixLabel));
            try { printMatrix(output);} catch (Exception e){
                System.out.print("Error");
            }
            menu();
        }else if (choice == 11){
            System.out.println("1 --> Mean of 2 matrix");
            System.out.println("2 --> Row mean of matrix");
            System.out.println("3 --> Column mean of matrix");
            System.out.print("Enter your choice: ");
            int choice2 = Integer.parseInt(sc.nextLine());
            if (choice2 == 1){
                displayLabelofMatrix();
                System.out.print("Enter the Index of 1st Matrix you wish to find mean of: ");
                int matrixLabel1 = Integer.parseInt(sc.nextLine());
                System.out.print("Enter the Index of 2nd Matrix you wish to find mean of: ");
                int matrixLabel2 = Integer.parseInt(sc.nextLine());
                double[][] output = Matrix.computeMean(matrixArrayList.get(matrixLabel1), matrixArrayList.get(matrixLabel2));
                try { printMatrix(output);} catch (Exception e){
                    System.out.print("Error");}
            } else if (choice2 == 2){
                    displayLabelofMatrix();
                    System.out.print("Enter the Index of Matrix you wish to find row mean of: ");
                    int matrixLabel = Integer.parseInt(sc.nextLine());
                    double[][] output = Matrix.computeRowMean(matrixArrayList.get(matrixLabel));
                    try { printMatrix(output);} catch (Exception e){
                        System.out.print("Error");
                    }
            } else if (choice2 == 3){
                    displayLabelofMatrix();
                    System.out.print("Enter the Index of Matrix you wish to find column mean of: ");
                    int matrixLabel = Integer.parseInt(sc.nextLine());
                    double[][] output = Matrix.computeColumnMean(matrixArrayList.get(matrixLabel));
                    try { printMatrix(output);} catch (Exception e){
                        System.out.print("Error");}
            } menu();
        } else if (choice == 12){
            displayLabelofMatrix();
            System.out.print("Enter the Index of Matrix you wish to compute determinant of: ");
            int matrixLabel = Integer.parseInt(sc.nextLine());
            if (isSquareMatrix(matrixArrayList.get(matrixLabel).getMatrix())){
                double output = SquareMatrix.determinant(matrixArrayList.get(matrixLabel));
                System.out.print("The determinant of the matrix is: " + output);
            } else {
                System.out.print("The matrix is not a square matrix");
            }
            menu();
        }else if (choice == 13){
            MatrixCalculator.displayLabelofMatrix();
            System.out.print("Enter the Index of Matrix you wish to operate on: ");
            int matrixLabel = Integer.parseInt(sc.nextLine());
            double[][] output = SquareMatrix.addAandATranspose(matrixArrayList.get(matrixLabel));
            try { printMatrix(output);} catch (Exception e){
                System.out.print("Error");
            }
            menu();
        }else if (choice == 14){
            displayLabelofMatrix();
            System.out.print("Enter the Index of Matrix you wish to find EigenValue of: ");
            int matrixLabel = Integer.parseInt(sc.nextLine());
            SquareMatrix.computeEigen(matrixArrayList.get(matrixLabel));
            menu();
        } else if (choice == 15){
            displayLabelofMatrix();
            System.out.print("Enter the Index of Matrix you wish to solve equation for: ");
            int matrixLabel = Integer.parseInt(sc.nextLine());
            System.out.println("Enter index of solution column: ");
            int matrixLabel2 = Integer.parseInt(sc.nextLine());
            if (matrixArrayList.get(matrixLabel2).getColumns() != 1) {
                System.out.println("Enter index of solution column: ");
                matrixLabel2 = Integer.parseInt(sc.nextLine());
            }
            double[][] output = SquareMatrix.solveLinearEquation(matrixArrayList.get(matrixLabel), matrixArrayList.get(matrixLabel2));
            try { printMatrix(output);} catch (Exception e){
                System.out.print("Error");
            }
            menu();
        }else if (choice == 16){
            Matrix.findByType();
            menu();
        }else if (choice == 17){
            break;
        } else if (choice == 18){
            displayLabelofMatrix();
            menu();
        } else {
            System.out.print("Enter the correct option");
        }
    } System.out.println("Thank you for using!");
}

private static void displayLabelofMatrix() {
    Iterator<Matrix> itr = matrixArrayList.iterator();
    System.out.println("Elements of the matrix are: ");
    int counter = 0;
    while (itr.hasNext()) {
        Matrix matrix = itr.next();
        // save the kind of matrix as string in a variable
        String matrixType = matrix.getMatrixType(matrix);
        System.out.println("Matrix " + counter + " is of type: " + matrixType + ":");
        matrix.print();
        counter ++;
    }
}

private static void changeElementsOfMatrix() {
    int column;
    int row;
    int matrixLabel;
    double value;

    displayLabelofMatrix();
    System.out.print("Enter the Index of Matrix you wish to change: ");
    matrixLabel = Integer.parseInt(sc.nextLine());
    
    System.out.print("Enter the Row number you wish to change: ");
    row = Integer.parseInt(sc.nextLine());
    System.out.print("Enter the Column number you wish to change: ");
    column = Integer.parseInt(sc.nextLine());

    System.out.print("Enter the new value: ");
    value = Integer.parseInt(sc.nextLine());
    // deep copy matrix
    double[][] temp = new double[matrixArrayList.get(matrixLabel).getMatrix().length][matrixArrayList.get(matrixLabel).getMatrix()[0].length];
    for (int i = 0; i < matrixArrayList.get(matrixLabel).getMatrix().length; i++) {
        for (int j = 0; j < matrixArrayList.get(matrixLabel).getMatrix()[0].length; j++) {
            temp[i][j] = matrixArrayList.get(matrixLabel).getMatrix()[i][j];
        }
    }

    //double[][] temp = matrixArrayList.get(matrixLabel).getMatrix().clone();
    temp[row][column] = value;
    
    if (checkType(temp).equals(checkType(matrixArrayList.get(matrixLabel).getMatrix()))) {
        System.out.println(checkType(matrixArrayList.get(matrixLabel).getMatrix()) + " Matrix is changed" + " to " + checkType(temp));
        matrixArrayList.get(matrixLabel).getMatrix()[row][column] = value;
        System.out.println("Done");
    } else {
        System.out.println("You cannot change the elements of a matrix to different type");
    }
}

private static String checkType(double[][] matrix) {
    if (isNullMatrix(matrix)){
        return "Null Matrix";
    } else if (isSingletonMatrix(matrix)){
        return "Singleton Matrix";
    } else if (isSquareMatrix(matrix)){
        if (isIdentityMatrix(matrix)){
            return "Identity Matrix";
        } else if (isScalarMatrix(matrix)){
            return "Scalar Matrix";
        } else if (isDiagonalMatrix(matrix)){
            return "Diagonal Matrix";
        } else if (isUpperTriangularMatrix(matrix)){
            return "Upper Triangular Matrix";
        } else if (isLowerTriangularMatrix(matrix)){
            return "Lower Triangular Matrix";
        } else if (isSingularMatrix(matrix)){
            return "Singular Matrix";
        } else if (isSkewSymmetricMatrix(matrix)){
            return "Skew Symmetric Matrix";
        } else {
            return "Square Matrix";
        }
    } else if (isRectangularMatrix(matrix)){
        if (isRowMatrix(matrix)){
            return "Row Matrix";
        } else if (isColumnMatrix(matrix)){
            return "Column Matrix";
        } else if (isOnesMatrix(matrix)){
            return "Ones Matrix";
        } else {
            return "Rectangle Matrix";
        } 
    }
    return null;
}

private static void printLabel(double[][] matrix) {
    if (isNullMatrix(matrix)){
        System.out.println("Null Matrix");
    }
    if (isSingletonMatrix(matrix)){
        System.out.println("Singleton Matrix");
    }
    if (isSquareMatrix(matrix)){
        System.out.println("Square Matrix");
    }
    if (isSkewSymmetricMatrix(matrix)){
        System.out.println("Skew Symmetric Matrix");
    }
    if (isSymmetricMatrix(matrix)){
        System.out.println("Symmetric Matrix");
    }
    if (isIdentityMatrix(matrix)){
        System.out.println("Identity Matrix");
    }
    if (isScalarMatrix(matrix)){
        System.out.println("Scalar Matrix");
    }
    if (isDiagonalMatrix(matrix)){
        System.out.println("Diagonal Matrix");
    }
    if (isUpperTriangularMatrix(matrix)){
            System.out.println("Upper Triangular Matrix");
    }
    if (isLowerTriangularMatrix(matrix)){
            System.out.println("Lower Triangular Matrix");
    }
    if (isSingularMatrix(matrix)){
        System.out.println("Singular Matrix");
    }
    if (isRectangularMatrix(matrix)){
        System.out.println("Rectangle Matrix");
    }
    if (isRowMatrix(matrix)){
        System.out.println("Row Matrix");
    }
    if (isColumnMatrix(matrix)){
        System.out.println("Column Matrix");
    }
    if (isOnesMatrix(matrix)){
        System.out.println("Ones Matrix");
    }
}

private static void takeMatrixAsInput() {
    int columns;
    int rows;
    System.out.print("Enter the number of Rows: ");
    rows = Integer.parseInt(sc.nextLine());
    System.out.print("Enter the number of Columns: ");
    columns = Integer.parseInt(sc.nextLine());

    double matrix[][] = new double[rows][columns];
    if (rows == 0 || columns == 0){
        System.out.println("Matrix cannot be empty");
        return;
    }
    System.out.println("Enter the elements of the matrix");
    for (int i = 0; i < rows; i++){
        for (int j = 0; j < columns; j++){
            matrix[i][j] = Integer.parseInt(sc.nextLine());
        }
    }
    System.out.println("Please wait, setting the type of matrix ");
    setType(rows, columns, matrix);
        
}

private static void setType(int rows, int columns, double[][] matrix) {
    if (isNullMatrix(matrix)){
        Matrix matrixObject = new NullMatrix(rows, columns, matrix);
        matrixArrayList.add(matrixObject);
        System.out.println("Null Matrix added successfully");
    } else if (isSingletonMatrix(matrix)){
        Matrix matrixObject = new SingletonMatrix(rows, columns, matrix);
        matrixArrayList.add(matrixObject);
        System.out.println("Singleton Matrix added successfully");
    } else if (isSquareMatrix(matrix)){
        if (isSkewSymmetricMatrix(matrix)){
            Matrix matrixObject = new SkewSymmetricMatrix(rows, columns, matrix);
            matrixArrayList.add(matrixObject);
            System.out.println("Skew Symmetric Matrix added successfully");
        }else if (isSymmetricMatrix(matrix)){
                if (isIdentityMatrix(matrix)){
                    Matrix matrixObject = new IdentityMatrix(rows, columns, matrix);
                    matrixArrayList.add(matrixObject);
                    System.out.println("Identity Matrix added successfully");
                } else if (isScalarMatrix(matrix)){
                    Matrix matrixObject = new ScalarMatrix(rows, columns, matrix);
                    matrixArrayList.add(matrixObject);
                    System.out.println("Scalar Matrix added successfully");
                } else if (isDiagonalMatrix(matrix)){
                    Matrix matrixObject = new DiagonalMatrix(rows, columns, matrix);
                    matrixArrayList.add(matrixObject);
                    System.out.println("Diagonal Matrix added successfully");
                } else { System.out.println("Bug here1");} 
        } else if (isUpperTriangularMatrix(matrix)){
            Matrix matrixObject = new UpperTriangularMatrix(rows, columns, matrix);
            matrixArrayList.add(matrixObject);
            System.out.println("Upper Triangular Matrix added successfully");
        } else if (isLowerTriangularMatrix(matrix)){
            Matrix matrixObject = new LowerTriangularMatrix(rows, columns, matrix);
            matrixArrayList.add(matrixObject);
            System.out.println("Lower Triangular Matrix added successfully");
        } else if (isSingularMatrix(matrix)){
            Matrix matrixObject = new SingularMatrix(rows, columns, matrix);
            matrixArrayList.add(matrixObject);
            System.out.println("Singular Matrix added successfully");
        } else {
            Matrix matrixObject = new SquareMatrix(rows, columns, matrix);
            matrixArrayList.add(matrixObject);
            System.out.println("Square Matrix added successfully");
        }
    } else if (isRectangularMatrix(matrix)){
        if (isRowMatrix(matrix)){
            Matrix matrixObject = new RowMatrix(rows, columns, matrix);
            matrixArrayList.add(matrixObject);
            System.out.println("Row Matrix added successfully");
        } else if (isColumnMatrix(matrix)){
            Matrix matrixObject = new ColumnMatrix(rows, columns, matrix);
            matrixArrayList.add(matrixObject);
            System.out.println("Column Matrix added successfully");
        } else if (isOnesMatrix(matrix)){
            Matrix matrixObject = new OnesMatrix(rows, columns, matrix);
            matrixArrayList.add(matrixObject);
            System.out.println("Ones Matrix added successfully");
        } else {
            Matrix matrixObject = new RectangleMatrix(rows, columns, matrix);
            matrixArrayList.add(matrixObject);
            System.out.println("Rectangle Matrix added successfully");
        }
    } else {
        System.err.println("Invalid Matrix");};
}

private static int menu(){
    System.out.print("\n=====================================");
    System.out.print("\n=================MENU================\n");
    System.out.print("1 --> Enter a new Matrix\n");
    System.out.print("2 --> Change elements of a Matrix\n");
    System.out.print("3 --> Display labels of a Matrix\n");
    System.out.print("4 --> Perform: Addition of Matrix\n");
    System.out.print("5 --> Perform: Subtraction of Matrix\n");
    System.out.print("6 --> Perform: Multiplication of Matrix\n");
    System.out.print("7 --> Perform: Division of Matrix\n");
    System.out.print("8 --> Perform element wise operation\n");
    System.out.print("9 --> Transpose Matrix\n");
    System.out.print("10 --> Inverse Matrix\n");
    System.out.print("11 --> Compute Mean\n");
    System.out.print("12 --> Compute Determinants\n");
    System.out.print("13 --> Compute A + A^T\n");
    System.out.print("14 --> Compute EigenVectors and Values\n");
    System.out.print("15 --> Solve a linear equation\n");
    System.out.print("16 --> Find by type\n");
    System.out.print("17 --> Exit\n");
    System.out.println("18 --> Display all matrix");
    System.out.print("=====================================\n");
    System.out.print("\nEnter your choice to go ahead: ");
    choice = Integer.parseInt(sc.nextLine());
        return choice;

}



private static boolean isDiagonalMatrix(double[][] matrix) {
    if(isSquareMatrix(matrix)){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (i != j && matrix[i][j] != 0){
                    return false;
                }
            }
        }
    } else {
        return false;
    }
    return true;
}

private static boolean isIdentityMatrix(double[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            if (i == j && matrix[i][j] != 1) {
                return false;
            } else if (i != j && matrix[i][j] != 0) {
                return false;
            }
        }
    }
    return true;
}

private static boolean isUpperTriangularMatrix(double[][] matrix) {
    if (isSquareMatrix(matrix)){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (i > j && matrix[i][j] != 0){
                    return false;
                }
            }
        }
    } else {
        return false;
    }
    return true;
}
 
private static boolean isLowerTriangularMatrix(double[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            if (i < j && matrix[i][j] != 0) {
                return false;
            }
        }
    }
    return true;
}

private static boolean isSymmetricMatrix(double[][] matrix) {
    if (isSquareMatrix(matrix)) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
    } else {
        return false;
    }
    return true;
}

private static boolean isSkewSymmetricMatrix(double[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            if (i != j && matrix[i][j] != -matrix[j][i]) {
                return false;
            } else if (i == j && matrix[i][j] != 0) {
                return false;
            }
        }
    }
    return true;
}

private static boolean isNullMatrix(double[][] matrix) { 
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] != 0) {
                return false;
            }
        }
    }
    return true;
}

private static boolean isRowMatrix(double[][] matrix) {
    if (matrix.length == 1) {
        return true;
    } else {
        return false;
    }
}

private static boolean isColumnMatrix(double[][] matrix) {
    if (matrix[0].length == 1) {
        return true;
    } else {
        return false;
    }
}

private static boolean isRectangularMatrix(double[][] matrix) {
    if (matrix.length != matrix[0].length) {
        return true;
    } else {
        return false;
    }
}

private static boolean isOnesMatrix(double[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] != 1) {
                return false;
            }
        }
    }
    return true;
}

private static boolean isSingularMatrix(double[][] matrix) {
    //System.out.println("error 1");
    Matrix mat = new SquareMatrix(matrix.length, matrix[0].length, matrix);
    //System.out.println("error 2");
    if(SquareMatrix.determinant(mat) == 0){
        //System.out.println("error 3");
        return true;
    } else {
        //System.out.println("error 4");
        return false;
    }
}

private static boolean isSingletonMatrix(double[][] matrix) {
    if (matrix.length == 1 && matrix[0].length == 1) {
        return true;
    } else {
        return false;
    }
}

private static boolean isScalarMatrix(double[][] matrix) {
    double k;
    k = matrix[0][0];
    if (isDiagonalMatrix(matrix)) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != k) {
                    return false;
                }
            }
        } return true;
    } else { return false; }
}
  
private static boolean isSquareMatrix(double[][] matrix) {
    if (matrix.length == matrix[0].length) {
        return true;
    } else {
        return false;
    }
}

public static void printMatrix(double[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
    }
}

}