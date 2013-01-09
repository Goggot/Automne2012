# -*- encoding: ISO-8859-1 -*-
from tkinter import *
from tkinter.font import *
import tkinter.simpledialog as sd
import tkinter.messagebox as mb
import random

class Buttonjm(Button): #Modele de bouton pour qu'ils soient tous pareils
    def __init__(self,parent,**kw):
        f=Font(size=7,slant="italic",weight="bold")
        kw["font"]=f
        kw["fg"]="orange"
        kw["bg"]="grey25"
        kw["relief"]="groove"
        Button.__init__(self,parent,**kw)
        
class Labeljm(Label): #Modele de label pour qu'ils soient tous pareils
    def __init__(self,parent,**kw):
        f=Font(size=7)
        kw["font"]=f
        kw["fg"]="orange"
        kw["bg"]="grey25"
        Label.__init__(self,parent,**kw)

class Vue(object):
    perspective=["cosmos","espace","systeme","planete"]
    
    def __init__(self,parent,x,y,x_espace,y_espace):
        self.parent=parent
        self.modele=self.parent.modele
        self.selection=[] #Objet selectionné par l'usager
        self.con=0
        self.x=x
        self.y=y
        self.x_espace=x_espace
        self.y_espace=y_espace
        self.root=Tk()
        self.root.protocol('WM_DELETE_WINDOW', self.intercepteFermeture)
        self.cadreActif=0
        self.perspective=""
        self.perspectives={} #Vue cosmos, systeme solaire, planete, etc
        self.perspectiveCourante=None
        self.canevasCourant=None
        self.selections=[]
        self.creeCadres()
        #self.ecranPartie(x,y,x_espace,y_espace)
        self.placeCadre(self.cadreConnection)

    def creeCadres(self): #Créer les cadres
        self.creeCadreConnection()
        self.creeCadreAttente()
        self.creeCadrePartie()
        
    def creeCadrePartie(self):
        self.cadrePartie=Frame(self.root)
        self.cadrePartie.rowconfigure(1,weight=1)
        self.cadrePartie.columnconfigure(0,weight=1)
        
        self.creeCadreMenuPartie() #Cadres de jeu
        self.creeCadreInfoCiv()
        self.creeCadreCosmos()
        self.creeCadreEspace()
        self.creeCadreSysteme()
        self.creeCadrePlanete()
        self.perspectives={"Cosmos":self.cadreCosmos,
                           "Espace":self.cadreEspace,
                           "Systeme":self.cadreSysteme,
                           "Planete":self.cadrePlanete}
        self.canevas={"Cosmos":self.canevasCosmos,
                           "Espace":self.canevasEspace,
                           "Systeme":self.canevasSysteme,
                           "Planete":self.canevasPlanete}
        self.creeCadreInfoArtefact()
        self.creeCadreNiveauVue()
        self.creeCadreCommandeCiv()

    def creeCadreMenuPartie(self):
        self.cadreMenuPartie=Frame(self.cadrePartie,height=40,bg="grey25")
        self.cadreMenuPartie.grid_propagate(0)
        
        trouveL=Frame(self.cadreMenuPartie,height=10,bg="grey25")
        trouveL.grid(row=5,column=10,sticky=N)
        trouveB=Buttonjm(self.cadreMenuPartie,text="Trouve planete",command=self.centrerPlanete)
        trouveB.grid(row=10,column=10,sticky=N)
        self.showB=Buttonjm(self.cadreMenuPartie,text="showPlanete",relief=GROOVE,command=self.showPlanete)
        self.showB.grid(row=10,column=20,sticky=N)
        
    def creeCadreInfoCiv(self):
        self.cadreInfoCiv=Frame(self.cadrePartie,height=40,width=100,bg="grey25")
        self.cadreInfoCiv.grid_propagate(0)
        
        
    def creeCadreCosmos(self): #Création du cadre cosmos
        self.cadreCosmos=Frame(self.cadrePartie)
        self.cadreCosmos.rowconfigure(0,weight=1)
        self.cadreCosmos.columnconfigure(0,weight=1)

        sy=Scrollbar(self.cadreCosmos,orient=VERTICAL) #Ajout de scrollbars
        sx=Scrollbar(self.cadreCosmos,orient=HORIZONTAL) #Ajout de scrollbars
        self.canevasCosmos=Canvas(self.cadreCosmos,width=self.x,height=self.y,
                            xscrollcommand=sx.set,yscrollcommand=sy.set,bd=0,
                            scrollregion=(0,0,self.x,self.y),bg="grey15")
        sx.config(command=self.canevasCosmos.xview)
        sy.config(command=self.canevasCosmos.yview)
        
        self.canevasCosmos.grid(row=0,column=0,sticky=N+S+W+E)
        sy.grid(row=0,column=1,sticky=N+S)
        sx.grid(row=1,column=0,sticky=W+E)
        self.canevasCosmos.bind("<Button-1>",self.selectObject)
        self.canevasCosmos.bind("<Configure>",self.initCosmos)
        
    def selectObject(self,evt): #Selectionner un objet
        t=self.canevasCourant.gettags(CURRENT)
        if t:
            if "vaisseau" in t:
                if t[1]==self.parent.nom:
                    for i in self.modele.civs[t[1]].artefacts["vaisseau"]:
                        if i.id==int(t[2]):
                            if i in self.selection:
                                self.selection.remove(i)
                            else:
                                self.selection.append(i)
                            self.afficheSelection()
                        else:
                            print("PAS BON VAISSEAU")
                else:
                    print("PAS MOI")
            elif "station" in t:
                if t[1]==self.parent.nom:
                    for i in self.modele.civs[t[1]].artefacts["station"]:
                        if i.id==int(t[2]):
                            pass
                    
                
        elif self.selection:
            #input(self.selection)
            self.changeCible(self.selection,evt)
        else:
            self.selection=[]
        self.artefacttype1.config(text=t)
        
    def creeCadreEspace(self):
        self.cadreEspace=Frame(self.cadrePartie)
        self.cadreEspace.rowconfigure(0,weight=1)
        self.cadreEspace.columnconfigure(0,weight=1)

        sy=Scrollbar(self.cadreEspace,orient=VERTICAL)
        sx=Scrollbar(self.cadreEspace,orient=HORIZONTAL)
        self.canevasEspace=Canvas(self.cadreEspace,width=self.x,height=self.y,
                            xscrollcommand=sx.set,yscrollcommand=sy.set,bd=0,
                            scrollregion=(0,0,self.x_espace,self.y_espace),bg="grey15")
        sx.config(command=self.canevasEspace.xview)
        sy.config(command=self.canevasEspace.yview)
        
        self.canevasEspace.bind("<Button-1>",self.selectObject)
        
        self.canevasEspace.grid(row=0,column=0,sticky=N+S+W+E)
        sy.grid(row=0,column=1,sticky=N+S)
        sx.grid(row=1,column=0,sticky=W+E)
        
    def creeCadreSysteme(self):
        self.cadreSysteme=Frame(self.cadrePartie)
        self.cadreSysteme.rowconfigure(0,weight=1)
        self.cadreSysteme.columnconfigure(0,weight=1)

        sy=Scrollbar(self.cadreSysteme,orient=VERTICAL)
        sx=Scrollbar(self.cadreSysteme,orient=HORIZONTAL)
        self.canevasSysteme=Canvas(self.cadreSysteme,width=self.x,height=self.y,
                            xscrollcommand=sx.set,yscrollcommand=sy.set,bd=0,
                            scrollregion=(0,0,self.x,self.y),bg="grey15")
        sx.config(command=self.canevasSysteme.xview)
        sy.config(command=self.canevasSysteme.yview)
        
        self.canevasSysteme.grid(row=0,column=0,sticky=N+S+W+E)
        sy.grid(row=0,column=1,sticky=N+S)
        sx.grid(row=1,column=0,sticky=W+E)
        
    def creeCadrePlanete(self):
        self.cadrePlanete=Frame(self.cadrePartie)
        self.cadrePlanete.rowconfigure(0,weight=1)
        self.cadrePlanete.columnconfigure(0,weight=1)

        sy=Scrollbar(self.cadrePlanete,orient=VERTICAL)
        sx=Scrollbar(self.cadrePlanete,orient=HORIZONTAL)
        self.canevasPlanete=Canvas(self.cadrePlanete,width=self.x,height=self.y,
                            xscrollcommand=sx.set,yscrollcommand=sy.set,bd=0,
                            scrollregion=(0,0,self.x,self.y),bg="grey15")
        sx.config(command=self.canevasPlanete.xview)
        sy.config(command=self.canevasPlanete.yview)
        
        self.canevasPlanete.grid(row=0,column=0,sticky=N+S+W+E)
        sy.grid(row=0,column=1,sticky=N+S)
        sx.grid(row=1,column=0,sticky=W+E)
        
    def creeCadreInfoArtefact(self):
        f=Font(size=7)
        self.cadreInfoArtefact=Frame(self.cadrePartie,width=100,bg="grey25")
        self.cadreInfoArtefact.grid_propagate(0)
        
        artefacttypel=Labeljm(self.cadreInfoArtefact,text="Objet 1")
        artefacttypel.grid(column=0,row=0,sticky=W)
        self.artefacttype1=Labeljm(self.cadreInfoArtefact,text="--",font=f,bg="darkgreen",fg="orange")
        self.artefacttype1.grid(column=0,row=1,sticky=W)
        artefacttypel=Labeljm(self.cadreInfoArtefact,text="Objet 2")
        artefacttypel.grid(column=0,row=2,sticky=W)
        self.artefacttype2=Labeljm(self.cadreInfoArtefact,text="--")
        self.artefacttype2.grid(column=0,row=3,sticky=W)
        
        self.cadreInfoArtefact2=Frame(self.cadreInfoArtefact,width=100,bg="grey25")
        self.cadreInfoArtefact2.grid_propagate(1)
        
        self.cadreInfoArtefact2.grid(column=0,row=4,sticky=W)
        exploSystB=Buttonjm(self.cadreInfoArtefact2,text="Explore Système",command=self.exploreSysteme)
        exploSystB.grid(column=0,row=0,sticky=W+E)
        colonisePlaneteB=Buttonjm(self.cadreInfoArtefact2,text="Colonise Planete",command=self.colonisePlanete)
        colonisePlaneteB.grid(column=0,row=1,sticky=W+E)
        
    def creeCadreCommandeCiv(self):
        self.cadreCommandeCiv=Frame(self.cadrePartie,height=100,bg="grey25")
        self.cadreCommandeCiv.grid_propagate(0)
        
        trouveL=Frame(self.cadreCommandeCiv,height=10,bg="grey25")
        trouveL.grid(row=5,column=10,sticky=N)
        trouveB=Buttonjm(self.cadreCommandeCiv,text="Trouve planetre",command=self.centrerPlanete)
        trouveB.grid(row=10,column=10,sticky=N)
        self.showB1=Buttonjm(self.cadreCommandeCiv,text="showPlanete",relief=GROOVE,command=self.showPlanete)
        self.showB1.grid(row=10,column=20,sticky=N)
        
    def creeCadreNiveauVue(self):
        self.cadreNiveauVue=Frame(self.cadrePartie,width=100,height=100,bg="grey25")
        self.cadreNiveauVue.grid_propagate(1)
        bcosmos=Buttonjm(self.cadreNiveauVue,text="Cosmos")
        bcosmos.grid(column=0,row=0,sticky=E+W)
        bcosmos.bind("<Button>",self.placeCadreNiveau)
        bespace=Buttonjm(self.cadreNiveauVue,text="Espace")
        bespace.grid(column=1,row=0,sticky=E+W)
        bespace.bind("<Button>",self.placeCadreNiveau)
        bsysteme=Buttonjm(self.cadreNiveauVue,text="Systeme")
        bsysteme.grid(column=0,row=1,sticky=E+W)
        bsysteme.bind("<Button>",self.placeCadreNiveau)
        bplanete=Buttonjm(self.cadreNiveauVue,text="Planete")
        bplanete.grid(column=1,row=1,sticky=E+W)
        bplanete.bind("<Button>",self.placeCadreNiveau)
        
    def placeCadreNiveau(self,evt):   
        t=evt.widget.cget("text")
        self.placePerspective(t)
        
    def intercepteFermeture(self):
        print("Je me ferme")
        self.parent.jeQuitte()
        self.root.destroy()
        
    def afficheAttente(self):
        self.placeCadre(self.cadreAttente)
        
    def placeCadre(self,c):
        if self.cadreActif:
            self.cadreActif.pack_forget()
        self.cadreActif=c
        self.cadreActif.pack(expand=1,fill=BOTH)
 
    def creeCadreConnection(self):
        self.cadreConnection=Frame(self.root)
        cadreMenu=Frame(self.cadreConnection)

        Nom=Labeljm(cadreMenu,text="Votre NOM svp->")
        self.nomjoueur=Entry(cadreMenu)
        self.nomjoueur.insert(0,"jmd_"+str(random.randrange(100)))
        Nom.grid(column=0,row=0)
        self.nomjoueur.grid(column=1,row=0)
        
        
        lcree=Labeljm(cadreMenu,text="Pour créer un serveur à l'adresse inscrite")
        lconnect=Labeljm(cadreMenu,text="Pour vous connecter à un serveur")
        lcree.grid(column=0,row=1)
        lconnect.grid(column=1,row=1)
        
        lip=Labeljm(cadreMenu,text=self.parent.monip)
        self.autreip=Entry(cadreMenu)
        self.autreip.insert(0,self.parent.monip)
        lip.grid(column=0,row=2)
        self.autreip.grid(column=1,row=2)
        
        creerB=Buttonjm(cadreMenu,text="Creer un serveur",command=self.creerServeur)
        connecterB=Buttonjm(cadreMenu,text="Connecter a un serveur",command=self.connecterServeur)
        creerB.grid(column=0,row=3)
        connecterB.grid(column=1,row=3)

        self.galax=PhotoImage(file="galaxie.gif")
        galaxl=Labeljm(self.cadreConnection,image=self.galax)
        galaxl.pack()
        cadreMenu.pack()
        
    def creeCadreAttente(self):
        self.cadreAttente=Frame(self.root)
        cadreMenu=Frame(self.cadreAttente)
        self.listeJoueurs=Listbox(cadreMenu)
        self.demarreB=Buttonjm(cadreMenu,text="Demarre partie",state=DISABLED,command=self.parent.demarrePartie)
        self.demarreB.grid(column=0,row=1)
        self.listeJoueurs.grid(column=0,row=0)
        cadreMenu.pack(side=LEFT)
        self.galax2=PhotoImage(file="galaxie.gif")
        galax=Labeljm(self.cadreAttente,image=self.galax2)
        galax.pack(side=RIGHT)
        
    def afficheListeJoueurs(self,liste):
        self.listeJoueurs.delete(0,END)
        for i in liste:
            self.listeJoueurs.insert(END,i)
        
    def exploreSysteme(self):
        pass
    def colonisePlanete(self):
        pass
        
    def initPartie(self,modele):
        self.partie=modele
        self.moi=modele.parent.nom
        self.initCosmos()
        self.initEspace()
        
        self.cadreMenuPartie.grid(column=0,row=0,sticky=W+E)
        self.cadreInfoCiv.grid(column=1,row=0,sticky=W+E+S+N)
        self.cadreInfoArtefact.grid(column=1,row=1,sticky=W+E+S+N)
        self.cadreCommandeCiv.grid(column=0,row=2,sticky=W+E)
        self.cadreNiveauVue.grid(column=1,row=2,sticky=W+E+S+N)
        

