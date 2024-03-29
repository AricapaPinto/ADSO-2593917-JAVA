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
            if ($session['tipo'] == "VENDEDOR" && $session['estado'] == "ACTIVO") {
                return false;
            } else {
                redirect('Login/cerrarSession', 'refresh');
                die();
            }
        } else {
            redirect('Login/cerrarSession', 'refresh');
        }
    }
    public function index()
    {
        $this->load->view('vendedor/inicio');
    }

}