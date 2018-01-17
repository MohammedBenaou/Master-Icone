#Mohammed BENAOU et Walid CHERKAOUI
# construction de l'arbre DOM en Python
from xml.dom.minidom import parse
from xml.dom.minidom import Document
import xml.dom.minidom
import sys, time 
docFoaf = parse("foaf.xml")
def getText(nodelist):
    rc = []
    for node in nodelist:
        if node.nodeType == node.TEXT_NODE:
            rc.append(node.data)
    return ''.join(rc)
#retournera l’ensemble des personnes connues par la personne passée en paramètre
def search_friends(doc,namePers):
	docFoaf = parse(doc)
	tagpersons=docFoaf.documentElement.getElementsByTagName('foaf:Person')
	for personne in tagpersons:
		if personne.getAttribute('rdf:nodeID')==namePers :
			tagknows=personne.getElementsByTagName('foaf:knows')
			for know in tagknows:
				if know.hasAttribute('rdf:nodeID')==True:
					print (namePers,' knows : ',know.getAttribute('rdf:nodeID'))
				else:
					childrenPers=know.getElementsByTagName('foaf:Person')
					for children in childrenPers:
						for c in children.getElementsByTagName('foaf:name'):
							print (c.childNodes[0].nodeValue)
# affichage d'un menu  
while True: 
	print ('------------------------------------------')
	print (' 1 Lister les personnes présentes dans le document') 
	print (' 2 Afficher l\'ensemble des personnes connues par une autre personne')
	print (' 3 Générer une arbre DOM')
	print (' 4 Quitter ')
	print ('------------------------------------------')
	x=input('Entrer votre choix ? ') 
	if x=='1' : 
		# Affiche les noms des personnes
		names = docFoaf.getElementsByTagNameNS("http://xmlns.com/foaf/0.1/", "name")
		for name in names:
			n = name
			print(getText(n.childNodes))

	if x=='2':
		print ('saisir le nom') 
		n=input() # passer la personne en parametre
		search_friends('foaf.xml',n)
	if x=='3':
		# création du document XML et de sa racine
		doc = Document()
		persons = doc.createElement('Persons')
		#ajout de l'élément Persons comme élément racine du document
		doc.appendChild(persons)

		# Gestion des ID des personnes
		i = 0
		index = {}
		# Liste des personnes du fichier XML
		personnes = docFoaf.getElementsByTagNameNS("http://xmlns.com/foaf/0.1/","Person")
		#Premier parcours de la liste
		for p in personnes:
			if p.attributes:
				index[p.attributes["rdf:nodeID"].value] = i #On assigne à chaque personne un ID
			else:
				index["autre"] = i
			i = i+1
		#Deuxième parcours de la liste
		for p in personnes:	
			name = p.getElementsByTagNameNS("http://xmlns.com/foaf/0.1/","name") #On récupère le nom de la personne
			person = doc.createElement('Person') #On créé l'élément "person"
			# On créé l'attribut ID et on lui assigne sa valeur
			if p.attributes:
				person.setAttribute('id', str(index[p.attributes["rdf:nodeID"].value]))
			else:
				person.setAttribute('id', str(index["autre"]))
			#On récupère les amis de la personne
			amis = p.getElementsByTagNameNS("http://xmlns.com/foaf/0.1/","knows")
			#On créé l'attribut friend
			for ami in amis:
				if ami.attributes:
					person.setAttribute('friend', str(index[ami.attributes["rdf:nodeID"].value])	)
			
			person.appendChild(doc.createTextNode(getText(name[0].childNodes)))
			persons.appendChild(person)# ajout de l’élément Persons comme élément racine du document
			# écriture du document XML dans un fichier
			file_handle = open("friends.xml", "w")
			doc.writexml(file_handle)
			file_handle.close()
		print('   ==> Le fichier friends.xml a été bien généré')
	if x=='4':
 		sys.exit() # quitter le programme 




