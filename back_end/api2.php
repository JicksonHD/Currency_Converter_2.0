<?php
  include("database_login.php");
  //retrieving rates from front-end
  $amount = $_POST["amount"];
  $current_rate = $_POST["current_rate"];
  $currency = $_POST["currency"];
  
  $query = $mysqli->prepare("INSERT INTO conversions(amount, current_rate, currency) VALUES (?,?,?)");//preparing to send to database

  $query->bind_param("iis", $amount, $current_rate, $currency);//adding the values to be sent to the database
  $query->execute();//executing

?>