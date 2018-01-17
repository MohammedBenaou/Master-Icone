function fraction(num,den){
	this.numerator=num/gcd(num,den);
	this.denominator=den/gcd(num,den);
   
   if(num==0 ){
   	if(!(this instanceof fraction)){
    	return new fraction(0,1);
   }
}
    fraction.last=this;
    if(!(this instanceof fraction)){
    	return new fraction(num,den);
    }

    if (den== 0){
    	console.log("Fraction impossible");
    }
}
fraction.prototype.toString=function(){
	return this.numerator+"/"+this.denominator;
}
fraction.prototype.addition=function(fractionA){
	var some1=this.numerator*fractionA.denominator;
	var some2=this.denominator*fractionA.numerator;	
	this.numerator=some1+some2;
	this.denominator=this.denominator * fractionA.denominator;
	return new fraction (this.numerator,this.denominator);
}
fraction.prototype.multiplication=function(fractionB){
	var totalA =this.numerator*fractionB.numerator;
	var totalB =this.denominator*fractionB.denominator;
	this.numerator =totalA;
	this.denominator =totalB;
	return new fraction (this.numerator,this.denominator);
}
fraction.parse=function(frac){
	var partsarray = frac.split('/');
	this.numerator=parseInt(partsarray[0]);
	this.denominator=parseInt(partsarray[1]);
	return new fraction (this.numerator,this.denominator);

}
fraction.approximate=function(decimal,precision){
	 decimal= decimal+ precision;
     var tolerance = 1.e-5;

    var numerator = 1;
    var h2 = 0;
    var denominator = 0;
    var k2 = 1;
    var b = 1 / decimal;
    do {
        b = 1 / b;
        a = Math.floor(b);
        var aux = numerator;
        numerator = a * numerator + h2;
        h2 = aux;
        aux = denominator;
        denominator = a * denominator + k2;
        k2 = aux;
        b = b - a;
    } while (Math.abs(decimal - numerator / denominator) > decimal * tolerance);
    //echo $numerator,"-",$denominator,"_",gcd($numerator,$denominator);

    return new fraction(parseInt(numerator),parseInt(denominator));
}

/*fraction.prototype.Integer=function(number){
   this.numerator=number;
   this.denominator=1;
   return new fraction (this.numerator,1);
}*/


