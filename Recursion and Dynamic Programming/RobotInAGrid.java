import java.util.*;

public class RobotInAGrid {
    public static void main(String[] args){
        int[][] matrix = {{0,0,0},{0,2,0},{0,2,0}};
        ArrayList<DIRECTION> result = getPath(matrix,matrix.length-1,matrix[0].length-1,new ArrayList<>());
        Collections.reverse(result);
        System.out.println(result);
    }

    public static ArrayList<DIRECTION> getPath(int[][] maze, int row, int col, ArrayList<DIRECTION> directions){
        if(row==0&&col==0){
            return directions;
        }
        ArrayList<DIRECTION> right = new ArrayList<>();
        if(valid(maze,row,col-1)&&maze[row][col-1]!=2){
            ArrayList<DIRECTION> currDir = new ArrayList<>(directions);
            currDir.add(DIRECTION.RIGHT);
            right = getPath(maze,row,col-1,currDir);
        }
        ArrayList<DIRECTION> down = new ArrayList<>();
        if(valid(maze,row-1,col)&&maze[row-1][col]!=2){
            ArrayList<DIRECTION> currDir = new ArrayList<>(directions);
            currDir.add(DIRECTION.DOWN);
            down = getPath(maze,row-1,col,currDir);
        }
        if(right.isEmpty()){
            return down;
        }
        if(down.isEmpty()){
            return right;
        }
        return right.size()>down.size()?down:right;
    }

    public static boolean valid(int[][] maze, int row, int col){
        if(row<0||col<0||row>=maze.length||col>=maze[0].length){
            return false;
        }
        return true;
    }
}

enum DIRECTION {
    RIGHT, DOWN;
}