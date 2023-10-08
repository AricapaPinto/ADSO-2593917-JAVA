package principal;
// importamos las librerias necesarias para poder hacer uso de sus metodos y funciones

import principal.Persona;
import principal.ConsumoAPI;
import principal.Menu;
// importamos el Gson 
import com.google.gson.*;
import javax.swing.table.*;

public class ListaPersonas extends javax.swing.JFrame {

    // creamos un areglo de Persona
    Persona listaPersona[];
    Menu VentanaMenu;

    public ListaPersonas(Menu ventanaMenu) {
        this.VentanaMenu = ventanaMenu;

        // este es el controlador de esta clase 
        ConsumoAPI metodo_get = new ConsumoAPI();
        Gson gson = new Gson();

        //ahora manipulamos la respuesta que nos de el consumo get 
        String respuestaAll = metodo_get.consumoGET("http://localhost/APIenPHP/Obtener.php");

        // ahora convertimos el objeto respuesta en un objeto json manipulable 
        /*Entonces, en resumen, la línea de código toma la cadena
        respuestaAll, que se espera que sea una matriz JSON, la analiza y 
        la convierte en un objeto JsonArray llamado objetoPersona. A partir 
        de este punto, puedes acceder y trabajar con los elementos individuales 
        dentro de objetoPersona como lo harías con una matriz en Java.*/
        JsonObject objetoPersona = JsonParser.parseString(respuestaAll).getAsJsonObject();

        JsonArray aregloPersona = objetoPersona.get("registros").getAsJsonArray();
        listaPersona = new Persona[aregloPersona.size()];

        for (int i = 0; i < aregloPersona.size(); i++) {
            /* este ciclo se encarga de meter los datos recibidos por el
            json para poder manipularlo como una areglo y hacer uso del
            metodo llenar en la funcion llenartabla ya que como el areglo es global 
            ponemos manipularlo en cualquier linea de codigo de nuestra 
            clase si lo quitamos producimos un error */

            //Esta línea de código se utiliza para convertir un objeto JSON en un objeto de la clase Persona
            /* para poder convertir los datos en una clase persona
            la clase persona deve tener los nombre de los datos del
            formato json para poder hacer la convercion y darle a 
            cada uno los datos corespondiente sino podria aver errores*/
            Persona temp = gson.fromJson(aregloPersona.get(i).getAsJsonObject(), Persona.class);
            listaPersona[i] = temp;
            System.out.println("Persona" + i + temp.getApellidos());

        }

        initComponents();
        initAlternComponents();

        // Llena la tabla después de que la interfaz se haya inicializado
        llenarTabla();
        setVisible(true);
    }

    // creamos un metodo para llenar la tabla
    private void llenarTabla() {
        // esta linea se encarga de hacer posible la manipulacion de la tabla o hacer crud que es lo que queremos
        DefaultTableModel tablaModel = (DefaultTableModel) tabla_users.getModel();

        // Limpia todas las filas existentes en la tabla
        tablaModel.setRowCount(0);
        for (Persona persona : listaPersona) {
            // Obtén los atributos de la persona
            String cedula = persona.getCedula();
            String nombres = persona.getNombre();
            String apellidos = persona.getApellidos();
            String telefono = persona.getTelefono();
            String direccion = persona.getDireccion();
            String email = persona.getEmail();

            // Crea un arreglo de objetos para representar una fila de la tabla
            Object[] fila = {cedula, nombres, apellidos, telefono, direccion, email};

            // Agrega la fila al modelo de la tabla
            tablaModel.addRow(fila);
        }

        // Actualiza el modelo de la tabla
        tabla_users.setModel(tablaModel);
    }

    public void initAlternComponents() {
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_users = new javax.swing.JTable();
        atras = new javax.swing.JButton();
        Lista = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla_users.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tabla_users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombres", "Apellidos", "Telefono", "Direccion", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_users.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla_users);
        if (tabla_users.getColumnModel().getColumnCount() > 0) {
            tabla_users.getColumnModel().getColumn(0).setResizable(false);
            tabla_users.getColumnModel().getColumn(1).setResizable(false);
            tabla_users.getColumnModel().getColumn(2).setResizable(false);
            tabla_users.getColumnModel().getColumn(3).setResizable(false);
        }

        atras.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        atras.setText("Volver Atras");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(atras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(atras)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setText("LISTA PERSONAS");

        javax.swing.GroupLayout ListaLayout = new javax.swing.GroupLayout(Lista);
        Lista.setLayout(ListaLayout);
        ListaLayout.setHorizontalGroup(
            ListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ListaLayout.createSequentialGroup()
                .addContainerGap(282, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(256, 256, 256))
        );
        ListaLayout.setVerticalGroup(
            ListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Lista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        // aqui volmeos atras al menu
        this.VentanaMenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_atrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Lista;
    private javax.swing.JButton atras;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_users;
    // End of variables declaration//GEN-END:variables
}
