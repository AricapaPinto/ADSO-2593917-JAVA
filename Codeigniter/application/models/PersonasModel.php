<?php 
defined('BASEPATH') OR exit('No direct script acces allowed');

class PersonasModel extends CI_Model{
    // creamos una funcion para estraer los datos de la base de datos mediante el email 
    public function getPersonasByEmail($email){

        $this->db->where('email',$email);
        // creamos una variable para guardar los datos o lo que envia la base de datos dependiendo de la respuesta de la base de datos 
        $registros=$this->db->get('personas')->result();
        // el result es par mostrar los registros de la respuesta y guardar eso en la variable en la cual creamos 


        // el sizeof es para contar el tamaño del areglo que tiene la la resuesta aqui miramos que no sea diferente de cero para saber si llego algo ono ya eso depnde si hacemos ua condicion para algo en este caso 


        if(sizeof($registros)!=0){
            // lo que le estamos enviando aqui en la celua para no mandar todos loa datos de la bas de datos ya que la respuesta trae todos lo datos de esa personas en el caso solo queremos la cedula que queda en la posicion cero 
            return $registros[0];
        }else{
        // caso contrario enviamo un null ya que no fuer encontrado 
         return null;
        }
    }
    

}