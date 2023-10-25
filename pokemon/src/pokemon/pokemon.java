package pokemon;

import java.awt.*;
// importamos la clase de Api para hacer la consulta de los pokemones
import clases.ConsumoAPI;
import clases.infoPokemon;
import com.google.gson.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class pokemon extends javax.swing.JFrame {

    public JsonObject temp;
    infoPokemon[] items = null;
    int total_pagina;
    int cargaPagina;
    int pasador;
    int[] listaPaginas;

    public pokemon() {
        int[] temp = {1, 2, 3, 4, 5, 6, 7, 8};
        this.listaPaginas = temp;
        // el total pagina es para poder saber cuatas pagins en totales estoy trayendo depediendo si los estpy trayendo de 25 o el limigte 
        // que quiera  muestre
        this.total_pagina = 52;
        initComponents();
        cargarPaginaPokemon(1);
        initAlternComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principal = new javax.swing.JPanel();
        titulo_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        scrollpokemon = new javax.swing.JScrollPane();
        lista = new javax.swing.JPanel();
        datatable = new javax.swing.JPanel();
        infoP = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("POKEDEX");

        javax.swing.GroupLayout titulo_panelLayout = new javax.swing.GroupLayout(titulo_panel);
        titulo_panel.setLayout(titulo_panelLayout);
        titulo_panelLayout.setHorizontalGroup(
            titulo_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titulo_panelLayout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jLabel1)
                .addContainerGap(232, Short.MAX_VALUE))
        );
        titulo_panelLayout.setVerticalGroup(
            titulo_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titulo_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        lista.setLayout(new javax.swing.BoxLayout(lista, javax.swing.BoxLayout.Y_AXIS));
        scrollpokemon.setViewportView(lista);

        datatable.setBackground(new java.awt.Color(0, 0, 102));
        datatable.setLayout(new javax.swing.BoxLayout(datatable, javax.swing.BoxLayout.LINE_AXIS));

        infoP.setBackground(new java.awt.Color(255, 153, 153));

        javax.swing.GroupLayout infoPLayout = new javax.swing.GroupLayout(infoP);
        infoP.setLayout(infoPLayout);
        infoPLayout.setHorizontalGroup(
            infoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        infoPLayout.setVerticalGroup(
            infoPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout principalLayout = new javax.swing.GroupLayout(principal);
        principal.setLayout(principalLayout);
        principalLayout.setHorizontalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titulo_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(datatable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(principalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollpokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(infoP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        principalLayout.setVerticalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalLayout.createSequentialGroup()
                .addComponent(titulo_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollpokemon, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                    .addComponent(infoP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datatable, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pokemon().setVisible(true);
            }
        });
    }

    public void initAlternComponents() {
        // le ponemos el titulo a nuestra ventana
        setLocationRelativeTo(null);
        setTitle("pokemon");
        // ponemos el de pokemon
        Image icono = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/pokeball.png"));
        setIconImage(icono);

        // aqui cargamos la primera pagina
    }
    // este metetodo va a recibir un metodo para cambiar de pagina y toca llamarlo en el init para poder inicar en la pagina 0

    // aqui es donde se cargan los botones aqui ejecutamos el codigo del pasador de pagina
    public void cargarPaginaPokemon(int pagina) {

        // removemos los botones que tiene actualmente para no mostrar los mismo 
        this.lista.removeAll();
        // aqui hacemos el calculo para poder cambiar de posicicin 
        this.cargaPagina = pagina;
        // aqui cargamos el paginador junto con los pokemones

        this.pasador = (cargaPagina - 1) * 25;

        // cargamos la informacion del pokemo paea mostrarlo en la lista en el pasador se le mandaria depediendo de la multiplicacion 
        String respuesta = ConsumoAPI.consumoGET("https://pokeapi.co/api/v2/pokemon?offset=+" + pasador + "&limit=25");

        // verificamos que la informacio solicidata no llegue vacia
        if (respuesta != null) {
            JsonObject objetoJson = JsonParser.parseString(respuesta).getAsJsonObject();
            JsonArray results = objetoJson.get("results").getAsJsonArray();

            /*creamos un metodo for que se encargara de mostrar la
            informacion de los pokemones solicitads*/
            this.items = new infoPokemon[results.size()];
            Gson gson = new Gson();
            for (int i = 0; i < results.size(); i++) {
                // creamo u objeto temporal llamado temp 

                items[i] = (infoPokemon) gson.fromJson((JsonElement) results.get(i).getAsJsonObject(), infoPokemon.class);
                // creamo los botones para mandarle los nombres y mostrarlos en el scroll
                JButton btn = new JButton(items[i].getNombre());
                // le añadimos estilos a los botones para que se vean de igual tamaño 

                btn.setFocusable(false);
                btn.setBackground(Color.white);
                btn.setPreferredSize(new Dimension(120, btn.getPreferredSize().height));
                btn.setMaximumSize(new Dimension(120, btn.getPreferredSize().height));
                int posicion = i;
                // ahora le agregamos los eventos a los botones para mostrar la informacion de dicho pokemon
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // metod para cambiar de pokemon 
                        cambiarPokemon(posicion);
                    }
                });
                lista.add(btn);
            }
            cargarPaginador();
            // este es para cambiar el pokemon en la pociion cero 
            cambiarPokemon(0);

            repaint();
            revalidate();

        }
    }

    public void cargarPaginador() {

        if (this.cargaPagina - 4 <= 0) {

            for (int j = 0; j < this.listaPaginas.length; j++) {
                this.listaPaginas[j] = j + 1;
            }
        } else if (this.cargaPagina - 4 > 0 && this.cargaPagina + 3 < this.total_pagina) {
            int inicia = this.cargaPagina - 3;
            for (int j = 0; j < this.listaPaginas.length; j++) {
                this.listaPaginas[j] = inicia;
                inicia++;
            }
        } else if (this.cargaPagina + 3 >= this.total_pagina) {
            for (int j = 0; j < this.listaPaginas.length; j++) {
                this.listaPaginas[j] = this.total_pagina - this.listaPaginas.length + j + 1;
            }
        }

        System.out.print("SE EJECUTO EL METODO");
        // SE REMUEVE TODO LO QUE HAY EN EL PANEL Y LE AGREGAMOS LOS BOTONES CON SUS RESPECTIVOS ACCIONES Y DECORACION

        this.datatable.removeAll();

        this.datatable.add(Box.createHorizontalGlue());

        JButton tempInicio = new JButton("<<");
        tempInicio.setFocusable(false);
        tempInicio.setBackground(Color.BLACK);
        tempInicio.setForeground(Color.YELLOW);
        tempInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pokemon.this.cargarPaginaPokemon((1));
            }
        });

        this.datatable.add(tempInicio);

        JButton tempAtras = new JButton("<");
        tempAtras.setFocusable(false);
        tempAtras.setBackground(Color.BLACK);
        tempAtras.setForeground(Color.YELLOW);
        tempAtras.setEnabled((pokemon.this.cargaPagina > 1));

        tempAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (pokemon.this.cargaPagina > 1) {
                    pokemon.this.cargarPaginaPokemon((pokemon.this.cargaPagina - 1));
                } else {
                    // condicion de cuando llegue el limite de toda la pagina 
                    System.out.println("NO SE PUEDE RETROCEDER");
                }
            }
        });
        this.datatable.add(tempAtras);

        for (int i = 0; i < this.listaPaginas.length; i++) {
            JButton temp = new JButton(((this.listaPaginas[i] < 10) ? "0" : "") + this.listaPaginas[i]);

            // JButton temp = new JButton(((i < 10) ? "0" : "") + i);
            System.out.println("Numero de pagina iterador" + i);
            temp.setFocusable(false);
            temp.setBackground((this.listaPaginas[i] == this.cargaPagina) ? Color.blue : Color.white);
            temp.setForeground((this.listaPaginas[i] == this.cargaPagina) ? Color.white : Color.black);
            final int pag = this.listaPaginas[i];
            temp.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // aqui se le manda el numero de pagina pag
                    System.out.println("HAS DADO CLIK EN UN BOTON PAGINADOR" + pag);
                    pokemon.this.cargarPaginaPokemon((pag));
                }
            });

            this.datatable.add(temp);
        }

        JButton tempSiguiente = new JButton(">");

        tempSiguiente.setFocusable(false);
        tempSiguiente.setBackground(Color.BLACK);

        tempSiguiente.setForeground(Color.YELLOW);

        tempSiguiente.setEnabled((pokemon.this.cargaPagina < pokemon.this.total_pagina));
        tempSiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (pokemon.this.cargaPagina < pokemon.this.total_pagina) {
                    // imprimos la varible para mirar que pagina estamos
                    System.out.println("numer page" + pokemon.this.cargaPagina);
                    pokemon.this.cargarPaginaPokemon((pokemon.this.cargaPagina + 1));
                } else {
                    System.out.println("NO SE PUEDE ADELANTAR");
                }
            }
        });

        this.datatable.add(tempSiguiente);

        JButton tempFinal = new JButton(">>");
        tempFinal.setFocusable(false);
        tempFinal.setBackground(Color.BLACK);
        tempFinal.setForeground(Color.YELLOW);
        tempFinal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pokemon.this.cargarPaginaPokemon(pokemon.this.total_pagina);
            }
        });

        this.datatable.add(tempFinal);

        this.datatable.add(Box.createHorizontalGlue());
        repaint();
        revalidate();
    }
    // metodo para pasar de pagina

    public void cambiarPokemon(int posicion) {
        infoPokemon item = items[posicion];
        System.out.println("SE ha dado Click");

        infoP.removeAll();
        // le mandamos la url del pokemon que queremos mostrar
        pokeInfo temporal = new pokeInfo(item);
        temporal.setSize(infoP.getSize());
        temporal.setPreferredSize(infoP.getPreferredSize());
        infoP.add(temporal);
        // repitamos para que se actulizen los datos mandados
        repaint();
        revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel datatable;
    private javax.swing.JPanel infoP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel lista;
    private javax.swing.JPanel principal;
    private javax.swing.JScrollPane scrollpokemon;
    private javax.swing.JPanel titulo_panel;
    // End of variables declaration//GEN-END:variables
}
