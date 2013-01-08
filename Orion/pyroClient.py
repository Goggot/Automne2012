# -*- coding: iso-8859-1 -*-

import Pyro4

ur="PYRO:foo@127.0.0.1:9999"
souhaiteur=Pyro4.Proxy(ur)
nom=input("Votre nom, svp? ")

print(souhaiteur.saluer(nom))