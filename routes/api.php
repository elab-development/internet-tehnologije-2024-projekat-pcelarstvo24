<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Models\Pcelar;

Route::get('/pcelar', function (Request $request) {
    return $request->pcelar();
})->middleware('auth:sanctum');


//dinamicka ruta koja na osnovu zadatog id-ja vraca podatke o tom pcelaru
Route::get('/pcelars/{id}', function ($id) {
    $pcelar = Pcelar::findOrFail($id);
    return "Ime: " . $pcelar->ime . "<br>Prezime: " . $pcelar->prezime . "<br>Email: " . $pcelar->email . "<br>Telefon: " . $pcelar->telefon .
    "<br>Adresa: " . $pcelar->adresa . "<br>Email potvrdjen: " . $pcelar->email_verified_at;
});

//resurs ruta za pcelara
Route::resource('pcelars', PcelarController::class);

