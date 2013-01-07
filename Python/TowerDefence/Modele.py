# -*- coding: ISO-8859-1 -*-
""" LE BON FICHIER """
import random
import math
from os import path #verifier si le fichier scores.txt existe ou non

class Parcours():
    def __init__(self):
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

""" Classe de tour de type MINIGUN contenant ses caractéristiques """
class Minigun():
    def __init__(self,parent,pos):
        self.parent=parent 
        self.lvl = 1
        self.prixUpgrade = 25*self.lvl*2
        self.pos=pos
        self.type = "minigun"
        self.attaqueReussi = 0 # Empeche la tour d'attaquer plus qu'une fois par code
        self.force = 2 # Puissance d'attaque de la tour
        self.range = 15
        self.attaquePossible = False # Un creep se trouve-t-il dans le rayon d'action ?
        self.cible = 0
        self.distanceCourant = 0 # Pour comparer la distance entre sa cible et la sortie à celle d'une autre cible potentielle
        self.derniereAttaque = 0
        self.valeurVente = self.prixUpgrade * 0.75

""" Classe de tour de type CANON contenant ses caractéristiques """
class Canon():
    def __init__(self,  parent,  pos):
        self.parent=parent
        self.lvl = 1
        self.prixUpgrade = 50*self.lvl*2
        self.pos=pos
        self.type = "canon"
        self.attaqueReussi = 0 # Empeche la tour d'attaquer plus qu'une fois par code
        self.force = 15 # Puissance d'attaque de la tour
        self.range = 30
        self.attaquePossible = False # Un creep se trouve-t-il dans le rayon d'action ?
        self.cible = 0
        self.distanceCourant = 0 # Pour comparer la distance entre sa cible et la sortie à celle d'une autre cible potentielle
        self.derniereAttaque = 0
        self.valeurVente = self.prixUpgrade * 0.75

""" Classe de tour de type SLOW contenant ses caractéristiques """
class Slow():
    def __init__ (self, parent,  pos):
        self.parent=parent
        self.pos=pos
        self.lvl = 1
        self.prixUpgrade = 40*self.lvl*2
        self.type = "slow"
        self.attaqueReussi = 0 # Empeche la tour d'attaquer plus qu'une fois par code
        self.force=2 # Puissance d'attaque de la tour
        self.range = 20
        self.attaquePossible = False # Un creep se trouve-t-il dans le rayon d'action ?
        self.cible = 0
        self.distanceCourant = 0 # Pour comparer la distance entre sa cible et la sortie à celle d'une autre cible potentielle
        self.derniereAttaque = 0
        self.valeurVente = self.prixUpgrade * 0.75

""" Classe de tour de type LASER contenant ses caractéristiques """
class Laser():
    def __init__ (self,  parent,  pos):
        self.parent=parent
        self.pos=pos
        self.lvl = 1
        self.prixUpgrade = 1000*self.lvl
        self.type = "laser"
        self.attaqueReussi = 0 # Empeche la tour d'attaquer plus qu'une fois par code
        self.attaqueCourant = False
        self.force = 1 # Puissance d'attaque de la tour
        self.range = 30
        self.attaquePossible = False # Un creep se trouve-t-il dans le rayon d'action ?
        self.cible = 0
        self.distanceCourant = 0 # Pour comparer la distance entre sa cible et la sortie à celle d'une autre cible potentielle
        self.derniereAttaque = 0
        self.valeurVente = self.prixUpgrade * 0.75

""" Classe de projectile contenant les caractéristiques de chacun """
class Projectile():
    def __init__(self, pos, cible, dmg, type, range, mamanTour, id):    # mamanTour !
        self.type = type
        self.mamanTour = mamanTour #Tour qui a créer ce projectile
        self.dmg = dmg
        self.range = range
        self.posDepart = pos[:]
        self.pos = pos[:]
        self.cible = cible
        self.longueurPas = 2
        self.id = id

