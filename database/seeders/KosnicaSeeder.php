<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class KosnicaSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $pcelinjaci = Pcelinjak::all();

        //po 5 kosnica u svakom pcelinjaku
        foreach ($pcelinjaci as $pcelinjak) {
            for ($i = 1; $i <= 5; $i++) {
                Kosnica::create([
                    'naziv' => 'Kosnica ' . $i,
                    'tip' => 'LR',
                    'broj_okvira' => rand(5, 15),
                    'trenutno_stanje' => 'Aktivna i zdrava',
                    'pcelinjak_id' => $pcelinjak->id,
                ]);
            }
        }
    }
}
