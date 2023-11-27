package model.data_structures;

public class HashMethods{


    static boolean isPrime(int n) 
    {

		if (n <= 1) return false;

		if (n > 1 && n <= 3) return true;


		if (n % 2 == 0 || n % 3 == 0) return false;

		for (int i = 5; i * i <= n; i = i + 6)

			if (n % i == 0 || n % (i + 2) == 0)

				return false;

		return true;
	}

    static int nextPrime(int N) {
		if (N <= 1)

			return 2;

		int prime = N;

		boolean found = false;


		while (!found)

		{
			prime++;

			if (isPrime(prime))

				found = true;

		}
		return prime;

	}

    public static <K extends Comparable<K>, V extends Comparable<V>> void rehash(TablaHashSeparteChaining<K, V> table) {
        try {
            ILista<NodoTS<K,V>> nodos = table.darListaNodos();
    
            table.tamanoAct = 0;
            table.tamanoTabla *= 2;
            int m = nextPrime(table.tamanoTabla);
            table.tamanoTabla = m;
            table.listaNodos = new ArregloDinamico<>(table.tamanoTabla);
    
            for(int i = 1; i <= table.tamanoTabla; i++) {
                table.listaNodos.insertElement(null, table.size() + 1);
            }
    
            NodoTS<K,V> actual = null;
            for(int i = 1; i <= nodos.size(); i++) {
                actual = nodos.getElement(i);
                table.put(actual.getKey(), actual.getValue());
            }
        } catch (NullException | VacioException | PosException e) {
            e.printStackTrace();
        }
    
        table.cantidadRehash++;
    }
    
    public static <K extends Comparable<K>, V extends Comparable<V>> void rehash(TablaHashLinearProbing<K, V> table) {
        try {
            ILista<NodoTS<K,V>> nodos = table.darListaNodos();
    
            table.tamanoAct = 0;
            table.tamanoTabla *= 2;
            int m = nextPrime(table.tamanoTabla);
            table.tamanoTabla = m;
            table.listaNodos = new ArregloDinamico<>(table.tamanoTabla);
    
            for(int i = 1; i <= table.tamanoTabla; i++) {
                table.listaNodos.insertElement(null, table.size() + 1);
            }
    
            NodoTS<K,V> actual = null;
            for(int i = 1; i <= nodos.size(); i++) {
                actual = nodos.getElement(i);
                table.put(actual.getKey(), actual.getValue());
            }
        } catch (NullException | VacioException | PosException e) {
            e.printStackTrace();
        }
    
        table.cantidadRehash++;
    }
    

    // public static <K, V> void rehash(TablaHashLinearProbing<K, V> table) {
    //     // ... (your existing rehash code)
    // }
    

}
