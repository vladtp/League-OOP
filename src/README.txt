###############################################################################
TIRIPLICA VLAD-PETRE
321CA - ETAPA 1 POO
###############################################################################
	Prin GameInputLoader se citesc datele si se stocheaza in GameInput.
	Pentru fiecare rounda se ruleaza playRound() care face urmatoarele lucruri
pentru fiecare player:
- verifica daca player-ul trebuie sa primeasca damage overtime
- verifica daca se poate misca, si in caz afirmativ il muta daca este cazul
	In final verifica daca exista 2 player in acelas loc caz in care apeleaza
fubnctia attack().
	Functia attack calculeaza damage-urile date de fiecare abilitate in parte,
atat in cazul initial cat si dupa modificatori. In final scade din viata
player-ilor damage ul primit. De asemenea aceasta seteaza damage-ul overtime, 
daca este cazul.
	Pentru heroes am creeat un HeroFactory, iar pentru abilitiati, am 
implementat fiecare abilitate ca o clasa diferita.
	Double dispatch a fost folosit intre clasele Ability si clasele Hero.
Astfel clasa ability actioneaza aspura claselor hero, iar clasele hero 
accepta aceasta actiune prin metoda accept() care returneaza race modifier.

	De asemenea am folosit git pentru versionarea codului. 
