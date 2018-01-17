select nofacture,datefacture
from factures
where etat='R'
order by  datefacture desc;