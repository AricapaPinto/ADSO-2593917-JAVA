package ModuloProductos;


import java.awt.*;
import java.awt.event.*;
import Clases.Productos;
import Principal.Menu;
import javax.swing.*;

public class EliminarProducto extends javax.swing.JFrame {

    // Creamomos la instancia de la ventana de menu 
    Menu ventMenu;
    Productos listaProductos[];
    String titulo;

    public EliminarProducto(Menu ventMenu, Productos listaProductos[]) {
        this.ventMenu = ventMenu;
        this.listaProductos = listaProductos;
        this.titulo = titulo;
        initComponents();
        initAlternComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        etqEliminar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        id_p = new javax.swing.JLabel();
        BuscarProducto = new javax.swing.JButton();
        inputEliminarProducto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        label_encontrado = new javax.swing.JLabel();
        labelNombres = new javax.swing.JLabel();
        labelApellidos = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        inputIdentificador = new javax.swing.JTextField();
        inputNombre = new javax.swing.JTextField();
        inputPrecio = new javax.swing.JTextField();
        inputCantidad = new javax.swing.JTextField();
        inputFecha = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Eliminar Producto");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        etqEliminar.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        etqEliminar.setForeground(new java.awt.Color(255, 255, 255));
        etqEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqEliminar.setText("ELIMINAR PRODUCTO");

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

        id_p.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        id_p.setText("ID P:");

        BuscarProducto.setBackground(new java.awt.Color(0, 0, 102));
        BuscarProducto.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        BuscarProducto.setForeground(new java.awt.Color(255, 255, 255));
        BuscarProducto.setText("Buscar");

        inputEliminarProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(id_p)
                .addGap(18, 18, 18)
                .addComponent(inputEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BuscarProducto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_p)
                    .addComponent(inputEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        label_encontrado.setText("Usuario :");

        labelNombres.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labelNombres.setText("ID:");

        labelApellidos.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labelApellidos.setText("Nombre:");

        labelTelefono.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labelTelefono.setText("    Precio:");

        labelDireccion.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labelDireccion.setText("    Cantidad:");

        labelEmail.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        labelEmail.setText("    Fecha:");

        inputIdentificador.setBackground(new java.awt.Color(255, 255, 255));

        inputNombre.setBackground(new java.awt.Color(255, 255, 255));

        inputPrecio.setBackground(new java.awt.Color(255, 255, 255));

        inputCantidad.setBackground(new java.awt.Color(255, 255, 255));

        inputFecha.setBackground(new java.awt.Color(255, 255, 255));

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
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(labelNombres)
                                .addGap(62, 62, 62))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelDireccion)
                                .addComponent(labelTelefono)
                                .addComponent(labelEmail))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btn_cancelar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(labelApellidos)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTelefono)
                            .addComponent(inputPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDireccion)
                            .addComponent(inputCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEmail)
                            .addComponent(inputFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_cancelar)
                            .addComponent(btn_eliminar))
                        .addGap(33, 33, 33))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(inputIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if (!this.inputIdentificador.getText().equals("") && !this.inputNombre.getText().equals("") && !this.inputPrecio.getText().equals("") && !this.inputCantidad.getText().equals("") && !this.inputFecha.getText().equals("")) {
            int eliminar = getObtenerPosicion();
            for (int i = eliminar; i < listaProductos.length - 1; i++) {
                this.listaProductos[i] = this.listaProductos[i + 1];
            }
            //aqui se destruye una vez guarde los cambios

            ventMenu.setVisible(true);
            dispose();
        }

    }//GEN-LAST:event_btn_eliminarActionPerformed

    public void initAlternComponents() {
        
        setLocationRelativeTo(null);
        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/icono_almacenes.png")));

        //agregamos el metodo a el evento del boton de buscar 
        ActionListener buscadorProducto = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarProducto();
            }
        };

        BuscarProducto.addActionListener(buscadorProducto);

        this.deshabilitarInput(inputIdentificador);
        this.deshabilitarInput(inputNombre);
        this.deshabilitarInput(inputPrecio);
        this.deshabilitarInput(inputCantidad);
        this.deshabilitarInput(inputFecha);

        //agregamos un evento en el caso que quiera eliminar el usuario 
        KeyListener eventoKeyBuscarCliente;
        eventoKeyBuscarCliente = new KeyListener() {
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String texto = inputEliminarProducto.getText();
                if (texto.equalsIgnoreCase("")) {
                    limpiarInput();
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        };
        inputEliminarProducto.addKeyListener(eventoKeyBuscarCliente);
    }

    public void buscarProducto() {

        if (!inputEliminarProducto.getText().equals("")) {
            System.out.println("EL input se encuentra lleno");
            boolean encontrado = false;
            String producto_ingresado = inputEliminarProducto.getText();
            System.out.println("=>" + producto_ingresado);

            for (int i = 0; i < listaProductos.length; i++) {
                if (this.listaProductos[i] != null && this.listaProductos[i].getIdentificador().equals(producto_ingresado)) {
                    this.label_encontrado.setText("Usuario encontrado :" + this.listaProductos[i].getIdentificador());
                    System.out.println("Cedula=>" + this.listaProductos[i].getIdentificador()+ i);
                    encontrado = true;

                  
                    this.inputIdentificador.setText(this.listaProductos[i].getIdentificador());
                    this.inputNombre.setText(this.listaProductos[i].getName());
                    this.inputPrecio.setText(this.listaProductos[i].getPrecio());
                    this.inputCantidad.setText(this.listaProductos[i].getcantidad());
                    this.inputFecha.setText(this.listaProductos[i].getfecha());
                    setObtenerPosicion(i);
                    break;
                }
            }
            if (encontrado == false) {
                this.label_encontrado.setText("Identificador no encontrado:");
                System.out.println("El Identificador del producto no se encuentra");
            }
        } else {
            this.label_encontrado.setText("Identificador :");
            System.out.print("EL input se encuentra Vacio");

        }
    }

    public void limpiarInput() {
        this.inputIdentificador.setText("");
        this.inputNombre.setText("");
        this.inputPrecio.setText("");
        this.inputCantidad.setText("");
        this.inputFecha.setText("");
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
    private javax.swing.JButton BuscarProducto;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JLabel etqEliminar;
    private javax.swing.JLabel id_p;
    private javax.swing.JTextField inputCantidad;
    private javax.swing.JTextField inputEliminarProducto;
    private javax.swing.JTextField inputFecha;
    private javax.swing.JTextField inputIdentificador;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JTextField inputPrecio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel labelApellidos;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelNombres;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel label_encontrado;
    // End of variables declaration//GEN-END:variables
}
