package dispersión;

public class ComparadorMetodos {
    public static String compararRendimiento() {
        return """
            **Análisis Asintótico**
            
            **Reasignación Lineal:**
            - Inserción: O(1) mejor caso, O(n) peor caso
            - Búsqueda: O(1) mejor caso, O(n) peor caso
            
            **Encadenamiento con BST:**
            - Inserción: O(1) + O(log k) por bucket (k: elementos en bucket)
            - Búsqueda: O(1) + O(log k) por bucket
            
            **Conclusiones:**
            - Linear es mejor con carga baja (<70%)
            - BST escala mejor con alta densidad de colisiones
            """;
    }
}