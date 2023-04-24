import javax.swing.JFrame;
import javax.print.DocFlavor.STRING;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Registro_persona extends JFrame {
    private JTextField inputName;
    private JTextField inputcedula;
    private JTextField inputdireccion;
    Persona listaVendedores[];
    public Registro_persona(){
        initComponents();
    }
    public void initComponents(){
        setVisible(true);
        setTitle("REGISTRO CLIENTE");
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel container=new JPanel();
        container.setLayout(new GridBagLayout());

        JLabel datos=new JLabel("DATOS:");
        GridBagConstraints restriccion=new GridBagConstraints();

        restriccion.gridx=0;
        restriccion.gridy=0;
        restriccion.gridheight=1;
        restriccion.gridwidth=1;
        restriccion.weighty=1;
        restriccion.weightx=1;
        restriccion.fill=GridBagConstraints.BOTH;
        container.add(datos,restriccion);
        
        JLabel nombre=new JLabel("NOMBRES:");
        restriccion.gridx=0;
        restriccion.gridy=1;
        restriccion.gridheight=1;
        restriccion.gridwidth=1;
        restriccion.weighty=1;
        restriccion.weightx=1;
        restriccion.fill=GridBagConstraints.BOTH;
        container.add(nombre,restriccion);

         inputName=new JTextField();
        restriccion.gridx=1;
        restriccion.gridy=1;
        restriccion.gridheight=1;
        restriccion.gridwidth=1;
        restriccion.weighty=1;
        restriccion.weightx=1;
        restriccion.fill=GridBagConstraints.BOTH;
        container.add(inputName,restriccion);
        // this.dispose();
        JLabel cedula=new JLabel("Cedula:");
        restriccion.gridx=0;
        restriccion.gridy=2;
        restriccion.gridheight=1;
        restriccion.gridwidth=1;
        restriccion.weighty=1;
        restriccion.weightx=1;
        restriccion.fill=GridBagConstraints.BOTH;
        container.add(cedula,restriccion);

        inputcedula=new JTextField();
        restriccion.gridx=1;
        restriccion.gridy=2;
        restriccion.gridheight=1;
        restriccion.gridwidth=1;
        restriccion.weighty=1;
        restriccion.weightx=1;
        restriccion.fill=GridBagConstraints.BOTH;
        container.add(inputcedula,restriccion);
        JLabel direccion=new JLabel("DIRECCION:");
        restriccion.gridx=0;
        restriccion.gridy=3;
        restriccion.gridheight=1;
        restriccion.gridwidth=1;
        restriccion.weighty=1;
        restriccion.weightx=1;
        restriccion.fill=GridBagConstraints.BOTH;
        container.add(direccion,restriccion);

        JTextField inputdireccion=new JTextField();
        restriccion.gridx=1;
        restriccion.gridy=3;
        restriccion.gridheight=1;
        restriccion.gridwidth=1;
        restriccion.weighty=1;
        restriccion.weightx=1;
        restriccion.fill=GridBagConstraints.BOTH;
        container.add(inputdireccion,restriccion);
        
        JButton btn=new JButton("ENVIAR");
        restriccion.gridx=0;
        restriccion.gridy=4;
        restriccion.gridheight=1;
        restriccion.gridwidth=4;
        restriccion.weighty=2;
        restriccion.weightx=2;
        restriccion.insets= new Insets(20, 0, 0, 0);
        restriccion.fill=GridBagConstraints.BOTH;
        container.add(btn,restriccion);

        ActionListener enviar_datos=new ActionListener() {
            public void actionPerformed(ActionEvent e){
                enviarDatos();
			}
        };
        btn.addActionListener(enviar_datos);
        add(container);
        revalidate();

    }
    public void enviarDatos(){
        setVisible(true);
        this.dispose();
    }
    public String getnombre(){
        String nombre=inputName.getText();
        return nombre;
    }
    public String getCedula(){
        String cedula=inputcedula.getText();
        return cedula;
    }
    public String getdireccion(){
        String addres=inputdireccion.getText();
        return addres;
    }
}
