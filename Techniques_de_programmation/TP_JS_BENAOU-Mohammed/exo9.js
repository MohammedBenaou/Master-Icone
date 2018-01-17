function gcd_more(input) {
  if (toString.call(input) !== "[object Array]")  
        return  false;  
  var len, a, b;
	len = input.length;
	if ( !len ) {
		return null;
	}
	a = input[ 0 ];
	for ( var i = 1; i < len; i++ ) {
		b = input[ i ];
		a = Arith.gcd( a, b );
	}
	return a;
}
function Arith(){

}
 Arith.gcd=function(nombre1,nombre2) {
 try{
 if (typeof nombre1 == "String")
 throw new TypeError (" TypeError : arguments must be numbers");
    var str=nombre1.toString();
    var n = str.indexOf(".");
    if(n != -1){
    	throw new RangeError("RangeError: arguments must be integers");
    }
 	
    while(nombre1 > 1){
	var reste = nombre1 % nombre2;
	if ( reste == 0){
		break ;
	}
      nombre1 = nombre2;
      nombre2 = reste;
      
}

return nombre2;
}catch (e){
		console.log(e.message);
	}
}
