<?php

defined('BASEPATH') or exit('No direct script access allowed');

// creamos la clase para actulizar los datos de una persona

class UpdateUsers extends CI_Controller
{
    // metodo para cargar la vista 
    public function UsersListen()
    {
        $this->load->model('deleteUserModel');
        // cargamos el inicio de sesion 
        $datos['session'] = $this->session->userdata("session-mvc");
        // cargamos el model para usar el metodo de mostrar los datos del usuario 

        // creamos una variable data para usar la variable creada para mostrar todos los datos de los usuarios registrados 


        $respuesta = $this->deleteUserModel->listaUsers();

        $datos['lista'] = $respuesta;

        // Verifica los datos que se obtienen del modelo


        // ahora cargamos los datos a la vista la cual queremos mostrar 
        $this->load->view('admin/actualizar', $datos); // y le mandamos la variable data para usar la variable user para mostrar los datos a dicha vista 
    }
    public function getCliente($cedula)
    {
        // Carga el modelo correspondiente para acceder a la base de datos
        $this->load->model('uptadeUsers');

        // Llama a una función en el modelo para obtener los datos del cliente
        $usuarioData = $this->uptadeUsers->obtenerDatosCliente($cedula);

        // Devuelve los datos del cliente en formato JSON 
        // eso es para poder procesar los datos en el formulario y cargarlo mediante el javascript 
        echo json_encode($usuarioData);
    }
    // creamos un metodo para actualizar los datos del usuario seleccionado

    // este recibe la cedula 

    public function actualizarPersona()
    {
        $this->load->model('deleteUserModel');
        // cargamos la sesion 
        $datos['session'] = $this->session->userdata("session-mvc");
        $cedula = $this->input->post("documento");
        $nuevosDatos = array(
            'nombre' => $this->input->post("nombres"),
            'apellido' => $this->input->post("apellidos"),
            'telefono' => $this->input->post("telefonos"),
            'direccion' => $this->input->post("direccion"),
            'correo' => $this->input->post("correo"),
        );
        // cargamos el modelo el cual le vamos a enviar los datos de actulizacion de dicho usuario 

        $this->load->model("uptadeUsers");

        $respuesta = $this->uptadeUsers->updatePersona($cedula, $nuevosDatos);

        $lista = $this->deleteUserModel->listaUsers();
        $datos['lista'] = $lista;
        if ($respuesta) {
            $datos['exitoso']=true;
        } else {
            $datos['error']=true;
        }
        $this->load->view('admin/actualizar', $datos);
    }
}