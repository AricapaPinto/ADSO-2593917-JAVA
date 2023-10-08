package principal;

import javax.swing.*;

public class Menu extends JFrame {

    public ListaPersonas personas[];

    public Menu() {

        //this.personas=new Persona[100];
        initComponents();
        initAlternComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentMenu = new javax.swing.JPanel();
        etqMenu = new javax.swing.JLabel();
        contentPrincipal = new javax.swing.JPanel();
        etiquetaCliente = new javax.swing.JLabel();
        contentClientes = new javax.swing.JPanel();
        btnCrearCliente = new javax.swing.JButton();
        btnModificarCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        btnListarClientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuarios");
        setBackground(new java.awt.Color(255, 51, 51));
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        contentMenu.setBackground(new java.awt.Color(0, 0, 102));

        etqMenu.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        etqMenu.setForeground(new java.awt.Color(255, 255, 255));
        etqMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etqMenu.setText("Menú");

        javax.swing.GroupLayout contentMenuLayout = new javax.swing.GroupLayout(contentMenu);
        contentMenu.setLayout(contentMenuLayout);
        contentMenuLayout.setHorizontalGroup(
            contentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etqMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
        );
        contentMenuLayout.setVerticalGroup(
            contentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etqMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        contentPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        etiquetaCliente.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        etiquetaCliente.setText("CLIENTES");
        etiquetaCliente.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        contentClientes.setBackground(new java.awt.Color(255, 255, 255));
        contentClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)));

        btnCrearCliente.setBackground(new java.awt.Color(0, 0, 153));
        btnCrearCliente.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnCrearCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearCliente.setText("Crear");
        btnCrearCliente.setFocusable(false);
        btnCrearCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearClienteActionPerformed(evt);
            }
        });

        btnModificarCliente.setBackground(new java.awt.Color(0, 0, 153));
        btnModificarCliente.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnModificarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarCliente.setText("Modificar");
        btnModificarCliente.setFocusable(false);
        btnModificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarClienteActionPerformed(evt);
            }
        });

        btnEliminarCliente.setBackground(new java.awt.Color(0, 0, 153));
        btnEliminarCliente.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnEliminarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarCliente.setText("Eliminar");
        btnEliminarCliente.setFocusable(false);
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        btnListarClientes.setBackground(new java.awt.Color(0, 0, 153));
        btnListarClientes.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnListarClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnListarClientes.setText("Listar");
        btnListarClientes.setFocusable(false);
        btnListarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentClientesLayout = new javax.swing.GroupLayout(contentClientes);
        contentClientes.setLayout(contentClientesLayout);
        contentClientesLayout.setHorizontalGroup(
            contentClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentClientesLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(contentClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnListarClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(btnEliminarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCrearCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificarCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
                .addGap(72, 72, 72))
        );
        contentClientesLayout.setVerticalGroup(
            contentClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentClientesLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(btnCrearCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout contentPrincipalLayout = new javax.swing.GroupLayout(contentPrincipal);
        contentPrincipal.setLayout(contentPrincipalLayout);
        contentPrincipalLayout.setHorizontalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPrincipalLayout.createSequentialGroup()
                        .addComponent(contentClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPrincipalLayout.createSequentialGroup()
                        .addComponent(etiquetaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))))
        );
        contentPrincipalLayout.setVerticalGroup(
            contentPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPrincipalLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(etiquetaCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contentClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(contentPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(contentMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarClientesActionPerformed
        setVisible(false);
        //aqui lo mandamos a  lista de mostrar todos los datos del consumo api
        ListaPersonas ventana = new ListaPersonas(this);

        ventana.setVisible(true);
    }//GEN-LAST:event_btnListarClientesActionPerformed

    private void btnCrearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearClienteActionPerformed
        setVisible(false);

        CrearUsuario ventana = new CrearUsuario(this, "CLIENTE");
        ventana.setVisible(true);
    }//GEN-LAST:event_btnCrearClienteActionPerformed

    private void btnModificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarClienteActionPerformed

        //creamos una instancia para mandarle todos los usuarios de la lista ya convertidos en areglo 
       
        setVisible(false);
        ModificarUsuario ventana = new ModificarUsuario(this, "CLIENTES");
        ventana.setVisible(true);
    }//GEN-LAST:event_btnModificarClienteActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        // ventana para eliminar el usuarios 
        
        setVisible(false);
        EliminarUsuario ventana=new EliminarUsuario(this, "PERSONA");
        ventana.setVisible(true);
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    public void initAlternComponents() {
        setLocationRelativeTo(null);

    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearCliente;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnListarClientes;
    private javax.swing.JButton btnModificarCliente;
    private javax.swing.JPanel contentClientes;
    private javax.swing.JPanel contentMenu;
    private javax.swing.JPanel contentPrincipal;
    private javax.swing.JLabel etiquetaCliente;
    private javax.swing.JLabel etqMenu;
    // End of variables declaration//GEN-END:variables
}
