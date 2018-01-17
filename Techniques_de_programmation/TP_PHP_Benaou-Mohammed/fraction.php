<?php
require_once("../TP_PHP/gcd.php");
// require_once("fraction.php");
class Fraction {
	public $numerator;
	public $denominator;
	//public static $cpt; compteur d'instanciation
	static $last;

  //  leconstructeur de la classe Fraction  
function __construct($numerator,$denominator)
	{

		$this->numerator = $numerator;
		$this->denominator = $denominator;
		$this->reduction();
		Fraction::$last = $this ;
		
	}
 // la fonction qui sert à réduire une fraction 
public function reduction()
	{
    	$PGCD = gcd($this->numerator,$this->denominator);
    	$this->numerator= $this->numerator/$PGCD;
   	$this->denominator= $this->denominator/$PGCD;
	}
    // geters
   public function getdenominator(){
   	return $this->denominator;
   }

   public function getnumerator(){
   	 return $this->numerator;
   }
 // fonction addition de deux fraction 
public function addition($fractionA){

     $some1 = $this->numerator * $fractionA->getdenominator() ;
     	$some2=$this->denominator * $fractionA->getnumerator();
     $some= $some1+$some2;

    $denocom=$this->denominator * $fractionA->denominator;
     $this->numerator = $some;
     $this->denominator= $denocom;
     $this->reduction();
     return new Fraction ($this->numerator,$this->denominator);

  }  
  // la fonction multiplication de deux fractions
  public function multiplication($fractionB){
     $totalA = $this->numerator * $fractionB->getnumerator();
     $totalB = $this->denominator * $fractionB->getdenominator();
     $this->numerator = $totalA;
     $this->denominator= $totalB;
     $this->reduction();
     return new Fraction ($this->numerator,$this->denominator);
  }

  public static function approximate($decimal,$precision)
{
    $decimal=$decimal+$precision;
    echo 'some : ',$decimal,"\n";
    $tolerance = 1.e-5;

    $numerator = 1;
    $h2 = 0;
    $denominator = 0;
    $k2 = 1;
    $b = 1 / $decimal;
    do {
        $b = 1 / $b;
        $a = floor($b);
        $aux = $numerator;
        $numerator = $a * $numerator + $h2;
        $h2 = $aux;
        $aux = $denominator;
        $denominator = $a * $denominator + $k2;
        $k2 = $aux;
        $b = $b - $a;
    } while (abs($decimal - $numerator / $denominator) > $decimal * $tolerance);
    //echo $numerator,"-",$denominator,"_",gcd($numerator,$denominator);

    return new Fraction((int)$numerator,(int)$denominator);
}
}
?>


