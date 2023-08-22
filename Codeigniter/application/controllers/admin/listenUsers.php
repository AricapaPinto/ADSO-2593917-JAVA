<?php
defined('BASEPATH') or exit('No direct script acces allowed');

class listenUsers extends CI_Controller
{

    public function getListenUsers()
    {
        $this->load->model('ListenUsersModel');
        // cargamos el inicio de sesion 
        $datos['session'] = $this->session->userdata("session-mvc");
        // cargamos el model para usar el metodo de mostrar los datos del usuario 

        // creamos una variable data para usar la variable creada para mostrar todos los datos de los usuarios registrados 


        $respuesta = $this->ListenUsersModel->getUserListen();

        $datos['lista'] = $respuesta;

        // Verifica los datos que se obtienen del modelo


        // ahora cargamos los datos a la vista la cual queremos mostrar 
        $this->load->view('admin/verUsuarios', $datos); // y le mandamos la variable data para usar la variable user para mostrar los datos a dicha vista 
    }
    
}