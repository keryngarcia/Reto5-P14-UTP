package view;

import controller.ControladorRequerimientos;

import model.vo.LiderSalarioCartagoVO;
import model.vo.MaterialProyectoVO;
import model.vo.LiderCostoPromVO;


import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class VistaRequerimientos extends JFrame {
    // req 1 CNS 1 , req2 CNS 4, req3 CNS 5 
    
    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static JTextArea textArea;

    public VistaRequerimientos(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 800,620);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbltitulo = new JLabel("Reto 5 P14");
        lbltitulo.setBounds(28, 6, 61, 16);
        contentPane.add(lbltitulo);

        JLabel lblautor = new JLabel("Keryn García");
        lblautor.setBounds(28, 34, 208, 16);
        contentPane.add(lblautor);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 70, 737, 455);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JButton btnConsuta1 = new JButton("Requerimiento 1");
        btnConsuta1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento1();
            }
        });
        btnConsuta1.setBounds(28, 537, 137, 29);
        contentPane.add(btnConsuta1);

        JButton btnConsuta2 = new JButton("Requerimiento 2");
        btnConsuta2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento2();
            }
        });
        btnConsuta2.setBounds(177, 537, 137, 29);
        contentPane.add(btnConsuta2);

        JButton btnConsuta3 = new JButton("Requerimiento 3");
        btnConsuta3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento3();
            }
        });
        btnConsuta3.setBounds(326, 537, 137, 29);
        contentPane.add(btnConsuta3);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        btnLimpiar.setBounds(648, 537, 117, 29);
        contentPane.add(btnLimpiar);

    }

    // CONSULTA 1
    public static void requerimiento1(){

        String salida = "Requerimiento 1, Consulta 1: \n\n";
        salida += "Nombre\t\tSalario\n";

        try{

            // Comunicarse con el controlador
            ArrayList<LiderSalarioCartagoVO> respuesta = ControladorRequerimientos.consultarLideresCartago();
            // Recibir los resultados
            DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
            symbols.setGroupingSeparator(',');            
            DecimalFormat formatter = new DecimalFormat("###,###", symbols);
            // recorrer e imprimir los resultados.
            for(LiderSalarioCartagoVO registro : respuesta){
                salida += registro.getNombre();
                salida += "\t";
                salida += formatter.format(registro.getSalario());
                salida += "\n";
            }
            
            textArea.setText(salida);

        } catch(SQLException e){
            System.err.println("Oops, paso algo!"+e.getMessage());
        }

    }

    // CONSULTA 4
    public static void requerimiento2(){

        String salida = "Requerimiento 2, Consulta 4:\n\n";
        salida += "Nombre_Material\tPrecio_Unidad Total\n";

        try{

            // Comunicarse con el controlador
            ArrayList<MaterialProyectoVO> respuesta = ControladorRequerimientos.consultarMaterialesProyecto();
            // Recibir los resultados
            DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
            symbols.setGroupingSeparator(',');            
            DecimalFormat formatter = new DecimalFormat("###,###", symbols);
            // recorrer e imprimir los resultados.
            for(MaterialProyectoVO registro : respuesta){
                salida += registro.getNombre_Material();
                salida += "\t\t";
                salida += formatter.format(registro.getPrecio_Unidad());
                salida += "\n";
            }
            
            textArea.setText(salida);

        } catch(SQLException e){
            System.err.println("Oops, paso algo!"+e.getMessage());
        }

    }

    // CONSULTA 5
    public static void requerimiento3(){

        String salida = "Requerimiento 3, Consulta 5:\n\n";
        salida += "Nombre\t\tPromedio\n";

        try{

            // Comunicarse con el controlador
            ArrayList<LiderCostoPromVO> respuesta = ControladorRequerimientos.consultarLideresCostoProm();
            // Recibir los resultados

            DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
            symbols.setGroupingSeparator(',');            
            DecimalFormat formatter = new DecimalFormat("###,###", symbols);
            // recorrer e imprimir los resultados.
            for(LiderCostoPromVO registro : respuesta){
                salida += registro.getNombre();
                salida += "\t";
                salida += formatter.format(registro.getPromedio());
                salida += "\n";
            }

            textArea.setText(salida);

        } catch(SQLException e){
            System.err.println("Oops, paso algo!"+e.getMessage());
        }

    }
}
