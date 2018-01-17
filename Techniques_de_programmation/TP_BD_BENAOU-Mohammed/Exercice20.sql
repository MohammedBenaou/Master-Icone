select f.nofacture
from factures f,clients l,interventions i
where i.nofacture=f.nofacture
and i.noclient=l.noclient
and nom='Rivoire';