<?php
function Fibonacci($n) {
    if($n <= 0)
     return 0;
    if($n == 1) 
    	return 1;
    $u = 0;
    $v = 1;
    for($i=2; $i <= $n; $i++) {
        $w = $u+$v;
        $u = $v;
        $v = $w;
    };
    return $v;
}

for($I=0;$I<=10;$I++) {
    echo "Fibonacci(".$I.")=".Fibonacci($I)."\n";
}
?>