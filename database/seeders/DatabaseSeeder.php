<?php

namespace Database\Seeders;

use App\Models\Pcelar;
// use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     */
    public function run(): void
    {
        // Pcelar::factory(10)->create();

        Pcelar::factory()->create([
            'ime' => 'Test pcelar',
            'email' => 'test@example.com',
        ]);
    }
}
