select f.nofacture,f.datefacture
from factures f,clients l,interventions i  
where f.nofacture=i.nofacture
and l.noclient=i.noclient
and nom='Rivoire' 
and etat='R'
union 
select f.nofacture,f.datefacture
from factures f,clients l,interventions i  
where f.nofacture=i.nofacture
and l.noclient=i.noclient
and nom='Dallalon' 
and etat='C';