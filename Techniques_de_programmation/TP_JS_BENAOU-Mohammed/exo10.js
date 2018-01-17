function lcm_more(input){
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
		a = lcm( a, b );
	}
	return a;
}
function lcm(nombre1,nombre2){
	var nombre1;
	var nombre2;

    var res = nombre1 * nombre2;
    while( nombre1 > 1){
       var reste = nombre1 % nombre2;
    if( reste == 0 ){
       result = res / nombre2;
        break;  // sorti qua nd resultat trouvé
             }
        nombre1 = nombre2;
        nombre2 = reste;
    }
     return result; // retourne le resultat
}