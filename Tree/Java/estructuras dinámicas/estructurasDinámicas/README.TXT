CREAR UNA PILA DINAMICA PROPIA CON VALORES HENÉRICOS (T), LA PILA DEBE TENER ESTOS METODOS:
    - isEmpty(): indica si la pila está vacia o no.
    - size(): indica el tamaño de la pila.
    - pop(): devuelve el contenido del primer elemento y lo elimina.
    - top(): devuelve el contenido del primer elemento (no elimina nada).
    - push(T elemento): introduce un elemento en la pila.
    - toString(): muestra el estado de la pila.
 
Necesitamos un objeto Nodo para todo esto, el nodo contiene:
    - El elemento (T)
    - Dirección del próximo nodo (null, significa que es el primer elemento) 