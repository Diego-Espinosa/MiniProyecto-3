/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author ASUS
 */
import Controller.UsuarioController;
import DAO.ImplementacionUsuarioMapDao;
import DAO.UsuarioDao;
import javax.swing.*;
import java.awt.*;
import model.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UsuarioGUI extends JFrame {
    private UsuarioController usuarioController;

    private JTextField nombreTextField;
    private JTextField ocupacionTextField;
    private JCheckBox prestamoActivoCheckBox;
    private JCheckBox parcialmenteActivoCheckBox;
    private JTextArea usuariosTextArea;

    public UsuarioGUI(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;

        setTitle("Gestión de Usuarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Hacer que la ventana ocupe toda la pantalla
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel formularioPanel = new JPanel();
        formularioPanel.setLayout(new BoxLayout(formularioPanel, BoxLayout.Y_AXIS));

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreTextField = new JTextField();
        JLabel ocupacionLabel = new JLabel("Ocupación:");
        ocupacionTextField = new JTextField();
        JLabel prestamoActivoLabel = new JLabel("Préstamo Activo:");
        prestamoActivoCheckBox = new JCheckBox();
        JLabel parcialmenteActivoLabel = new JLabel("Parcialmente Activo:");
        parcialmenteActivoCheckBox = new JCheckBox();

        JPanel nombrePanel = new JPanel();
        nombrePanel.add(nombreLabel);
        nombrePanel.add(nombreTextField);

        JPanel ocupacionPanel = new JPanel();
        ocupacionPanel.add(ocupacionLabel);
        ocupacionPanel.add(ocupacionTextField);

        JPanel prestamoActivoPanel = new JPanel();
        prestamoActivoPanel.add(prestamoActivoLabel);
        prestamoActivoPanel.add(prestamoActivoCheckBox);

        JPanel parcialmenteActivoPanel = new JPanel();
        parcialmenteActivoPanel.add(parcialmenteActivoLabel);
        parcialmenteActivoPanel.add(parcialmenteActivoCheckBox);

        formularioPanel.add(nombrePanel);
        formularioPanel.add(ocupacionPanel);
        formularioPanel.add(prestamoActivoPanel);
        formularioPanel.add(parcialmenteActivoPanel);

        
        
         // Estilo de los campos de texto y etiquetas
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
        Color labelColor = Color.BLUE;
        Color textFieldColor = Color.BLACK;

        nombreLabel.setFont(labelFont);
        nombreLabel.setForeground(labelColor);
        ocupacionLabel.setFont(labelFont);
        ocupacionLabel.setForeground(labelColor);
        prestamoActivoLabel.setFont(labelFont);
        prestamoActivoLabel.setForeground(labelColor);
        parcialmenteActivoLabel.setFont(labelFont);
        parcialmenteActivoLabel.setForeground(labelColor);

        nombreTextField.setFont(textFieldFont);
        nombreTextField.setForeground(textFieldColor);
        ocupacionTextField.setFont(textFieldFont);
        ocupacionTextField.setForeground(textFieldColor);


        JButton agregarUsuarioButton = new JButton("Agregar Usuario");
        agregarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText();
                String ocupacion = ocupacionTextField.getText();
                boolean prestamoActivo = prestamoActivoCheckBox.isSelected();
                boolean parcialmenteActivo = parcialmenteActivoCheckBox.isSelected();

                usuarioController.agregarUsuario(nombre, ocupacion, prestamoActivo, parcialmenteActivo);
                actualizarListaUsuarios();

                // Limpiar los campos de texto y casillas de verificación
                nombreTextField.setText("");
                ocupacionTextField.setText("");
                prestamoActivoCheckBox.setSelected(false);
                parcialmenteActivoCheckBox.setSelected(false);
            }
        });

        JButton actualizarUsuarioButton = new JButton("Actualizar Usuario");
        actualizarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText();
                String ocupacion = ocupacionTextField.getText();
                boolean prestamoActivo = prestamoActivoCheckBox.isSelected();
                boolean parcialmenteActivo = parcialmenteActivoCheckBox.isSelected();

                int codigo = obtenerCodigoSeleccionado();
                if (codigo != -1) {
                    usuarioController.actualizarUsuario(codigo, nombre, ocupacion, prestamoActivo, parcialmenteActivo);
                    actualizarListaUsuarios();

                    // Limpiar los campos de texto y casillas de verificación
                    nombreTextField.setText("");
                    ocupacionTextField.setText("");
                    prestamoActivoCheckBox.setSelected(false);
                    parcialmenteActivoCheckBox.setSelected(false);
                }
            }
        });

        JButton eliminarUsuarioButton = new JButton("Eliminar Usuario");
        eliminarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo = obtenerCodigoSeleccionado();
                if (codigo != -1) {
                    usuarioController.eliminarUsuario(codigo);
                    actualizarListaUsuarios();

                    // Limpiar los campos de texto y casillas de verificación
                    nombreTextField.setText("");
                    ocupacionTextField.setText("");
                    prestamoActivoCheckBox.setSelected(false);
                    parcialmenteActivoCheckBox.setSelected(false);
                }
            }
        });

        usuariosTextArea = new JTextArea();
        usuariosTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(usuariosTextArea);

        formularioPanel.add(nombreLabel);
        formularioPanel.add(nombreTextField);
        formularioPanel.add(ocupacionLabel);
        formularioPanel.add(ocupacionTextField);
        formularioPanel.add(prestamoActivoLabel);
        formularioPanel.add(prestamoActivoCheckBox);
        formularioPanel.add(parcialmenteActivoLabel);
        formularioPanel.add(parcialmenteActivoCheckBox);
        formularioPanel.add(agregarUsuarioButton);
        formularioPanel.add(actualizarUsuarioButton);
        formularioPanel.add(eliminarUsuarioButton);

        add(formularioPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setVisible(true);

        // Mostrar la lista de usuarios al iniciar la GUI
        actualizarListaUsuarios();
    }

    public void actualizarListaUsuarios() {
        usuariosTextArea.setText("");
        List<Usuario> usuarios = usuarioController.getUsuarios();
        for (Usuario usuario : usuarios) {
            usuariosTextArea.append("Código: " + usuario.getCodigo() + "\n");
            usuariosTextArea.append("Nombre: " + usuario.getName() + "\n");
            usuariosTextArea.append("Ocupación: " + usuario.getOcupacion() + "\n");
            usuariosTextArea.append("Préstamo Activo: " + usuario.isPrestamoaActivo() + "\n");
            usuariosTextArea.append("Parcialmente Activo: " + usuario.isParcialmenteActivo() + "\n");
            usuariosTextArea.append("\n");
        }
    }

    public int obtenerCodigoSeleccionado() {
        String codigoString = JOptionPane.showInputDialog("Ingrese el código del usuario:");
        int codigo = -1;
        try {
            codigo = Integer.parseInt(codigoString);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return codigo;
    }

    public static void main(String[] args) {
        UsuarioDao usuarioDao = new ImplementacionUsuarioMapDao();
        UsuarioController usuarioController = new UsuarioController(usuarioDao);
        UsuarioGUI usuarioGUI = new UsuarioGUI(usuarioController);
    }
}
