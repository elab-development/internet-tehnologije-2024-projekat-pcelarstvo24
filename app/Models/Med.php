<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Med extends Model
{
    /** @use HasFactory<\Database\Factories\MedFactory> */
    use HasFactory;
    use HasFactory;

    protected $fillable = [
        'naziv',
        'kolicina',
        'cena',
    ];

    public function pcelinjaks()
    {
        return $this->belongsToMany(Pcelinjak::class, 'pcelinjak_med');
    }
}
