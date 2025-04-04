import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Ventana {
    JFrame ventana = new JFrame();
    String[] estados = {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua",
            "Coahuila de Zaragoza", "Colima", "Ciudad de México", "Durango", "Guanajuato", "Guerrero",
            "Hidalgo", "Jalisco", "Estado de Mexico", "Michoacan de Ocampo", "Morelos", "Nayarit",
            "Nuevo Leon", "Oaxaca", "Puebla", "Queretaro de Arteaga", "Quintana Roo", "San Luis Potosi",
            "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz de Ignacio de la Llave",
            "Yucatan", "Zacatecas"};


    public Ventana() {
        ventana.setSize(200, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);


        ventana.add(panel);


        JLabel curp = new JLabel("CURP");
        JTextField curpCampo = new JTextField(13);

        JLabel fechaNacimiento  = new JLabel("Fecha Nacimiento");
        DateFormat formato = new SimpleDateFormat("/yyyy/MM/dd");
        JFormattedTextField fechaNacimientoCampo = new JFormattedTextField(formato);
        fechaNacimientoCampo.setColumns(13);
        fechaNacimientoCampo.setEditable(false);

        JLabel genero = new JLabel("Genero");
        JComboBox generoComboBox = new JComboBox();
        generoComboBox.addItem("Masculino");
        generoComboBox.addItem("Femenino");
        generoComboBox.setEditable(false);


        JLabel estado = new JLabel("Estado");
        JComboBox<String> comboBoxEstados = new JComboBox<>(estados);
        comboBoxEstados.setEditable(false);


        JButton btnSiguiente = new JButton("Siguiente");

        btnSiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String curp = curpCampo.getText().toUpperCase();
                String año = curp.substring(4, 6);
                String mes = curp.substring(6, 8);
                String dia = curp.substring(8, 10);
                String fechaNac = año + "/" + mes + "/" + dia;
                fechaNacimientoCampo.setText(fechaNac);

                char generoObtener = curp.charAt(10);
                    if (genero == 'H') {
                        generoComboBox.setSelectedItem("Masculino");
                    } else if (genero == 'M') {
                        generoComboBox.setSelectedItem("Femenino");
                    }
            }
        }

        ventana.add(curp);
        ventana.add(curpCampo);
        ventana.add(fechaNacimiento);
        ventana.add(fechaNacimientoCampo);
        ventana.add(genero);
        ventana.add(generoComboBox);
        ventana.add(estado);
        ventana.add(comboBoxEstados);
        ventana.add(btnSiguiente);


    public static void main(String[] args) {
        new Ventana();
    }
}
}