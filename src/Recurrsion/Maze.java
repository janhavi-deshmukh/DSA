package Recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze {

    public static void main(String[] args) {

        //printpaths("",3,3);
        //System.out.println(paths("",3,3));
        //System.out.println(allPathsincludingDia("",3,3));

        boolean[][] board={
            {true,true,true},
            {true,true,true},
            {true,true,true}
        };

        //System.out.println(mazeWithObstacles("",board,0,0));

        //this will give stack overflow error
        //System.out.println(mazeWithallDirectionBACKTRACK("",board,0,0));

        int[][] path=new int[board.length][board[0].length];
        printpathBACKTRACK("",board,0,0,path,1);
    }


    //to count number of possible ways to reach end point of a square maze
    //You can only move DOWN or RIGHT . Indexing is considered in decreasing manner, so when it will reach the end col or end row , there will be only 1 possible way so it will return 1
    static int countways(int row,int col){

        if(row==1 || col==1){
            return 1;
        }

        int left=countways(row-1,col);
        int right=countways(row,col-1);

        return left+right;
    }

    //printing all possible paths
    //in this case we will return only when the block index becomes (1,1) which is our destination index

    static void printpaths(String p,int row,int col){

        if(row==1 && col==1){
            System.out.println(p);
            return;
        }

        if(row>1){
            printpaths(p+'D',row-1,col);
        }

        if(col>1){
            printpaths(p+'R',row,col-1);
        }

    }

    static List<String> paths(String p,int row,int col){

        if(row==1 && col==1){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> ans=new ArrayList<>();

        if(row>1){
            ans.addAll(paths(p+'D',row-1,col));
        }

        if(col>1){
             ans.addAll(paths(p+'R',row,col-1));
        }


        return ans;

    }

    //for checking diagonal condition we can move diagonally only till row and col are not 1
    static List<String> allPathsincludingDia(String p,int row,int col){

        if(row==1 && col==1){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> ans=new ArrayList<>();

        if(row>1 && col>1){
            ans.addAll(allPathsincludingDia(p+'D',row-1,col-1));
        }
        if(row>1){
            ans.addAll(allPathsincludingDia(p+'V',row-1,col));
        }

        if(col>1){
            ans.addAll(allPathsincludingDia(p+'H',row,col-1));
        }


        return ans;

    }

    //this is 0-based indexing
    static List<String> mazeWithObstacles(String p,boolean[][] maze,int row,int col){

        if(row==maze.length-1 && col==maze[0].length-1){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> ans=new ArrayList<>();

        if(maze[row][col]==false){
            return ans;
        }

        if(row<maze.length-1){
            ans.addAll(mazeWithObstacles(p+'D',maze,row+1,col));
        }

        if(col<maze[0].length-1){
            ans.addAll(mazeWithObstacles(p+'R',maze,row,col+1));
        }
        return ans;
    }

    // this is to illustrate backtracking example. The function goal is to get all paths using all
    //directions up,right,down,left.
    static List<String> mazeWithallDirection(String p,boolean[][] maze,int row,int col){

        if(row==maze.length-1 && col==maze[0].length-1){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> ans=new ArrayList<>();

        if(maze[row][col]==false){
            return ans;
        }

        if(row<maze.length-1){
            ans.addAll(mazeWithallDirection(p+'D',maze,row+1,col));
        }

        if(col<maze[0].length-1){
            ans.addAll(mazeWithallDirection(p+'R',maze,row,col+1));
        }

        if(row>0){
            ans.addAll(mazeWithallDirection(p+'U',maze,row-1,col));
        }

        if(col>0){
            ans.addAll(mazeWithallDirection(p+'L',maze,row,col-1));
        }
        return ans;
    }

    //above gives stackoverflow error, so using backtracking approach that is initially mark the cell which are visited as false
    //then after the path or function is over and you are returing remeber to set the visited cells as true back to original condition


    static List<String> mazeWithallDirectionBACKTRACK(String p,boolean[][] maze,int row,int col){

        if(row==maze.length-1 && col==maze[0].length-1){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> ans=new ArrayList<>();

        if(maze[row][col]==false){
            return ans;
        }

        // i am considering this is in my path and visiting them so set them as false
        maze[row][col]=false;
        if(row<maze.length-1){
            ans.addAll(mazeWithallDirectionBACKTRACK(p+'D',maze,row+1,col));
        }

        if(col<maze[0].length-1){
            ans.addAll(mazeWithallDirectionBACKTRACK(p+'R',maze,row,col+1));
        }

        if(row>0){
            ans.addAll(mazeWithallDirectionBACKTRACK(p+'U',maze,row-1,col));
        }

        if(col>0){
            ans.addAll(mazeWithallDirectionBACKTRACK(p+'L',maze,row,col-1));
        }

        //this is where fun over so before returning set the visited path as not visited by making true
        maze[row][col]=true;
        return ans;
    }

    static void printpathBACKTRACK(String p,boolean[][] maze,int row,int col,int[][] path,int step){

        if(row==maze.length-1 && col==maze[0].length-1){

            path[row][col]=step;
            for(int[] arr:path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }



        if(maze[row][col]==false){
            return ;
        }

        // i am considering this is in my path and visiting them so set them as false
        maze[row][col]=false;
        path[row][col]=step;
        if(row<maze.length-1){
            printpathBACKTRACK(p+'D',maze,row+1,col,path,step+1);
        }

        if(col<maze[0].length-1){
            printpathBACKTRACK(p+'R',maze,row,col+1,path,step+1);
        }

        if(row>0){
            printpathBACKTRACK(p+'U',maze,row-1,col,path,step+1);
        }

        if(col>0){
            printpathBACKTRACK(p+'L',maze,row,col-1,path,step+1);
        }

        //this is where fun over so before returning set the visited path as not visited by making true
        maze[row][col]=true;
        path[row][col]=0;
        return ;
    }


}
