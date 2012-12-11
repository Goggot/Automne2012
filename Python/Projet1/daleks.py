
import random   #aleatoire

class Docteur():
    def __init__(self):
        self.pos=[0,0]

class Dalek():
    def __init__(self, pos):
        self.pos=pos
        
class AireDeJeu():
    def __init__(self):
        self.doc = Docteur()
        self.largeur = 20   #tableau x
        self.hauteur = 20   #tableau y
        self.nbDalekParNiveau = 5
        self.dalek=[]
        self.niveau = 0
        self.initNiveau()
        
    def initNiveau(self):
        self.niveau = self.niveau+1 #prochain niveau
        xdoc = random.randrange(self.largeur)   #trouve une position x
        ydoc = random.randrange(self.hauteur)   #trouve une position y
        self.doc.pos=[[xdoc, ydoc]]
        
        
        listePos=[[xdoc,ydoc]]  
        for i in range(self.nbDalekParNiveau*self.niveau):  #for : prochain element de la sequence
           x = random.randrange(self.largeur)   #trouve une position x
           y = random.randrange(self.hauteur)   #trouve une position y
           if[x,y] in listePos:
              i = i-1
           else:
              listePos.append([x,y])    #creer un nouveau dalek
        listePos.remove([xdoc,ydoc])
        for i in listePos:
            self.dalek.append(Dalek(i))
              
              
class Controleur():
    def __init__(self):
        self.modele = AireDeJeu()
        self.vue= Vue()
        self.vue.afficherAireDeJeu(self.modele)
        
class Vue():
    def __init__(self):
        pass
    def afficherAireDeJeu(self, modele):  
        pass
    def AvertirChoixJeu(self):
        pass
                            
              
if __name__ == '__main__': 
    cont = Controleur()
    
    obj1=[2,3]
    obj2=[4,4]
    obj3=[1,0]
    grille=[]
    for i in range(5):
        r=[]
        for j in range(5):
            r.append("-")
        grille.append(r)
    for i in grille:
        print(i)   
        
    x = obj1[1]
    y = obj1[0]
    grille[x][y]= "w"
    
    val = input("Votre choix: 1- quitter 2-imprimier")
    if val[:-1] == "2":
        for i in grille:
            print(i)
    elif val[:-1]== "1":
        print("bouuh")
    
    print("Fin de jeu") #imprime et saute une ligne