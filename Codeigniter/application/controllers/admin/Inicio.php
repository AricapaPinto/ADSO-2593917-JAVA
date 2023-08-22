<?php
defined('BASEPATH') or exit('No direct script access allowed');

class Inicio extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        $validacion = $this->session->has_userdata("session-mvc");
        if ($validacion) {
            $session = $this->session->userdata("session-mvc");
            if ($session['tipo'] == "ADMIN" && $session['estado'] == "ACTIVO") {
                return false;
            } else {
                redirect('Login/cerrarSession', 'refresh');
                die();
            }
        } else {
            redirect('Login/cerrarSession', 'refresh');
        }
    }
    // estos metodos solo lo utilizan solo el abministrador ya que el es el que se encrga de manejar la aplicacion

    public function openCreateUser()
    {
        $data['session'] = $this->session->userdata("session-mvc");
        $this->load->view('admin/crearUsuario', $data);
    }

    
    public function index()
    {
        /* creo que este pedaso de codigo es para que hagamos la validacion de inicio de sesion y no 
        permitir que inicie navegue en las demas paginas hasta que no se logue */
        $data['session'] = $this->session->userdata;
        $this->load->view('admin/inicio');
    }

}