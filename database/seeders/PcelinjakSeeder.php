<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class PcelinjakSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        Pcelinjak::create([
            'naziv' => 'Pčelinjak 1',
            'lokacija' => 'Beograd',
            'broj_kosnica' => 5,
            'povrsina' => 1000,
        ]);

        Pcelinjak::create([
            'naziv' => 'Pčelinjak 2',
            'lokacija' => 'Niš',
            'broj_kosnica' => 3,
            'povrsina' => 700,
        ]);

        Pcelinjak::create([
            'naziv' => 'Pčelinjak 3',
            'lokacija' => 'Novi Sad',
            'broj_kosnica' => 8,
            'povrsina' => 1200,
        ]);

        Pcelinjak::create([
            'naziv' => 'Pčelinjak 4',
            'lokacija' => 'Kragujevac',
            'broj_kosnica' => 10,
            'povrsina' => 1500,
        ]);

        Pcelinjak::create([
            'naziv' => 'Pčelinjak 5',
            'lokacija' => 'Subotica',
            'broj_kosnica' => 6,
            'povrsina' => 900,
        ]);
    }
}
