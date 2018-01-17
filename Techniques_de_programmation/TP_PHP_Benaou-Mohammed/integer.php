<?php 
require_once ("../TP_PHP/fraction.php");
class integer extends Fraction{
	public $numerator;
  public function __construct($a){
  	$this->numerator=$a;
  	$this->denominator=1;
  }
}
?>
 