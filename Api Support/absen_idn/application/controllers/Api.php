<?php
defined('BASEPATH') OR exit('No direct script access allowed');
class Api extends CI_Controller {

    function LoginGuru(){
        $emailGuru = $this -> input -> post("emailGuru");
        $passwordGuru = $this -> input ->post("passwordGuru");

        $this -> db -> where("email_guru", $emailGuru);
        $this -> db -> where("password_guru", md5($passwordGuru));

        $cek_table = $this ->db->get("tb_guru");

        if($cek_table -> num_rows() > 0) {
            $data['status'] = true;
            $data['pesan'] = "true";
            $data['data'] = $cek_table -> row();

        }else{
            $data['pesan'] = "login gagal username atau password salah";
		    $data['status'] = false;
        }

        echo json_encode($data);
    }

    function RegisterGuru(){
        $emailGuru = $this -> input -> post("emailGuru");
        $passwordGuru = $this -> input ->post("passwordGuru");
        $namaDepanGuru = $this -> input ->post("namaDepanGuru");
        $namaBelakangGuru = $this -> input ->post("namaBelakangGuru");

        $this -> db -> where("email_guru", $emailGuru);
        $cek_email = $this -> db -> get('tb_guru');
        if($cek_email -> num_rows() > 0){
			$response['status'] = false;
			$response['pesan'] = "email sudah terdaftar";

		}else{
			$insert = array();
			$insert['email_guru'] = $emailGuru;
			$insert['password_guru'] = $passwordGuru;
            $insert['nama_depan_guru'] = $namaBelakangGuru;
            $insert['nama_belakang_guru'] = $namaBelakangGuru;


			$simpan = $this->db ->insert('tb_guru', $insert);

			if($simpan){
				$response['status'] = true;
				$response['pesan'] = "register berhasil";
			}else{
				$response['status'] = false;
				$response['pesan'] = "silakan cek koneksi";
            }
            
    
        }

        echo json_encode($response);
            

        }     

        function getInformasiGuru() {
            $idGuru = $this -> input -> post("idGuru");
            $this -> db -> where("id_guru", $idGuru);
            $data = $this -> db -> get("tb_guru");

            if($data -> num_rows() > 0 ){
            $response['status'] = true;
            $response['pesan'] = "datanya ada";
            $response['data'] = $data -> result()[0]; 
            
        }else{
            $response['status'] = false;
            $response['pesan'] = "datanya tidak ada";
        }

        echo json_encode($response);

            

        }

    

    function getCategoryAgendaByIdGuru(){
        $idGuru = $this -> input -> post("idGuru");
        
        $this -> db -> where("id_guru", $idGuru);
        $data = $this -> db -> get("tb_category_agenda");

       if($data -> num_rows() > 0 ){
            $response['status'] = true;
            $response['pesan'] = "datanya ada";
            $response['data'] = $data -> result(); 
        }else{
            $response['status'] = false;
            $response['pesan'] = "datanya tidak ada";
        }
       echo json_encode($response);
    }

    function insertCategoryAgenda(){
        //berhasil uji post man

		$idGuru = $this -> input -> post('idGuru');
		$namaCategory = $this -> input -> post('namaCategory');

        $this -> db -> where('nama_category', $namaCategory);
        $cek_email = $this->db->get('tb_category_agenda');
        if($cek_email -> num_rows() > 0){
			$response['status'] = false;
			$response['pesan'] = "nama sudah terpakai";

		}else{
			$insert = array();
			$insert['id_guru'] = $idGuru;
			$insert['nama_category'] = $namaCategory;

			$simpan = $this->db ->insert('tb_category_agenda', $insert);

			if($simpan){
				$response['status'] = true;
				$response['pesan'] = "insert berhasil";
			}else{
				$response['status'] = false;
				$response['pesan'] = "silakan cek koneksi";
            }
            
    
        }

        echo json_encode($response);
    }

    function insertPengaturanSiswaByCategory(){

    }

    function getSubAgendaByCategory(){
        $idCategoryAgenda = $this ->input->post("idCategoryAgenda");       
        
        //mencocokan
        $this -> db -> where("id_category_agenda",$idCategoryAgenda); 
        $cek_category = $this -> db -> get("tb_agenda");
        if($cek_category -> num_rows()>0){
            $response['status'] = true;
            $response['pesan'] = "berhasil";
            $response['data'] = $cek_category -> result();
        }else{
            $response['status'] = false;
            $response['pesan'] = "gagal mendapatkan sub cateogry";
        }

        echo json_encode($response);


    }

    function insertSubAgendaByCategory(){
        $idAgenda = $this -> input -> post("idAgenda");
        $idCategoryAgenda = $this->input->post("idCategoryAgenda");

        $this -> db -> where('id_agenda', $idAgenda);
        $cek_id = $this->db->get('tb_agenda');

        if($cek_id -> num_rows()>0){
            $response['status'] = false;
            $response['pesan'] = "Sudah Ada!";
        }else{
            $insert = array();
            $insert['id_agenda'] = $idAgenda;
            $insert['id_category_agenda'] = $idCategoryAgenda;
            $insertSubAgenda = $this -> db -> insert('tb_agenda', $insert);
            if($insertSubAgenda) {
                $response['status'] = true;
                $response['pesan'] = "Insert berhasil";
                $response['idAgenda'] = $cek_id;
            }
    
            else {
                $response['status'] = false;
                $response['pesan'] = "Insert gagal, silahkan cek koneksi internet";
    
            }

        }


        

	


        echo json_encode($response);
        

        
    }

    function getAbsensiBySubAgenda(){
        $idAgenda = $this -> input -> post('idAgenda');

        $this -> db -> where('id_agenda', $idAgenda);
        $absensi = $this -> db -> get("tb_absensi");
        if($absensi -> num_rows() > 0 ){
            $response['status'] = true;
            $response['pesan'] = "datanya ada";
            $response['data'] = $absensi -> result(); 
        }else{
            $response['status'] = false;
            $response['pesan'] = "datanya tidak ada";

        }
       echo json_encode($response);


    }

    function insertAbsensiBySubAgenda(){
        $idAgenda = $this -> input -> post("idAgenda");
        $namaSiswa = $this -> input -> post("namaSiswa");
        
        $this -> db -> where("nama_siswa", $namaSiswa);
        $cekSiswa = $this -> db -> get('tb_absensi');

        if($cekSiswa -> num_rows()<0){
            $response['status'] = false;
            $response['pesan'] = "siswa sudah terdaftar";
        }else{

        $insert = array();
        $insert['id_agenda'] = $idAgenda;
        $insert['nama_siswa'] = $namaSiswa;

        $insertAbsensi = $this-> db ->insert('tb_absensi', $insert);
        

        if($insertAbsensi){
            $response['status'] = true;
            $response['pesan'] = "berhasil insert";
        }else {

            $response['status'] = false;
            $response['pesan'] = "gagal insert";
        }

            
        }

        echo json_encode($response);


    }


}



