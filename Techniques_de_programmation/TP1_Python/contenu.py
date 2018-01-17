with open('donnees.rss') as c:
    content = c.read()
start=content.find("<item>")
end=content.find("<\item>")
data=content[start:end]
lines=data.split('\n')
searchString = ("<dataset:")
start1=content.find("<dataset:reseau>")
end1=content.find("</dataset:reseau>")
reseau=content[start1:end1]
start2=content.find("<dataset:station>")
end2=content.find("</dataset:station>")
station=content[start2:end2]
start3=content.find("<dataset:trafic>")
end3=content.find("</dataset:trafic>")
trafic=content[start3:end3]
start4=content.find("<dataset:ville>")
end4=content.find("</dataset:ville>")
ville=content[start1:end1]
dictionnair={}
dictionnair["nom de station"]=(station)
dictionnair["réseau concerné"]=(reseau)
dictionnair["trafic de la station"]=(trafic)
dictionnair["la ville"]=(ville)
print(dictionnair)