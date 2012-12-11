# -*- coding: ISO-8859-1 -*-
'''
Created on 2012-09-07

@author: jmd
'''
import Tour_2012_modele as mod
import Tour_2012_vue as vue

class Controleur():
    def __init__(self):
        self.modele=mod.Modele(self)
        self.vue=vue.Vue(self)
        self.actif=0
        
    def demarrePartie(self):
        if self.actif==0:
            self.actif=1
            self.modele.demarrePartie()
            self.vue.afficheModele()
            self.continuePartie()
        else:
            self.actif=0
            
    def continuePartie(self):
        if self.actif:
            self.modele.nivoActif.bougeCreep()
            self.vue.afficheCreepTourBombe()
            self.vue.root.after(100,self.continuePartie)
            
    def setTour(self,pos):
        print("Controleur",pos)
        self.modele.setTour(pos)

if __name__ == '__main__':
    print("Initialise l'application")
    cont=Controleur()
    print("Affiche la fenêtre d'ouverture")
    cont.vue.root.mainloop()
    