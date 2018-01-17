select nom,nominterv,dateinterv
from clients,interventions
where interventions.noclient=clients.noclient;
