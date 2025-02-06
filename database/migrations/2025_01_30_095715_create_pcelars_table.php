<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    
    public function up(): void
    {
        Schema::create('pcelars', function (Blueprint $table) {
            $table->id(); //primarni kljuc 
            $table->string('ime', 50);
            $table->string('prezime', 50)->default('Neodređeno');
            $table->string('email')->unique();
            $table->timestamp('email_verified_at')->nullable();
            $table->string('password');
            $table->rememberToken();
            $table->string('telefon', 20)->nullable();
            $table->string('adresa', 255)->nullable();
            $table->timestamps(); //created_at i updated_at
        });
    }

   
    public function down(): void
    {
        Schema::dropIfExists('pcelars');
    }
};
