package ModuloFactura;

import Clases.*;
import Principal.Menu;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Factura extends javax.swing.JFrame {

    // HACEMOS LLAMADO A LOS DOS AREGO EL DE LOS PRODUCTOS Y DE LOS VENDEDORES
    Menu ventanaMenu;
    Productos listaProductos[];
    Persona listaPersonas[];
    Persona listaVendedores[];
    int totalPagar = 0;
    // esto es lo que nesecita la ventana de factura para hacer la factura

    public Factura(Menu ventanaMenu, Productos listaProductos[], Persona listaPersonas[], Persona listaVendedores[]) {
        this.ventanaMenu = ventanaMenu;
        this.listaPersonas = listaPersonas;
        this.listaProductos = listaProductos;
        this.listaVendedores = listaVendedores;
        initComponents();
        initAlternComponents();
    }

    public void initAlternComponents() {
        setLocationRelativeTo(null);
        setIconImage(getToolkit().createImage(ClassLoader.getSystemResource("imagenes/icono_almacenes.png")));

        // evento para buscar los productos el vendedore y el cliente 
        // Creo los eventos para buscar el cliente si esta registrado o no
        ActionListener buscadorCliente = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarCliente();
            }
        };

        this.buscadorCedula.addActionListener(buscadorCliente);
        
        ActionListener buscarVendedor = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarVendedor();
            }
        };
        this.cedulaVen.addActionListener(buscarVendedor);
        
        ActionListener eventoAgregarProductos = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AgregarProducto();
            }
        };
        this.compraProducto.addActionListener(eventoAgregarProductos);
        // actionKeylistener
        KeyListener eventoKeyBuscarCliente = new KeyListener() {
            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                String texto = inputCedula.getText();
                if (texto.equalsIgnoreCase("")) {
                    nombreCliente.setText("");
                    direccionCliente.setText("");
                }
            }

            public void keyTyped(KeyEvent e) {
            }
        };

        KeyListener eventoKeyBuscarVendedor = new KeyListener() {
            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                buscarVendedor();
            }

            public void keyTyped(KeyEvent e) {
            }
        };
        KeyListener buscarProductos = new KeyListener() {
            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                busquedaProductos();
            }

            public void keyTyped(KeyEvent e) {
            }
        };
        // añadimos el evento a la llave
        identificador.addKeyListener(buscarProductos);
        inputCedula.addKeyListener(eventoKeyBuscarCliente);
        //cedulaVendedor.addKeyListener(eventoKeyBuscarVendedor);
    }

    // estos son los metodos para el vendedor usaurio y producto 
    public void buscarCliente() {
        boolean encontrado = false;
        String texto = inputCedula.getText();
        if (!texto.equalsIgnoreCase("")) {
            for (int i = 0; i < this.listaPersonas.length; i++) {
                if (listaPersonas[i] != null && listaPersonas[i].getCedula().equalsIgnoreCase(texto)) {
                    encontrado = true;
                    this.nombreCliente.setText(this.listaPersonas[i].getNombres());
                    this.direccionCliente.setText(this.listaPersonas[i].getDireccion());
                    System.out.println(this.listaPersonas[i].getNombres());
                    System.out.println(this.listaPersonas[i].getDireccion());
                    break;
                }
            }
            if (encontrado) {
                deshabilitarInput(this.nombreCliente);
                deshabilitarInput(this.direccionCliente);
                this.cedulaVendedor.requestFocus();
            }
        }

    }

    public void buscarVendedor() {
        boolean encontrado_vendedor = false;
        String vendedor = cedulaVendedor.getText();
        for (int i = 0; i < this.listaVendedores.length; i++) {
            if (this.listaVendedores[i] != null && this.listaVendedores[i].getCedula().equalsIgnoreCase(vendedor)) {
                encontrado_vendedor = true;
                this.nombreVendedor.setText(listaVendedores[i].getNombres());
                break;
            }
        }
        if (encontrado_vendedor) {

            habilitarInput(this.identificador);
            deshabilitarInput(this.nombreProducto);
            habilitarInput(this.canti);
        } else {

            deshabilitarInput(this.nombreProducto);
            deshabilitarInput(this.identificador);
            deshabilitarInput(this.canti);
        }
    }

    // Busqueda de productos
    public void busquedaProductos() {
        String unico = identificador.getText();
        boolean encontrado = false;
        if (!unico.equalsIgnoreCase("")) {
            for (int i = 0; i < listaProductos.length; i++) {
                if (this.listaProductos[i] != null
                        && this.listaProductos[i].getIdentificador().equalsIgnoreCase(unico)) {
                    this.nombreProducto.setText(this.listaProductos[i].getName());
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                this.nombreProducto.setText("No encontrado");
            }
        } else {
            this.nombreProducto.setText("");
        }
    }

    public void AgregarProducto() {
        String textCant = canti.getText();
        String id = identificador.getText();
        int valorProducto = 0;
        for (int i = 0; i < listaProductos.length; i++) {
            if (this.listaProductos[i] != null) {
                if (this.listaProductos[i].getIdentificador().equalsIgnoreCase(id)
                        && !canti.getText().equalsIgnoreCase("")) {
                    compraProducto.setEnabled(true);
                    int cantidad = Integer.parseInt(textCant);
                    int precio = Integer.parseInt(this.listaProductos[i].getPrecio());
                    valorProducto = precio * cantidad;
                    resultado.setText(resultado.getText() + "\n\n" + this.listaProductos[i].getIdentificador() + " --- "
                            + this.listaProductos[i].getName() + " --" + valorProducto + "  \n\n");
                    // agregamo el valor final de todos los productos comprados
                    revalidate();
                    break;
                }
            }
        }
        totalPagar = totalPagar + valorProducto;
        System.out.print(totalPagar);
        total.setText("TOTAL $: " + Integer.toString(totalPagar));
    }

    // estos metodos son para habilitar los inputs
    public void deshabilitarInput(JTextField input) {
        input.setEditable(false);
        input.setEnabled(false);
        input.setDisabledTextColor(Color.black);
    }

    public void habilitarInput(JTextField input) {
        input.setText("");
        input.setEditable(true);
        input.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputCedula = new javax.swing.JTextField();
        compraProducto = new javax.swing.JButton();
        nombreCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        direccionCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cedulaVendedor = new javax.swing.JTextField();
        nombreVendedor = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        buscadorCedula = new javax.swing.JButton();
        identificador = new javax.swing.JTextField();
        nombreProducto = new javax.swing.JTextField();
        canti = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Compra = new javax.swing.JPanel();
        resultado = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Guardar = new javax.swing.JButton();
        Guardar1 = new javax.swing.JButton();
        total = new javax.swing.JLabel();
        cedulaVen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Factura");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("DATOS CLIENTE:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("NOMBRES:");

        inputCedula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        compraProducto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        compraProducto.setText("COMPRAR");

        nombreCliente.setEditable(false);
        nombreCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("CEDULA");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("DATOS DEL VENDEDOR:");

        direccionCliente.setEditable(false);
        direccionCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("DIRECCION:");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("CEDULA:");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setText("NOMBRES:");

        cedulaVendedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        nombreVendedor.setEditable(false);
        nombreVendedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel13.setText("PRODUCTOS:");

        jLabel14.setText("ID");

        jLabel15.setText("NOMBRE");

        jLabel16.setText("CANTIDAD");

        buscadorCedula.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        buscadorCedula.setText("BUSCAR ");

        identificador.setEditable(false);
        identificador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        nombreProducto.setEditable(false);
        nombreProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        canti.setEditable(false);
        canti.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        resultado.setText(".....");

        javax.swing.GroupLayout CompraLayout = new javax.swing.GroupLayout(Compra);
        Compra.setLayout(CompraLayout);
        CompraLayout.setHorizontalGroup(
            CompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CompraLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(resultado)
                .addContainerGap(479, Short.MAX_VALUE))
        );
        CompraLayout.setVerticalGroup(
            CompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CompraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(resultado)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(Compra);

        Guardar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Guardar.setText("CANCELAR");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        Guardar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Guardar1.setText("GUARDAR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(Guardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(352, Short.MAX_VALUE)
                    .addComponent(Guardar1)
                    .addGap(16, 16, 16)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Guardar)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Guardar1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        total.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        total.setText("TOTAL: 0.00");

        cedulaVen.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cedulaVen.setText("BUSCAR ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(total))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(identificador)))
                                .addGap(18, 18, 18)
                                .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(canti, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(compraProducto)
                                .addGap(33, 33, 33))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(39, 39, 39)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(inputCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(buscadorCedula))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel11))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cedulaVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cedulaVen)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(direccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel14)
                .addGap(67, 67, 67)
                .addComponent(jLabel15)
                .addGap(73, 73, 73)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(buscadorCedula))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(direccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cedulaVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cedulaVen))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(nombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compraProducto)
                    .addComponent(canti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(identificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(total)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        this.ventanaMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_GuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Compra;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Guardar1;
    private javax.swing.JButton buscadorCedula;
    private javax.swing.JTextField canti;
    private javax.swing.JButton cedulaVen;
    private javax.swing.JTextField cedulaVendedor;
    private javax.swing.JButton compraProducto;
    private javax.swing.JTextField direccionCliente;
    private javax.swing.JTextField identificador;
    private javax.swing.JTextField inputCedula;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField nombreCliente;
    private javax.swing.JTextField nombreProducto;
    private javax.swing.JTextField nombreVendedor;
    private javax.swing.JLabel resultado;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
