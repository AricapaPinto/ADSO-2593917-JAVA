<?php
defined('BASEPATH') or exit('No direct script acces allowed');


class ListenUsersModel extends CI_Model{

    // creamos el metodo para obtener los datos de los usuarios de nuestra base de datos 
    public function getUserListen(){
        $this->db->select("cedula,email,tipo, estado");
        $listenUser = $this->db->get('usuarios')->result();

        // Comprueba si se obtuvieron resultados
        if (!empty($listenUser)) {
            return $listenUser;
        } else {
            
            return array();
        }
    }
}