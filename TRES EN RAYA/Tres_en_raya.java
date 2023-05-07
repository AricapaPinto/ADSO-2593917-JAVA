import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tres_en_raya extends JFrame {
    private int TAM_TABLERO = 9;
    private String JUGADOR_X = "X";
    private String JUGADOR_O = "O";
    private String VACIO = "-";
    private JLabel tablero[];
    private boolean jugando;
    private int turno;

    public Tres_en_raya() {
        initComponets();
        Image icon = new ImageIcon("iconTres.png").getImage();
        // establecer el icono a la ventana
        setIconImage(icon);
        this.jugando = true;
        this.turno = 1;

    }

    public void initComponets() {
        setVisible(true);
        setSize(400, 400);
        setTitle("TRIKI");
        setLocationRelativeTo(null);
        setResizable(false);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Creamo el contenedor
        JPanel container = new JPanel();
        Border borde = new EmptyBorder(10, 10, 10, 10);
        container.setBorder(borde);
        container.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
        container.setLayout(new GridLayout(3, 3));

        tablero = new JLabel[TAM_TABLERO];
        for (int i = 0; i < tablero.length; i++) {
            tablero[i] = new JLabel();
            tablero[i].setFont(new Font("Arial", Font.BOLD, 60));
            tablero[i].setOpaque(true);
            tablero[i].setBackground(Color.WHITE);
            tablero[i].setHorizontalAlignment(JLabel.CENTER);
            tablero[i].setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
        }
        for (int i = 0; i < TAM_TABLERO; i++) {
            tablero[i].setText(VACIO);
        }
        // creamos la acion del Jlabel
        for (int i = 0; i < tablero.length; i++) {
            final int opcion_casilla = i;
            MouseAdapter eventoCambio = new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (jugando == true) {
                        validarCasilla(opcion_casilla);
                    }
                }
            };
            tablero[i].addMouseListener(eventoCambio);

            container.add(tablero[i]);
        }
        add(container);
        revalidate();
    }

    public String jugadorActual() {
        return (this.turno == 1) ? JUGADOR_X : JUGADOR_O;
    }

    public void validarCasilla(int casilla) {
        tablero[casilla].setEnabled(true);
        if (tablero[casilla].getText().equalsIgnoreCase("-")) {
            tablero[casilla].setText(JUGADOR_X);
            if (validarGanador()) {
                System.out.print("GANASTE JUGADOR X");
                this.jugando = false;
            } else {
                if (tablerolleno()) {
                    System.out.println("  ==== EMPATE ====");
                    this.jugando = false;
                } else {
                    turno = 2;
                }
            }
        } else {
            // No - Repetir jugada
            System.out.println("==> POSICION INVALIDA - OCUPADA.");
        }
        if (turno == 2) {
            turnoMaquina();
        }
    }

    public void turnoMaquina() {
        System.out.println("Turno de la máquina...");

        int posicion = movimientoMaquina();
        tablero[posicion].setText(JUGADOR_O);
        if (validarGanador()) {
            System.out.print("GANASTE JUGADO O");
            jugando = false;
        }
        turno = 1;
    }

    // verificamos los ganadores
    public boolean validarGanador() {
        if (this.tablero[0].getText().equalsIgnoreCase(this.tablero[1].getText())
                && tablero[0].getText().equalsIgnoreCase(tablero[2].getText())
                && !this.tablero[0].getText().equalsIgnoreCase("-")
                || this.tablero[3].getText().equalsIgnoreCase(this.tablero[4].getText())
                        && tablero[3].getText().equalsIgnoreCase(this.tablero[5].getText())
                        && !this.tablero[5].getText().equalsIgnoreCase("-")
                || this.tablero[6].getText().equalsIgnoreCase(this.tablero[7].getText())
                        && tablero[6].getText().equalsIgnoreCase(this.tablero[8].getText())
                        && !this.tablero[8].getText().equalsIgnoreCase("-")
                // validando los valores en forma de x
                || this.tablero[0].getText().equalsIgnoreCase(this.tablero[4].getText())
                        && tablero[0].getText().equalsIgnoreCase(this.tablero[8].getText())
                        && !this.tablero[0].getText().equalsIgnoreCase("-")
                || this.tablero[2].getText().equalsIgnoreCase(this.tablero[4].getText())
                        && tablero[2].getText().equalsIgnoreCase(this.tablero[6].getText())
                        && !this.tablero[6].getText().equalsIgnoreCase("-")
                || this.tablero[0].getText().equalsIgnoreCase(this.tablero[4].getText())
                        && tablero[0].getText().equalsIgnoreCase(this.tablero[8].getText())
                        && !this.tablero[0].getText().equalsIgnoreCase("-")
                // validando las de los lados
                || this.tablero[0].getText().equalsIgnoreCase(this.tablero[3].getText())
                        && tablero[0].getText().equalsIgnoreCase(this.tablero[6].getText())
                        && !this.tablero[0].getText().equalsIgnoreCase("-")
                || this.tablero[2].getText().equalsIgnoreCase(this.tablero[5].getText())
                        && tablero[2].getText().equalsIgnoreCase(this.tablero[8].getText())
                        && !this.tablero[2].getText().equalsIgnoreCase("-")
                || this.tablero[1].getText().equalsIgnoreCase(this.tablero[4].getText())
                        && tablero[1].getText().equalsIgnoreCase(this.tablero[7].getText())
                        && !this.tablero[1].getText().equalsIgnoreCase("-")) {
            return true;
        } else {
            return false;
        }
    }
    public boolean tablerolleno() {
        for (int i = 0; i < tablero.length; i++) {
            if (this.tablero[i].getText() == "-") {
                return false;
            }
        }
        return true;
        // return false;
    }
    // Buscar una jugada para bloquear al jugador y ganar tambien
    public boolean verificarGanador(String jugador) {
        // Comprobar las filas
        for (int i = 0; i < TAM_TABLERO; i += 3) {
            if (tablero[i].getText().equals(jugador) && tablero[i + 1].getText().equals(jugador) && tablero[i + 2].getText().equals(jugador)) {
                return true;
            }
        }
    
        // Comprobar las columnas
        for (int i = 0; i < 3; i++) {
            if (tablero[i].getText().equals(jugador) && tablero[i + 3].getText().equals(jugador) && tablero[i + 6].getText().equals(jugador)) {
                return true;
            }
        }
    
        // Comprobar las diagonales
        if (tablero[0].getText().equals(jugador) && tablero[4].getText().equals(jugador) && tablero[8].getText().equals(jugador)) {
            return true;
        }
        if (tablero[2].getText().equals(jugador) && tablero[4].getText().equals(jugador) && tablero[6].getText().equals(jugador)) {
            return true;
        }
    
        // Si no hay ganador, devolver false
        return false;
    }
    public int movimientoMaquina() {
        // Buscar una jugada ganadora para la máquina
        for (int i = 0; i < TAM_TABLERO; i++) {
            if (tablero[i].getText().equals(VACIO)) {
                tablero[i].setText(JUGADOR_O);
                if (verificarGanador(JUGADOR_O)) {
                    return i;
                }
                tablero[i].setText(VACIO);
            }
        }

        // Buscar una jugada para bloquear al jugador
        for (int i = 0; i < TAM_TABLERO; i++) {
            if (tablero[i].getText().equals(VACIO)) {
                tablero[i].setText(JUGADOR_X);
                if (verificarGanador(JUGADOR_X)) {
                    tablero[i].setText(JUGADOR_O);
                    return i;
                }
                tablero[i].setText(VACIO);
            }
        }

        // Buscar una jugada para que la máquina gane
        for (int i = 0; i < TAM_TABLERO; i++) {
            if (tablero[i].getText().equals(VACIO)) {
                tablero[i].setText(JUGADOR_O);
                if (verificarGanador(JUGADOR_O)) {
                    return i;
                }
                tablero[i].setText(VACIO);
            }
        }

        // Si no se encontró ninguna jugada ganadora o para bloquear al jugador,
        // realizar un movimiento aleatorio
        int posicion;
        do {
            posicion = (int) (Math.random() * TAM_TABLERO);
        } while (!tablero[posicion].getText().equals(VACIO));
        tablero[posicion].setText(JUGADOR_O);
        return posicion;
    }

}