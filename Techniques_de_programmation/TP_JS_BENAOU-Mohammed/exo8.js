function gcd(nombre1,nombre2) {
var nombre1;
var nombre2;
while(nombre1 > 1){
	var reste = nombre1 % nombre2;
	if ( reste == 0){
		break ;
	}
      nombre1 = nombre2;
      nombre2 = reste;
}
return nombre2;
}

