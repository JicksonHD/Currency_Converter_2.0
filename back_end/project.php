<?php
    $ch = curl_init();

    curl_setopt($ch, CURLOPT_URL, 'https://lirarate.org/wp-json/lirarate/v2/rates?currency=LBP&_ver=t20224216');

    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

    $server_response = curl_exec($ch);

    curl_close($ch);

    $server_response = json_decode($server_response);
    echo "<pre>";print_r($server_response);echo "</pre>";
?>