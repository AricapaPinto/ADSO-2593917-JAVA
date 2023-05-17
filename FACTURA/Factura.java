import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Factura extends JFrame {
    // atributos
    public Persona aregloPersonas[];
    private Persona aregloVendedores[];
    private Productos listaProductos[];
    public JTextField input_cedula;
    public JTextField input_nombre;
    public JTextField input_calle;
    private JButton buscar;
    private JTextField input_cedula_search;
    private JTextField input_n;
    private JTextField id;
    private JTextField nomb;
    private JTextField canti;
    private JButton agregar;
    private JLabel resultado;
    private JLabel Label1;
    private int totalPagar = 0;


    public Factura(Persona aregloPersonas[], Persona aregloVendedores[], Productos listaProductos[]) {
        this.aregloVendedores = aregloVendedores;
        this.aregloPersonas = aregloPersonas;
        this.listaProductos = listaProductos;
        initComponents();
    }

    public void initComponents() {

        setVisible(true);

        setSize(500, 700);

        setTitle("FACTURA");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // este es el contenedor donde se ve toda la ventana aunq no se haga visible
        JPanel container = new JPanel();
        container.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        // creamos la capa que es donde va a tener los input botones y demas
        container.setLayout(new GridBagLayout());

        // añadimos el contenido

        JLabel d_cliente = new JLabel("DATOS CLIENTE");
        // le añadimos tamaño a la letra
        Font fuente = new Font("Arial", Font.BOLD, 16);
        d_cliente.setFont(fuente);
        GridBagConstraints restriccion = new GridBagConstraints();
        // d_cliente.setVerticalAlignment(JLabel.TOP);
        // d_cliente.setBorder(BorderFactory.createLineBorder(Color.yellow,2));
        restriccion.gridx = 0;
        restriccion.gridy = 0;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 4;
        restriccion.weighty = 1;
        restriccion.weightx = 100;
        restriccion.insets = new Insets(0, 0, 20, 0);
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(d_cliente, restriccion);

        JLabel cedula = new JLabel("CEDULA:");
        fuente = new Font("Arial", Font.BOLD, 15);
        cedula.setFont(fuente);
        // cedula.setBorder(BorderFactory.createLineBorder(Color.blue,2));
        restriccion.gridx = 0;
        restriccion.gridy = 1;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 10;
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(cedula, restriccion);

        // creamos el text field
        input_cedula = new JTextField();
        // input_cedula.setBorder(BorderFactory.createLineBorder(Color.red,2));

        restriccion.gridx = 1;
        restriccion.gridy = 1;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 2;
        restriccion.weighty = 1;
        restriccion.weightx = 80;
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(input_cedula, restriccion);

        // creamos el boton
        buscar = new JButton("BUSCAR");
        Cursor manito = new Cursor(Cursor.HAND_CURSOR);
        buscar.setCursor(manito);
        // buscar.setFont(fuente);
        // buscar.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        restriccion.gridx = 3;
        restriccion.gridy = 1;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 10;
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(buscar, restriccion);

        // creamos el nombre
        JLabel nombres = new JLabel("NOMBRES:");
        nombres.setFont(fuente);
        // nombres.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        restriccion.gridx = 0;
        restriccion.gridy = 2;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 10;
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(nombres, restriccion);

        // creamos le input del nombre

        input_nombre = new JTextField();
        // input_nombre.setBorder(BorderFactory.createLineBorder(Color.yellow,2));

        restriccion.gridx = 1;
        restriccion.gridy = 2;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 3;
        restriccion.weighty = 1;
        restriccion.weightx = 90;
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(input_nombre, restriccion);

        // agreamos la dirreecion
        JLabel addres = new JLabel("DIRECCION:");
        addres.setFont(fuente);
        // addres.setBorder(BorderFactory.createLineBorder(Color.red,2));
        restriccion.gridx = 0;
        restriccion.gridy = 3;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 10;
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(addres, restriccion);

        input_calle = new JTextField();
        // input_calle.setBorder(BorderFactory.createLineBorder(Color.blue,2));

        restriccion.gridx = 1;
        restriccion.gridy = 3;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 3;
        restriccion.weighty = 1;
        restriccion.weightx = 90;
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(input_calle, restriccion);

        // creamos el jLabel
        JLabel vendedor = new JLabel("DATOS VENDEDOR:");
        vendedor.setFont(fuente);
        // vendedor.setBorder(BorderFactory.createLineBorder(Color.blue,2));

        restriccion.gridx = 0;
        restriccion.gridy = 4;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 4;
        restriccion.weighty = 1;
        restriccion.weightx = 100;
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(vendedor, restriccion);

        // CREAMOS EL BUSCADOR DE CEDUILA AQUI EMPIZA

        JLabel search_cedula = new JLabel("CEDULA:");
        search_cedula.setFont(fuente);
        // search_cedula.setBorder(BorderFactory.createLineBorder(Color.blue,2));

        restriccion.gridx = 0;
        restriccion.gridy = 5;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 10;
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(search_cedula, restriccion);
        // creamos el text field

        input_cedula_search = new JTextField();
        // input_cedula_search.setBorder(BorderFactory.createLineBorder(Color.red,2));
        restriccion.gridx = 1;
        restriccion.gridy = 5;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 2;
        restriccion.weighty = 1;
        restriccion.weightx = 80;
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(input_cedula_search, restriccion);

        // creamos el boton
        JButton buscar_cedula = new JButton("BUSCAR");

        buscar_cedula.setCursor(manito);
        // buscar_cedula.setFont(fuente);
        // buscar_cedula.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        restriccion.gridx = 3;
        restriccion.gridy = 5;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 10;
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(buscar_cedula, restriccion);

        // seguimos con el label

        JLabel names = new JLabel("NOMBRES:");
        names.setFont(fuente);
        // names.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        restriccion.gridx = 0;
        restriccion.gridy = 6;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 20;
        restriccion.fill = GridBagConstraints.BOTH;

        container.add(names, restriccion);

        input_n = new JTextField();
        // input_n.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));

        restriccion.gridx = 1;
        restriccion.gridy = 6;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 3;
        restriccion.weighty = 1;
        restriccion.weightx = 80;
        restriccion.fill = GridBagConstraints.BOTH;

        container.add(input_n, restriccion);

        JLabel productos = new JLabel("PRODUCTOS:");
        fuente = new Font("Arial", Font.BOLD, 25);
        // productos.setBorder(BorderFactory.createLineBorder(Color.red,2));
        restriccion.gridx = 0;
        restriccion.gridy = 7;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 4;
        restriccion.weighty = 1;
        restriccion.weightx = 100;
        restriccion.insets = new Insets(20, 0, 0, 0);
        restriccion.fill = GridBagConstraints.BOTH;

        container.add(productos, restriccion);

        JLabel identificador = new JLabel("ID");
        // identificador.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        restriccion.gridx = 0;
        restriccion.gridy = 8;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 20;
        restriccion.fill = GridBagConstraints.BOTH;

        container.add(identificador, restriccion);

        // number
        JLabel name = new JLabel("Nombre");
        // identificador.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        restriccion.gridx = 1;
        restriccion.gridy = 8;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 60;
        restriccion.fill = GridBagConstraints.BOTH;

        container.add(name, restriccion);

        JLabel cant = new JLabel("Cant");
        // identificador.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        restriccion.gridx = 2;
        restriccion.gridy = 8;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 20;
        restriccion.fill = GridBagConstraints.BOTH;

        container.add(cant, restriccion);

        // primero boton

        id = new JTextField();
        // id.setBorder(BorderFactory.createLineBorder(Color.red,2));

        restriccion.gridx = 0;
        restriccion.gridy = 9;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 20;
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(id, restriccion);
        // segundo
        nomb = new JTextField();
        // nomb.setBorder(BorderFactory.createLineBorder(Color.red,2));

        restriccion.gridx = 1;
        restriccion.gridy = 9;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 50;
        restriccion.fill = GridBagConstraints.BOTH;

        container.add(nomb, restriccion);
        // tercero
        canti = new JTextField();
        // canti.setBorder(BorderFactory.createLineBorder(Color.blue,2));

        restriccion.gridx = 2;
        restriccion.gridy = 9;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 10;
        restriccion.fill = GridBagConstraints.BOTH;

        container.add(canti, restriccion);

        agregar = new JButton("AGREGAR");
        agregar.setCursor(manito);
        // agregar.setBorder(BorderFactory.createLineBorder(Color.red,2));
        restriccion.gridx = 3;
        restriccion.gridy = 9;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 1;
        restriccion.weighty = 1;
        restriccion.weightx = 20;

        restriccion.fill = GridBagConstraints.BOTH;

        // agregamos el evento hover

        agregar.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                agregar.setBackground(Color.ORANGE);
            }

            public void mouseExited(MouseEvent e) {
                agregar.setBackground(UIManager.getColor("Button.background"));
            }
        });

        container.add(agregar, restriccion);

        resultado = new JLabel("----");
        resultado.setHorizontalAlignment(SwingConstants.RIGHT);
        // resultado.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
        resultado.setOpaque(true);
        resultado.setBackground(Color.white);
        // resultado.setBorder(BorderFactory.createLineBorder(Color.blue,2));

        restriccion.gridx = 0;
        restriccion.gridy = 10;
        restriccion.gridheight = 1;
        restriccion.gridwidth = 4;
        restriccion.weighty = 20;
        restriccion.weightx = 100;
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(resultado, restriccion);

        Label1 = new JLabel("TOTAL: $ 0");
        Label1.setHorizontalAlignment(SwingConstants.RIGHT);
        Border borde = new EmptyBorder(10, 10, 10, 10);
        Label1.setBorder(borde);
        // Label1.setBorder(BorderFactory.createLineBorder(Color.yellow,2));
        Label1.setOpaque(true);
        Label1.setBackground(Color.white);
        restriccion.gridx = 0;
        restriccion.gridy = 11;
        restriccion.gridheight = 0;
        restriccion.gridwidth = 4;
        restriccion.weighty = 10;
        restriccion.weightx = 100;
        restriccion.insets = new Insets(0, 0, 0, 0);
        restriccion.fill = GridBagConstraints.BOTH;
        container.add(Label1, restriccion);

        // Creo los eventos para buscar el cliente si esta registrado o no
        ActionListener buscadorCliente = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarCliente();
            }
        };

        buscar.addActionListener(buscadorCliente);
        ActionListener buscarVendedor = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarVendedor();
            }
        };
        buscar_cedula.addActionListener(buscarVendedor);
        ActionListener eventoAgregarProductos = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AgregarProducto();
            }
        };
        agregar.addActionListener(eventoAgregarProductos);
        // actionKeylistener
        KeyListener eventoKeyBuscarCliente = new KeyListener() {
            public void keyPressed(KeyEvent e) {
            }
            
            public void keyReleased(KeyEvent e) {
                String texto = input_cedula.getText();
                if (texto.equalsIgnoreCase("")) {
                    input_nombre.setText("");
                    input_calle.setText("");
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
        id.addKeyListener(buscarProductos);
        input_cedula.addKeyListener(eventoKeyBuscarCliente);
        input_cedula_search.addKeyListener(eventoKeyBuscarVendedor);
        deshabilitarInput(id);
        deshabilitarInput(canti);
        deshabilitarInput(nomb);
        deshabilitarInput(this.input_nombre);
        deshabilitarInput(this.input_calle);

        // no mover siempre de ultimo
        add(container);
        revalidate();
    }

    public void buscarCliente() {
        boolean encontrado = false;
        String texto = input_cedula.getText();
        if (!texto.equalsIgnoreCase("")) {
            for (int i = 0; i < this.aregloPersonas.length; i++) {
                if (this.aregloPersonas[i] != null && this.aregloPersonas[i].getCedula().equalsIgnoreCase(texto)) {
                    encontrado = true;
                    this.input_nombre.setText(this.aregloPersonas[i].getNombre());
                    this.input_calle.setText(this.aregloPersonas[i].getDireccion());
                    System.out.println(this.aregloPersonas[i].getNombre());
                    System.out.println(this.aregloPersonas[i].getDireccion());
                    break;
                }
            }
            if (encontrado) {
                deshabilitarInput(this.input_nombre);
                deshabilitarInput(input_calle);
                this.input_cedula_search.requestFocus();

            } else {
                // isntanciamos la ventana de registros
                // isntanciamos la ventana de registros
                setVisible(false);
                Registro_persona ventana = new Registro_persona(this, this.input_cedula.getText());
                this.input_cedula.setText("");

            }
        }

    }

    public void buscarVendedor() {
        boolean encontrado_vendedor = false;
        String vendedor = input_cedula_search.getText();
        for (int i = 0; i < aregloVendedores.length; i++) {
            if (this.aregloVendedores[i] != null && this.aregloVendedores[i].getCedula().equalsIgnoreCase(vendedor)) {
                encontrado_vendedor = true;
                this.input_n.setText(aregloVendedores[i].getNombre());
                break;
            }
        }
        if (encontrado_vendedor) {
            // System.out.print(" se encontro");
            habilitarInput(id);
            habilitarInput(canti);
            deshabilitarInput(input_n);
            // agregar.setEnabled(true);
        } else {
            // System.out.print(" no se encontro");
            // agregar.setEnabled(false);
            deshabilitarInput(id);
            deshabilitarInput(canti);
            habilitarInput(input_n);
        }
    }

    // Busqueda de productos
    public void busquedaProductos() {
        String unico = id.getText();
        boolean encontrado = false;
        if (!unico.equalsIgnoreCase("")) {
            for (int i = 0; i < listaProductos.length; i++) {
                if (this.listaProductos[i] != null
                        && this.listaProductos[i].getIdentificador().equalsIgnoreCase(unico)) {
                    this.nomb.setText(this.listaProductos[i].getName());
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                this.nomb.setText("No encontrado");
            }
        } else {
            this.nomb.setText("");
        }
    }








    public void AgregarProducto() {
        String textCant = canti.getText();
        String identificador = id.getText();
        int valorProducto=0;
        for (int i = 0; i < listaProductos.length; i++) {
            if (this.listaProductos[i] != null) {
                if (this.listaProductos[i].getIdentificador().equalsIgnoreCase(identificador)
                        && !canti.getText().equalsIgnoreCase("")) {
                    agregar.setEnabled(true);
                    int cantidad = Integer.parseInt(textCant);
                    valorProducto = this.listaProductos[i].getPrecio() * cantidad;
                    resultado.setText(resultado.getText() + "\n\n" + this.listaProductos[i].getIdentificador() + " --- "
                            + this.listaProductos[i].getName() + " --" + valorProducto + "  \n\n");
                    // agregamo el valor final de todos los productos comprados
                    revalidate();
                    break;
                }
            }
        }
        totalPagar = totalPagar+valorProducto;
        System.out.print(totalPagar);
        Label1.setText("TOTAL $: "+Integer.toString(totalPagar));
    }

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

}