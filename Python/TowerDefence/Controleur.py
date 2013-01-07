# -*- coding: ISO-8859-1 -*-
""" LE BON FICHIER """
import Modele as mod
import Vue as vue
import time

class Controleur():
    def __init__(self):
        self.actif = False 
        self.modele=mod.Modele(self)
        self.vue=vue.Vue(self)    
        
    def demarrePartie(self):
        self.actif = True
        self.pause = False
        self.dureePause = 0
        self.debutPause = 0
        self.vue.frameBoutons = self.vue.boutonsControle()
        self.vue.frameBoutons.grid(row=0, column=0, columnspan=2)
        self.modele.demarrePartie()
        self.vue.afficheModele()
        if self.vue.frameScore:
            self.vue.frameScore.destroy()
        if self.vue.frameFin:
            self.vue.frameFin.destroy()
        self.modele.nivoActif.debut = time.time()
        self.vitesseCreep = 0.01  ##Temporaire
        self.vitesseProjectile = 0.01
        self.vitesseTour = 0.15
        self.dernierProjectile = 0
        self.dernierTour = 0
        self.dernierCreep = 0
        self.derniereVague = 10
        self.continuePartie()
        self.vue.frameDroit=self.vue.panneauDroit()
        self.vue.frameDroit.grid(row=1, column=2)
    
    def comPause(self):
        if self.pause == False:             # Si le jeu est en cours
             self.pause = True                  # Pause positive
             self.actif = False
             self.debutPause = time.time()      # Calcul du temps de pause
             self.vue.frameBoutons = self.vue.boutonsControle()
             self.vue.frameBoutons.grid(row=0, column=0, columnspan=2)
        else:                               # Si le jeu est en pause
            self.actif = True
            self.pause = False                  # Pause negative
            self.dureePause += time.time() - self.debutPause
            self.continuePartie()               # Relancement du jeu
        
    def continuePartie(self):
        if self.vue.frameScore:
            self.vue.frameScore.destroy()
        if self.modele.nivoActif.vie > 0:
            if self.pause != True:              # Si le jeu n'est pas en pause
                self.modele.nivoActif.present = time.time() - self.dureePause
                    
                if (self.modele.nivoActif.present - self.dernierCreep) > self.vitesseCreep:
                    self.modele.nivoActif.bougeCreep()
                    self.modele.nivoActif.distanceRestante()
                    self.dernierCreep = self.modele.nivoActif.present
                    self.vue.afficheCreepTourBombe()
                    self.vue.afficherPanneauDroit()
                    
                if (self.modele.nivoActif.present - self.dernierProjectile) > self.vitesseProjectile:
                    self.modele.nivoActif.bougeProjectile()
                    self.dernierProjectile = self.modele.nivoActif.present
                    self.vue.afficheCreepTourBombe()
                    self.vue.afficherPanneauDroit()
                    self.modele.calculerScore()
                       
                if (self.modele.nivoActif.present - self.dernierTour) > self.vitesseTour:
                    self.modele.nivoActif.attaque()
                    self.dernierTour = self.modele.nivoActif.present
                    self.vue.afficheCreepTourBombe()
                    self.vue.afficherPanneauDroit()
                        
                if self.modele.nivoActif.present - self.modele.nivoActif.debut > self.modele.nivoActif.secEcoulees:
                    self.modele.nivoActif.secEcoulees+=1
                    self.vue.afficherPanneauDroit()
                    
                if self.modele.nivoActif.present - self.modele.nivoActif.debut > self.derniereVague:
                    self.modele.nivoActif.nouvelleVague()
                    self.derniereVague += 15
                    self.vue.afficherPanneauDroit()
                        
                self.vue.root.after(5,self.continuePartie)
                
        else:
            self.actif = False
            self.vue.frameFin = self.vue.messageDeFin()
            self.vue.frameFin.grid(row=1,column=0)
            
            self.vue.frameBoutons = self.vue.boutonsControle()
            self.vue.frameBoutons.grid(row=0, column=0, columnspan=2)
                        
            self.modele.trierScores()
            self.modele.ecrireScore()
            
    def setTour(self,pos,type):
        self.modele.nivoActif.setTour(pos, type)

if __name__ == '__main__':
    cont=Controleur()
    cont.vue.root.mainloop()