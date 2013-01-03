# -*- encoding: ISO-8859-1 -*-
import Pyro4
import random
from subprocess import Popen
import os
import socket
import platform

from orion_2011_modele import *
from orion_2011_vue import *
from helper import Helper

print(platform.platform())
print(platform.system())
print(platform.python_version_tuple())
print(os.getcwd())
print(os.environ)

class Toto(object):
    def __init__(self):
        self.n=1

t=Toto()
l=[t]
l2=[l[0]]
del t
del l 
del l2[0]
print(l2)


class Controleur(object):
    def __init__(self):
        self.nom=""
        self.cadre=0
        self.actions=[]
        self.serveurLocal=0
        self.serveur=0
        
        s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        s.connect(("gmail.com",80))
        self.monip=s.getsockname()[0]
        s.close()
        
        print(self.monip)

        self.modele=Modele(self)
        #s=input("2")
        self.vue=Vue(self,300,200,self.modele.paramPartie["x_espace"],self.modele.paramPartie["y_espace"])

        #s=input("3")
        
    def creerServeur(self):
        if platform.python_version_tuple()[0]=='3':
            p="python3"
        else:
            p="python"
        print("PPPPP ",p)
        cwd=os.getcwd()
        testJMServeur=cwd+"\\"+"orion_2011_serveur.py"
        #pid = Popen([p, testJMServeur]).pid
        pid = Popen(["python3", "orion_2011_serveur.py"]).pid
        self.serveurLocal=1
        return pid
        
    def jeQuitte(self):
        if self.serveur:
            self.serveur.jeQuitte(self.nom)
        
    def stopServeur(self):
        rep=self.serveur.quitter()
        print(rep)    
        self.serveur=0
        input("FERMER")
        
    def inscritClient(self,nom,leip):
        ad="PYRO:controleurServeur@"+leip+":54440"
        self.serveur=Pyro4.core.Proxy(ad)
        Pyro4.socketutil.setReuseAddr(self.serveur)
        
        rep=self.serveur.inscritClient(nom)
        if rep[0]:
            self.modele.rdseed=rep[2]
            random.seed(self.modele.rdseed)
            self.nom=nom
            #self.vue.canevasEspace.bind("<Button>",self.vue.changeCible)
            self.vue.afficheAttente()
            self.timerAttend()
        else:
            print("NON inscrit: recommencer avec un autre nom !")
        
    def demarrePartie(self):
        rep=self.serveur.demarrePartie()
        print(rep)
                
    def changeCible(self,monid,x,y):
        self.actions.append([self.nom,"changeCible",[monid,x,y]])
    
    # ******  SECTION d'appels automatique
    def timerAttend(self):
        #print("attente1")
        if self.serveur:
            #print("attente2")
            rep=self.serveur.faitAction([self.nom,self.cadre,[]])
            if rep[0]:
                #print("attente3")
                self.modele.initPartie(rep[2][1][0][1])
                self.vue.initPartie(self.modele)
                self.vue.canevasEspace.bind("<Button>",self.vue.changeCible)
                #input("TATA")
                self.vue.root.after(10,self.timerJeu)
            elif rep[0]==0:
                #print(rep[2])
                self.vue.afficheListeJoueurs(rep[2])
                self.vue.root.after(10,self.timerAttend)
        else:
            print("Aucun serveur attache")
        
    def timerJeu(self):
        if self.serveur:
            self.cadre=self.cadre+1
            self.modele.prochaineAction(self.cadre)
            self.vue.afficheArtefact()
            #print("ACTION ENVOYE",self.actions)
            if self.actions:
                rep=self.serveur.faitAction([self.nom,self.cadre,self.actions])
            else:
                rep=self.serveur.faitAction([self.nom,self.cadre,0])
            #print("OUT",self.cadre)
            #print("BACK")
            self.actions=[]
            if rep[0]:
                #print(rep)
                #input("QUELQUE CHOSE SUR LE RADAR")
                for i in rep[2]:
                    if i in self.modele.actionsAFaire.keys():
                        for k in rep[2][i]:
                            for m in k:
                                self.modele.actionsAFaire[i].append(m)
                    else:
                        for k in rep[2][i]:
                            for m in k:
                                self.modele.actionsAFaire[i]=[m]
                print("ACTIONS",self.cadre,"\nREP",rep,"\nACTIONAFAIRE",self.modele.actionsAFaire)  
            if rep[1]=="attend":
                self.cadre=self.cadre-1       
#                                
#                        if j[0]=="creerVaisseau" and j[1][0]==self.nom:
#                            self.modele.vaisseau=Vaisseau(j[1])
#                        elif j[0]=="creerVaisseau":
#                            self.modele.vaisseaux.append(Vaisseau(j[1]))
#                        elif j[0]=="changeCible":
#                            self.modele.changerCible(j[1])
            
            self.vue.root.after(50,self.timerJeu)
        else:
            print("Aucun serveur connu")
        
if __name__ == '__main__':
    #s=input("1")
    c=Controleur()
    c.vue.root.mainloop()
    print("FIN")
