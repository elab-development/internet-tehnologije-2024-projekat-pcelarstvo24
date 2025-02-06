<?php

namespace Database\Factories;

use App\Models\Pcelar;
use Illuminate\Database\Eloquent\Factories\Factory;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Str;


class PcelarFactory extends Factory
{
    
    protected $model = Pcelar::class;

    
    public function definition(): array
    {
        return [
            'ime' => $this->faker->firstName(),
            'prezime' => $this->faker->lastName(),
            'email' => $this->faker->unique()->safeEmail(),
            'telefon' => $this->faker->phoneNumber(),
            'adresa' => $this->faker->address(),
            'email_verified_at' => now(),
            'password' => Hash::make('password'),
            'remember_token' => Str::random(10),
        ];
    }

    //ovo nam upucuje da treba email adresa pcelara da bude unverified
    public function unverified(): static
    {
        return $this->state(fn (array $attributes) => [
            'email_verified_at' => null,
        ]);
    }
}
