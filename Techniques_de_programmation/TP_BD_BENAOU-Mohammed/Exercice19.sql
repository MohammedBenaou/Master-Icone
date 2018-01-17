select nointerv,nominterv,dateinterv
from interventions,factures
where factures.nofacture=interventions.nofacture
and datefacture ='15/07/2009';