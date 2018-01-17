<?php
function gcd($nombre,$nombre2,$nombre1){

   while($nombre>1){
        $reste = $nombre%$nombre2%$nombre1;

        if($reste == 0){
        break; // sorti quand resultat trouvé
        }

        $nombre=$nombre2;
        $nombre2=$nombre1;
        $nombre1=$reste;
}
return $nombre1; // retourne le resultat
}
$res=gcd(40,20,10);
echo "le plus grand commun diviseur est $res \n";

function lcm($nombre3,$nombre4){

    $res = $nombre3 * $nombre4;
    while($nombre3 > 1){
        $reste = $nombre3 % $nombre4;
    if($reste == 0 ){
      $result = $res / $nombre4;
        break;  // sorti qua nd resultat trouvé
             }
        $nombre3 = $nombre4;
        $nombre4 = $reste;
    }
     return $result; // retourne le resultat
}

$resu=lcm(120,420);

echo "le plus petit commun multiple est $resu ";
?>

