package dispersión;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazGrafica extends JFrame {
    private TablaHashLineal tablaLineal;
    private TablaHashBST tablaBST;
    private JTextArea resultadoArea;

    public InterfazGrafica() {
        tablaLineal = new TablaHashLineal(100);
        tablaBST = new TablaHashBST(100);
        
        setTitle("Comparación Tablas Hash");
        setSize(900, 700);  // Aumentamos el tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Panel principal con BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel de entrada con GridLayout
        JPanel entradaPanel = new JPanel(new GridLayout(7, 2, 5, 5));
        entradaPanel.setBorder(BorderFactory.createTitledBorder("Datos del Cliente"));
        
        JTextField[] campos = new JTextField[7];
        String[] etiquetas = {"Código", "Nombres", "Apellidos", "Teléfono", "Correo", "Dirección", "Código Postal"};
        
        for (int i = 0; i < campos.length; i++) {
            JLabel label = new JLabel(etiquetas[i] + ":");
            entradaPanel.add(label);
            campos[i] = new JTextField();
            entradaPanel.add(campos[i]);
        }
        
        // Panel de botones
        JPanel botonesPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        botonesPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        
        JButton btnInsertar = new JButton("Insertar en ambas tablas");
        JButton btnBuscar = new JButton("Buscar por Nombre/Apellido");
        botonesPanel.add(btnInsertar);
        botonesPanel.add(btnBuscar);
        
        // Área de resultados con scroll
        resultadoArea = new JTextArea(15, 70);  // 15 filas, 70 columnas
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        resultadoArea.setLineWrap(true);
        resultadoArea.setWrapStyleWord(true);
        
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Resultados y Comparación"));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        // Listeners para los botones
        btnInsertar.addActionListener(e -> {
            Cliente cliente = new Cliente(
                campos[0].getText(), campos[1].getText(), campos[2].getText(),
                campos[3].getText(), campos[4].getText(), campos[5].getText(), 
                campos[6].getText()
            );
            
            // Medir tiempos
            long inicio = System.nanoTime();
            tablaLineal.insertar(cliente);
            long tiempoLineal = System.nanoTime() - inicio;
            
            inicio = System.nanoTime();
            tablaBST.insertar(cliente);
            long tiempoBST = System.nanoTime() - inicio;
            
            // Formatear salida multilínea
            String resultado = "✅ CLIENTE INSERTADO:\n" +
                "----------------------------------------------\n" +
                cliente.toString() + "\n\n" +
                
                "⏱️  TIEMPOS DE INSERCIÓN:\n" +
                "----------------------------------------------\n" +
                "• Lineal: " + tiempoLineal + " ns\n" +
                "• BST:    " + tiempoBST + " ns\n\n" +
                
                "🚨 COLISIONES TOTALES:\n" +
                "----------------------------------------------\n" +
                "• Lineal: " + tablaLineal.getColisiones() + "\n" +
                "• BST:    " + tablaBST.getColisiones() + "\n\n" +
                
                "Nota: Se insertó el mismo cliente en ambas tablas hash";
            
            resultadoArea.setText(resultado);
        });
        
        btnBuscar.addActionListener(e -> {
            String clave = campos[1].getText() + " " + campos[2].getText();
            
            long inicio = System.nanoTime();
            Cliente encontradoLineal = tablaLineal.buscar(clave);
            long tiempoLineal = System.nanoTime() - inicio;
            
            inicio = System.nanoTime();
            Cliente encontradoBST = tablaBST.buscar(clave);
            long tiempoBST = System.nanoTime() - inicio;
            
            // Formatear salida multilínea
            String resultado = "🔍 BUSQUEDA: '" + clave + "'\n" +
                "==============================================\n\n" +
                
                "📊 MÉTODO LINEAL:\n" +
                "----------------------------------------------\n" +
                "Resultado: " + ((encontradoLineal != null) ? encontradoLineal : "No encontrado") + "\n" +
                "Tiempo:    " + tiempoLineal + " ns\n" +
                "Colisiones: " + tablaLineal.getColisiones() + "\n\n" +
                
                "🌳 MÉTODO BST:\n" +
                "----------------------------------------------\n" +
                "Resultado: " + ((encontradoBST != null) ? encontradoBST : "No encontrado") + "\n" +
                "Tiempo:    " + tiempoBST + " ns\n" +
                "Colisiones: " + tablaBST.getColisiones() + "\n\n" +
                
                "📈 ANÁLISIS COMPARATIVO:\n" +
                "==============================================\n" +
                ComparadorMetodos.compararRendimiento();
            
            resultadoArea.setText(resultado);
        });
        
        // Construir interfaz
        mainPanel.add(entradaPanel, BorderLayout.NORTH);
        mainPanel.add(botonesPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);
        
        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfazGrafica gui = new InterfazGrafica();
            gui.setVisible(true);
        });
    }
}