<?php

namespace Database\Factories;

use App\Models\Kosnica;
use App\Models\Pcelinjak;
use Illuminate\Database\Eloquent\Factories\Factory;


class KosnicaFactory extends Factory
{
    
    protected $model = Kosnica::class;

   
    public function definition(): array
    {
        return [
            'naziv' => $this->faker->word(),
            'tip' => $this->faker->randomElement(['Langstrot-Rutova', 'Dadan-Blatova', 'Fararova', 'Alberti-Žnideršičev', 'Košnica pološka']),
            'broj_okvira' => $this->faker->numberBetween(5, 20),
            'trenutno_stanje' => $this->faker->randomElement(['Aktivna i zdrava', 'Oslabljena', 'Bez matice', 'Bolesna', 'Gladna', 'Uništena']),
            'pcelinjak_id' => Pcelinjak::factory(), 
        ];
    }
}
