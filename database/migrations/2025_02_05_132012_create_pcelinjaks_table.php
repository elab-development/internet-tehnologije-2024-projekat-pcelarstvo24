<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('pcelinjaks', function (Blueprint $table) {
            $table->id();
            $table->string('naziv');
            $table->string('lokacija');
            $table->integer('broj_kosnica');
            $table->decimal('povrsina', 8, 2);
            $table->timestamps();
        });
        
            Schema::create('pcelar_pcelinjak', function (Blueprint $table) {
            $table->id();
            $table->foreignId('pcelar_id')->constrained()->onDelete('cascade');
            $table->foreignId('pcelinjak_id')->constrained()->onDelete('cascade');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('pcelinjaks');
    }
};
