 
insert into clients VALUES  ( 105,'Dallalon','Jean','5 Rue Jean Moulin','La Rochelle','17000','05-46-35-37-39');
insert into clients VALUES  ( 101,'Rivoire',null,'18 rue ronde','La Rochelle','17000','05-46-41-56-56');
insert into clients VALUES  ( 102,'Favero','André','43 rue Beaujolais','Poitiers','86000','05-49-35-63-62' );
insert into clients VALUES  ( 103,'Provent','Catherine','38 rue du stade','Poitiers','86000','05-49-49-45-46' );
insert into clients VALUES  ( 104,'Labric',null,'35 rue des fleurs','Poitiers','86000','05-49-46-45-48' );
insert into clients VALUES  ( 108,'Usturritz','Noa','27 rue des gentilshommes','Poitiers','86000', '05-49-46-45-52');
insert into clients VALUES  ( 109,'Lavalee','Amelia','14 Bd de Gaulle','Poitiers','86000', '05-49-46-45-50');


insert into produits values ( 'DT010','Disjoncteur 10A',7.21);
insert into produits values ( 'DT180','Bloc Huger',6.12);
insert into produits values ( 'DT802','Boite controle',68.35);
insert into produits values ( 'DT711','cellule',25.36);
insert into produits values ( 'DT125','Bloc Soc',6.89);
insert into produits values ( 'DT015','Disjoncteur 15A',14.94);
insert into produits values ( 'DT205','Bruleur Huger',153.37);
insert into produits values ( 'DT310','bruleur soc',200.20);
insert into produits values ( 'DT120','Connecteur',20.35);
insert into produits values ( 'DT121','Connecteur1',40.25);
insert into produits values ( 'DT122','Connecteur2',34.35);

 
insert into factures values ( 1000,'01/01/2009','R');
insert into factures values ( 1001,'12/02/2009','R');
insert into factures values ( 1002,'17/03/2009','R');
insert into factures values ( 1003,'24/04/2009','R');
insert into factures values ( 1004,'16/05/2009','R');
insert into factures values ( 1005,'08/07/2009','R');
insert into factures values ( 1006,'08/07/2009','R');
insert into factures values ( 1007,'15/07/2009','R');
insert into factures values ( 1008,'15/07/2009','R');
insert into factures values ( 1009,'22/07/2009','C');
insert into factures values ( 1010,'22/07/2009','C');
insert into factures values ( 1011,'29/07/2009','C');
insert into factures values ( 1012,'30/08/2009','R');
insert into factures values ( 1013,'19/10/2009','R');


insert into  interventions values ( 1039,'03/07/2009','Mauras','Saultier',1,101,1001);
insert into  interventions values ( 1040,'03/07/2009','Foucher','Saultier',1,103,1002);
insert into  interventions values ( 1041,'03/07/2009','Foucher','Saultier',2,103,1002);
insert into  interventions values ( 1042,'03/07/2009','Foucher','Saultier',1,101,1003);
insert into  interventions values ( 1043,'03/07/2009','Mauras','Saultier',2,105,1005);
insert into  interventions values ( 1044,'04/07/2009','Mauras','Saultier',0.5,101,1006);
insert into  interventions values ( 1045,'08/07/2009','Mauras','Bonnaz',1.5,102,1007);
insert into  interventions values ( 1046,'10/07/2009','Foucher','Crespin',1,102,1007);
insert into  interventions values ( 1047,'11/07/2009','Mauras','Crespin',2,103,1008);
insert into  interventions values ( 1048,'15/07/2009','Foucher','Bonnaz',1,105,1009);
insert into  interventions values ( 1049,'18/07/2009','Foucher','Saultier',1.5,101,1010);
insert into  interventions values ( 1050,'22/07/2009','Foucher','Saultier',0.5,104,1011);
insert into  interventions values ( 1051,'23/07/2009','Mauras','Bonnaz',2.5,104,1011);
insert into  interventions values ( 1052,'29/07/2009','Mauras','Saultier',1.5,104,1011);


insert into remplacements values ('DT802',1043,1);
insert into remplacements values ('DT711',1043,2);
insert into remplacements values ('DT180',1043,1);
insert into remplacements values ('DT205',1044,1);
insert into remplacements values ('DT125',1045,2);
insert into remplacements values ('DT010',1045,1);
insert into remplacements values ('DT310',1046,1);
insert into remplacements values ('DT711',1047,3);
insert into remplacements values ('DT120',1047,2);
insert into remplacements values ('DT015',1048,1);
insert into remplacements values ('DT180',1049,4);
insert into remplacements values ('DT711',1049,2);
insert into remplacements values ('DT205',1050,1);
insert into remplacements values ('DT711',1051,2);
insert into remplacements values ('DT120',1051,1);
insert into remplacements values ('DT120',1052,3);

insert into tauxhoraire values (1, 20.15 );
insert into tauxhoraire values (2, 24.35 );
insert into tauxhoraire values (3, 30.12 );
insert into tauxhoraire values (4, 35.13 );