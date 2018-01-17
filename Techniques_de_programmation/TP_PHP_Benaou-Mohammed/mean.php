<?php
function mean($tab){
$size=sizeof($tab);
$vl=0;
foreach ($tab as &$value) {
     $vl=$vl+$value ;
}
$result=$vl/$size;
return $result;
}
echo mean([1,2,3,4,5,6]),	"\n";

