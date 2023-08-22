<?php
defined('BASEPATH') or exit('No direct script access allowed');

class crearUser extends CI_Controller{


    public function IngresarUser()
    {
        $cedula = $this->input->post("new_cedula");
        $correo = $this->input->post("new_correo");
        $password = $this->input->post("new_password");
        $tipo = $this->input->post("new_tipo");

        // Inicializa el arreglo $data
        $data = array();
        // aqui mandamos llamar el ininicio de session lo guardamos el la varible de de data para mandarle la session y las variables
        $data['session'] = $this->session->userdata("session-mvc");
        // Creamos la condicion para validar que todos los datos esten completos
        if ($cedula != "" && $correo != "" && $password != "" && $tipo != "") {
            // ya que todos los datos son validos mandamos el mensaje y guardamos los datos en la base de datos usando el model de insertar usuario


            // hacemos llamado a el model el cual vamos a usar en este controlador
            $this->load->model('insertarUsuarioModel');

            // la metemos en una variable para mirar ue tipo de valor retorno
            $respuesta = $this->insertarUsuarioModel->setInsertUser($cedula, $correo, $password, $tipo);

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