package Assignment3;

public class SquareMatrix extends Matrix{

public SquareMatrix(int rows, int columns, double[][] matrix) {
        super(rows, columns, matrix);
    }

static double[][] addAandATranspose(Matrix matrixObject) {
        int rows = matrixObject.getRows();
        int column = matrixObject.getColumns();
        double[][] solution = new double[rows][column];
        double transpose[][] = transposeMatrix(matrixObject);
        if (matrixObject instanceof SquareMatrix){
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < column; j++){
                    solution[i][j] = matrixObject.getMatrix()[i][j] + transpose[i][j];
                }
            }
        } else {
            System.out.println("Matrix is not square");
        }
        return solution;
    }

static double determinant(Matrix matrixObject) {
        int rows = matrixObject.getRows();
        int columns = matrixObject.getColumns();
        double determinant = 0;
        if (rows != columns){
            return -9999;
        }
        if (rows == 1) {
            determinant = matrixObject.getMatrix()[0][0];
        } else if (rows == 2) {
            determinant = matrixObject.getMatrix()[0][0] * matrixObject.getMatrix()[1][1] - matrixObject.getMatrix()[0][1] * matrixObject.getMatrix()[1][0];
        } else {
            for (int k = 0; k < rows; k++) {
                double[][] temp = new double[rows - 1][columns - 1];
                for (int i = 1; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        if (j < k) {
                            temp[i - 1][j] = matrixObject.getMatrix()[i][j];
                        } else if (j > k) {
                            temp[i - 1][j - 1] = matrixObject.getMatrix()[i][j];
                        }
                    }
                }
                determinant += Math.pow(-1, k) * matrixObject.getMatrix()[0][k] * determinant(new Matrix(rows - 1, columns - 1, temp));
            }
        }
        return determinant;
    }

static void computeEigen(Matrix matrixObject) {
    double[] eigenValues = getEigenValues(matrixObject);
    System.out.println("Eigen values are: ");
    for (int i = 0; i < eigenValues.length; i++) {
        System.out.println(eigenValues[i]);
    }
    double[][] eigenVectors = getEigenVectors(matrixObject);
    System.out.println("Eigen vectors are: ");
    for (int i = 0; i < eigenVectors.length; i++) {
        for (int j = 0; j < eigenVectors[i].length; j++) {
            System.out.print(eigenVectors[i][j] + " ");
        }
        System.out.println();
    }

}

private static double[][] getEigenVectors(Matrix matrixObject) {
    double eigenValues[] = getEigenValues(matrixObject);

    double eigenVectors0[][] = {{1}, {0}};
    double eigenVectors1[][] = {{1}, {0}};

    if ((matrixObject.getRows() == 2)&& matrixObject.getColumns() == 2) {
        if (matrixObject.getMatrix()[0][1] == 0){
            eigenVectors0[1][0] = eigenValues[0] - matrixObject.getMatrix()[0][0] / matrixObject.getMatrix()[0][1];
        } else {
            eigenVectors0[1][0] = matrixObject.getMatrix()[0][1] / (eigenValues[0] - matrixObject.getMatrix()[1][1]);
        }
        if (matrixObject.getMatrix()[1][0] == 0){
            eigenVectors1[1][0] = eigenValues[1] - matrixObject.getMatrix()[0][0] / matrixObject.getMatrix()[0][1];
        } else {
            eigenVectors1[1][0] = matrixObject.getMatrix()[0][1] / (eigenValues[0] - matrixObject.getMatrix()[1][1]);
        }
    }
    double[][] array = {{eigenVectors0[0][0], eigenVectors1[0][0]}, {eigenVectors0[1][0], eigenVectors1[1][0]}};
    return array;
    
}

private static double getTrace(Matrix matrixObject) {
    double trace = 0;
    for (int i = 0; i < matrixObject.getRows(); i++){
        trace += matrixObject.getMatrix()[i][i];
    }
    return trace;
}

