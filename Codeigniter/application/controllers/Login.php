<?php
defined('BASEPATH') or exit('No direct script access allowed');

class Login extends CI_Controller{
    public function index()
    {
        $this->load->view('Inicio_Sesion');
    }
    public function validarIngreso(){

        $email = $this->input->post("campo_email");
        $pass = $this->input->post("campo_password");
        if ($email != "" && $pass != "") {
            // aqui cargamos los modelos ya que vamos a utilizar las funcion o obtner la informacion de dicho modelo dependiendo 
            // de  los metodos que tengan y esas cosas 
            $this->load->model('PersonasModel');
            $this->load->model('UsuariosModel');
            $validacion = $this->UsuariosModel->validarIngreso($email, $pass);

            if ($validacion) {
                $datosPersona = $this->PersonasModel->getPersonasByEmail($email);
                $datosUsuario = $this->UsuariosModel->getUsuariosByEmail($email);

                $dataSession = [
                    // los nombres despues de datosblabla tiene que ser igual a la de l base de datos eso creo no estoy seguro pero tiene que condicir con algo para poder que funcionen 
                    "cedula" => $datosPersona->cedula,
                    "nombres" => $datosPersona->nombres,
                    "apellidos" => $datosPersona->apellidos,
                    "telefono" => $datosPersona->telefono,
                    "direccion" => $datosPersona->direccion,
                    "email" => $datosPersona->email,
                    "foto" => $datosPersona->foto,
                    "tipo" => $datosUsuario->tipo,
                    "estado" => $datosUsuario->estado,
                ];
                // este es como guardar la sesesion usando php puro yguardarmos los dato de ese areglo ya que contiene los datos de esa persona
                // el parametro sesion-mvc es la que vamos a usar para obtner ada uno de esos valores dependiendo en donde lo nesecitemos
                $this->session->set_userdata("session-mvc", $dataSession);

                if ($datosUsuario->tipo == "ADMIN") {
                    // echo "Entro en la primera condicion";
                    redirect('admin/Inicio', 'refresh');

                } else if ($datosUsuario->tipo == "VENDEDOR") {
                    // echo "Entro en la segunda condicion";
                    redirect('vendedor/Inicio', 'refresh');
                } else {
                    // echo "Entro en la tercera condicion";

                    redirect('Login', 'refresh');
                }
            } else {
                // echo "Entro aqui 4";
                $data['datosInvalidos'] = true;
                $this->load->view('Inicio_Sesion', $data);
            }
        } else {
            // echo "datos invalidos";
            $data['ErrorInData'] = true;
            $data['valueEmail'] = $email;
            $data['valuePassword'] = $pass;
            $this->load->view('Inicio_Sesion', $data);
        }
        // print_r($_POST);
        // echo "<br><br>";
        // var_dump($_POST);
        // echo "<br><br> Seguimos en el controlador";
    }
    // este metodo se encarga de cerrar sesion en la cuenta ingresada 
    public function cerrarSession()
    {
        $this->session->sess_destroy();
        redirect('Login', 'refresh');
    }
    // esta linea es para el registro de persona
    
    public function registrar(){
        $this->load->view('registro');
    }
}