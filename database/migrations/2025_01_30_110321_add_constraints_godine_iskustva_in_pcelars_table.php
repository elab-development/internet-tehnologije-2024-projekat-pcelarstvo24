<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    
    public function up(): void
    {
        Schema::table('pcelars', function (Blueprint $table) {
            //dodavanje ogranicenja za godine iskustva
            $table->integer('godine_iskustva')->nullable()->check('godine_iskustva >= 0');
        });
    }

    
    public function down(): void
    {
        Schema::table('pcelars', function (Blueprint $table) {
            //uklanjanje ogranicenja
            //$table->dropForeign(['godine_iskustva']); //ako je bilo nekih drugih veza
            $table->dropColumn('godine_iskustva');
        });
    }
};
