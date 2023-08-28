<?php

defined('BASEPATH') or exit('No direct script access allowed');

class uptadeUsers extends CI_Model
{
    // esta funcion se encarga de mostrar la lista de los usuarios que se encuentran registrados
    public function ListaUser()
    {
        $this->db->select("cedula,email,tipo, estado");
        $listenUser = $this->db->get('usuarios')->result();

        // Comprueba si se obtuvieron resultados
        if (!empty($listenUser)) {
            return $listenUser;
        } else {

            return array();
        }
    }

    public function editUser(){
        
    }
}