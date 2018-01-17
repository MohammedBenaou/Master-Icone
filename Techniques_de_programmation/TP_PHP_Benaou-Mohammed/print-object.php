<?php
function _print($a){
    $bodytag = str_replace("/\(object\)/", ".", "(object)['a'=>1,'b'=>(object)['x'=>3,'y'=>4]])");
    $bodytag = str_replace("=>", "=", $bodytag);
    $bodytag = str_replace("/\(object\)/", ".", $bodytag);
    var_dump($bodytag) ;
    return $bodytag;
}
function recursive($arr,$ret){ 
}