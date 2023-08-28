<?php

defined('BASEPATH') or exit('No direct script access allowed');

class deleteUserModel extends CI_Model
{

    public function listaUsers()
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
    public function deleteUsers($cedula)
    {
        // eliminamos el usuario con todos sus datos si el dato de la cedula es correcta
        $this->db->where('cedula', $cedula);
        $respuesta1 = $this->db->delete('personas');
        $this->db->where('cedula', $cedula);
        $respuesta2 = $this->db->delete('usuarios');
        // hacemos la condicion para returnar valores dependiendo de la respuesta que de 
        if ($respuesta1 && $respuesta2) {
            return true;
        } else {
            false;
        }
    }
    // creamo un metodo para hacer la eliminacion  de un usuario en expecifico 
    public function buscar_personas($busqueda)
    {
        // Realiza la consulta de búsqueda en la base de datos, puedes personalizarla según tus necesidades
        $this->db->like('cedula', $busqueda);
        $this->db->or_like('email', $busqueda);
        
        $respuesta = $this->db->get('usuarios');

        // aqui retornamos los valores de el usuario a buscar
        return $respuesta->result();
    }

}