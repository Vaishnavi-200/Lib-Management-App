<?php

include('dbconnect.php');
 
$v1=$_REQUEST['f1'];


 
 
$response = array();
 
$sql=mysqli_query($conn,"DELETE FROM TABLE_BOOK where bookid='$v1'");

 
if ( $sql == TRUE)
{
    $response["success"] = 1;
    $response["message"] = "  successfully.";
    echo json_encode($response);
    
}
else
{
    $response["success"] = 0;
    $response["message"] = "  failed.";
    echo json_encode($response);
}

?>

