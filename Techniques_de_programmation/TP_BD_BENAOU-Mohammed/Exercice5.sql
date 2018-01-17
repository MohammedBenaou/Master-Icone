drop DOMAIN if exists D_JOUEUR;

CREATE DOMAIN D_JOUEUR as CHAR(4) 
check (VALUE ~'j\d{3}');
