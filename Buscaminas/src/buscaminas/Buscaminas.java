package buscaminas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Buscaminas extends JFrame {

    JLabel etiqueta_minas;
    JLabel etiqueta_tiempo;
    JButton btn_happy;
    JButton tablero[][];
    int tablero_interno[][];
    int minas;

    public Buscaminas() {
        this.minas = 20;
        this.tablero_interno = new int[9][9];
        crearTablero();

        initComponents();
    }

    public void initComponents() {
        setTitle("BuscaMinas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        Image icono = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/icono_bomba.png"));
        setIconImage(icono);

        JPanel contenedor = new JPanel();
        GridBagLayout capa = new GridBagLayout();
        contenedor.setLayout(capa);
        contenedor.setBorder(new EmptyBorder(10, 10, 10, 10));

        GridBagConstraints restriccion = new GridBagConstraints();

        // Creando Etiqueta Minas
        this.etiqueta_minas = new JLabel("0" + this.minas, SwingConstants.CENTER);
        this.etiqueta_minas.setOpaque(true);
        this.etiqueta_minas.setBackground(Color.BLACK);
        this.etiqueta_minas.setForeground(Color.red);
        this.etiqueta_minas.setFont(new Font("Arial", Font.BOLD, 30));
        this.etiqueta_minas.setBorder(new EmptyBorder(5, 10, 5, 10));
        restriccion.gridx = 0;
        restriccion.gridy = 0;
        restriccion.gridwidth = 3;
        restriccion.gridheight = 1;
        restriccion.weightx = 1;
        restriccion.weighty = 1;
        restriccion.fill = GridBagConstraints.CENTER;
        contenedor.add(this.etiqueta_minas, restriccion);

        // Creando Boton de Iniciar
        this.btn_happy = new JButton();
        Image img_iniciar = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/icono_happy.png"));
        img_iniciar = img_iniciar.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        this.btn_happy.setIcon(new ImageIcon(img_iniciar));
        this.btn_happy.setFocusable(false);
        this.btn_happy.setBorder(new EmptyBorder(10, 10, 10, 10));
        restriccion.gridx = 3;
        restriccion.gridy = 0;
        restriccion.gridwidth = 3;
        restriccion.gridheight = 1;
        restriccion.weightx = 1;
        restriccion.weighty = 1;
        restriccion.fill = GridBagConstraints.CENTER;
        contenedor.add(this.btn_happy, restriccion);

        // Creando etiqueta Tiempo
        this.etiqueta_tiempo = new JLabel("000", SwingConstants.CENTER);
        this.etiqueta_tiempo.setOpaque(true);
        this.etiqueta_tiempo.setBackground(Color.BLACK);
        this.etiqueta_tiempo.setForeground(Color.red);
        this.etiqueta_tiempo.setFont(new Font("Arial", Font.BOLD, 30));
        this.etiqueta_tiempo.setBorder(new EmptyBorder(5, 10, 5, 10));
        restriccion.gridx = 6;
        restriccion.gridy = 0;
        restriccion.gridwidth = 3;
        restriccion.gridheight = 1;
        restriccion.weightx = 1;
        restriccion.weighty = 1;
        restriccion.fill = GridBagConstraints.CENTER;
        contenedor.add(this.etiqueta_tiempo, restriccion);

        // Creando Botones - Mapa
        this.tablero = new JButton[9][9];
        for (int i = 0; i < this.tablero_interno.length; i++) {
            for (int j = 0; j < this.tablero_interno[0].length; j++) {
                Image img_blanco = getToolkit()
                        .createImage(ClassLoader.getSystemResource("imagenes/icono_espacio.png"));
                img_blanco = img_blanco.getScaledInstance(20, 20, Image.SCALE_SMOOTH);

                this.tablero[i][j] = new JButton();
                this.tablero[i][j].setIcon(new ImageIcon(img_blanco));
                this.tablero[i][j].setFocusable(false);
                restriccion.gridx = j;
                restriccion.gridy = i + 1;
                restriccion.gridwidth = 1;
                restriccion.gridheight = 1;
                restriccion.weightx = 1;
                restriccion.weighty = 1;
                restriccion.fill = GridBagConstraints.BOTH;
                contenedor.add(this.tablero[i][j], restriccion);

                final int fila = i;
                final int columna = j;
                ActionListener evento = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        destaparCasilla(fila, columna);
                        destaparTodasLasCasillas(fila, columna);

                    }
                };
                this.tablero[i][j].addActionListener(evento);
            }
        }
        //LE CREAMOS EL EVENTO AL BOTON PARA QUE SE REINICIE
        ActionListener reinicio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < tablero_interno.length; i++) {
                    for (int j = 0; j < tablero_interno[0].length; j++) {
                        tablero_interno[i][j] = 0;
                    }
                }
                taparTablero();
                System.out.println("");
                crearTablero();
            }
        };
        btn_happy.addActionListener(reinicio);
        add(contenedor);
        revalidate();
        setVisible(true);
    }

    public void destaparCasilla(int fila, int columna) {
        // Es una casilla en blanco
        if (this.tablero_interno[fila][columna] == 0) {
            Image img_blanco = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/icono_espacio.png"));
            img_blanco = img_blanco.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            this.tablero[fila][columna].setDisabledIcon(new ImageIcon(img_blanco));
            this.tablero[fila][columna].setEnabled(false);
            destaparCasillaLibre(fila, columna);
            // Completar Algoritmo
            // XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            // XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        }

        // Es un numero
        if (this.tablero_interno[fila][columna] >= 1 && this.tablero_interno[fila][columna] <= 8) {
            // lo que hace esata linea de codigo esque se encarga de descojer la imagen
            // correspondiente al lo que es fila y colunna por eso se agrega el mas para que
            // la iagen autocomplete el numero que se se le manda y buqe la imagen co ese
            // nombre que se le mando
            Image img_numero = getToolkit().createImage(ClassLoader
                    .getSystemResource("imagenes/icono_num_" + this.tablero_interno[fila][columna] + ".png"));
            img_numero = img_numero.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            this.tablero[fila][columna].setDisabledIcon(new ImageIcon(img_numero));
            this.tablero[fila][columna].setEnabled(false);
        }

        // Es una mina
        if (this.tablero_interno[fila][columna] == 9) {

            Image img_bomba = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/icono_bomba.png"));
            img_bomba = img_bomba.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            this.tablero[fila][columna].setDisabledIcon(new ImageIcon(img_bomba));
            this.tablero[fila][columna].setEnabled(false);
            // Completar Algoritmo
            // XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
            // XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        }
    }

    public void crearTablero() {
        int contador = 0;
        while (contador < this.minas) {
            // aqui se crean los numeros aleatorios
            // aqui estahaciendo un numero de 0 hasta el tamaño del trablero menor uno
            int fila = (int) (Math.random() * (this.tablero_interno.length - 1));
            // System.out.println("[ "+fila+"]");

            int columna = (int) (Math.random() * (this.tablero_interno[0].length - 1));

            if (this.tablero_interno[fila][columna] == 0) {
                this.tablero_interno[fila][columna] = 9;
                contador++;
            }
        }

        completarTableroConNumeros();

        for (int i = 0; i < this.tablero_interno.length; i++) {
            for (int j = 0; j < this.tablero_interno[0].length; j++) {
                System.out.print("[" + this.tablero_interno[i][j] + "]");
            }
            System.out.println();
        }
    }

    public void completarTableroConNumeros() {
        int limite_filas = this.tablero_interno.length;
        int limite_columnas = this.tablero_interno[0].length;

        for (int i = 0; i < limite_filas; i++) {
            for (int j = 0; j < limite_columnas; j++) {
                if (this.tablero_interno[i][j] == 0) {
                    int contador = 0;

                    if (i - 1 >= 0 && j - 1 >= 0 && this.tablero_interno[i - 1][j - 1] == 9) {
                        contador++;
                    }

                    if (i - 1 >= 0 && this.tablero_interno[i - 1][j] == 9) {
                        contador++;
                    }

                    if (i - 1 >= 0 && j + 1 < limite_columnas && this.tablero_interno[i - 1][j + 1] == 9) {
                        contador++;
                    }

                    if (j - 1 >= 0 && this.tablero_interno[i][j - 1] == 9) {
                        contador++;
                    }

                    if (j + 1 < limite_columnas && this.tablero_interno[i][j + 1] == 9) {
                        contador++;
                    }

                    if (i + 1 < limite_filas && j - 1 >= 0 && this.tablero_interno[i + 1][j - 1] == 9) {
                        contador++;
                    }

                    if (i + 1 < limite_filas && this.tablero_interno[i + 1][j] == 9) {
                        contador++;
                    }

                    if (i + 1 < limite_filas && j + 1 < limite_columnas && this.tablero_interno[i + 1][j + 1] == 9) {
                        contador++;
                    }
                    this.tablero_interno[i][j] = contador;
                }
            }
        }

    }

    public void destaparCasillaLibre(int fila, int columna) {
        // Comprobar si la casilla en la posición (fila-1, columna-1) está dentro del
        // tablero y habilitada
        if (fila - 1 >= 0 && columna - 1 >= 0 && tablero[fila - 1][columna - 1].isEnabled()) {
            // Si cumple las condiciones, destapar la casilla
            destaparCasilla(fila - 1, columna - 1);
        }

        // Comprobar si la casilla en la posición (fila-1, columna) está dentro del
        // tablero y habilitada
        if (fila - 1 >= 0 && tablero[fila - 1][columna].isEnabled()) {
            // Si cumple las condiciones, destapar la casilla
            destaparCasilla(fila - 1, columna);
        }

        // Comprobar si la casilla en la posición (fila-1, columna+1) está dentro del
        // tablero y habilitada
        if (fila - 1 >= 0 && columna + 1 < tablero[0].length && tablero[fila - 1][columna + 1].isEnabled()) {
            // Si cumple las condiciones, destapar la casilla
            destaparCasilla(fila - 1, columna + 1);
        }

        // Comprobar si la casilla en la posición (fila, columna-1) está dentro del
        // tablero y habilitada
        if (columna - 1 >= 0 && tablero[fila][columna - 1].isEnabled()) {
            // Si cumple las condiciones, destapar la casilla
            destaparCasilla(fila, columna - 1);
        }

        // Comprobar si la casilla en la posición (fila, columna+1) está dentro del
        // tablero y habilitada
        if (columna + 1 < tablero[0].length && tablero[fila][columna + 1].isEnabled()) {
            // Si cumple las condiciones, destapar la casilla
            destaparCasilla(fila, columna + 1);
        }

        // Comprobar si la casilla en la posición (fila+1, columna-1) está dentro del
        // tablero y habilitada
        if (fila + 1 < tablero.length && columna - 1 >= 0 && tablero[fila + 1][columna - 1].isEnabled()) {
            // Si cumple las condiciones, destapar la casilla
            destaparCasilla(fila + 1, columna - 1);
        }

        // Comprobar si la casilla en la posición (fila+1, columna) está dentro del
        // tablero y habilitada
        if (fila + 1 < tablero.length && tablero[fila + 1][columna].isEnabled()) {
            // Si cumple las condiciones, destapar la casilla
            destaparCasilla(fila + 1, columna);
        }

        // Comprobar si la casilla en la posición (fila+1, columna+1) está dentro del
        // tablero y habilitada
        if (fila + 1 < tablero.length && columna + 1 < tablero[0].length
                && tablero[fila + 1][columna + 1].isEnabled()) {
            // Si cumple las condiciones, destapar la casilla
            destaparCasilla(fila + 1, columna + 1);
        }
    }

    public void destaparTodasLasCasillas(int filas, int columnas) {
        //int iterador = 0;
        // lo que hacemos aca es preguntar que si la casilla que el toco es igual a 9 ose 
        //la mina que destape todo el areglo
        //1 recorremos el areglo 
        if (this.tablero_interno[filas][columnas] == 9) {
            //this.tablero[filas][columnas].setBackground(Color.RED);
            for (int i = 0; i < this.tablero_interno.length; i++) {
                for (int j = 0; j < this.tablero_interno[0].length; j++) {
                    //iterador++;
                    //hacemos llamado a la funcion destapar casilla libre que se encargar de destapar todas la casillas libres
                    destaparCasillaLibre(i, j);
                    //System.out.println("HAS TOCADO UNA MINA DESTAPALAS TODAS" + iterador);
                }
            }
            //cambiamos la imagen del boton para que sepa que perdio
            Image img_perdio = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/icono_triste.png"));
            img_perdio = img_perdio.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
            this.btn_happy.setIcon(new ImageIcon(img_perdio));

        }
    }

    public void taparTablero() {
        //cambiamos la imagen del boton a feliz de nuevo 
        Image img_feliz = getToolkit().createImage(ClassLoader.getSystemResource("imagenes/icono_happy.png"));
        img_feliz = img_feliz.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        this.btn_happy.setIcon(new ImageIcon(img_feliz));
        for (int i = 0; i < this.tablero_interno.length; i++) {

            for (int j = 0; j < this.tablero_interno[0].length; j++) {
                this.tablero[i][j].setEnabled(true);
            }
        }
    }

}
