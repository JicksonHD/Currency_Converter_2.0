<?php
//database login
$db_host = "localhost";
$db_user = "root";
$db_pass = null;
$db_name = "currency_db";

mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT);
$mysqli = mysqli_connect($db_host, $db_user, $db_pass, $db_name);

if(mysqli_connect_errno()){
    die("Connection_failed!");
}

?>
