select m.NomB,m.NumBuveur,AVG(QtteCommande)
from Membre m,Commande d
where m.NumBuveur=d.Numbuveur
and m.VilleB='Paris';