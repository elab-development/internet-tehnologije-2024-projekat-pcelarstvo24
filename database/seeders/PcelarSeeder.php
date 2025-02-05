<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Faker\Factory as Faker;

class PcelarSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        //faker init
        $faker = Faker::create();

        //pravimo 10 pcelara
        for ($i = 0; $i < 10; $i++) {
            $pcelar = Pcelar::create([
                'ime' => $faker->firstName,
                'prezime' => $faker->lastName,
                'email' => $faker->unique()->safeEmail,
                'telefon' => $faker->phoneNumber,
                'adresa' => $faker->address,
            ]);

            $pcelinjaci = \App\Models\Pcelinjak::inRandomOrder()->take(2)->get(); 
            $pcelar->pcelinjaks()->attach($pcelinjaci);
        }
    }
}
