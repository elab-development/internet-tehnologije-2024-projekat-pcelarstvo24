<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class MedSeeder extends Seeder
{
    
    public function run(): void
    {
        //kreiramo nekoliko vrsta medova
        $medovi = [
            ['naziv' => 'Bagremov med', 'kolicina' => 50, 'cena' => 12],
            ['naziv' => 'Lipov med', 'kolicina' => 30, 'cena' => 15],
            ['naziv' => 'Suncokretov med', 'kolicina' => 20, 'cena' => 13],
            ['naziv' => 'Livadski med', 'kolicina' => 40, 'cena' => 16],
        ];

        foreach ($medovi as $med) {
            $noviMed = Med::create([
                'naziv' => $med['naziv'],
                'kolicina' => $med['kolicina'],
                'cena' => $med['cena'],
            ]);

            $pcelinjaci = Pcelinjak::inRandomOrder()->take(3)->get(); //tri nasumice odabrana pcelinjaka
            $noviMed->pcelinjaks()->attach($pcelinjaci);
        }
    }
}
