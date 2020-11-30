<?php

use Illuminate\Http\Request;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});

Route::get('read', 'apiController@read_api');
Route::get('read/{id}', 'apiController@read_mhs_api');
Route::post('create', 'apiController@create_api');
Route::post('update', 'apiController@update_api');
Route::post('delete', 'apiController@delete_api');