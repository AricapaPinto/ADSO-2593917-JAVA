import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Registro_persona extends JFrame {
    private JTextField inputName;
    private JTextField inputcedula;
    private JTextField inputdireccion;
    // Persona aregloPersonas[]=new Persona[10];
    Factura ventanaOriginal;
    String cedula;
    public Registro_persona(Factura ventanaOriginal,String cedula){
        this.ventanaOriginal=ventanaOriginal;
        this.cedula=cedula;
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
        restriccion.gridy=2;
        restriccion.gridheight=1;
        restriccion.gridwidth=1;
        restriccion.weighty=1;
        restriccion.weightx=1;
        restriccion.fill=GridBagConstraints.BOTH;
        container.add(nombre,restriccion);

        inputName=new JTextField();
        restriccion.gridx=1;
        restriccion.gridy=2;
        restriccion.gridheight=1;
        restriccion.gridwidth=1;
        restriccion.weighty=1;
        restriccion.weightx=1;
        restriccion.fill=GridBagConstraints.BOTH;
        container.add(inputName,restriccion);
        // this.dispose();
        JLabel cedula=new JLabel("Cedula:");
        restriccion.gridx=0;
        restriccion.gridy=1;
        restriccion.gridheight=1;
        restriccion.gridwidth=1;
        restriccion.weighty=1;
        restriccion.weightx=1;
        restriccion.fill=GridBagConstraints.BOTH;
        container.add(cedula,restriccion);

        inputcedula=new JTextField( this.cedula );
        inputcedula.setEnabled(false);
        inputcedula.setEditable(false);
        inputcedula.setDisabledTextColor(Color.black);
        restriccion.gridx=1;
        restriccion.gridy=1;
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

        inputdireccion=new JTextField();
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
                llenarAreglo();
			}
        };
        btn.addActionListener(enviar_datos);
        add(container);
        revalidate();

    }

    
    public void enviarDatos(){
       
        // this.ventanaOriginal.input_cedula.setText( this.inputcedula.getText() );
        // this.ventanaOriginal.input_nombre.setText( this.inputName.getText() );
        // this.ventanaOriginal.input_calle.setText( this.inputdireccion.getText() );
        setVisible(false);
        this.ventanaOriginal.setVisible(true);
        this.dispose();
    }
    public void llenarAreglo(){
        for (int i = 0; i < ventanaOriginal.aregloPersonas.length; i++) {
            ventanaOriginal.aregloPersonas[i]=new Persona(this.inputcedula.getText(),this.inputName.getText(),this.inputdireccion.getText());
        }
    }
    public String  convertirString(JTextField input){
        String texto=input.getText();
        return texto;
    }
}
