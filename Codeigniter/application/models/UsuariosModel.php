<!-- los model siempre el nombre del archivo va en mayuscula al principio
 -->
<?php

defined('BASEPATH') or exit('No direct script access allowed');

class UsuariosModel extends CI_Model
{
    // creamos la funcion para validar el ingreso de la persona 

    public function validarIngreso($email, $password)
    {
        // esto es como en php en estilo select pero con lo metodos que tiene codeignater
        $this->db->select('cedula,email,tipo,estado');
        // estas son las condicion es de validacion donde la contraseña y el email que le enviamos sea igual a la que le mandamos nosotros
        $this->db->where('email', $email);
        // como la contrasña en la base de datos esta incriptada la convertimos a incritada para que asi condisa con el md5 de la base que la tenemos programada haci
        $this->db->where('password', md5($password));
        $this->db->where('estado', 'ACTIVO');

        // Guardamos la respuesta en una varible 
        $registros = $this->db->get('usuarios')->result();

        // validos que la respuesta tenga almenos una respuesta con el sizeof  

        if (sizeof($registros) != 0) {
            return true;
        } else {
            return false;
        }
    }

    // creamos otra funcion para obtener los datos del usuarios por el email 
    public function getUsuariosByEmail($email){

        $this->db->select("cedula, tipo, estado");
        $this->db->where('email', $email);
        $registros = $this->db->get('usuarios')->result();

        if (sizeof($registros) != 0) {
            return $registros[0];
        } else {
            return null;
        }
    }

}