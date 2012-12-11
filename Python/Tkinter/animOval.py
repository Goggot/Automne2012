from tkinter import *
import random

class Vue():
    def __init__(self,  parent):
        self.parent = parent
        self.root=Tk()
        self.largeur=800
        self.hauteur=600
        self.roule=0
        self.champ=Label(self.root,  text="Aucune coordonnees")
        self.champ.pack()
        
        self.canevas=Canvas(self.root,  width=self.largeur,  height=self.hauteur,  bg="red")
        self.canevas.pack()
        
        self.canevas.bind("<Button-1>", self.trouveClick)
        
        b=Button(self.root, text="Ajouter un oval",  command=self.ajoutOval)
        b.pack()
        b=Button(self.root,  text="Demarage Automatique",  command=self.demarAuto)
        b.pack()
        b=Button(self.root,  text="Stop",  command=self.stopAuto)
        b.pack()
        
    def trouveClick(self,  evt):
        monX=str(evt.x)
        monY=str(evt.y)
        self.champ.config(text=monX+" "+monY)
        self.canevas.create_text(evt.x, evt.y, text="X")
        
    def stopAuto(self):
        self.roule=0
        
    def demarAuto(self):
        self.canevas.delete(ALL)
        self.roule=1
        self.ajoutAuto()
        
    def ajoutAuto(self):
        if self.roule:
            self.ajoutOval()
            self.root.after(100,  self.ajoutAuto)
        
    def ajoutOval(self):
        couleurs=["red", "green", "blue", "pink",  "orange",  "yellow",  "grey",  "purple"]
        x1=random.randrange(self.largeur)
        x2=random.randrange(self.largeur)
        y1=random.randrange(self.hauteur)
        y2=random.randrange(self.hauteur)
        c=couleurs[random.randrange(len(couleurs))]
        self.canevas.create_oval(x1, y1, x2, y2,  width=10,  fill=c)

        
class Controleur():
    def __init__(self):
        self.Vue=Vue(self)
        self.Vue.root.mainloop()
        
if __name__ == '__main__':
    c=Controleur()
