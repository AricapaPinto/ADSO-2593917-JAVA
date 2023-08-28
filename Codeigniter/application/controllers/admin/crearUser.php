<?php
defined('BASEPATH') or exit('No direct script access allowed');

class crearUser extends CI_Controller
{


    public function IngresarUser()
    {
        $cedula = $this->input->post("new_cedula");
        $nombres = $this->input->post("new_nombres");
        $apellidos = $this->input->post("new_apellidos");
        $telefono = $this->input->post("new_telefono");
        $direccion = $this->input->post("new_direccion");
        $correo = $this->input->post("new_correo");
        $password = $this->input->post("new_password");
        $tipo = $this->input->post("new_tipo");

        // TOCA ACABAR DE HACER LA INSERCION DE LOS  DEMAS DATOS QUE FALTAN TOCA METER DATOS EN LA DOS TABLAS CORRESPODIENTES
        // Inicializa el arreglo $data
        $data = array();
        // aqui mandamos llamar el ininicio de session lo guardamos el la varible de de data para mandarle la session y las variables
        $data['session'] = $this->session->userdata("session-mvc");
        // Creamos la condicion para validar que todos los datos esten completos
        if ($cedula != "" && $correo != "" && $password != "" && $tipo != "" && $nombres!="" && $apellidos!="" && $direccion!="" && $telefono !="") {
        //    insertamos los datos en sus respectivas tablas


            // hacemos llamado a el model el cual vamos a usar en este controlador
            $this->load->model('insertarUsuarioModel');

            // la metemos en una variable para mirar que tipo de valor retorno
            $respuesta = $this->insertarUsuarioModel->setInsertUser($cedula, $correo, $password, $tipo,$nombres,$apellidos,$direccion,$telefono);

            // miramos si se insertaron los datos correctamente
            if ($respuesta) {
                $data['date_validos'] = true;
            } else {
                $data['error_insert'] = false;
            }
        } else {
            // los datos no estan completos
            $data['dateIncompletos'] = true;
        }
        $this->load->view('admin/crearUsuario', $data);
    }
}