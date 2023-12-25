public class diagonalSum {
    public static int diagonalSum(int[][] mat) {

        int sum=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(i==j){
                    sum+=mat[i][j];
                }
            }
        }
        mat=reverseMatrix(mat);

        int sum1=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(i==j){
                    sum1+=mat[i][j];
                }
            }
        }

        return sum+sum1;
    }

    static int[][] reverseMatrix(int[][] mat){
        for(int i=0;i<mat.length;i++){

            int start=0;
            int end=mat[i].length-1;
            while(start<=end){
                int temp=mat[i][start];
                mat[i][start]=mat[i][end];
                mat[i][end]=temp;
                start++;
                end--;
            }
        }
        return mat;
    }

    public static void main(String[] args){

        int[][] mat={
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1}
        };

        int result=diagonalSum(mat);
        System.out.println(result);
    }


}
