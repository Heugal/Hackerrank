package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// Solution for: https://www.hackerrank.com/challenges/count-luck
public class Hackerrank {
    public static int row, col, paths;
    
    public static class Node{
        private int posX, posY;
        private char value;
        private List<Node> children;
        
        public Node(int posX, int posY, char val){
            this.posX = posX;
            this.posY = posY;
            this.value = val;
            this.children = new ArrayList<Node>();
        }
        
        public void addChild(Node child){
            //Node child = new Node(m.posX, m.posY, m.value);
            this.children.add(child);
        }
       
        public int getPosX(){
            return this.posX;
        }
        
        public int getPosY(){
            return this.posY;
        }
        
        public boolean findPath(char[][] map){
            boolean isPath = false;
            if (this.value == '*'){
                return true;
            }
            else{
                for (Node child : this.children){
                    isPath = child.findPath(map);
                    if ((isPath == true) && (this.children.size() > 1)){
                        paths++;
                        break;
                    }
                }
            }
            if (isPath == true){
                return true;
            }
            
            return false;
        }
        
        public void processMap(char[][] map){
            Node child;
            int aPosX = this.getPosX();
            int aPosY = this.getPosY();
            
            if (this.value == '*'){
                return;
            }
            
            // go up
            if (aPosX > 0){
                if (map[aPosX-1][aPosY] != 'X'){
                    map[aPosX][aPosY] = 'X';
                    child = new Node(aPosX-1, aPosY, map[aPosX-1][aPosY]);
                    child.processMap(map);
                    this.addChild(child);
                }
            }
            // go left
            if (aPosY > 0){
                if (map[aPosX][aPosY-1] != 'X'){
                    map[aPosX][aPosY] = 'X';
                    child = new Node(aPosX, aPosY-1, map[aPosX][aPosY-1]);
                    child.processMap(map);
                    this.addChild(child);
                }
            }
            // go down
            if (aPosX < row-1){
                if (map[aPosX+1][aPosY] != 'X'){
                    map[aPosX][aPosY] = 'X';
                    child = new Node(aPosX+1, aPosY, map[aPosX+1][aPosY]);
                    child.processMap(map);
                    this.addChild(child);
                }   
            }
            // go right
            if (aPosY < col-1){
                if (map[aPosX][aPosY+1] != 'X'){
                    map[aPosX][aPosY] = 'X';
                    child = new Node(aPosX, aPosY+1, map[aPosX][aPosY+1]);
                    child.processMap(map);
                    this.addChild(child);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lim = Integer.parseInt(in.next());
        int posX, posY, guess;
        char[][] map;
        Node root;
        for (int i = 0; i < lim; i++){
            col = 0;
            row = 0;
            paths = 0;
            posX = 0;
            posY = 0;
            guess = 0;
            // get all of the map details into appropriate variables
            row = Integer.parseInt(in.next());
            col = Integer.parseInt(in.next());
            map = new char[row][col];
            for (int j = 0; j < row; j++){
                map[j] = in.next().toCharArray();
            }
            guess = Integer.parseInt(in.next());
            
            // find 'M', aka the root node
            for (int j = 0; j < row; j++){
                for (int k = 0; k < col; k++){
                    if (map[j][k] == 'M'){
                        posX = j;
                        posY = k;
                        break;
                    }
                }
            }
            root = new Node(posX, posY, 'M');
            root.processMap(map);
            boolean path = root.findPath(map);
            
            if (paths == guess)
                System.out.println("Impressed");
            else
                System.out.println("Oops!");
        }
        
        
    }
    
}