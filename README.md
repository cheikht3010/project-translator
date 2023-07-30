# project-translator

### Description
Projet _Maven_ implémentant l'interface _ITranslateService_. Deux implémentations sont disponibles.
* Une première utilisant l'API Google Translate (https://cloud.google.com/translate/docs/) 
* Une seconde avec l'API Deepl (https://www.deepl.com/fr/docs-api)

### Pré-requis avant execution

* Modifier le fichier _api_google_key.txt_ dans src/main/resources/ et ajouter (à la première ligne) la clé pour l'API Google Translate.
* Modifier le fichier _api_deepl_key.txt_ dans src/main/resources/ et ajouter (à la première ligne) la clé pour l'API Deepl.

* Modifier le fichier src/main/resources/log4j.properties. Changer la valeur de l'attribut log (ligne 2) du fichier _log4j.properties_ pour y saisir le chemin souhaité pour le dossier de log.
