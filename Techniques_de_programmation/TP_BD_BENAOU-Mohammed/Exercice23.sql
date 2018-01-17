select f.datefacture
from produits d,remplacements r,interventions i,factures f
where d.reference=r.reference
and i.nointerv=r.nointerv
and i.nofacture=f.nofacture
and designation='Bruleur Huger'
and nominterv='Saultier'
union
select f.datefacture
from produits d,remplacements r,interventions i,factures f
where d.reference=r.reference
and i.nointerv=r.nointerv
and i.nofacture=f.nofacture
and designation='bruleur soc'
and nominterv='Saultier';