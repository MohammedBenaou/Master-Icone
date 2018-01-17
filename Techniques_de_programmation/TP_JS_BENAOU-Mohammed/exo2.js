function factorielle(n) {
 var fact= 1;
 if (n<=0)
 	return 1;
 
 else {
 	for (i=1;i<=n;i++){
 		fact=fact*i;

 	}
 }
 return fact;
}

