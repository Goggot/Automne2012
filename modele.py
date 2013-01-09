import random
from helper import Helper


class Etoile(object):
    def __init__(self,parent,id,x,y):
        self.parent=parent
        self.id=id
        self.proprietaire=""
        self.x=x
        self.y=y
        self.taille=random.randrange(100)+10
        self.planetes=[]
        self.creePlanetes()
        
    def creePlanetes(self):
        n=random.randrange(3)
        if n>0:
            tmin=self.taille*3
            tmax=self.taille*20
            np=random.randrange(10)
            
            for i in range(np):
                dirx=random.randrange(2)-1
                if dirx==0:
                    dirx=1
                diry=random.randrange(2)-1
                if diry==0:
                    diry=1
                x=random.randrange(tmin,tmax)*dirx
                y=random.randrange(tmin,tmax)*diry
                t=random.randrange(10)+1
                self.planetes.append(Planete(self,x,y,t))
                
        
class Planete(object):
    def __init__(self,parent,x,y,t):
        self.parent=parent
        self.x=x
        self.y=y
        self.taille=t
        self.minerai=random.randrange(self.taille)*10000
        self.energie=random.randrange(self.taille)*1000000
        self.artefacts={"batiment":[],
                       "extracteur":[]
                       }
        
class Civ(object):
    def __init__(self,parent,nom,e,p,couleur):
        self.parent=parent
        self.nom=nom
        self.etoileMere=e
        self.planeteMere=p
        self.couleur=couleur
        self.planetesColonisees=[p]
        self.etoilesVisites=[e]
        self.artefactsDecouverts=[]
        self.flottes=[]
        self.artefacts={"station":[Station(self,Modele.nextId())],
                       "vaisseau":[Vaisseau(self,Modele.nextId(),p.parent)],
                       "batiment":[],
                       "extracteur":[],
                       "balise":[]}
        self.actions={"changeCible":self.changeCible,}
        
                       
    def changeCible(self,par):
        id,x,y=par
        for i in self.artefacts["vaisseau"]:
            if id==i.id:
                i.changeCible(x,y)
                print("CHANGER VAISSEAU CIBLE")
                
    def prochaineAction(self):
        print("NO ",self.parent.parent.cadre)
        for i in self.artefacts.keys():
            for j in self.artefacts[i]:
                j.prochaineAction()
                                
    def evalueAction(self):
        for i in self.artefacts.keys():
            for j in self.artefacts[i]:
                x=34*3/4*5+9
        for i in self.artefacts.keys():
            for j in self.artefacts[i]:
                x=34*3/4*5+9

class Station(object):
    def __init__(self,parent,id):
        self.parent=parent
        self.id=id
        self.nom=parent.nom
        dirx=random.randrange(2)-1
        if dirx==0:
            dirx=1
        diry=random.randrange(2)-1
        if diry==0:
            diry=1
        self.x=(random.randrange(10)+10*dirx)+parent.planeteMere.parent.x
        self.y=(random.randrange(10)+10*diry)+parent.planeteMere.parent.y
        print("STATION",self.x,self.y)
        
    def prochaineAction(self):
        pass
    
class Vaisseau(object):
    def __init__(self,parent,id,p):
        self.parent=parent
        self.id=id
        self.nom=parent.nom
        self.x=p.x+10
        self.y=p.y
        self.vitesse=5
        self.angle=0
        self.cible=[]
        
    def changeCible(self,x,y):
        self.cible=[x,y]
        self.angle=Helper.calcAngle(self.x,self.y,self.cible[0],self.cible[1])
        #print("CALC",[x,y])
        
    def bougerVaisseau(self):
        if self.cible:
            x,y=Helper.getAngledPoint(self.angle,self.vitesse,self.x,self.y)
            self.x=x
            self.y=y
            #print("CALC2",[x,y])
            d=Helper.calcDistance(self.x,self.y,self.cible[0],self.cible[1])
            if d<self.vitesse:
                self.cible=[]
                
    def prochaineAction(self):
        #print("DO SOMETING")
        self.bougerVaisseau()
                        
                        
class Modele(object):
    id=0
    def nextId():
        Modele.id=Modele.id+1
        return Modele.id
    
    def __init__(self,parent):
        self.parent=parent
        self.paramPartie={"x_espace":8000,
                          "y_espace":6000,
                          "etoiles":1000,
                          "max_planetes":10,
                          "min_minerai":10000,
                          "max_minerai":10000,
                          "min_energie":10000,
                          "max_energie":10000,
                          }
        self.rdseed=0
        self.civs={}
        self.vaisseau=""
        self.vaisseaux=[]
        self.actions=[]
        self.actionsAFaire={}
        self.etoiles=[]
        
    def initPartie(self,listeNomsJoueurs):
        for i in range(self.paramPartie["etoiles"]):
            x=random.randrange(self.paramPartie["x_espace"])
            y=random.randrange(self.paramPartie["y_espace"])
            id=Modele.nextId()
            self.etoiles.append(Etoile(self,id,x,y))
        couleurs=["red","blue","green","yellow","orange","purple"]
        n=0
        for j in listeNomsJoueurs:
            x=random.randrange(self.paramPartie["x_espace"])
            y=random.randrange(self.paramPartie["y_espace"])
            id=Modele.nextId()
            s=1
            while s:
                e=Etoile(self,id,x,y)
                if len(e.planetes):
                    s=0
            print("NOM",j)        
            p=e.planetes[random.randrange(len(e.planetes))]
            self.etoiles.append(e)
            self.civs[j]=Civ(self,j,e,p,couleurs[n])
            n=n+1

        
    def creerVaisseau(self,):
        x=random.randrange(self.parent.largeur_espace)
        y=random.randrange(self.parent.hauteur_espace)
        random.seed(self.rdseed)
        self.actions.append(["creerVaisseau",[self.nom,x,y]])
        self.creerEtoiles()
        
    def creerEtoiles(self):
        for i in range(self.paramPartie["etoiles"]):
            x=random.randrange(self.parent.largeur_espace)
            y=random.randrange(self.parent.hauteur_espace)
            self.etoiles.append(Etoile(self,x,y))
        
    def prochaineAction(self,cadre):
        if cadre in self.actionsAFaire:
            for i in self.actionsAFaire[cadre]:
                self.civs[i[0]].actions[i[1]](i[2])
            del self.actionsAFaire[cadre]
            print("NO1",cadre)
                
        for i in self.civs.keys():
            self.civs[i].prochaineAction()
            
        for i in self.civs.keys():
            self.civs[i].evalueAction()