private static double[] getEigenValues(Matrix matrixObject) {
    if (matrixObject instanceof SquareMatrix){
        int rows = matrixObject.getRows();
        if (rows == 2){
            double EigenValue[] = new double[2];
            double trace = getTrace(matrixObject);
            double determinant = determinant(matrixObject);
            EigenValue[0] = (trace + Math.sqrt(Math.pow(trace, 2) - 4 * determinant))/2;
            EigenValue[1] = (trace - Math.sqrt(Math.pow(trace, 2) - 4 * determinant))/2;
            return EigenValue;
        } else {
            System.err.println("Only 2x2 matrix is supported");
        }
    } else {
        System.err.println("Matrix is not square");
    }    
    return null;
}

static double[][] solveLinearEquation(Matrix matrixObject, Matrix matrixObject2) {
    double[][] solution = new double[matrixObject.getRows()][matrixObject2.getColumns()];
    if (determinant(matrixObject) == 0) {
        System.err.println("Matrix has no unique solution, Exit code = 0");
        return null;
    } else {
        double[][] inv = inverseMatrix(matrixObject);
        Matrix inverse = new SquareMatrix(matrixObject.getRows(), matrixObject.getColumns(), inv);
        solution = mulTwoMatrix(inverse, matrixObject2);
    } 
    return solution;
}

static double[][] divideTwoVector(Matrix matrixObject, Matrix matrixObject2) {
    int rows1 = matrixObject.getRows();
    int column1 = matrixObject.getColumns();
    int rows2 = matrixObject2.getRows();
    int column2 = matrixObject2.getColumns();
    if ((rows1 != rows2 || column1 != column2) || (rows1 != column1 || rows2 != column2)){
        System.err.println("Matrix is not square, Exit code = 0");
        return null;
    }

    double[][] inverse = inverseMatrix(matrixObject2);
    Matrix inverseMatrix = new Matrix(rows2, column2, inverse);
    double[][] solution = mulTwoMatrix(inverseMatrix, matrixObject);
    return solution;
}

static double[][] inverseMatrix(Matrix matrixObject){
    double determinant = determinant(matrixObject);
    if (determinant == 0){
        System.out.println("The matrix is not invertible");
        return null;
    }
    double[][] inverse = new double[matrixObject.getRows()][matrixObject.getColumns()];
    for (int i = 0; i< matrixObject.getRows(); i++){
        for (int j = 0; j< matrixObject.getColumns(); j++){
            //System.out.println("I got " + matrixObject.getMatrix()[i][j]);
            inverse[i][j] = Math.pow(-1, i+j)*determinant(minorMatrix(matrixObject, j, i))/determinant;
        }
    }
    // for (int i = 0; i< inverse.length; i++){
    //     for (int j = 0; j< inverse.length; j++){
    //         inverse[i][j] = inverse[j][i]/determinant;
    //     }
    // }
    return inverse; 
}

private static Matrix minorMatrix(Matrix matrixObject, int row, int column) {
        int rows = matrixObject.getRows();
        int columns = matrixObject.getColumns();
        double[][] solution = new double[rows - 1][columns - 1];
        int rCounter = 0;
        int cCounter = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if ((i != row) && (j != column)) {
                    solution[rCounter][cCounter] = matrixObject.getMatrix()[i][j];
                    cCounter++;
                    if (cCounter == columns - 1) {
                        cCounter = 0;
                        rCounter++;
                    } 
                } 
            }
        }
        SquareMatrix returnValue = new SquareMatrix(rows - 1, columns - 1, solution);
        // System.out.println("MINOR MATRIX:");
        // for (int i=0; i<solution.length; i++)
        //     for (int j=0; j<solution[0].length; i++)
        //         System.out.print(solution[0][0] + " ");
        return returnValue;
    }

static boolean isSquareMatrix(Matrix matrixObject) {
        int rows = matrixObject.getRows();
        int column = matrixObject.getColumns();
        if (rows == column){
            return true;
        } else {
            return false;
        }
    }

}