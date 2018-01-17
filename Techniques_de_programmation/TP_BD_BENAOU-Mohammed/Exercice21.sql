select datefacture,nom
from factures,clients,interventions
where interventions.nofacture=factures.nofacture
and interventions.noclient=clients.noclient
and etat='R';