package pokemon;

import clases.ConsumoAPI;
import clases.infoPokemon;
import com.google.gson.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class pokeInfo extends javax.swing.JPanel {

    ArrayList<String> listadoPoke = new ArrayList<String>();
    // este variable es para saber el tamano del areglo
    int tamano;
    int index;
    DefaultTableModel tableModel;

    infoPokemon url;
    JsonObject datosPokemon;
    ConsumoAPI consumoApi = new ConsumoAPI();

    public pokeInfo(infoPokemon url) {
        // ahora mostramos las imaganes del pokemon seleccionado
        String respuesta = this.consumoApi.consumoGET(url.getUrl());
        // usamo esto para convertir en un objeto json manipulable de la respueta recibidada

        datosPokemon = JsonParser.parseString(respuesta).getAsJsonObject();
        this.url = url;
        initComponents();
        initAlternComponents();
        //deshabilitamos el boton de atras cuando se inicie la app 
        etq_atras.setEnabled(false);
        cargaImgPoke();
    }

    // aqui devo hacer una consulta a la api para cargar las imagenes de dicho pokemon
    public void initAlternComponents() {
        tableModel = (DefaultTableModel) this.tablepoke.getModel();
        // tabla reinicar valores 
        tableModel.setNumRows(0);
        Image icono_atras = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/icono_atras.png"));
        icono_atras = icono_atras.getScaledInstance(50, 50, 4);
        this.etq_atras.setIcon(new ImageIcon(icono_atras));

        Image icono_siguiente = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/icono_siguiente.png"));
        icono_siguiente = icono_siguiente.getScaledInstance(50, 50, 4);
        this.etq_siguiente.setIcon(new ImageIcon(icono_siguiente));
        // aqui validamos que los valores no lleguen 
        // validamos que los campo que trajimos no sean nulos

        this.namePoke.setText(this.datosPokemon.get("name").getAsString().toUpperCase());
        if (!this.datosPokemon.get("sprites").getAsJsonObject().get("back_default").isJsonNull()) {

            listadoPoke.add(this.datosPokemon.get("sprites").getAsJsonObject().get("back_default").getAsString());
        }

        if (!this.datosPokemon.get("sprites").getAsJsonObject().get("back_female").isJsonNull()) {

            listadoPoke.add(this.datosPokemon.get("sprites").getAsJsonObject().get("back_female").getAsString());
        }

        if (!this.datosPokemon.get("sprites").getAsJsonObject().get("back_shiny").isJsonNull()) {

            listadoPoke.add(this.datosPokemon.get("sprites").getAsJsonObject().get("back_shiny").getAsString());
        }

        if (!this.datosPokemon.get("sprites").getAsJsonObject().get("back_shiny_female").isJsonNull()) {
            listadoPoke.add(this.datosPokemon.get("sprites").getAsJsonObject().get("back_shiny_female").getAsString());

        }

        if (!this.datosPokemon.get("sprites").getAsJsonObject().get("front_default").isJsonNull()) {
            listadoPoke.add(this.datosPokemon.get("sprites").getAsJsonObject().get("front_default").getAsString());

        }

        if (!this.datosPokemon.get("sprites").getAsJsonObject().get("front_female").isJsonNull()) {
            listadoPoke.add(this.datosPokemon.get("sprites").getAsJsonObject().get("front_female").getAsString());

        }

        if (!this.datosPokemon.get("sprites").getAsJsonObject().get("front_shiny").isJsonNull()) {
            listadoPoke.add(this.datosPokemon.get("sprites").getAsJsonObject().get("front_shiny").getAsString());

        }

        if (!this.datosPokemon.get("sprites").getAsJsonObject().get("front_shiny_female").isJsonNull()) {
            listadoPoke.add(this.datosPokemon.get("sprites").getAsJsonObject().get("front_shiny_female").getAsString());
        }
        if (!this.datosPokemon.get("sprites").getAsJsonObject().get("other").getAsJsonObject().get("home").getAsJsonObject().get("front_default").isJsonNull()) {
            listadoPoke.add(this.datosPokemon.get("sprites").getAsJsonObject().get("other").getAsJsonObject().get("home").getAsJsonObject().get("front_default").getAsString());
        }
        DefaultTableModel tableModel = (DefaultTableModel) this.tablepoke.getModel();

        tableModel.setNumRows(0);
        this.tablepoke.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.tablepoke.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.tablepoke.getColumnModel().getColumn(2).setPreferredWidth(200);
        // obtenemos las habulidades de pokemon para mosrarlas en la tabla
        JsonArray habilidades = this.datosPokemon.get("abilities").getAsJsonArray();

        for (int i = 0; i < habilidades.size(); i++) {
            JsonObject tempHab = habilidades.get(i).getAsJsonObject().get("ability").getAsJsonObject();
            Object[] temporal = {Integer.valueOf(i + 1), tempHab.get("name").getAsString(), tempHab.get("url").getAsString()};
            tableModel.addRow(temporal);
        }

        this.index = 0;
        int tamano = listadoPoke.size();

        // Evento para el botón "Siguiente"
        MouseAdapter siguiente = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (index < tamano - 1) {
                    index++;
                    cargaImgPoke();
                }

                // Habilitar o deshabilitar botones según la posición actual
                if (index == 0) {
                    etq_atras.setEnabled(false);
                } else {
                    etq_atras.setEnabled(true);
                }

                if (index == tamano - 1) {
                    etq_siguiente.setEnabled(false);
                    System.out.println("No hay más pokemones");
                } else {
                    etq_siguiente.setEnabled(true);
                }

                System.out.println("Has dado clic en siguiente " + index);
            }
        };

