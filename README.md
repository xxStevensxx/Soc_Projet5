Objet : Bienvenue chez SafetyNet !
De : Brenda Havvisol
À : moi

Bienvenue chez SafetyNet,

Nous sommes ravis de vous accueillir dans l'équipe. Le projet sur lequel vous allez travailler est l'application SafetyNet Alerts. Son objectif essentiel est d'envoyer des informations aux services d'urgence. 

Si, par exemple, un incendie se déclare, il faut que SafetyNet Alerts fournisse des informations sur les personnes présentes dans le bâtiment en feu, tels que leurs numéros de téléphone. Autre exemple : en cas d’alerte ouragan, nous souhaitons que SafetyNet Alerts puisse avertir par SMS tous les habitants de la région. Pour ce faire, SafetyNet Alerts doit recueillir les numéros de téléphone des personnes vivant dans les maisons proches de la zone de l'ouragan. Dernier exemple : dans le cas d'une inondation, nous souhaitons fournir aux services d'urgence des informations spécifiques sur les personnes dans la zone. Nous devons connaître les victimes potentielles, leurs âges et leurs antécédents médicaux (traitements, allergies, etc.).

Avec SafetyNet Alerts, nous espérons pouvoir donner les moyens aux premiers secours de mieux se préparer et appréhender toutes les situations.

Nous sommes heureux de vous voir ici, et sommes impatients que vous nous aidiez à faire de SafetyNet Alerts une réalité. Ce n'est qu'un début.      

Brenda Havvisol

Directrice du programme

 

Encouragé par le message de la Directrice, vous installez votre bureau et prenez un déjeuner rapide. De retour à votre poste, vous trouvez un mail de votre responsable, George :

 

Objet : Quelques infos sur SafetyNet Alerts
De : George Carlisle
À : moi

Félicitations ! 

Bienvenue chez SafetyNet. Nous sommes impatients de voir ce que vous pourrez coder pour nous.

La première chose qu’il vous faut pour commencer est une liste de besoins. Notre activité est de sauver des vies, donc l’un des éléments les plus importants de notre travail consiste à savoir où se trouvent les personnes et quand elles sont en détresse. 

Nous avons compilé une liste de noms, d'adresses et d'autres informations sur les personnes dans notre juridiction locale. Nous avons aussi une correspondance d'adresses avec des casernes de pompiers. Ce fichier de données sera indispensable pour SafetyNet Alerts. 

SafetyNet Alerts doit disposer d’endpoints permettant de conduire à des informations sur leurs statuts. L'ensemble des endpoints que nous aimerions voir au départ est : health, info, metrics, trace. Ensuite, quand votre application lira le fichier de données contenant les noms et adresses, SafetyNet Alerts devra produire en sortie un fichier JSON à partir des URL correspondantes dans ce document. 

Pour tous ces endpoints, les résultats devront être au format JSON et, à partir d'une adresse ou d'un numéro de poste d'incendie trouvé dans notre fichier, l'application devra renvoyer un objet JSON vide. Nous aurons aussi besoin d'un ensemble de tests unitaires pour valider le bon fonctionnement de l'application. Ces tests unitaires doivent s’appuyer sur le principe de la pyramide des tests. N'oubliez pas non plus les logs : l'application devra logger chaque requête et chaque réponse.

En plus de ces endpoints, nous avons besoin d’autres endpoints qui permettront aux différentes couches du logiciel d'interagir avec SafetyNet Alerts pour la mise à jour des données. Les spécifications des endpoints sont ici.

SafetyNet doit aussi avoir une architecture suivant le motif modèle-vue-contrôleur. Si vous suivez les principes SOLID et séparez le modèle des contrôleurs, vous serez en phase avec nos bonnes pratiques de programmation.

Pour le développement de l'application, faites des commits réguliers de façon à disposer pouvoir valider au fur et à mesure. Ceci nous aidera à distinguer les étapes du développement global et à estimer (entre autres) le nombre de lignes que vous codez par jour. Nous pourrons ainsi dresser plus facilement un calendrier pour la phase suivante de SafetyNet Alerts.

Quand vous aurez terminé SafetyNet Alerts, nous évaluerons le code de votre solution lors d'une réunion. Pourriez-vous préparer une présentation de synthèse avec des slides, présenter une modélisation du domaine métier ainsi qu’une description de votre solution ? Cela servira de documentation supplémentaire aux autres membres de l'équipe qui auront pour tâche de travailler sur SafetyNet Alerts lors de la phase suivante de développement.

Cela fait sans doute suffisamment d'informations pour votre premier jour. Voici un récapitulatif de la stack technique et des besoins. Pour toute question, n'hésitez pas à me contacter !

George Carlisle

Responsable du développement logiciel et de l'assurance qualité


Scénario OPC tout droits réservés
