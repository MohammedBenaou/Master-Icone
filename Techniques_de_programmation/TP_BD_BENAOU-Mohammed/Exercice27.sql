select NomV,count(NumVitic) as nombre,Region
from Vin v,Vitticuler c
where c.NumVitic=v.NumVitic;