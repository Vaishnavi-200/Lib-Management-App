<?php

include('dbconnect.php');
 
$v1=$_REQUEST['f1'];
$v2=$_REQUEST['f2'];
$v3=$_REQUEST['f3'];
$v4=$_REQUEST['f4'];
$v5=$_REQUEST['f5'];
$v6=$_REQUEST['f6'];

$response = array();
 
$sql=mysqli_query($conn,"INSERT INTO TABLE_BOOK VALUES('$v1','$v2','$v3','$v4','$v5','$v6')");

 
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