""" Classe de creep de type DALEK contenant ses caractéristiques """
class Dalek():
    def __init__(self,parent,pos,difficulte):
        self.parent=parent
        self.pos=pos
        self.frozen = False
        self.compteurFrozen = -1 
        self.ancienLP = 0.5 # Longueur pas par defaut
        self.cible = 1
        self.longueurPas = 0.5 # Vitesse
        self.forceMax = 30*difficulte
        self.force = 30*difficulte # Vie
        self.reward = 5*difficulte
        self.distance = 0 # Distance entre ce creep et la sortie

    """ Définition des mouvements du Dalek """
    def bouge(self):
        if self.frozen == True and self.compteurFrozen == -1:       # Si le dalek est de glace avec un temps positif
            self.longueurPas *= 0.5                                     # Sa vitesse de pas diminue
            self.compteurFrozen = 150
        elif self.frozen == True and self.compteurFrozen > 0:       # Si le dalek est de glace avec un compteur toujours positif
            self.compteurFrozen -= 1                                    # Sa vitesse reste lente, le compteur diminue
        elif self.frozen == True and self.compteurFrozen == 0:      # Si le dalek est de glace mais avec un compteur null
            self.frozen = False                                         # Sa vitesse redevient normal
            self.longueurPas = self.ancienLP
            self.compteurFrozen -= 1
            
        if self.pos != self.parent.parcours.noeuds[self.cible]:
            if self.pos[0] == self.parent.parcours.noeuds[self.cible][0]:
                if self.pos[1] < self.parent.parcours.noeuds[self.cible][1]:
                    if self.pos[1] + self.longueurPas > self.parent.parcours.noeuds[self.cible][1]:
                        self.pos[1] = self.parent.parcours.noeuds[self.cible][1]
                    else:
                        self.pos[1] += self.longueurPas
                else:
                    if self.pos[1] - self.longueurPas < self.parent.parcours.noeuds[self.cible][1]:
                        self.pos[1] = self.parent.parcours.noeuds[self.cible][1]
                    else:
                        self.pos[1] -= self.longueurPas
            else:
                if self.pos[0] < self.parent.parcours.noeuds[self.cible][0]:
                    if self.pos[0] + self.longueurPas > self.parent.parcours.noeuds[self.cible][0]:
                        self.pos[0] = self.parent.parcours.noeuds[self.cible][0]
                    else:
                        self.pos[0] += self.longueurPas
                else:
                    if self.pos[0] - self.longueurPas < self.parent.parcours.noeuds[self.cible][0]:
                        self.pos[0] = self.parent.parcours.noeuds[self.cible][0]
                    else:
                        self.pos[0] -= self.longueurPas
        else:
            if self.cible < 9:
                self.cible +=1
            else:
                if self.force > 0:
                    self.parent.vie -= 1
                self.parent.creepsEnCours.remove(self)

