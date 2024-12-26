package Module1;
import java.util.HashMap;

public class QuickUnion_Find {
    static HashMap<Integer, Integer> roots = new HashMap<>(); // Guarda las raíces de cada elemento
    static HashMap<Integer, Integer> maxElement = new HashMap<>(); // Guarda el máximo elemento por componente

    public static void main(String[] args) {
        union(6, 5);
        union(6, 3);
        union(9, 3);
        System.out.println(isConnected(3, 5)); // true
        System.out.println(find(3)); // 9
    }

    private static void union(int number1, int number2) {
        // Obtenemos las raíces de ambos elementos
        int root1 = getRoot(number1);
        int root2 = getRoot(number2);

        if (root1 != root2) {
            // Determinamos qué árbol será el padre (por rango o tamaño)
            if (root1 >= root2) {
                roots.put(root2, root1); // root1 será la nueva raíz
                maxElement.put(root1, Math.max(maxElement.getOrDefault(root1, root1), maxElement.getOrDefault(root2, root2)));
            } else {
                roots.put(root1, root2); // root2 será la nueva raíz
                maxElement.put(root2, Math.max(maxElement.getOrDefault(root1, root1), maxElement.getOrDefault(root2, root2)));
            }
        }
    }

    private static int getRoot(int number) {
        int root = roots.getOrDefault(number, number);
        if (root != number) {
            root = getRoot(root); // Llamada recursiva para encontrar la raíz
            roots.put(number, root); // Compresión de caminos
        }
        return root;
    }

    private static boolean isConnected(int number1, int number2) {
        return getRoot(number1) == getRoot(number2);
    }

    private static int find(int number) {
        // Encuentra la raíz y retorna el máximo elemento asociado
        int root = getRoot(number);
        return maxElement.getOrDefault(root, root);
    }
}
