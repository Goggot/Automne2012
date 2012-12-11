# -*- coding: ISO-8859-1 -*-
'''
Created on 2012-09-07

@author: jmd

Jeu de defense de tours
 deux patrons de parcours
 les niveaux incremente la difficulté
    en augmentant la force des creeps
    en augmentant le nombre de creeps

les tours peuvent bénéficier d'ameliorations
   en terme de morts occasionées
   et d'argent disponible
'''

import random

class Parcours():
    def __init__(self):
        self.noeuds1=[[0,10],
                     [50,10],
                     [50,80],
                     [100,80]]
        
        self.noeuds=[[0,10],
                     [20,10],
                     [20,40],
                     [50,40],
                     [50,20],
                     [80,20],
                     [80,60],
                     [30,60],
                     [30,80],
                     [100,80]]

class Tour():
    def __init__(self,parent,pos):
        self.parent=parent
        self.pos=pos
        self.cible=[0,0]
        self.vitesse=5
        self.force=1

class Creep():
    def __init__(self,parent):
        self.parent=parent
        self.pos=self.parent.parcours.noeuds[0][:]
        self.cible=1 #indice du noeud de parcours a atteindre
        if self.pos[0]!=self.parent.parcours.noeuds[1][0]: # on simplifie le mouvement en verifiant uniquement l'axe de deplacement
            self.axe=0
            if self.pos[0]<self.parent.parcours.noeuds[1][0]:
                self.dir=1
            else:
                self.dir=-1
        else:
            self.axe=1
            if self.pos[1]<self.parent.parcours.noeuds[1][1]:
                self.dir=1
            else:
                self.dir=-1
        self.vitesse=2
        self.force=10
        
    def bouge(self):
        #ajoute test pour changer de noeud
        #self.pos[self.axe]=self.pos[self.axe]+self.vitesse
        
        paxe=self.pos[self.axe]+(self.vitesse*self.dir)
        
        
        if self.dir==1:
            if paxe > self.parent.parcours.noeuds[self.cible][self.axe]:
                if self.cible<len(self.parent.parcours.noeuds)-1:
                    print(self.cible,len(self.parent.parcours.noeuds)-1)
                    newpaxe=paxe-self.parent.parcours.noeuds[self.cible][self.axe]
                    self.pos=self.parent.parcours.noeuds[self.cible][:]
                    self.cible= self.cible+1
                    if self.axe==1:
                        self.axe=0
                        if self.pos[0]<self.parent.parcours.noeuds[self.cible][0]:
                            self.dir=1
                        else:
                            self.dir=-1
                    else:
                        self.axe=1
                        if self.pos[1]<self.parent.parcours.noeuds[self.cible][1]:
                            self.dir=1
                        else:
                            self.dir=-1
                else:
                    self.parent.creepsEnCours.remove(self)
            else:
                self.pos[self.axe]=paxe
        else:
            if paxe < self.parent.parcours.noeuds[self.cible][self.axe]:
                if self.cible<len(self.parent.parcours.noeuds)-1:
                    newpaxe=self.parent.parcours.noeuds[self.cible][self.axe]+paxe
                    self.pos=self.parent.parcours.noeuds[self.cible][:]
                    self.cible= self.cible+1
                    if self.axe==0:
                        self.axe=1
                        if self.pos[1]<self.parent.parcours.noeuds[self.cible][1]:
                            self.dir=1
                        else:
                            self.dir=-1
                    else:
                        self.axe=0
                        if self.pos[0]<self.parent.parcours.noeuds[self.cible][0]:
                            self.dir=1
                        else:
                            self.dir=-1
                else:
                    self.parent.creepsEnCours.remove(self)
            else:
                self.pos[self.axe]=paxe
        
class Nivo():
    def __init__(self,parent):
        self.parent=parent
        self.parcours = Parcours()
        self.densiteCreep=3
        self.tours=[]
        self.creeps=[]
        self.creepsEnCours=[]
        self.creeCreep()
        
    def ajouteTour(self,pos):
        self.tours.append(Tour(self,pos))
        
        
    def creeCreep(self):
        for i in range(self.parent.creepparnivo):
            self.creeps.append(Creep(self))
            
    def bougeCreep(self):
        if self.creeps:
            ajoute=0
            c=self.creeps[0]
            if self.creepsEnCours:
                cPrecedent=self.creepsEnCours[0]
                if cPrecedent.cible==1: # onverifie si le dernier creep parti est assez loin seulement s'il est sur le même tronçon
                    if cPrecedent.pos[c.axe]>c.pos[c.axe]+c.parent.densiteCreep:
                        ajoute=1
            else:
                ajoute=1
            if ajoute:
                c=self.creeps.pop(0)
                c.pos=self.parcours.noeuds[0][:] # on positionne le creep sur le prmier noeud
                c.cible=1 #on vise le prochain noeud, le deuxieme
                self.creepsEnCours.insert(0,c)
        n=0
        for i in self.creepsEnCours:
            n=n+1
            i.bouge()
            
    def setTour(self,pos):
        print("NIVO",pos)
        self.tours.append(Tour(self,pos))
        
class Modele():
    def __init__(self, parent):
        self.parent=parent
        self.vie=20
        self.cash=0
        self.creepparnivo=12
        self.creepforce=5
        self.nivo=0
        
    def demarrePartie(self):
        self.nivo=self.nivo+1
        self.nivoActif=Nivo(self)
    def setTour(self,pos):
        print("MODELE",pos)
        self.nivoActif.setTour(pos)

if __name__ == '__main__':
    m=Modele(1)
    m.demarrePartie()
    print(m.nivo.creeps)
    print("FIN")