""" Classe de creep de type CYBERMAN contenant ses caractéristiques """
class Cyberman():
    def __init__(self,parent,pos,difficulte):
        self.parent=parent
        self.pos=pos
        self.frozen = False
        self.compteurFrozen = -1
        self.ancienLP = 3
        self.cible = 1
        self.longueurPas = 1 # Vitesse
        self.forceMax = 15*difficulte
        self.force = 15*difficulte # Vie
        self.reward = 5*difficulte
        self.distance = 0

    """ Définition des mouvements du Cyberman """
    def bouge(self):
        if self.frozen == True and self.compteurFrozen == -1:       # Si le cyberman est de glace avec un temps positif
            self.longueurPas *= 0.5                                     # Sa vitesse de pas diminue
            self.compteurFrozen = 150
        elif self.frozen == True and self.compteurFrozen > 0:       # Si le cyberman est de glace avec un compteur toujours positif
            self.compteurFrozen -= 1                                    # Sa vitesse reste lente, le compteur diminue
        elif self.frozen == True and self.compteurFrozen == 0:      # Si le cyberman est de glace mais avec un compteur null
            self.frozen = False                                         # Sa vitesse redevient normal
            self.longueurPas = self.ancienLP
            self.compteurFrozen -= 1
            
        if self.pos != self.parent.parcours.noeuds[self.cible]:
            if self.pos[0] == self.parent.parcours.noeuds[self.cible][0]:
                if self.pos[1] < self.parent.parcours.noeuds[self.cible][1]:
                    if self.pos[1] + self.longueurPas > self.parent.parcours.noeuds[self.cible][1]:
                        self.pos[1] = self.parent.parcours.noeuds[self.cible][1]
                    else:
                        self.pos[1] += self.longueurPas
                else:
                    if self.pos[1] - self.longueurPas < self.parent.parcours.noeuds[self.cible][1]:
                        self.pos[1] = self.parent.parcours.noeuds[self.cible][1]
                    else:
                        self.pos[1] -= self.longueurPas
            else:
                if self.pos[0] < self.parent.parcours.noeuds[self.cible][0]:
                    if self.pos[0] + self.longueurPas > self.parent.parcours.noeuds[self.cible][0]:
                        self.pos[0] = self.parent.parcours.noeuds[self.cible][0]
                    else:
                        self.pos[0] += self.longueurPas
                else:
                    if self.pos[0] - self.longueurPas < self.parent.parcours.noeuds[self.cible][0]:
                        self.pos[0] = self.parent.parcours.noeuds[self.cible][0]
                    else:
                        self.pos[0] -= self.longueurPas
        else:
            if self.cible < 9:
                self.cible +=1
            else:
                if self.force > 0:
                    self.parent.vie -= 1
                self.parent.creepsEnCours.remove(self)

""" Classe de creep de type BOSS contenant ses caractéristiques """
class Boss():
    def __init__(self,parent,pos,difficulte):
        self.parent=parent
        self.pos=pos
        self.frozen = False
        self.compteurFrozen = -1
        self.ancienLP = 0.1
        self.cible = 1
        self.longueurPas=0.1 # Vitesse
        self.forceMax = 1000*difficulte
        self.force = 1000*difficulte # Vie
        self.reward = 150*difficulte
        self.distance = 0

    """ Définition des mouvements du Boss """
    def bouge(self):
        if self.frozen == True and self.compteurFrozen == -1:       # Si le boss est de glace avec un temps positif
            self.longueurPas *= 0.5                                     # Sa vitesse de pas diminue
            self.compteurFrozen = 150
        elif self.frozen == True and self.compteurFrozen > 0:       # Si le boss est de glace avec un compteur toujours positif
            self.compteurFrozen -= 1                                    # Sa vitesse reste lente, le compteur diminue
        elif self.frozen == True and self.compteurFrozen == 0:      # Si le boss est de glace mais avec un compteur null
            self.frozen = False                                         # Sa vitesse redevient normal
            self.longueurPas = self.ancienLP
            self.compteurFrozen -= 1
            
        if self.pos != self.parent.parcours.noeuds[self.cible]:
            if self.pos[0] == self.parent.parcours.noeuds[self.cible][0]:
                if self.pos[1] < self.parent.parcours.noeuds[self.cible][1]:
                    if self.pos[1] + self.longueurPas > self.parent.parcours.noeuds[self.cible][1]:
                        self.pos[1] = self.parent.parcours.noeuds[self.cible][1]
                    else:
                        self.pos[1] += self.longueurPas
                else:
                    if self.pos[1] - self.longueurPas < self.parent.parcours.noeuds[self.cible][1]:
                        self.pos[1] = self.parent.parcours.noeuds[self.cible][1]
                    else:
                        self.pos[1] -= self.longueurPas
            else:
                if self.pos[0] < self.parent.parcours.noeuds[self.cible][0]:
                    if self.pos[0] + self.longueurPas > self.parent.parcours.noeuds[self.cible][0]:
                        self.pos[0] = self.parent.parcours.noeuds[self.cible][0]
                    else:
                        self.pos[0] += self.longueurPas
                else:
                    if self.pos[0] - self.longueurPas < self.parent.parcours.noeuds[self.cible][0]:
                        self.pos[0] = self.parent.parcours.noeuds[self.cible][0]
                    else:
                        self.pos[0] -= self.longueurPas
        else:
            if self.cible < 9:
                self.cible +=1
            else:
                if self.force > 0:
                    self.parent.vie -= 1
                self.parent.creepsEnCours.remove(self)
      
