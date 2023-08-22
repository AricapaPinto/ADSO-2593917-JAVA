<?php
defined('BASEPATH') or exit('No direct script acces allowed');

// creamos la clase para insertar los datos 

final class InsertarUsuarioModel extends CI_Model{

    public function setInsertUser($cedula, $email, $password, $tipo){
        // creamos un areglo para insertados todos de una vez
        $datos = array(
            'cedula' => $cedula,
            'email' => $email,
            'password' => md5($password),
            'tipo' => $tipo,
            'estado' => "ACTIVO"
        );
        // ahora metemos el nombre de la tabla en  la cual vamos a insertar los datos 

        $tabla = 'usuarios';
        // Insertar los datos en la tabla
        $this->db->insert($tabla, $datos);

        // Verificar si la inserción fue exitosa
        // el metodo affected_rows() es para mirar cuantas de la filas de la base de datos fueron afectadas ahi me doy cuenta si se inserto corectamente la insercion de loos datos 
        $numeros_columnas = $this->db->affected_rows();

        if ($numeros_columnas === count($datos)) {
            return true; // Todos los datos se insertaron correctamente
        } else {
            return false; // Al menos una inserción falló
        }
        
    }
    // usamos un metodo para trae el tipo de usuario para que se puea registrar con lo que hay en la base de datos 
    

}