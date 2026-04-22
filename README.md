[![CI](https://github.com/SinanOzturk10/Projet_DevOps_LOPES_OZTURK_PICHON/actions/workflows/ci.yml/badge.svg)](https://github.com/SinanOzturk10/Projet_DevOps_LOPES_OZTURK_PICHON/actions/workflows/ci.yml)
# Projet DevOps — LopesOzturkPichon

**Auteurs :** Allan Lopes · Sinan Ozturk · Kalvin-Giang Pichon

---

## Description des fonctionnalités

Ce projet implémente une bibliothèque Java de tableaux N-dimensionnels, inspirée de l'API NumPy (Python).

### Fonctionnalités implémentées

- **`NdArray` (classe abstraite)** — structure de base commune à tous les tableaux, définie par un tableau de données brutes (`float[]`) et une forme (`int[] shape`). Expose les attributs `ndim`, `size`, ainsi que `reshape()` et `toString()`.
- **`Vector1D`** — vecteur 1D. Opérations disponibles :
  - `get(i)` / `set(i, value)` — accès et modification par indice (avec vérification de bornes)
  - `add(other)` — addition élément par élément, retourne un nouveau vecteur
  - `iadd(other)` — addition en place (`+=`)
  - `dot(other)` — produit scalaire
- **`Matrix2D`** — matrice 2D complète. Opérations disponibles :
  - `get(i, j)` / `set(i, j, value)` — accès et modification par indice (avec vérification de bornes)
  - `add(other)` — addition élément par élément, retourne une nouvelle matrice
  - `iadd(other)` — addition en place (`+=`)
  - `matmul(other)` — produit matriciel
  - `transpose()` — transposition de la matrice
- **`NdArrayFactory`** — fabrique centralisée pour créer des tableaux :
  - `array(float[])` — depuis un tableau de flottants (crée un `Vector1D`)
  - `array(float[][])` — depuis un tableau 2D de flottants (crée une `Matrix2D`)
  - `zeros(int... shape)` — tableau rempli de zéros (1D et 2D)
  - `arange(float start, float stop)` — séquence de valeurs consécutives (1D)
- **`NdArrayPrinter`** — affichage formaté des tableaux (1D et 2D).
- **`reshape()`** — changement de forme, disponible sur tous les `NdArray`.

### Fonctionnalités non implémentées (optionnelles)

- Extension de `zeros()` et `arange()` aux shapes N-dimensionnels (> 2D)
- Broadcast (opérations entre tableaux de dimensions différentes)
- Universal functions (`sum`, `min`, `max`, etc.)
- Support d'autres types de données (`int`, `double`, etc.)

---

## Choix techniques

| Outil | Rôle | Raison du choix |
|---|---|---|
| **Java 17** | Langage principal | Version LTS récente, bonne compatibilité avec les outils utilisés |
| **Maven** | Build & gestion des dépendances | Standard Java, intégration native avec les outils CI |
| **JUnit 4** | Framework de tests unitaires | Simplicité, annotation `@Test`, support natif Maven Surefire |
| **JaCoCo 0.8.12** | Couverture de code | Génération de rapports HTML, intégration Maven via `mvn verify` |
| **GitHub Actions** | CI/CD | Intégration native GitHub, configuration YAML, gratuit pour les dépôts publics |
| **Docker** | Lancement automatique de la démonstration à l'éxécution, hébergé sur DockerHub, configuration/automatisation YAML |

---

## Workflow Git

Nous avons adopté un workflow basé sur **Git Flow simplifié** :

- `main` — branche stable, contient uniquement du code validé et testé
- `develop` — branche d'intégration, cible des Pull Requests des features
- `feature/<nom>` — une branche par fonctionnalité ou correctif, créée depuis `develop`

### Procédure de validation des Pull Requests

1. Le développeur crée une branche `feature/...` depuis `develop`.
2. Il ouvre une **Pull Request** vers `develop` sur GitHub.
3. La **pipeline CI** (GitHub Actions) se déclenche automatiquement : compilation + tests + rapport JaCoCo.
4. La PR ne peut être fusionnée que si la CI est verte.
5. La PR doit être approuvée par un autre membre de l'équipe. Les branches `develop` et `main` sont protégées : aucun push direct n'est autorisé.
6. Après validation, la branche `feature/...` est fusionnée dans `develop` puis supprimée.
7. Le merge de `develop` vers `main` n'est effectué que lorsque `develop` pointe sur une version stable, identifiée par un tag.

---

## Images Docker


Une image Docker de démonstration est produite pour le projet. À l'exécution, elle déroule automatiquement un scénario illustrant les principales opérations de la bibliothèque.

Deux images sont disponibles : une version Ubuntu (tag `ubuntu`) conservée à titre de référence, et une version Alpine (tag `latest`) livrée automatiquement depuis la pipeline sur `main`, réduite de 800 MB à environ 200 MB.

**Dépôt Docker Hub** : https://hub.docker.com/r/allandocker90/ndarray-demo

## Utilisation

Pour la premiere version ubuntu
```bash
docker pull allandocker90/ndarray-demo:ubuntu
docker run --rm allandocker90/ndarray-demo:ubuntu
```
Pour la version alpine :
```bash
docker pull allandocker90/ndarray-demo:latest
docker run --rm allandocker90/ndarray-demo:latest
```
---

**Infrastructure-as-code Cloud**

## Utilisation
Tout les fichiers propre à cette partie est dans le dossier infraCloud à la racine du dépôt et un Readme dans le même dossier sert de tutoriel.

---

## Avancement du TP

### Obligatoire

#### 4.1 Pratiques de développement
- [x] Git — versionnage du code source
- [x] Maven — build et gestion des dépendances
- [x] JUnit 4 — tests unitaires
- [x] JaCoCo — couverture de code intégrée à Maven (seuil à 70%)
- [x] Dépôt GitHub

#### 4.2 Mise en place GitHub
- [x] Comptes GitHub créés pour chaque membre
- [x] Dépôt créé et collaborateurs ajoutés

#### 4.3 Intégration continue
- [x] Pipeline GitHub Actions — lance les tests à chaque push/PR
- [x] Rapport de couverture JaCoCo uploadé comme artefact

#### 4.4 Travail collaboratif
- [x] Feature branches (`feature/<nom>` depuis `develop`)
- [x] Pull Requests avec revue de code
- [x] CI automatique déclenchée sur chaque PR
- [x] Seuil de couverture vérifié à chaque build (JaCoCo `check`)

#### 5.1 Fonctionnalités obligatoires
- [x] `NdArray` — structure de base avec attributs `ndim`, `shape`, `size`
- [x] `Vector1D` — tableau 1D avec `get`, `set`, `add`, `iadd`, `dot`
- [x] `Matrix2D` — structure 2D (`get`, `set`, `add`, `iadd`, `matmul`, `transpose`)
- [x] `array()`, `zeros()`, `arange()` — fonctions de création (1D et 2D)
- [x] `array(float[][])` — création depuis un tableau 2D
- [x] Affichage (`NdArrayPrinter`)
- [x] `add()` / `iadd()` pour `Vector1D`
- [x] `add()` / `iadd()` pour `Matrix2D`
- [x] `reshape()`

---

### Optionnel

#### 4.5 Livraison continue Maven \[difficulté : 2\]
- [x] Déploiement automatique vers GitHub Packages à chaque push sur `main`/`develop`

#### 4.6 Livraison continue Docker \[difficulté : 3\]
- [x] Image Docker avec scénario de démonstration
- [x] Déploiement automatique de l'image dans la pipeline

#### 4.7 Infrastructure-as-code et Cloud \[difficulté : 4\]
- [x] Déploiement automatique sur Google Cloud avec Terraform/Ansible

#### 4.8 Badges \[difficulté : 1\]
- [x] Badge CI/CD dans le README
- [ ] Badge couverture de code

#### 4.9 Valorisation de la bibliothèque \[difficulté : 1\]
- [x] Site web GitHub Pages — maven-site avec JaCoCo, Javadoc et Surefire, déployé depuis `main` et `develop`

#### 4.10 SonarQube \[difficulté : 3\]
- [x] Analyse statique intégrée à la pipeline (`mvn sonar:sonar` sur chaque push/PR vers `main`/`develop`)

#### 5.2 Fonctionnalités optionnelles
- [x] Support `Matrix2D` complet (`get`, `set`, `add`, `iadd`, `matmul`, `transpose`)
- [ ] Broadcast (opérations entre dimensions différentes)
- [ ] Universal functions (`sum`, `min`, `max`, etc.)
- [ ] Support d'autres types de données (`int`, `double`, etc.)

---

## Feedback

### GitHub Actions

Outil très satisfaisant. Tout est accessible depuis l'interface GitHub, le dashboard est clair, et après deux ou trois PRs on a vite saisi le fonctionnement. La mise à disposition de machines virtuelles par GitHub est un vrai plus : elle nous garantit que le code qu'on pousse est fiable et testé dans un environnement propre.

### Maven / JaCoCo

Maven nous a considérablement simplifié la vie. Ne pas avoir à gérer le build manuellement permet de se concentrer sur ce qui a vraiment de la valeur. Toute la configuration du projet tient dans un seul fichier `pom.xml`, ce qui est très pratique.

JaCoCo est un outil formidable pour évaluer la couverture des tests. Un bémol cependant : une fois le seuil de couverture minimum activé, notre workflow feature branch a posé problème. Avec une branche pour l'implémentation et une autre pour les tests, le code ne passait pas la CI faute de couverture suffisante. La solution aurait été de confier implémentation et tests au même développeur, ce qui va à l'encontre de la séparation des tâches. C'est une limite de notre workflow.

### Git Flow

Notre façon de travailler s'y adaptait parfaitement. On travaille depuis chez nous de manière asynchrone, donc un tel workflow était même nécessaire. Les branches `feature/`, les PRs et les revues de code ont rendu la collaboration fluide malgré la distance.

### Docker
Le docker en lui-même était plus facile à configurer que prèvu et le site dockerhub est très pratique c'était une étape intéressante. Nous trouvons le principe de conteneur très pratique pour le déploiement et test rapide sur toute machine ayant docker.

### Infrastructure-as-Code
La compréhension de chaque outil différent était très laborieux mais le fait d'avoir au moins une petite expèrience avec les vm et la plateforme google cloud est très enrichissant.

### Outils généraux

Ce projet nous a fait prendre en main beaucoup d'outils nouveaux. On se sent maintenant capables de gérer des projets plus ambitieux et on comprend concrètement comment de grands projets logiciels peuvent voir le jour. La méthode DevOps permet de se focaliser sur ce qui est vraiment important et d'accorder de la valeur au travail créatif plutôt qu'aux tâches répétitives.
