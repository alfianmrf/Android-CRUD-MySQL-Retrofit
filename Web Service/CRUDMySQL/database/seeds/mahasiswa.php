<?php

use Illuminate\Database\Seeder;
use Faker\Factory as Faker;

class mahasiswa extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        $faker = Faker::create('id_ID');
        for($i = 1; $i <= 10; $i++){
            DB::table('mahasiswa')->insert([
                'nim' => $faker->numberBetween($min = 18051204000, $max = 18051204999),
                'nama' => $faker->name,
                'prodi' => "Teknik Informatika",
            ]);
        }
    }
}
