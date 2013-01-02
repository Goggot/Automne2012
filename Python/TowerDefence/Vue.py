# -*- coding: ISO-8859-1 -*-
""" LE BON FICHIER """
from tkinter import * # from tkinter import * avec python 3.0
from collections import OrderedDict #pour affichage ordonnes des joueurs et de leur score.

class Vue():
    def __init__(self, controleur):
        self.controleur=controleur
        self.root=Tk()
        self.multiplicateur=6
        self.largeur=100*self.multiplicateur
        self.hauteur=100*self.multiplicateur 
        self.Nom=""
        self.textVie = StringVar()
        self.textVagues = StringVar()
        self.textCash = StringVar()
        self.textChrono = StringVar()
        self.textTours = StringVar()
        self.textScore = StringVar()
        self.frameBoutons = self.boutonsControle()
        self.frameInscription = self.inscription()        
        self.frameInscription.pack()
        self.frameDroit=self.panneauDroit()
        self.type = 0       
        self.jeu()
        self.listeFinale = []
        self.listePoints = []
        self.listeJoueurs = []
        self.Nom.focus_set()
        self.i = 0
        self.frameFin = self.messageDeFin() 
        self.tabLaser = []
        self.frameScore = 0


    """ Définition du type de tour selectionnee """
    def initMinigun(self):
        self.type = 0


    def initSlow(self):
        self.type = 1


    def initCanon(self):
        self.type = 2


    def initLaser(self):
        self.type = 3


    def afficherPanneauDroit(self): 
        self.textVie.set(str(self.controleur.modele.nivoActif.vie))
        self.textVagues.set(str(self.controleur.modele.nivoActif.nbVagues))
        self.textCash.set(str(self.controleur.modele.nivoActif.cash))
        self.textChrono.set(str(self.controleur.modele.nivoActif.secEcoulees))
        self.textTours.set(str(self.controleur.modele.nivoActif.nbTours))
        self.textScore.set(str(self.controleur.modele.nivoActif.score))
        
        
    def panneauDroit(self): #Partie DROITE du programme:
        scorePanel=Frame(self.root)

        labelPtsSubstrCreeps=Label(scorePanel, text="Vie: ", font=("Helvetica", 10, 'bold'), bd=10)
        labelPtsSubstrCreeps.grid(row=0, column=0, sticky=W)
        self.labelPtsSubstrCreeps=Label(scorePanel, textvariable=self.textVie)
        self.labelPtsSubstrCreeps.grid(row=0, column=1)

        labelNbCreeps=Label(scorePanel, text="Nombre de vagues: ", font=("Helvetica", 10, 'bold'), bd=10)
        labelNbCreeps.grid(row=1, column=0, sticky=W)
        self.labelNbCreeps=Label(scorePanel, textvariable=self.textVagues)
        self.labelNbCreeps.grid(row=1, column=1)

        labelCreepsEchappes=Label(scorePanel, text="Cash: ", font=("Helvetica", 10, 'bold'), bd=10)
        labelCreepsEchappes.grid(row=2, column=0, sticky=W)
        self.labelCreepsEchappes=Label(scorePanel, textvariable=self.textCash)
        self.labelCreepsEchappes.grid(row=2, column=1)
        
        labelEfficaciteTir=Label(scorePanel, text="Durée de la partie: ", font=("Helvetica", 10, 'bold'), bd=10)
        labelEfficaciteTir.grid(row=3, column=0, sticky=W)
        self.labelEfficaciteTir=Label(scorePanel, textvariable=self.textChrono)
        self.labelEfficaciteTir.grid(row=3, column=1)
        
        labelNbTours=Label(scorePanel, text="Nombre de tours: ", font=("Helvetica", 10, 'bold'), bd=10)
        labelNbTours.grid(row=4, column=0, sticky=W)
        self.labelNbTours=Label(scorePanel, textvariable=self.textTours)
        self.labelNbTours.grid(row=4, column=1)
        
        labelTimer=Label(scorePanel, text="Votre score: ", font=("Helvetica", 10, 'bold'), bd=10)
        labelTimer.grid(row=5, column=0, sticky=W)
        self.labelTimer=Label(scorePanel, textvariable=self.textScore)
        self.labelTimer.grid(row=5, column=1)


        """ Affichage des boutons de choix de tours et de Upgrade et Vente """
        self.m=Button(scorePanel,text="Minigun\n20 $", font=("Helvetica", 10, 'bold'), relief=GROOVE, height=3, width=7, bg="GREEN", command=self.initMinigun)
        self.m.grid(row=6, column=0, sticky=W, pady=3)
        self.s=Button(scorePanel,text="Slow\n75 $", font=("Helvetica", 10, 'bold'), relief=GROOVE, height=3, width=7, fg="YELLOW", bg="BLUE", command=self.initSlow)
        self.s.grid(row=7, column=0, sticky=W, pady=3)
        self.c=Button(scorePanel,text="Canon\n50 $", font=("Helvetica", 10, 'bold'), relief=GROOVE, height=3, width=7, bg="YELLOW",command=self.initCanon)
        self.c.grid(row=8, column=0, sticky=W, pady=3)
        self.l=Button(scorePanel,text="Laser\n200$", font=("Helvetica", 10, 'bold'),relief=GROOVE, height=3, width=7, bg="RED", command=self.initLaser)
        self.l.grid(row=9, column=0, sticky=W, pady=3)

        if self.controleur.actif == True:
            self.u=Button(scorePanel,text="Upgrade", font=("Helvetica", 10, 'bold'), relief=GROOVE, height=3, width=7, bg="BLUE", command=self.controleur.modele.nivoActif.upgradeTour)
            self.u.grid(row=10, column=0, sticky=W, pady=3)

            self.v=Button(scorePanel,text="Vendre", font=("Helvetica", 10, 'bold'), relief=GROOVE, height=3, width=7, bg="ORANGE", command=self.controleur.modele.nivoActif.vendreTour)
            self.v.grid(row=11, column=0, sticky=W, pady=3)
        
        return scorePanel


    def boutonsControle(self):
        f = Frame(self.root)
        '''Bouton: Commencer une nouvelle partie'''
        d=Button(f, text="Commencer une nouvelle partie", font=("Helvetica", 10, 'bold'), relief=RAISED, highlightthickness=5, command=self.controleur.demarrePartie)
        d.pack(side=LEFT, padx=5)
        '''Bouton: Pause '''
        p=Button(f, text="Pause / Reprise", font=("Helvetica", 10, 'bold'), relief=RAISED, highlightthickness=5, command=self.controleur.comPause)
        p.pack(side=LEFT, padx=5)
        '''Bouton: Afficher le highscore'''
        if self.controleur.actif == False:
            hs=Button(f, text="Afficher le Top 5", font=("Helvetica", 10, 'bold'), relief=RAISED, highlightthickness=5, state = ACTIVE, command=self.afficherHighScore)
        else:
            hs=Button(f, text="Afficher le Top 5", font=("Helvetica", 10, 'bold'), relief=RAISED, highlightthickness=5, state = DISABLED, command=self.afficherHighScore)   
        hs.pack(side=LEFT, padx=5)
        '''Bouton: Quitter la partie'''
        q=Button(f, text="Quitter", font=("Helvetica", 10, 'bold'), relief=RAISED, highlightthickness=5, command=sys.exit)
        q.pack(side=LEFT)
        
        return f


    def creerFrameHighScore(self):
        self.f=Frame(self.root)
        self.L=Label(self.f, text='Voici les cinq meilleurs joueurs:', wraplength=500, borderwidth=5, font=("Helvetica", 18))
        self.L.grid(row=0,column=0)
        textHighScore = ""
        for i in range(len(self.controleur.modele.tabScores)):
            if i < 5:
                textHighScore += self.controleur.modele.tabScores[i] + "\n"
        self.z = self.L=Label(self.f, text=textHighScore, wraplength=350, font=("Helvetica", 12))
        self.z.grid(row=1, column=0)
        return self.f


    def afficherHighScore(self):
        self.frameScore = self.creerFrameHighScore()
        if self.frameFin:
            self.frameFin.destroy()
        self.frameScore.grid(row = 1, column = 0)


    def getPosMinigun(self,evt):       # Position de la Tour de type Minigun (1)
        x=evt.x/self.multiplicateur
        y=evt.y/self.multiplicateur
        self.controleur.setTour([x,y],  self.type)


    def getPosSlow(self,evt):          # Position de la Tour de type Slow (2)
        x=evt.x/self.multiplicateur
        y=evt.y/self.multiplicateur
        self.controleur.setTour([x,y],  self.type)


    def getPosCanon(self,evt):         # Position de la Tour de type Canon (3)
        x=evt.x/self.multiplicateur
        y=evt.y/self.multiplicateur
        self.controleur.setTour([x,y],  self.type)


    def getPosLaser(self,evt):         # Position de la Tour de type Laser (4)
        x=evt.x/self.multiplicateur
        y=evt.y/self.multiplicateur
        self.controleur.setTour([x,y],  self.type)  


    def afficheModele(self):
        pos=[]
        for i in self.controleur.modele.nivoActif.parcours.noeuds:
            pos.append(i[0]*self.multiplicateur)
            pos.append(i[1]*self.multiplicateur)
        self.canevas.create_line(pos, width=36, fill="red", stipple = "gray50", tags=("chemin",))
        self.canevas.create_line(pos, width=30, fill="yellow", stipple = "gray50", tags=("chemin",))
        #self.canevas.create_line(pos, width=32, fill="white", stipple = "gray25",tags=("chemin",))
        #self.canevas.create_line(pos, width=30, stipple="@sentier.xbm")    


    def afficheCreepTourBombe(self):
        self.dalek=PhotoImage(file="Images/dalek_sec.gif")
        self.cyberman=PhotoImage(file="Images/cyberman.gif")
        self.angel=PhotoImage(file="Images/angel.gif")
        
        self.dalekFrozen=PhotoImage(file="Images/IceDalek.gif")
        self.cybermanFrozen=PhotoImage(file="Images/IceCyberman.gif")
        self.angelFrozen=PhotoImage(file="Images/IceAngel.gif")
        
        self.tardis=PhotoImage(file="Images/tardis.gif")
        self.sonic=PhotoImage(file="Images/sonic.gif")
        self.unit=PhotoImage(file="Images/UNIT.gif")
        self.K9=PhotoImage(file="Images/K9.gif")
        
        self.projectileFrost=PhotoImage(file="Images/flocon.gif")
        self.projectileCanon=PhotoImage(file="Images/Boulet.gif")
        self.projectile=PhotoImage(file="Images/projectile.gif")

        # Compteur d'acces au dictionnaire de liste des tours
        compteurM=0
        compteurS=0
        compteurC=0
        compteurL=0

        # Mises a jour des barres de vie et du tir du laser sur l'affichage
        self.canevas.delete("laser")
        self.canevas.delete("barreVie")
        self.canevas.delete("selection")
        
        for i in self.controleur.modele.nivoActif.creepsEnCours:
            if(i.force>0 and i.pos[0] >= 0):
                x1=i.pos[0]*self.multiplicateur
                y1=i.pos[1]*self.multiplicateur

                if i.__class__.__name__ == "Dalek":
                    if i.frozen == False:
                        self.canevas.create_image(x1, y1, image=self.dalek)
                    else:
                        self.canevas.create_image(x1, y1, image=self.dalekFrozen)
                        
                elif i.__class__.__name__ == "Cyberman":
                    if i.frozen == False:
                        self.canevas.create_image(x1, y1, image=self.cyberman)
                    else:
                        self.canevas.create_image(x1, y1, image=self.cybermanFrozen) 
                elif i.__class__.__name__ == "Boss":
                    if i.frozen == False:
                        self.canevas.create_image(x1, y1, image=self.angel)
                    else:
                        self.canevas.create_image(x1, y1, image=self.angelFrozen)
                vieX = (i.force/i.forceMax)
                
            # Création des barres de vie et calculs des changements de couleurs en fonction des vies restantes
                if vieX >= 0.75:
                    self.canevas.create_line(x1-8,  y1-20,  x1+(vieX*20)-8,  y1-20, tags="barreVie",  width=2, fill="green")
                elif vieX >= 0.33:
                    self.canevas.create_line(x1-8,  y1-20,  x1+(vieX*20)-8,  y1-20, tags="barreVie",  width=2, fill="yellow")
                else:
                    self.canevas.create_line(x1-8,  y1-20,  x1+(vieX*20)-8,  y1-20, tags="barreVie",  width=2, fill="red")

    # Affichage de la zone de tir de la tour, indique que la tour est selectionnee
        if self.controleur.modele.nivoActif.tourSelectionnee != False:
            x1 = self.controleur.modele.nivoActif.tourSelectionnee.pos[0] * self.multiplicateur
            y1 = self.controleur.modele.nivoActif.tourSelectionnee.pos[1] * self.multiplicateur
            z = self.controleur.modele.nivoActif.tourSelectionnee.range * self.multiplicateur
            self.canevas.create_oval(x1-z,y1-z,x1+z,y1+z,tags="selection")
                    
    # Affichage des tours Minigun
        for i in self.controleur.modele.nivoActif.tours["Minigun"]:
            x1=self.controleur.modele.nivoActif.tours["Minigun"][compteurM].pos[0]* self.multiplicateur
            y1=self.controleur.modele.nivoActif.tours["Minigun"][compteurM].pos[1]*self.multiplicateur
            self.canevas.create_image(x1, y1, image=self.tardis)
            compteurM+=1
    # Affichage des tours Slow
        for i in self.controleur.modele.nivoActif.tours['Slow']:
            x1=self.controleur.modele.nivoActif.tours['Slow'][compteurS].pos[0]*self.multiplicateur
            y1=self.controleur.modele.nivoActif.tours['Slow'][compteurS].pos[1]*self.multiplicateur
            self.canevas.create_image(x1, y1, image=self.sonic)
            compteurS+=1
    # Affichage des tours Canon
        for i in self.controleur.modele.nivoActif.tours['Canon']:
            x1=self.controleur.modele.nivoActif.tours['Canon'][compteurC].pos[0]*self.multiplicateur
            y1=self.controleur.modele.nivoActif.tours['Canon'][compteurC].pos[1]*self.multiplicateur
            self.canevas.create_image(x1, y1, image=self.unit)
            compteurC+=1
    # Affichage des tours Laser
        for i in self.controleur.modele.nivoActif.tours['Laser']:
            x1=self.controleur.modele.nivoActif.tours['Laser'][compteurL].pos[0]*self.multiplicateur
            y1=self.controleur.modele.nivoActif.tours['Laser'][compteurL].pos[1]*self.multiplicateur
            self.canevas.create_image(x1, y1, image=self.K9)
            compteurL+=1
    # Affichage des projectiles
        for i in self.controleur.modele.nivoActif.tabProjectiles: # MOTHERFUCKING BROKEN
            if i.type == "canon" or i.type == "slow" or i.type == "minigun":
                x1=i.pos[0]*self.multiplicateur
                y1=i.pos[1]*self.multiplicateur
                self.canevas.create_image(x1, y1, image=self.projectile)
            if i.type == "canon":
                x1=i.pos[0]*self.multiplicateur
                y1=i.pos[1]*self.multiplicateur
                self.canevas.create_image(x1, y1, image=self.projectileCanon)
            if i.type == "slow":
                x1=i.pos[0]*self.multiplicateur
                y1=i.pos[1]*self.multiplicateur
                self.canevas.create_image(x1, y1, image=self.projectileFrost)
            if i.type == "laser":
                x1=i.posDepart[0]*self.multiplicateur
                y1=i.posDepart[1]*self.multiplicateur
                x2=i.pos[0]*self.multiplicateur
                y2=i.pos[1]*self.multiplicateur
                l = self.canevas.create_line(x1,y1,x2,y2, width=3, fill="blue", tags="laser")
                l2 = self.canevas.create_line(x1,y1,x2,y2, width=2, fill="green", tags="laser")


    def inscription(self):
        self.f=Frame(self.root)
        self.L=Label(self.f, text='Entrez votre nom', borderwidth=5, font=("Helvetica", 14))
        self.L.pack(padx=5, pady=5)
        self.Nom=Entry(self.f, borderwidth=5, justify=CENTER, font=("Helvetica", 12))
        self.Nom.pack(padx=5, pady=5)
        self.b=Button(self.f, text='Enregistrer', command=self.getName, borderwidth=3, bd=3)
        self.b.pack()
        
        return self.f


    def messageDeFin(self):
        self.f=Frame(self.root)
        self.L=Label(self.f, text='Vous avez laissé les vilains gagner. Les Seigneurs du Temps seraient déçus!', wraplength=350, borderwidth=5, font=("Helvetica", 18))
        self.L.pack(padx=5, pady=5)
        
        return self.f


    def jeu(self):      
        """Longueur et largeur du tableau d'affichage du programme"""
        self.frameJeu=Frame(self.root)
        self.map=PhotoImage(file= "Images/Gallifrey.gif")
        self.root.title('Tower Defense Background')
        self.canevas = Canvas(self.frameJeu, width=self.largeur, height=self.hauteur)
        self.canevas.create_image(0,0,image=self.map, anchor=N+W)
        if self.type == 0:
            self.canevas.bind("<Button-1>",self.getPosMinigun)
            
        elif self.type == 1:
            self.canevas.bind("<Button-1>",self.getPosSlow)
            
        elif self.type == 2:
            self.canevas.bind("<Button-1>",self.getPosCanon)
            
        elif self.type == 3:
            self.canevas.bind("<Button-1>",self.getPosLaser)
        self.canevas.pack()    


    def getName(self):
        self.listeJoueurs.append(self.Nom.get())
        self.frameInscription.pack_forget()
        self.frameBoutons.grid(row=0, column=0, columnspan=2)
        self.frameJeu.grid(row=1, column=0, sticky=N+S+W+E)
        self.frameDroit.grid(row=1, column=2, sticky=N+S+W+E)
