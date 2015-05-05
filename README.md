**READ ME !** 

- Binôme :
  	  Chapalain Yoann
	  Lepage Sebastien

	Le projet porte sur la réalisation d'un client de gestion d'après les demandes formulées 
dans le document exprimant les besoins.
Le modèle de données pour le domaine est déjà fournit. 
Le champs de compétence recouvre :
			- La gestion du catalogue
			- La gestion des clients
			- La visualisation et suppression des commandes

	Le travail consiste à implémenter les différentes pages nécessaires présentées ainsi que la 
navigation entres-elles.

	Le patron "observer" à été choisi pour la gestion des données entre les classes de ce projet.
On retrouve ainsi différents controllers (ainsi que les listeners et events correspondants) pour 
chaque domaine à gérer.(categories, sujets, clients, ordres de commandes ...). 
Un diagramme UML , présent dans le projet, fournit un exemple pour la representation d'un controller.

	Pour ce projet la navigation par onglet à été choisi, car elle semble moins contraignante et
plus souple que l'utilisation d'un grand nombre de fenêtre.
Ce système est basé sur des JPanel modifiés (une croix ainsi qu'un menu déroulant au clic droit ont 
été rajoutés) placés dans un tabbedPane.
Pour chaque liste, il est possible d'insérer, de lire, de modifier ou de supprimer un élèment (CRUD)
grâce à une gestion par formulaire.
L'implementation d'un formulaire de recherche à également été fait.

Le stockage des données est assuré par l'utilisation de listes.
Une sérialisation binaire de ces listes est ensuite effectuées pour en garantir la persistence à la
fermeture de l'application.

