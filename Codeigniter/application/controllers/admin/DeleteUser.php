<?php
defined('BASEPATH') or exit('No direct script access allowed');

class DeleteUser extends CI_Controller
{

    public function ObtenerUsers()
    {
        $this->load->model('deleteUserModel');
        // cargamos el inicio de sesion 
        $datos['session'] = $this->session->userdata("session-mvc");
        // cargamos el model para usar el metodo de mostrar los datos del usuario 

        // creamos una variable data para usar la variable creada para mostrar todos los datos de los usuarios registrados 


        $respuesta = $this->deleteUserModel->listaUsers();

        $datos['lista'] = $respuesta;
        // ahora cargamos los datos a la vista la cual queremos mostrar 
        $this->load->view('admin/eliminarUser', $datos);
    }

    public function eliminar($cedula)
    {
        // Cargamos el modelo de eliminación de usuarios
        $this->load->model('deleteUserModel');
        $datos['session'] = $this->session->userdata("session-mvc");
        // Intentamos eliminar al usuario
        $respuesta = $this->deleteUserModel->deleteUsers($cedula);


        // volvemos a cargar la lista 
        $respuesta = $this->deleteUserModel->listaUsers();
        $datos['lista'] = $respuesta;

        if ($respuesta) {
            $datos['exitoso'] = true;
        } else {
            // Manejar errores, si es necesario
            $datos['error'] = true;
        }
        $this->load->view('admin/eliminarUser', $datos); // Por ejemplo, redirige a la lista de usuarios
    }
    // agregamos un metodo para la busqueda individual de un usuario

    public function buscar()
    {
        $busqueda = $this->input->post('busqueda'); // Obtiene el valor del campo de búsqueda
        // Cargamos el modelo de eliminación de usuarios
        $this->load->model('deleteUserModel');
        $data['session'] = $this->session->userdata("session-mvc");
        // Intentamos eliminar al usuario

        // Llama al modelo para buscar personas
        $resultados = $this->deleteUserModel->buscar_personas($busqueda);

        // volvemos a cargar la lista 
        $respuesta = $this->deleteUserModel->listaUsers();
        $data['lista'] = $respuesta;
        // Pasa los resultados a la vista
        $data['resultados'] = $resultados;
        $this->load->view('admin/eliminarUser', $data);
    }

}