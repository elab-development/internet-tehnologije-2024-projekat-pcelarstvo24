<?php

namespace Database\Factories;

use App\Models\Med;
use Illuminate\Database\Eloquent\Factories\Factory;

class MedFactory extends Factory
{
   
    protected $model = Med::class; 

    
    public function definition(): array
    {
        return [
            'naziv' => $this->faker->word(),  
            'kolicina' => $this->faker->numberBetween(100, 1000), 
            'cena' => $this->faker->randomFloat(2, 0, 100),  //cena meda na dve decimale
        ];
    }
}