class Nivo():
    def __init__(self,parent):
        self.parent=parent
        self.multiplicateur = self.parent.parent.vue.multiplicateur
        self.lvl = 1
        self.debut = 0
        self.present = 0
        self.secEcoulees = 0
        self.creepparnivo=5
        self.creepsDetruits=0
        self.ajoute = 0
        self.nbsec = 0.1
        self.vie = 10
        self.cash = 80
        self.score = 0
        self.nbVagues = 1
        self.parcours = Parcours()
        self.nbTours = 0
        self.tours={"Minigun": [], "Slow":[], "Canon":[], "Laser":[]}
        self.creeps=[]
        self.creepsEnCours=[]
        self.creeCreep()
        self.matriceTours=[]     
        self.tabProjectiles = []
        self.derniereAttaqueTour = 0
        self.idProjectile = 0
        self.tourSelectionnee = 0
        
    def distanceRestante(self):
        for x in self.creepsEnCours:            # Calcul de la distance avant la fin pour chaque creep du tableau
            distance = 0
            dernierNoeud = len(self.parcours.noeuds) - 1
            i = x.cible
            
            while i<dernierNoeud:               # Tant que le noeud final n'est pas atteint, la distance diminue
                if self.parcours.noeuds[i][0]==self.parcours.noeuds[i+1][0]:
                    # Valeur absolue
                    distance+=((self.parcours.noeuds[i][1]-self.parcours.noeuds[i+1][1])**2)**0.5
                else:
                    # Valeur absolue
                    distance+=((self.parcours.noeuds[i][0]-self.parcours.noeuds[i+1][0])**2)**0.5
                i+=1

            if x.pos[0] == self.parcours.noeuds[x.cible][0]:
                # Valeur absolue
                distance+=((x.pos[1]- self.parcours.noeuds[x.cible][1])**2)**0.5
            else:
                # Valeur absolue
                distance+=((x.pos[0]- self.parcours.noeuds[x.cible][0])**2)**0.5
                        
            x.distance = distance
    
    def nouvelleVague(self):
        self.nbVagues+=1
        if self.nbVagues % 3 == 0:          # Si bonne vague (toute les 3 vagues)
            posCreep = self.parcours.noeuds[0][:]
            self.creepsEnCours.append(Boss(self,posCreep,self.lvl))
            self.lvl += 1
        elif self.nbVagues % 2 == 0:          # Si bonne vague(toute les 3 vagues)
            for i in range(self.creepparnivo):
                posCreep = self.parcours.noeuds[0][:]
                posCreep[0] -= 5*i
                self.creepsEnCours.append(Cyberman(self,posCreep,self.lvl))
        else:
            for i in range(self.creepparnivo): # Si bonne vague(toute les 3 vagues)
                posCreep = self.parcours.noeuds[0][:]
                posCreep[0] -= 5*i
                self.creepsEnCours.append(Dalek(self,posCreep,self.lvl))
                
    def creeCreep(self):                            # Creation des creeps dans le tableau
        for i in range(self.creepparnivo):
            posCreep = self.parcours.noeuds[0][:]
            posCreep[0] -= 5*i
            self.creepsEnCours.append(Dalek(self,posCreep,self.lvl))  
            
    def bougeCreep(self):
        for i in self.creepsEnCours:
            i.bouge()
        
    def attaque(self):
        for key,  i in self.tours.items():          # Pour chaque sorte de tour (key), parcours des items de la liste (i)
            for x in i:
                x.attaqueReussi = 0
                x.distanceCourant = 1000
                x.attaquePossible = False
        
        for key,  i in self.tours.items():          # Pour chaque sorte de tour (key), parcours des items de la liste (i)
            for x in i:
                if x.type == "laser" and x.cible:       # Si tour Laser qui avait une cible
                    distanceX = x.pos[0] - x.cible.pos[0]
                    distanceY = x.pos[1] - x.cible.pos[1]     # Calcul de la position de la cible
                    distanceTotal = (distanceX**2 + distanceY**2)**0.5
                    if distanceTotal > x.range:         # Si cible hors de portée
                        x.attaqueCourant = False            # Stop l'attaque
                    if x.cible == None:                 # Si cible disparu
                        x.attaqueCourant = False            # Stop l'attaque

        for key, i in self.tours.items():           # Pour chaque sorte de tour (key), parcours des items de la liste (i)
            for x in i:
                if x.attaqueReussi == 0:
                    for j in range(len(self.creepsEnCours)):    # Parcours de la liste des creeps sur le jeu
                        distanceX = x.pos[0] - self.creepsEnCours[j].pos[0]     # Calcul de la position du creep selectionne
                        distanceY = x.pos[1] - self.creepsEnCours[j].pos[1]
                        distanceTotal = (distanceX**2 + distanceY**2)**0.5
                        if distanceTotal <= x.range:                            # Si creep a distance d'une tour et toujours en vie
                            if self.creepsEnCours[j].distance <= x.distanceCourant and self.creepsEnCours[j].force > 0:
                                if x.type == "laser" and x.attaqueCourant == False:  # Si tour laser
                                    x.distanceCourant = self.creepsEnCours[j].distance      # ATTAQUE !!!
                                    x.cible = self.creepsEnCours[j]
                                    x.attaquePossible = True
                                    x.attaqueCourant = True
                                elif x.type == "canon":                             # Si tour Canon
                                    if self.present - x.derniereAttaque > 1:            # Si temps entre les attaques correct
                                        x.distanceCourant = self.creepsEnCours[j].distance  # ATTAQUE !!!
                                        x.cible = self.creepsEnCours[j]
                                        x.attaquePossible = True
                                        x.derniereAttaque = self.present
                                elif x.type == "slow":                              # Si tour Slow
                                    if self.present - x.derniereAttaque > 1:
                                        if self.creepsEnCours[j].frozen == False:       # Si creep pas encore congele
                                            x.distanceCourant = self.creepsEnCours[j].distance
                                            x.cible = self.creepsEnCours[j]                   # ATTAQUE !!!
                                            x.attaquePossible = True
                                            x.derniereAttaque = self.present
                                elif x.type == "minigun":
                                    x.distanceCourant = self.creepsEnCours[j].distance
                                    x.cible = self.creepsEnCours[j]                       # ATTAQUE !!!
                                    x.attaquePossible = True
                                                 
                    if x.attaquePossible == True:
                        self.idProjectile += 1
                        self.tabProjectiles.append(Projectile(x.pos, x.cible, x.force, x.type, x.range, x, self.idProjectile))
                        x.attaqueReussi = 1
                        x.attaquePossible = False
                        if x.cible.force <= 0:
                            self.cash += self.creepsEnCours[x.cible].reward
                            self.creepsDetruits += 1
                                
                                        
    def bougeProjectile(self):
        tabProjectilesDetruits = []           
        for i in range(len(self.tabProjectiles)):
            if self.tabProjectiles[i].type == "minigun" or self.tabProjectiles[i].type == "slow" or self.tabProjectiles[i].type == "canon":
                                        # Calcul des coordonnées X
                if self.tabProjectiles[i].pos[0]<self.tabProjectiles[i].cible.pos[0]:
                    if self.tabProjectiles[i].cible.pos[0]-self.tabProjectiles[i].pos[0]<self.tabProjectiles[i].longueurPas:
                        self.tabProjectiles[i].pos[0]=self.tabProjectiles[i].cible.pos[0]
                    else:
                        self.tabProjectiles[i].pos[0]+=self.tabProjectiles[i].longueurPas
                elif self.tabProjectiles[i].pos[0]>self.tabProjectiles[i].cible.pos[0]:
                    if self.tabProjectiles[i].pos[0]-self.tabProjectiles[i].cible.pos[0]<self.tabProjectiles[i].longueurPas:
                        self.tabProjectiles[i].pos[0]=self.tabProjectiles[i].cible.pos[0]
                    else:
                        self.tabProjectiles[i].pos[0]-=self.tabProjectiles[i].longueurPas
                                        # Calcul des coordonnées Y
                if self.tabProjectiles[i].pos[1]<self.tabProjectiles[i].cible.pos[1]:
                    if self.tabProjectiles[i].cible.pos[1]-self.tabProjectiles[i].pos[1]<self.tabProjectiles[i].longueurPas:
                        self.tabProjectiles[i].pos[1]=self.tabProjectiles[i].cible.pos[1]
                    else:
                        self.tabProjectiles[i].pos[1]+=self.tabProjectiles[i].longueurPas
                elif self.tabProjectiles[i].pos[1]>self.tabProjectiles[i].cible.pos[1]:
                    if self.tabProjectiles[i].pos[1]-self.tabProjectiles[i].cible.pos[1]<self.tabProjectiles[i].longueurPas:
                        self.tabProjectiles[i].pos[1]=self.tabProjectiles[i].cible.pos[1]
                    else:
                        self.tabProjectiles[i].pos[1]-=self.tabProjectiles[i].longueurPas
                
                if self.tabProjectiles[i].pos == self.tabProjectiles[i].cible.pos:      # Si projectile sur position de la cible
                    if self.tabProjectiles[i].type == "slow":                               # Si c'est une tour Slow qui tire
                        if self.tabProjectiles[i].cible.force - self.tabProjectiles[i].dmg <= 0:    # Si cible detruite
                            self.parent.nivoActif.cash += self.tabProjectiles[i].cible.reward
                            self.tabProjectiles[i].cible.reward = 0
                            self.creepsDetruits += 1        # Destruction creep
                        self.tabProjectiles[i].cible.force -= self.tabProjectiles[i].dmg
                        self.tabProjectiles[i].cible.frozen = True   
                        tabProjectilesDetruits.append(i)    # Destruction missile
                    else:                                                                   # Si ce n'est pas une tour Slow
                        if self.tabProjectiles[i].cible.force - self.tabProjectiles[i].dmg <= 0:    # Si cible detruite
                            self.parent.nivoActif.cash += self.tabProjectiles[i].cible.reward
                            self.tabProjectiles[i].cible.reward = 0
                            self.creepsDetruits += 1        # Destruction creep
                        self.tabProjectiles[i].cible.force -= self.tabProjectiles[i].dmg    
                        tabProjectilesDetruits.append(i)    # Destruction missile
                    
            if self.tabProjectiles[i].type == "laser":          # Si projectile de type Laser
                self.tabProjectiles[i].pos = self.tabProjectiles[i].cible.pos       # Attribution de la position
                distanceX = self.tabProjectiles[i].pos[0] - self.tabProjectiles[i].posDepart[0]     # Calcul de la position
                distanceY = self.tabProjectiles[i].pos[1] - self.tabProjectiles[i].posDepart[1]
                distanceTotal = (distanceX**2 + distanceY**2)**0.5
                if self.tabProjectiles[i].cible.force - self.tabProjectiles[i].dmg <= 0:
                    tabProjectilesDetruits.append(i)
                    self.tabProjectiles[i].mamanTour.attaqueCourant = False
                    self.parent.nivoActif.cash += self.tabProjectiles[i].cible.reward
                    self.tabProjectiles[i].cible.reward = 0
                    self.creepsDetruits += 1
                self.tabProjectiles[i].cible.force -= self.tabProjectiles[i].dmg
                if distanceTotal > self.tabProjectiles[i].range:
                    tabProjectilesDetruits.append(i)
                    
        
        i = len(tabProjectilesDetruits) -1
        while i >= 0:
            self.tabProjectiles.remove(self.tabProjectiles[tabProjectilesDetruits[i]])
            i-=1
        
    def setTour(self,pos,type):                                 # Creation des tours
        positionVide = True
        
        print(self.tourSelectionnee)
           
        for key, i in self.tours.items():                           # Calcul de la distance et vérification de la place
            for x in i:                                                 # disponible pour placer la tour
                distanceX = x.pos[0] - pos[0]
                distanceY = x.pos[1] - pos[1]
                distanceTotal = (distanceX**2 + distanceY**2)**0.5
                if distanceTotal < 10:
                    positionVide = False
            
        if positionVide == True:
            if type == 0:                                           # Si tour est de type Minigun (1)
                if self.parent.nivoActif.cash - 20 >= 0:
                    self.parent.nivoActif.cash -= 20
                    self.tours["Minigun"].append(Minigun(self, pos))   # Ajout de la tour dans le dictionnaire
                    self.tourSelectionnee = False
                else:
                    self.tourSelectionnee = False
                    print ("Pas assez d'argent")
                
            elif type == 1:                                         # Si tour est de type Slow (2)
                if self.parent.nivoActif.cash - 75 >= 0:
                    self.parent.nivoActif.cash -= 75
                    self.tours["Slow"].append(Slow(self, pos))         # Ajout de la tour dans le dictionnaire
                    self.tourSelectionnee = False
                else:
                    self.tourSelectionnee = False
                    print ("Pas assez d'argent")

            elif type == 2:                                         # Si tour est de type Canon (3)
                if self.parent.nivoActif.cash - 50 >= 0:
                    self.parent.nivoActif.cash -= 50
                    self.tours["Canon"].append(Canon(self, pos))        # Ajout de la tour dans le dictionnaire
                    self.tourSelectionnee = False
                else:
                    self.tourSelectionnee = False
                    print ("Pas assez d'argent")

            elif type == 3:                                         # Si tour est de type Laser (4)
                if self.parent.nivoActif.cash - 200 - 2*self.nbTours >= 0:
                    self.parent.nivoActif.cash -= (200 + 2*self.nbTours)
                    self.tours["Laser"].append(Laser(self, pos))        # Ajout de la tour dans le dictionnaire
                    self.tourSelectionnee = False
                else:
                    self.tourSelectionnee = False
                    print ("Pas assez d'argent")

            self.nbTours+=1
        
        if self.tourSelectionnee != False:                          # Si clique sur une tour deja en place
            for key, i in self.tours.items():
                for x in i:
                    if int(pos[0]) in range(int(x.pos[0]-5),int(x.pos[0]+5)):
                        if int(pos[1]) in range(int(x.pos[1] -5),int(x.pos[1] +5)):
                            self.tourSelectionnee = x                   # La tour selectionnee est celle se trouvant
                                                                            # a l'emplacement du clique

        else:
            for key, i in self.tours.items():                       # Sinon
                for x in i:
                    if int(pos[0]) in range(int(x.pos[0]-5),int(x.pos[0]+5)):
                        if int(pos[1]) in range(int(x.pos[1] -5),int(x.pos[1] +5)):
                            self.tourSelectionnee = x

        
    def upgradeTour(self):                                          # Upgrade des tours
        if self.tourSelectionnee.type == "minigun":                     # Si la tour est de type Minigun
            if self.tourSelectionnee.prixUpgrade < self.cash:               # Initialisation des variables de tourSelectionnee
                self.cash -= self.tourSelectionnee.prixUpgrade
                self.tourSelectionnee.force *= 2
                self.tourSelectionnee.lvl +=1
            else:
                print("Plus assez d'argent")
        if self.tourSelectionnee.type == "canon":                       # Si la tour est de type Canon
            if self.tourSelectionnee.prixUpgrade < self.cash:               # Initialisation des variables de tourSelectionnee
                self.tourSelectionnee.force *= 2
                self.tourSelectionnee.lvl +=1
                self.cash -= self.tourSelectionnee.prixUpgrade
            else:
                print("Plus assez d'argent")
        if self.tourSelectionnee.type == "slow":                        # Si la tour est de type Slow
            if self.tourSelectionnee.prixUpgrade < self.cash:               # Initialisation des variables de tourSelectionnee
                self.tourSelectionnee.range += 2
                self.tourSelectionnee.lvl +=1
                self.cash -= self.tourSelectionnee.prixUpgrade
            else:
                print("Plus assez d'argent")
        if self.tourSelectionnee.type == "laser":                       # Si la tour est de type Laser
            if self.tourSelectionnee.prixUpgrade < self.cash:               # Initialisation des variables de tourSelectionnee
                if self.tourSelectionnee.lvl < 3:
                    self.tourSelectionnee.force *= 1.5
                    self.tourSelectionnee.lvl +=1
                    self.cash -= self.tourSelectionnee.prixUpgrade
            else:
                print("Plus assez d'argent")
            
    def vendreTour(self):                                           # Vente des tours
        self.cash += self.tourSelectionnee.valeurVente                  # Augmentation du cash
        if self.tourSelectionnee.type == "minigun":                     # Si la tour est de type Minigun
            self.tours["Minigun"].remove(self.tourSelectionnee)             # Supprimer la tour Minigun
        if self.tourSelectionnee.type == "canon":                       # Si la tour est de type Canon
            self.tours["Canon"].remove(self.tourSelectionnee)               # Supprimer la tour Canon
        if self.tourSelectionnee.type == "slow":                        # Si la tour est de type Slow
            self.tours["Slow"].remove(self.tourSelectionnee)                # Supprimer la tour Slow
        if self.tourSelectionnee.type == "laser":                       # Si la tour est de type Laser
            self.tours["Laser"].remove(self.tourSelectionnee)               # Supprimer la tour Laser
        self.tourSelectionnee = False                                   # Aucune tour selectionnee
            
