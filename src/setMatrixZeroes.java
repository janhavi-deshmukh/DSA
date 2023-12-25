public class setMatrixZeroes {

    //bruteforce create two arraylist rowList and columnList and get the indices of row and column in the list by travesring the matrix
    //then for each index in rowList and index in columnList set matrix[k][i] and matrix[i][k] to 0

    //optimized way by O(1) SC consider the column and row array in matrix itself. set col0=1 for overlapping element.
    //now traverse the matrix and set row or column to 0 if matrix[i][j]==0 check differently for j!=0 column and set col0=0 if j=0
    //traverse the inner forming matrix from 1 to length and if the marked row or column is 0 set the element to 0
    public static void setZero(int[][] matrix){

        //int column=matrix[0][..]
        //int row=matrix[...][0]
        int col0=1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){

                if(matrix[i][j]==0){

                    matrix[i][0]=0;//mark the row

                    if(j!=0){
                        matrix[0][j]=0;//mark the column
                    }
                    else{
                        col0=0;
                    }
                }

            }
        }

        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){

                if(matrix[i][j]!=0){
                    if(matrix[i][0]==0 || matrix[0][j]==0){
                        matrix[i][j]=0;
                    }

                }

            }
        }
        if(matrix[0][0]==0){
            for(int i=0;i<matrix.length;i++){
                matrix[0][i]=0;
            }
        }
        if(col0==0){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }


    }

    public static void main(String[] args){
        int[][] matrix={
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        setZero(matrix);

        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }


}
