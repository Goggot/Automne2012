from tkinter import *
class Vue():
    def __init__(self,  parent):
        self.parent = parent
        self.root = Tk()
        f1=Frame(self.root)
        f2=Frame(self.root)
        b=Button(f1,  text = "BATMAN",  command = self.getBatman)
        b.grid(column=10, row=20)
        b=Button(f1,  text = "ROBIN",  command = self.getRobin)
        b.grid(column=10,  row=10)
        lb=Label(f2, text="Go for it , F*ck*r!")
        lb.pack()
        lb=Label(f2, text="Wiiiiiiiiiiiiiiiiiiiiiiiizzzz !!!, Zaweeeeeeeeee!")
        lb.pack()
        f1.pack(side=LEFT)
        f2.pack(side=LEFT)
        
    def getRobin(self):
        print("I'm here, Batman !")
    def getBatman(self):
        print ("SHUT UP!")
        
class Controleur():
    def __init__(self):
        self.Vue=Vue(self)
        print("Creation Vue")
        self.Vue.root.mainloop()
        print("Fin du programme")
        
if __name__ == '__main__':
    c=Controleur()
