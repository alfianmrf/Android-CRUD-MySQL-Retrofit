<?php

namespace App\Http\Controllers;

use App\Mahasiswa;
use Illuminate\Http\Request;
use DB;

class apiController extends Controller
{
    public function read_api(){
        $mahasiswa = Mahasiswa::all();
        return response()->json([
            'status'=>'OK',
            'message'=>'Data Tersedia',
            'data'=>$mahasiswa
        ], 200);
    }

    public function read_mhs_api(Request $request, $id){
        $cek = Mahasiswa::firstWhere('id', $id);
        if($cek){
            $mahasiswa = Mahasiswa::find($id);
            return response()->json([
                'status'=>'OK',
                'message'=>'Data Tersedia',
                'data'=>$mahasiswa
            ], 200);
        }
        else{
            return response([
                'status'=>'Not Found',
                'message'=>'Data Tidak Ditemukan'
            ], 404);
        }
    }

    public function create_api(Request $request){
        $mahasiswa = new Mahasiswa;
        $mahasiswa->nim = $request->inputNim;
        $mahasiswa->nama = $request->inputNama;
        $mahasiswa->prodi = $request->inputProdi;
        $mahasiswa->save();
        return response([
            'status'=>'OK',
            'message'=>'Data Disimpan'
        ], 200);
    }

    public function update_api(Request $request){
        $cek = Mahasiswa::firstWhere('id', $request->inputId);
        if($cek){
            $mahasiswa = Mahasiswa::find($request->inputId);
            $mahasiswa->nim = $request->inputNim;
            $mahasiswa->nama = $request->inputNama;
            $mahasiswa->prodi = $request->inputProdi;
            $mahasiswa->save();
            return response([
                'status'=>'OK',
                'message'=>'Data Berhasil Diperbarui'
            ], 200);
        }
        else{
            return response([
                'status'=>'Not Found',
                'message'=>'Data Tidak Ditemukan',
            ], 404);
        }
    }

    public function delete_api(Request $request){
        $cek = Mahasiswa::firstWhere('id', $request->inputId);
        if($cek){
            Mahasiswa::destroy($request->inputId);
            return response([
                'status'=>'OK',
                'message'=>'Data Dihapus'
            ], 200);
        }
        else{
            return response([
                'status'=>'Not Found',
                'message'=>'Data Tidak Ditemukan'
            ], 404);
        }
    }
}
