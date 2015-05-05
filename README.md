===================================== BookShop Enib : README =====================================
- Bin�me :
  	  Chapalain Yoann
	  Lepage Sebastien

	Le projet porte sur la r�alisation d'un client de gestion d'apr�s les demandes formul�es 
dans le document exprimant les besoins.
Le mod�le de donn�es pour le domaine est d�j� fournit. 
Le champs de comp�tence recouvre :
			- La gestion du catalogue
			- La gestion des clients
			- La visualisation et suppression des commandes

	Le travail consiste � impl�menter les diff�rentes pages n�cessaires pr�sent�es ainsi que la 
navigation entres-elles.

	Le patron "observer" � �t� choisi pour la gestion des donn�es entre les classes de ce projet.
On retrouve ainsi diff�rents controllers (ainsi que les listeners et events correspondants) pour 
chaque domaine � g�rer.(categories, sujets, clients, ordres de commandes ...). 
Un diagramme UML , pr�sent dans le projet, fournit un exemple pour la representation d'un controller.

	Pour ce projet la navigation par onglet � �t� choisi, car elle semble moins contraignante et
plus souple que l'utilisation d'un grand nombre de fen�tre.
Ce syst�me est bas� sur des JPanel modifi�s (une croix ainsi qu'un menu d�roulant au clic droit ont 
�t� rajout�s) plac�s dans un tabbedPane.
Pour chaque liste, il est possible d'ins�rer, de lire, de modifier ou de supprimer un �l�ment (CRUD)
gr�ce � une gestion par formulaire.
L'implementation d'un formulaire de recherche � �galement �t� fait.

Le stockage des donn�es est assur� par l'utilisation de listes.
Une s�rialisation binaire de ces listes est ensuite effectu�es pour en garantir la persistence � la
fermeture de l'application.

