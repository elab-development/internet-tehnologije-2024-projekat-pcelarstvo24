<?php

use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/greeting', function () {
    return 'zdravo, pcelicee!!! :)';
});

//fallback ruta ako korisnik pristupa stranici koja ne postoji
Route::fallback(function () {
    return 'Stranica nije pronađena';
});






