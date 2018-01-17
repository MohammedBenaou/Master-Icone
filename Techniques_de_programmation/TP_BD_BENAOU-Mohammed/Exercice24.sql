select d.designation
from produits d,remplacements r,interventions i,clients l
where d.reference=r.reference
and r.nointerv=i.nointerv
and i.noclient=l.noclient
and nom='Provent';