#        self.perspectiveCourante=self.perspectives["Cosmos"]
#        self.placePerspective("Cosmos")
        self.perspectiveCourante=self.perspectives["Espace"]
        self.placePerspective("Espace")
        
        self.placeCadre(self.cadrePartie)
        
    def placePerspective(self,p="Cosmos"):
        self.perspectiveCourante.grid_forget()
        self.perspectiveCourante=self.perspectives[p]
        self.perspectiveCourante.grid(column=0,row=1,sticky=W+E+S+N)
        self.canevasCourant=self.canevas [p]
        
    def initCosmos(self,evt=""):
        self.canevasCosmos.delete(ALL)
        divx=self.x_espace/self.canevasCosmos.winfo_width()
        divy=self.y_espace/self.canevasCosmos.winfo_height()
        n=1
        for i in self.partie.etoiles:
            x=i.x/divx
            y=i.y/divy
            self.canevasCosmos.create_oval(x-n,y-n,x+n,y+n, fill="yellow",tags=("fond","etoile",i.id))
        self.afficheCosmos()
        
    def afficheCosmos(self):
        self.canevasCosmos.delete("miseajour")
        divx=self.x_espace/self.canevasCosmos.winfo_width()
        divy=self.y_espace/self.canevasCosmos.winfo_height()
        n=1
        j=self.partie.civs[self.moi]
        i=j.etoileMere
        x=i.x/divx
        y=i.y/divy
        self.canevasCosmos.create_oval(x-n,y-n,x+n,y+n, fill=j.couleur,tags=("miseajour","etoile",i.id,j.nom,"etoilemere"))
        n=3
        self.canevasCosmos.create_oval(x-n,y-n,x+n,y+n, outline=j.couleur,tags=("miseajour","etoile",i.id,j.nom,"etoilemere"))
            
        
            
    def initEspace(self):
        self.afficheEtoiles()
        self.afficheArtefact()
    
    def afficheArtefact(self):
        self.canevasEspace.delete("artefact")
        n=10
        for i in self.partie.civs.keys():
            coul=self.partie.civs[i].couleur
            for j in self.partie.civs[i].artefacts["vaisseau"]:
                self.canevasEspace.create_arc(j.x-n,j.y-n,j.x+n,j.y+n,
                                        start=(90-22), extent=45,outline=coul,fill=coul,tags=("artefact",i,j.id,"vaisseau"))
            n=5
            for j in self.partie.civs[i].artefacts["station"]:
                self.canevasEspace.create_rectangle(j.x-n,j.y-n,j.x+n,j.y+n,outline=coul,fill=coul,tags=("artefact",i,j.id,"station"))
                self.canevasEspace.create_oval(j.x-n,j.y-n,j.x+n,j.y+n,outline=coul,fill="lightblue",tags=("artefact",i,j.id,"station"))
        self.afficheSelection()
        
    def afficheSelection(self):
        self.canevasEspace.delete("selection")
        for i in self.selection:
            x=i.x
            y=i.y
            self.canevasEspace.create_rectangle(x-10,y-10,x+10,y+10,outline="yellow",dash=( 2, 2 ),  tags=("selection",))
                
    def changeCible(self,selection,e):
        #s=input("WO")
        #print("CHANGE",e.x,e.y)

        x=e.x
        y=e.y
        x1 = self.canevasEspace.canvasx(x)
        y1 = self.canevasEspace.canvasy(y)
        self.parent.changeCible(selection[0].id,x1,y1)
            
    def creerServeur(self):
        nom=self.nomjoueur.get()
        leip=self.parent.monip
        if nom:
            pid=self.parent.creerServeur()
            if pid:
                self.demarreB.config(state=NORMAL)
                self.root.after(500,self.inscritClient)
        else:
            mb.showerror(title="Besoin d'un nom",message="Vous devez inscrire un nom pour vous connecter.")
            
                
    def inscritClient(self):
        nom=self.nomjoueur.get()
        leip=self.parent.monip
        self.parent.inscritClient(nom,leip)
        
    def connecterServeur(self):
        nom=self.nomjoueur.get()
        leip=self.autreip.get()
        if nom:
            self.parent.inscritClient(nom,leip)
    
    def afficheModele(self,civs):
        if self.perspective=="cosmos":
            return
        elif self.perspective=="espace":
            self.canevasEspace.delete("vaisseau")
            for i in civs.keys():
                 for j in civs[i].artefacts["vaisseau"]:
                    if moi:
                        x1=0
                        self.canevas.create_rectangle(moi.x-5+x1,moi.y-5,moi.x+5+x1,moi.y+5,fill="blue",tags=("vaisseau",))
                    if autre:
                        for i in autre:
                            self.canevas.create_rectangle(i.x-5,i.y-5,i.x+5,i.y+5,fill="lightgreen",tags=("vaisseau",))
                            self.canevas.create_text(i.x-5,i.y+5,text=i.nom,tags=("vaisseau",))
                
    def afficheEtoiles(self):
        self.canevasEspace.delete("etoile")
        n=2
        for i in self.partie.etoiles:
            self.canevasEspace.create_oval(i.x-n,i.y-n,i.x+n,i.y+n,fill="yellow",tags=("etoiles",i.id))
        e=self.partie.civs[self.parent.nom].planeteMere.parent
        n=4
        self.canevasEspace.create_oval(e.x-n,e.y-n,e.x+n,e.y+n,width=2,outline="red",tags=("etoiles",self.parent.nom,e.id,"etoilemere"))
            
    def showPlanete(self):
        if self.perspective=="espace":
            self.placeCadre(self.cadrePlanete)
            self.perspective="planete"
            self.showB.config(text="Show Espace")
        else:
            self.placeCadre(self.ecranPartie)
            self.perspective="espace"
            self.showB.config(text="Show Planete")
        
    def centrerPlanete(self):
        self.centrerObjet( self.partie.civs[self.parent.nom].planeteMere.parent)
        
    def centrerObjet( self, obj):
        x=obj.x
        y=obj.y
        sx = float(self.x_espace)
        ecranx=float( self.canevasEspace.winfo_width() )/2.0
        #print(ecranx)
        posx = ( x-ecranx )/sx
        self.canevasEspace.xview( "moveto", posx )
        
        sy = float( self.y_espace )
        ecrany=float( self.canevasEspace.winfo_height() )/2.0
        posy = ( y-ecrany )/sy
        self.canevasEspace.yview( "moveto", posy )
                