package ModuloUsuarios;

import java.awt.*;
import java.awt.event.*;
import Clases.Persona;
import Principal.Menu;
import javax.swing.*;

public class EliminarUsuario extends javax.swing.JFrame {

    // Creamomos la instancia de la ventana de menu 
    Menu ventMenu;
    Persona listapersonas[];
    String titulo;

    public EliminarUsuario(Menu ventMenu, Persona listaPersonas[], String titulo) {
        this.ventMenu = ventMenu;
        this.listapersonas = listaPersonas;
        this.titulo = titulo;
        initComponents();
        initAlternComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        etqEliminar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BuscarClienteEliminar = new javax.swing.JButton();
        inputEliminarUsuario = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        label_encontrado = new javax.swing.JLabel();
        labelNombres = new javax.swing.JLabel();
        labelApellidos = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        inputNombres = new javax.swing.JTextField();
        inputApellidos = new javax.swing.JTextField();
        inputTelefono = new javax.swing.JTextField();
        inputDireccion = new javax.swing.JTextField();
        inputCorreo = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        etqEliminar.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        etqEliminar.setForeground(new java.awt.Color(255, 255, 255));
        etqEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqEliminar.setText("ELIMINAR USUARIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(etqEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(etqEliminar)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Cedula:");

        BuscarClienteEliminar.setBackground(new java.awt.Color(0, 0, 102));
        BuscarClienteEliminar.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        BuscarClienteEliminar.setForeground(new java.awt.Color(255, 255, 255));
        BuscarClienteEliminar.setText("Buscar");

        inputEliminarUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(inputEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BuscarClienteEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inputEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarClienteEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        label_encontrado.setText("Usuario :");

        labelNombres.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labelNombres.setText("Nombres:");

        labelApellidos.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labelApellidos.setText("Apellidos");

        labelTelefono.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labelTelefono.setText("Telefono:");

        labelDireccion.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labelDireccion.setText("Direccion:");

        labelEmail.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labelEmail.setText("Email:");

        inputNombres.setBackground(new java.awt.Color(255, 255, 255));

        inputApellidos.setBackground(new java.awt.Color(255, 255, 255));

        inputTelefono.setBackground(new java.awt.Color(255, 255, 255));

        inputDireccion.setBackground(new java.awt.Color(255, 255, 255));

        inputCorreo.setBackground(new java.awt.Color(255, 255, 255));

        btn_cancelar.setBackground(new java.awt.Color(102, 102, 102));
        btn_cancelar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_eliminar.setBackground(new java.awt.Color(0, 0, 102));
        btn_eliminar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btn_eliminar.setText("DELETE");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(label_encontrado)
                                .addGap(48, 48, 48))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelApellidos)
                                .addComponent(labelNombres))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelDireccion)
                                .addComponent(labelTelefono)
                                .addComponent(labelEmail))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btn_cancelar)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_encontrado)
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(labelNombres)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelApellidos)
                            .addComponent(inputApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTelefono)
                            .addComponent(inputTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDireccion)
                            .addComponent(inputDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEmail)
                            .addComponent(inputCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_cancelar)
                            .addComponent(btn_eliminar))
                        .addGap(33, 33, 33))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(inputNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //este es el de eliminar usuario 

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        //agregamos una condicion 
        if (!this.inputNombres.getText().equals("") && !this.inputApellidos.getText().equals("") && !this.inputTelefono.getText().equals("") && !this.inputDireccion.getText().equals("") && !this.inputCorreo.getText().equals("")) {
            int eliminar = getObtenerPosicion();
            for (int i = eliminar; i < listapersonas.length - 1; i++) {
                this.listapersonas[i] = this.listapersonas[i + 1];
                if (this.titulo.equals("CLIENTE")) {
                    this.ventMenu.indexClientes--;
                    break;
                } else if (this.titulo.equals("VENDEDOR")) {
                    this.ventMenu.indexVendedores--;
                    break;
                }
            }
            //aqui se destruye una vez guarde los cambios

            ventMenu.setVisible(true);
            dispose();
        }

    }//GEN-LAST:event_btn_eliminarActionPerformed

    public void initAlternComponents() {
        this.etqEliminar.setText("ELIMINAR " + this.titulo);
        setLocationRelativeTo(null);
        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/icono_almacenes.png")));

        //agregamos el metodo a el evento del boton de buscar 
        ActionListener buscadorCliente = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarCliente();
            }
        };

        BuscarClienteEliminar.addActionListener(buscadorCliente);

        this.deshabilitarInput(inputNombres);
        this.deshabilitarInput(inputApellidos);
        this.deshabilitarInput(inputTelefono);
        this.deshabilitarInput(inputDireccion);
        this.deshabilitarInput(inputCorreo);

        //agregamos un evento en el caso que quiera eliminar el usuario 
        KeyListener eventoKeyBuscarCliente;
        eventoKeyBuscarCliente = new KeyListener() {
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String texto = inputEliminarUsuario.getText();
                if (texto.equalsIgnoreCase("")) {
                    limpiarInput();
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        };
        inputEliminarUsuario.addKeyListener(eventoKeyBuscarCliente);
    }

    public void buscarCliente() {

        if (!inputEliminarUsuario.getText().equals("")) {
            System.out.println("EL input se encuentra lleno");
            boolean encontrado = false;
            String cedula_ingresada = inputEliminarUsuario.getText();
            System.out.print("=>" + cedula_ingresada);

            for (int i = 0; i < listapersonas.length; i++) {
                if (listapersonas[i] != null && this.listapersonas[i].getCedula().equals(cedula_ingresada)) {
                    this.label_encontrado.setText("Usuario encontrado :" + listapersonas[i].getNombres());
                    System.out.println("Cedula=>" + this.listapersonas[i].getCedula() + i);
                    encontrado = true;

                    //agregamos la informacion del usuario en los input para que los pueda modificar
                    this.inputNombres.setText(listapersonas[i].getNombres());
                    this.inputApellidos.setText(listapersonas[i].getApellidos());
                    this.inputTelefono.setText(listapersonas[i].getTelefono());
                    this.inputDireccion.setText(listapersonas[i].getDireccion());
                    this.inputCorreo.setText(listapersonas[i].getEmail());
                    setObtenerPosicion(i);
                    break;
                }
            }
            if (encontrado == false) {
                this.label_encontrado.setText("Usuario NO encontrado :");
                System.out.println("El usuario no se encuentra");
            }
        } else {
            this.label_encontrado.setText("Usuario :");
            System.out.print("EL input se encuentra Vacio");

        }
    }

    public void limpiarInput() {
        this.inputNombres.setText("");
        this.inputApellidos.setText("");
        this.inputTelefono.setText("");
        this.inputDireccion.setText("");
        this.inputCorreo.setText("");
    }
    int posicion;

    public void setObtenerPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getObtenerPosicion() {
        return this.posicion;
    }
    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.ventMenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    public void deshabilitarInput(JTextField input) {
        input.setEditable(false);
        input.setEnabled(false);
        input.setDisabledTextColor(Color.black);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarClienteEliminar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JLabel etqEliminar;
    private javax.swing.JTextField inputApellidos;
    private javax.swing.JTextField inputCorreo;
    private javax.swing.JTextField inputDireccion;
    private javax.swing.JTextField inputEliminarUsuario;
    private javax.swing.JTextField inputNombres;
    private javax.swing.JTextField inputTelefono;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelApellidos;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelNombres;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel label_encontrado;
    // End of variables declaration//GEN-END:variables
}
