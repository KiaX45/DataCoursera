package Module1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Percolate {

    public static void main(String[] args) {
        int[][] grid = generateGrid(8, 0.7);
        printGrid(grid);

        /*int[][] grid = {
                {1, 1, 0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1},

        };*/

        Object[] result = generateWeightsAndVirtualNode(8);
        int[] virtualNode = (int[]) result[0];
        HashMap<Integer, Integer> weights = (HashMap<Integer, Integer>) result[1];
        check(grid, virtualNode, weights,0);

    }

    public static int[][] generateGrid(int size, double probability) {
        int[][] grid = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int value = random.nextDouble() < probability ? 1 : 0;
                grid[i][j] = value;
            }
        }
        return grid;
    }

    private static Object[] generateWeightsAndVirtualNode(int size) {
        int[] virtualNode = new int[size];
        HashMap<Integer, Integer> weights = new HashMap<>();
        for (int i = 0; i < size; i++) {
            virtualNode[i] = i + 2;
            weights.put(i + 2, 0);
        }
        return new Object[]{virtualNode, weights};
    }

    private static void printGrid(int[][] grid) {
        for (int[] ints : grid) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean check(int[][] grid, int[] virtualNode, HashMap<Integer, Integer> weights, int height) {

        if(height >= grid.length) {
            return true;
        }



        int[] newVirtualNode = new int[virtualNode.length];

        for (int i = 0; i < virtualNode.length; i++) {
            if(virtualNode[i] != 0 || grid[height][i] != 1) {
                grid[height][i] = grid[height][i] != 0 ? virtualNode[i] : 0;

            } else if (grid[height][i] == 1 && i != 0) {
                //chekeamos si a la izquierda hay un valor posible
                grid[height][i] = grid[height][i-1] != 0 ? grid[height][i-1]: 1;
            }
            newVirtualNode[i] = grid[height][i];
            Integer actualWeight =  weights.getOrDefault(virtualNode[i], 0);
            weights.put(virtualNode[i], actualWeight);

            //si el index es diferente de cero significa que hay un posible valor a la izquierda y es posible que ese
            //valor sea uno en otras palabras en una casilla disponible sin valor asignado si en la casilla que estamso
            if(i != 0 && grid[height][i] != 0 && grid[height][i] != 1) {
                int index = i;
                while(index > 0 && grid[height][index-1] == 1){
                    grid[height][index-1] = grid[height][index];
                    index--;
                }
            }
        }

        printGrid(grid);



        height ++;
        return(check(grid, newVirtualNode, weights, height));

    }




}
