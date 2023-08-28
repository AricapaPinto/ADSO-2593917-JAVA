<?php

defined('BASEPATH') or exit('No direct script access allowed');

// creamos la clase para actulizar los datos de una persona

class UpdateUsers extends CI_Controller
{
    // metodo para cargar la vista 
    public function UsersListen(){
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
    public function UpdateUser(){
       
    }
}