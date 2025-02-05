<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsToMany;
use App\Models\Kosnica;

class Pcelinjak extends Model
{
    /** @use HasFactory<\Database\Factories\PcelinjakFactory> */
    use HasFactory;
    protected $fillable = [
        'naziv',
        'lokacija',
        'broj_kosnica',
        'povrsina',
    ];

    public function kosnice()
    {
        return $this->hasMany(Kosnica::class);
    }

    public function pcelari()
    {
        return $this->belongsToMany(Pcelar::class);
    }

    //ako dodam kosnicu mora da se uradi azuriranje brkosnica
    public function addKosnica($kosnicaData)
    {
        $this->kosnice()->create($kosnicaData);
        $this->increment('broj_kosnica'); //povecanje broja kosnica
    }
    
    public function medovi()
    {
        return $this->belongsToMany(Med::class, 'pcelinjak_med');
    }
}
