<?php

namespace Database\Factories;

use App\Models\Pcelinjak;
use App\Models\Kosnica;
use App\Models\Pcelar;
use Illuminate\Database\Eloquent\Factories\Factory;

class PcelinjakFactory extends Factory
{
   
    protected $model = Pcelinjak::class;

    
    public function definition(): array
    {
        return [
            'naziv' => $this->faker->word(),  
            'lokacija' => $this->faker->address(),  
            'broj_kosnica' => $this->faker->numberBetween(5, 300), //mali pcelinjaci su do 50, srednji 50-150, veliki preko 150
            'povrsina' => $this->faker->randomFloat(2, 0.5, 15),  //povrsina na dve decimale, u hektarima
        ];
    }

   
    public function withPcelari(): static
    {
        return $this->afterCreating(function (Pcelinjak $pcelinjak) {
            $pcelar = Pcelar::factory()->create();
            $pcelinjak->pcelari()->attach($pcelar);
        });
    }

   
    public function withKosnice(int $count = 5): static
    {
        return $this->afterCreating(function (Pcelinjak $pcelinjak) use ($count) {
            Kosnica::factory()->count($count)->create([
                'pcelinjak_id' => $pcelinjak->id,
            ]);
            $pcelinjak->increment('broj_kosnica', $count); 
        });
    }

    
    public function withMedove(): static
    {
        return $this->afterCreating(function (Pcelinjak $pcelinjak) {
            $med = \App\Models\Med::factory()->create();
            $pcelinjak->medovi()->attach($med);
        });
    }
}
