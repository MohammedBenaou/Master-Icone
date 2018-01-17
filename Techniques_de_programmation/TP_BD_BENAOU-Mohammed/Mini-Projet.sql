/*//////////- création de la base de données -/////////////////*/
create DATABASE MINIPROJET
/*//////////- la création de la table categorie_client -/////////////////*/
create table categorie_client(id_cat_cl int primary key,designation char(50));
/*//////////- L'insertion dans  la table categorie_client -/////////////////*/
insert into categorie_client values (1,'commerçant');
insert into categorie_client values (2,'particulier');
/*//////////- la création de la table clients -/////////////////*/
create table clients(
id_client int  AUTO_INCREMENT,
nom_client char(50) ,
adresse varchar(250),
id_categorie int, 
primary key( id_client),
foreign key  (id_categorie)references categorie_client(id_cat_cl)
);
/*//////////- L'insertion dans  la table clients -/////////////////*/
INSERT INTO `clients`(`nom_client`, `adresse`, `id_categorie`)  values('Dupont','4 rue de condé 69002 lyon',1);
INSERT INTO `clients`(`nom_client`, `adresse`,  `id_categorie`) values('Durant','2 rue neuve 69002 lyon',2);
INSERT INTO `clients`(`nom_client`, `adresse`, `id_categorie`)values ('dubois','8 place de la bourse 69002 lyon',1);
INSERT INTO `clients`(`nom_client`, `adresse`,  `id_categorie`) values('durant','17 rue des Myosotis 69002 lyon',2);
/*//////////- la création de la table matiere -/////////////////*/
create table matiere (id_mat int AUTO_INCREMENT,
libelle char(50),
primary key(id_mat));
/*//////////- L'insertion dans  la table matiere -/////////////////*/
INSERT INTO `matiere`(`libelle`) VALUES ('serpent');
INSERT INTO `matiere`(`libelle`) VALUES ('crocodile');
INSERT INTO `matiere`(`libelle`) VALUES ('sky');


/*--//////- la création de la table categorie_article -////////--*/
create table categorie_article(id_cat_ar int primary key,designation_art char(50));
  insert into categorie_article values(1,'sac a main');
  insert into categorie_article values(2,'cartable');
/*--//////- la création de la table article -////////--*/
create table article(
reference int,
 designation varchar(100) not null ,
id_cat int,
id_mat int,
primary key( reference),
foreign  key  (id_cat)references categorie_article(id_cat_ar),
foreign key (id_mat) references matiere(id_mat));
/*--//////////- L'insertion dans la table article -///////--*/
INSERT INTO `article`(`reference`, `designation`, `id_cat`, `id_mat`) values (1121,'sac longchamp',1,2);
INSERT INTO `article`(`reference`, `designation`, `id_cat`, `id_mat`) values (1122,'sac montagne verte',1,1);
INSERT INTO `article`(`reference`, `designation`, `id_cat`, `id_mat`) values (1123,'sac montagne verte',1,3);
INSERT INTO `article`(`reference`, `designation`, `id_cat`, `id_mat`) values (1124,'sac longchamp',1,1);
/*--//////- la création de la table vente -////////--*/
create table vente(
id_vente int  AUTO_INCREMENT,
prix int not null,
id_client int ,
id_article int ,
primary key (id_vente),
foreign key(id_article) references articles (reference),
foreign key (id_client) references clients(id_client)
);
/*--//////////- L'insertion dans la table vente -///////--*/
INSERT INTO `vente`( `prix`, `id_client`, `id_article`) values (293,1,1121);
INSERT INTO `vente`( `prix`, `id_client`, `id_article`) values (369,2,1122);
INSERT INTO `vente`( `prix`, `id_client`, `id_article`) values (258,1,1122);
INSERT INTO `vente`( `prix`, `id_client`, `id_article`) values (342,2,1123);
/*--//////- la création de la table commande -////////--*/
create table commande(
id_commande int AUTO_INCREMENT,
id_vente int,
primary key (id_commande),
foreign key (id_vente) references vente(id_vente))
/*--//////////- L'insertion dans la table commande -///////--*/
INSERT INTO `commande`( `id_vente`) values(1);
INSERT INTO `commande`( `id_vente`) values(2);
INSERT INTO `commande`( `id_vente`) values(3);
INSERT INTO `commande`( `id_vente`) values(4);


/*////////////////Les requetes/////////*/
select distinct reference,categorie_client.designation,prix   from article,categorie_client,vente,clients
where article.reference=vente.id_article and clients.id_categorie=categorie_client.id_cat_cl
	
	
create procedure visibilitie_client()
begin
	
	select prix from vente;
	end
 le nombre des aricless acheté par client*/

select count(id_article) as 'totalArticle',prix,id_client from vente group by (id_client)	

/*///////////////////////////////////////////////////////*/

CREATE OR REPLACE FUNCTION remise_prix ()
RETURNS trigger AS $$
BEGIN
select distinct reference,categorie_client.designation,prix   from article,categorie_client,vente,clients
where article.reference=vente.id_article and clients.id_categorie=categorie_client.id_cat_cl
if (new.designation == 'particulier') then
RAISE NOTICE 'evenement : % %', tg_event, tg_tag;
end if;
END;
$$ LANGUAGE plpgsql;
/*//////--curseur d'affichage du ticket-------------*/

declare @var_ref as  int;
declare @var_cat_cl as  char(50);
declare @var_prix as  int;	
declare mon_curseur cursor 
local 
FORWARD_ONLY
READ_ONLY
for
select * from tickets
open mon_curseur
fetch next from mon_curseur into @var_ref ,@var_cat_cl,@var_prix
while
@@fetch_status <>-1
begin

print 'Numéro:' +ltrim(cast(@var_ref as char(10)))+'Type de client:'+@var_cat_cl+'  '+'Prix de vente:'+ltrim(cast(@var_prix as char(10)))+'€'

fetch next from mon_curseur into @var_ref ,@var_cat_cl,@var_prix
close mon_curseur
DEALLOCATE mon_curseur









  