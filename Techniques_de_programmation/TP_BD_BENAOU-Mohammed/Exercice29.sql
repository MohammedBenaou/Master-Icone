select v.NumVin,v.cru,count(*) as nb_doublons
from Vin v,Commande d
where v.NumVin=d.NumVin
HAVING   COUNT(*) > 1;