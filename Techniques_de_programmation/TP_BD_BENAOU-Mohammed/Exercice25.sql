select l.noclient
from clients l,interventions i
where l.noclient=i.noclient
and i.nominterv='Saultier';