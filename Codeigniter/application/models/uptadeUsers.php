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

    public function obtenerDatosCliente($cedula)
    {
        $this->db->where("cedula", $cedula);
        $datosUsuario = $this->db->get('usuarios')->row();
        // traemos los datos de la otra tabla 
        $this->db->where("cedula", $cedula);
        $datosPersona = $this->db->get('personas')->row();

        // los combinamos para madar todos los datos de esa persona y poder hacer la modificacion que deseamos
        $datosCombinados = array(
            // el nombre que le asignamos es el que vamos a a utilizar para obtener los datos de cada tabla
            'usuario' => $datosUsuario,
            'persona' => $datosPersona
        );
        // Devuelve los resultados como un arreglo de objetos
        return $datosCombinados;
    }
    public function updatePersona($cedula,$nuevosDatos){
    //    cargamos los datos recibidos 
        $data=array(
            'nombres'=>$nuevosDatos['nombre'],
            'apellidos'=>$nuevosDatos['apellido'],
            'telefono'=>$nuevosDatos['telefono'],
            'direccion'=>$nuevosDatos['direccion'],
            'email'=>$nuevosDatos['correo'],
        );
        $data2=array(
            'email'=>$nuevosDatos['correo'],
        );
        // realizamos la actualizacion en la base de datos

        $this->db->where('cedula',$cedula);
        $this->db->update('personas',$data);

        $this->db->where('cedula',$cedula);
        $this->db->update('usuarios',$data2);

        // ahora verificamos que la actualizacion de datos fue exitosa 

        if($this->db->affected_rows()>0){
            return true; // actulizacion exitosa 
        }else{
            return false; // no se actualizo los datos por alguna razons
        }
    }
}