class Modele():
    def __init__(self, parent):
        self.parent=parent
        self.tabScores = []
        self.nom = ""
        self.cheminFichier = "scores.txt"
        self.tabScores = []
        self.lireFichierScores()
        self.dernierScoreCreep = 0
        self.dernierScoreVague = 0
        
    def demarrePartie(self):
        self.nivoActif=Nivo(self)
        
    def calculerScore(self):
        if self.nivoActif.creepsDetruits > self.dernierScoreCreep:
            self.nivoActif.score += 10
            self.dernierScoreCreep = self.nivoActif.creepsDetruits
        if self.nivoActif.nbVagues - 1> self.dernierScoreVague:
            self.nivoActif.score +=1000
            self.dernierScoreVague = self.nivoActif.nbVagues - 1        
    
    def lireFichierScores(self):
        #si le fichier existe, lire le fichier
        if path.exists(self.cheminFichier):
            #lecture du fichier
            self.fichier = open(self.cheminFichier, "r")
            self.tabScores = self.fichier.readlines()
            self.fichier.close()
        # Si le fichier n'existe pas, ecrire le nom saisi ainsi que le score initial (= 0)
        else: 
            #créer le fichier
            self.fichier = open(self.cheminFichier, "w")
            self.fichier.close()
            
    def trierScores(self):
        scorePlace = False
        
        if len(self.tabScores) > 0:
            for i in range(len(self.tabScores)):
                if self.nivoActif.score > int(self.tabScores[i].split("    ")[1]) and scorePlace == False:
                    score = self.parent.vue.Nom.get() + "    " + str(self.nivoActif.score) + "\n"
                    if i == 0:
                        self.tabScores.insert(i, score)
                        scorePlace = True
                    else:
                        self.tabScores.insert(i, score)
                        scorePlace = True
            if scorePlace == False:
                score = "\n" + self.parent.vue.Nom.get() + "    " + str(self.nivoActif.score)
                self.tabScores.append(score)
        else:
            score = self.parent.vue.Nom.get() + "    " + str(self.nivoActif.score)
            self.tabScores.append(score)
        
    def ecrireScore(self):
        self.fichier = open(self.cheminFichier, "w")
        
        for i in self.tabScores:
            self.fichier.writelines(i)
        
        self.fichier.close()
        

if __name__ == '__main__':
    m=Modele(1)
    m.demarrePartie()