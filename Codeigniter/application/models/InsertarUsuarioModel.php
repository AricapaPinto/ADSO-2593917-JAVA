<?php
defined('BASEPATH') or exit('No direct script acces allowed');

// creamos la clase para insertar los datos 

final class InsertarUsuarioModel extends CI_Model{

    public function setInsertUser($cedula, $email, $password, $tipo, $nombres, $apellidos, $direccion, $telefono){

        $datosPersona = array(
            'cedula' => $cedula,
            'nombres' => $nombres,
            'apellidos' => $apellidos,
            'telefono' => $telefono,
            'direccion' => $direccion,
            'email'=>$email,
            'foto' => "default.png"
        );

        // creamos un areglo para insertados todos de una vez
        $datosUsuario = array(
            'cedula' => $cedula,
            'email' => $email,
            'password' => md5($password),
            'tipo' => $tipo,
            'estado' => "ACTIVO"
        );

        $tablaPersona = 'personas';
        if (!$this->db->insert($tablaPersona, $datosPersona)) {
            return false; // Hubo un error en la inserción de la persona
        }

        // Insertar los datos del usuario después
        $tablaUsuario = 'usuarios';
        if (!$this->db->insert($tablaUsuario, $datosUsuario)) {
            // Si ocurre un error, podrías deshacer la inserción de la persona aquí si es necesario
            return false; // Hubo un error en la inserción del usuario
        }

        return true; // Ambas inserciones se realizaron correctamente se devolveria true
    } 


}