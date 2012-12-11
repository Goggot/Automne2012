from tkinter import *

class Morpion():
    def __init__ (self,  modele):
        self.x=0
        self.y=0
        self.modele = modele
        self.pos=[self.x, self.y]
        
    def Grille(self):
        self.grille=[]
        for i in range(3):
            r=[]
            for j in range(3):
                r.append(' ')
                self.grille.append(r)
                
    def calculerPosition(self):
        i = 0
        if self.grille[0] == 0:
            if event.x > 40 and event.x < 150:
                if event.y > 40  and event.y < 150:
                    i=0
                    self.x = 55
                    self.y = 55
                if event.y > 155  and event.y < 265:
                    i=3
                    self.x = 55
                    self.y = 215
                if event.y > 270  and event.y < 380:
                    i=6
                    self.x = 55
                    self.y = 325
                    
            if event.x > 155 and event.x < 265:
                if event.y > 40  and event.y < 150:
                    i=1
                    self.x = 215
                    self.y = 55
                if event.y > 155  and enent.y < 265:
                    i=4
                    self.x = 215
                    self.y = 215
                if event.y > 270  and enent.y < 380:
                    i=7
                    self.x = 215
                    self.y = 325
                    
            if event.x > 270 and event.x < 380:
                if event.y > 40  and event.y < 150:
                    i=2
                    self.x = 325
                    self.y = 55
                if event.y > 155  and enent.y < 265:
                    i=5
                    self.x = 325
                    self.y = 215
                if event.y > 270  and enent.y < 380:
                    i=8
                    self.x = 325
                    self.y = 325
        else:
            return
                    
        compteur = 0
        if compteur % 2 == 0:
            Vue.Croix(self.x,  self.y)
            compteur = compteur +1
        else:
            Vue.Rond(self.x,  self.y)
            
    def calculOrdi(self):
        for ()
                    
class Controleur():
    def __init__ (self):
            self.Vue=Vue(self)
            self.Modele=Morpion(self)
            self.Vue.root.mainloop()

class Vue():
    def __init__ (self,  parent):
        self.parent = parent
        self.root = Tk()
        self.largeur=420
        self.hauteur=420
        self.x=40
        self.y=150
        self.x1=self.x
        self.x2=self.y
        self.y1=self.x
        self.y2=self.y
        
        self.champ=Label(self.root,  text="MOTHER FUCKING MORPION")
        self.champ.pack()
        
        self.canevas=Canvas(self.root,  width=self.largeur,  height=self.hauteur,  bg="black")
        self.canevas.pack()
        
        self.canevas.bind("<Button-1>",  self.parent)
        
        for x in range(3):
            for y in range(3):
                self.canevas.create_rectangle(self.x1, self.y1, self.x2, self.y2, width=2,  fill="white")
                self.canevas.pack()
                self.x1=self.x2+5
                self.x2=self.x1+110
            self.x1=self.x
            self.x2=self.y
            self.y1=self.y2+5
            self.y2=self.y1+110
        
    def Croix(self,  x,  y):
        self.canevas.create_line(x-30, y-30, x+30, y+30,  width=5,  fill="black")
        self.canevas.create_line(x-30, y+30, x+30, y-30,  width=5,  fill="black")
    
    def Rond(selfself,  x,  y):
        self.canevas.create_oval(x-30, y-30, x+30, y+30,  fill="black")
        self.canevas.create_oval(x-25, y-25, x+25, y+25,  fill="black")
    
            
if __name__ == '__main__':
    c=Controleur()
