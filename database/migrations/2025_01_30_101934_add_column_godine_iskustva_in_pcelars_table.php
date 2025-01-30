<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    public function up()
    {
        Schema::table('pcelars', function (Blueprint $table) {
            $table->integer('godine_iskustva')->after('adresa')->default(0);
        });
    }

    public function down()
    {
        Schema::table('pcelars', function (Blueprint $table) {
            $table->dropColumn('godine_iskustva'); //uklanja kolonu godine_iskustva
        });
    }
};
