<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;

class Kosnica extends Model
{
    /** @use HasFactory<\Database\Factories\KosnicaFactory> */
    use HasFactory;
    
    protected $fillable = [
        'naziv',
        'tip',
        'broj_okvira',
        'trenutno_stanje',
        'pcelinjak_id',
    ];
//kosnica pripada jednom pcelinjaku
    public function pcelinjak(): BelongsTo
    {
        return $this->belongsTo(Pcelinjak::class);
    }
}