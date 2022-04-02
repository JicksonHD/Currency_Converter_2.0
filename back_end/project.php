<?php
    date_default_timezone_set('Asia/Beirut');

    //finding the date and the time for API only allows access if the version is the same as current date and time to the hour
    $year = intval(date('Y'));
    $month = intval(date('m'));
    $day = intval(date('d'));
    $hour = intval(date('H'));
    
    
    // adding them all
    $variant_part = strval($year.$month.$day.$hour);
    
    
    $url = "https://lirarate.org/wp-json/lirarate/v2/rates?currency=LBP&_ver=t$variant_part";

    //retreiving API information from the website
    $curl = curl_init();
    
    curl_setopt($curl, CURLOPT_URL, $url);//linking to APi
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);//returning information
    
    $response = curl_exec($curl);//executing return of information
    
    curl_close($curl);//ending session
    
    $result = (array) json_decode($response,true);//writing in a simpler format
    $array_length =  sizeof($result['buy']);//retrieving length
    
    $json = [];
    $json ["Rate"] = (array) $result['buy'][$array_length - 1][1];
    
    
    $json_response = json_encode($json);
    echo $json_response;
    
?>