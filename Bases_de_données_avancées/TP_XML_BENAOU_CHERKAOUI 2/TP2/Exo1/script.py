import xml.sax


class myclass(xml.sax.ContentHandler):
		# initialisaion du constructeur
	def __init__(self):
		self.countcd=0 # conteur des cd
		self.countdvd=0 # conteur des dvd
		self.blueray=0	# conteur des blueray
		self.sacd=0	# conteur de SACD
		self.listeTitre=[] # la liste des titres de tous les CD
		##################
		self.testone=0
		self.testtwo=0
		# on teste sur le fichier mediatheque.xml 
	def startElement(self,name,	attrs):		
		if self.testone==1:
			if name=="titre":
				self.testtwo=1	
				self.testone=0
		# si on trouve cd incrementation du conteur cd 
		if name=="cd":
			self.countcd=self.countcd+1
			self.testone=1
			for k,v in attrs.items():
				# si on trouve SACD incrementation du conteur SACD 
				if v == "SACD":
					self.sacd=self.sacd+1
		# si on trouve dvd incrementation du conteur dvd 	
		if name=="dvd":
			self.countdvd=self.countdvd+1
		# si on trouve blue-ray incrementation du conteur blue-ray
		if name=="blue-ray":
			self.blueray=self.blueray+1	

	def characters(self, data):
		if self.testtwo==1:
			self.listeTitre.append(data)
			self.testtwo=0
			# affichege 
	def endDocument(self):
		print "le nombre de CD est : ",self.countcd
		print "le nombre de DVD est : ",self.countdvd
		print "le nombre de blue-ray est : ",self.blueray	
		print "le nombre de SACD est : ",self.sacd
		print "La liste des titres : "
		for a in self.listeTitre:
			print (a)

parser = xml.sax.make_parser()
parser.setContentHandler(myclass())
parser.parse(open("mediatheque.xml","r"))