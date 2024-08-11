<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Categoria;


class CategoriaController extends Controller
{
    public function getCategoria(){
        return response()->json(Categoria::all(), 200);
    }

    public function getCategoriaxid($id){
        $categoria = Categoria::find($id);
        if(is_null($categoria)){
            return response()->json(['Mensaje'=>'No encontrado'],404);
        }
        return response()->json($categoria::find($id),200);
    }

    public function insertcategoria(Request $request){
        $categoria = Categoria::create($request->all());
        return response($categoria,201);
    }

    public function updatecategoria(Request $request,$id){
        $categoria = Categoria::find($id);
        if(is_null($categoria)){
            return response()->json(['Mensaje'=>'No encontrado'],404);
        }
        $categoria -> update($request->all());
        return response($categoria,200);
    }


    public function deletecategoria(Request $request,$id){
        $categoria = Categoria::find($id);
        if(is_null($categoria)){
            return response()->json(['Mensaje'=>'No encontrado'],404);
        }
        $categoria -> delete();
        return response()->json(['Mensaje'=>'Eliminado Correctamente'],200);
    }

}
