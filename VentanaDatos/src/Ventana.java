import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class Ventana {
    JFrame ventana = new JFrame("Sacar CURP");


    public Ventana() {
        ventana.setSize(350, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(new GridLayout(5,2,10,10));

        //Componentes
        JLabel labelCurp = new JLabel("CURP");
        JTextField curpCampo = new JTextField();

        JLabel labelFechaNacimiento  = new JLabel("Fecha Nacimiento");
        JTextField fechaNacimientoField = new JTextField();
        fechaNacimientoField.setEditable(false);

        JLabel labelGenero = new JLabel("Genero");
        JTextField generoField = new JTextField();
        generoField.setEditable(false);

        JLabel labelEstado= new JLabel("Nombre");
        JTextField estadoField = new JTextField();
        estadoField.setEditable(false);

        JButton btnSiguiente = new JButton("Siguiente");

        //Accion del Boton
        btnSiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String curp = curpCampo.getText().toUpperCase().trim();

                //CURP de 18 Digitos?
                if (curp.length() < 18) {
                    JOptionPane.showMessageDialog(null, "CURP inválido. Debe contener al menos 18 caracteres.");
                    return;
                }
            try {
                //Extraer fecha de nacimiento
                String año = curp.substring(4, 6);
                String mes = curp.substring(6, 8);
                String dia = curp.substring(8, 10);
                int añoInt = Integer.parseInt(año);//Pasamos el año String a año Int, para calcular el siglo
                String siglo = (añoInt < 30) ? "20" : "19";
                String fechaFormateada = siglo + año + "/" + mes + "/" + dia;
                fechaNacimientoField.setText(fechaFormateada);

                char generoObtener = curp.charAt(10);
                if (generoObtener == 'H') {
                    generoField.setText("Masculino");
                } else {
                    generoField.setText("Femenino");
                }

                //Estado
                String estadoCodigo = curp.substring(11, 13);
                String estadoNombre = obtenerNombreEstado(estadoCodigo);
                estadoField.setText(Objects.requireNonNullElse(estadoNombre, "Desconocido"));

                //Crear Objeto Persona
                Persona persona1 = new Persona("Nombre","Ap","Am",generoField.getText(),fechaNacimientoField.getText());
                System.out.println(persona1);
                JOptionPane.showMessageDialog(null,persona1);

            } catch (Exception ex){
                JOptionPane.showMessageDialog(ventana, "Error al procesar el CURP");
            }
        }
    });
        ventana.add(labelCurp);
        ventana.add(curpCampo);
        ventana.add(labelFechaNacimiento);
        ventana.add(fechaNacimientoField);
        ventana.add(labelGenero);
        ventana.add(generoField);
        ventana.add(labelEstado);
        ventana.add(estadoField);
        ventana.add(new JLabel());
        ventana.add(btnSiguiente);

        ventana.setVisible(true);
        ventana.add(btnSiguiente);

        ventana.setVisible(true);
    }

    // Método para obtener el nombre del estado desde el código del CURP
    public static String obtenerNombreEstado(String codigo) {
        return switch (codigo) {
            case "AS" -> "Aguascalientes";
            case "BC" -> "Baja California";
            case "BS" -> "Baja California Sur";
            case "CC" -> "Campeche";
            case "CL" -> "Coahuila de Zaragoza";
            case "CM" -> "Colima";
            case "CS" -> "Chiapas";
            case "CH" -> "Chihuahua";
            case "DF" -> "Ciudad de México";
            case "DG" -> "Durango";
            case "GT" -> "Guanajuato";
            case "GR" -> "Guerrero";
            case "HG" -> "Hidalgo";
            case "JC" -> "Jalisco";
            case "MC" -> "Estado de Mexico";
            case "MN" -> "Michoacan de Ocampo";
            case "MS" -> "Morelos";
            case "NT" -> "Nayarit";
            case "NL" -> "Nuevo Leon";
            case "OC" -> "Oaxaca";
            case "PL" -> "Puebla";
            case "QT" -> "Queretaro de Arteaga";
            case "QR" -> "Quintana Roo";
            case "SP" -> "San Luis Potosi";
            case "SL" -> "Sinaloa";
            case "SR" -> "Sonora";
            case "TC" -> "Tabasco";
            case "TS" -> "Tamaulipas";
            case "TL" -> "Tlaxcala";
            case "VZ" -> "Veracruz de Ignacio de la Llave";
            case "YN" -> "Yucatan";
            case "ZS" -> "Zacatecas";
            case "NE" -> "Nacido en el extranjero";
            default -> null;
        };
    }

    public static void main(String[] args) {
        new Ventana();
    }
}