// Evento para el botón "Atras"
        MouseAdapter atras = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (index > 0) {
                    index--;
                    cargaImgPoke();
                }

                // Habilitar o deshabilitar botones según la posición actual
                if (index == 0) {
                    etq_atras.setEnabled(false);
                } else {
                    etq_atras.setEnabled(true);
                }

                if (index == tamano - 1) {
                    etq_siguiente.setEnabled(false);
                } else {
                    etq_siguiente.setEnabled(true);
                }

                System.out.println("Has dado clic atras " + index);
            }
        };

        // Configura los eventos de mouse para los botones
        this.etq_siguiente.addMouseListener(siguiente);
        this.etq_atras.addMouseListener(atras);

    }

    public void cargaImgPoke() {

        try {
            URL url = new URL(listadoPoke.get(index));
            Image imagen = Toolkit.getDefaultToolkit().createImage(url);
            imagen = imagen.getScaledInstance(230, 180, 4);
            if (imagen != null) {
                this.img.setIcon(new ImageIcon(imagen));
            } else {
                System.out.println("No se pudo cargar la imagen desde la URL proporcionada.");
            }
        } catch (Exception e) {
            // mensaje o algo para mostrarle al usuario
        }
    }

    // agregamos los eventos de mouse a los label 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        namePoke = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablepoke = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        etq_atras = new javax.swing.JLabel();
        etq_siguiente = new javax.swing.JLabel();
        img = new javax.swing.JLabel();

        namePoke.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        namePoke.setText("Indefinido");

        tablepoke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "N", "Habilidad", "URL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablepoke.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablepoke);
        if (tablepoke.getColumnModel().getColumnCount() > 0) {
            tablepoke.getColumnModel().getColumn(0).setResizable(false);
            tablepoke.getColumnModel().getColumn(1).setResizable(false);
            tablepoke.getColumnModel().getColumn(2).setResizable(false);
        }

        etq_atras.setText("BTN-A");

        etq_siguiente.setText("BTN-D");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etq_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(etq_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 33, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(etq_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(etq_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(namePoke)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(namePoke)
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etq_atras;
    private javax.swing.JLabel etq_siguiente;
    private javax.swing.JLabel img;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel namePoke;
    private javax.swing.JTable tablepoke;
    // End of variables declaration//GEN-END:variables
}
