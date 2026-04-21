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
- **`NdArrayFactory`** — fabrique centralisée pour créer des tableaux :
  - `array(float[])` — depuis un tableau de flottants
  - `zeros(int... shape)` — tableau rempli de zéros (1D uniquement pour l'instant)
  - `arange(float start, float stop)` — tableau de valeurs consécutives
- **`NdArrayPrinter`** — affichage formaté des tableaux.

### Fonctionnalités prévues / en cours

- **`Matrix2D`** — structure 2D déclarée, méthodes à implémenter : `get(i,j)`, `set(i,j,value)`, `add()`, `iadd()`, `matmul()`, `transpose()`
- `NdArrayFactory.array(float[][])` — création de matrices 2D
- Extension de `zeros()` et `arange()` aux shapes N-dimensionnels
- <!-- TODO: compléter avec les fonctionnalités prévues pour la suite du TP -->

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
5. <!-- TODO: décrire si une relecture par un autre membre de l'équipe est requise (règle de protection de branche, reviewer obligatoire, etc.) -->
6. Après validation, la branche `feature/...` est fusionnée dans `develop` puis supprimée.
7. <!-- TODO: décrire la procédure de merge develop → main (release, tag, etc.) -->

---

## Images Docker


Une image Docker de démonstration basé sur Ubuntu est produite pour le projet. A l'éxécution l'image docker montre directement différentes opérations utilisable avec la bibliothèque scientifique que nous avons implémentées.
Si la livraison automatique fonctionne, la version latest sera une version alpine alégé permettant de passer d'une image de 800MB à 200MB.

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
- [ ] `Matrix2D` — structure 2D (`get`, `set`, `add`, `iadd`, `matmul`, `transpose`)
- [x] `array()`, `zeros()`, `arange()` — fonctions de création (1D)
- [ ] `array(float[][])` — création depuis un tableau 2D
- [x] Affichage (`NdArrayPrinter`)
- [x] `add()` / `iadd()` pour `Vector1D`
- [ ] `add()` / `iadd()` pour `Matrix2D`
- [x] `reshape()`

---

### Optionnel

#### 4.5 Livraison continue Maven \[difficulté : 2\]
- [x] Déploiement automatique vers GitHub Packages à chaque push sur `main`/`develop`

#### 4.6 Livraison continue Docker \[difficulté : 3\]
- [x] Image Docker avec scénario de démonstration
- [x] Déploiement automatique de l'image dans la pipeline

#### 4.7 Infrastructure-as-code et Cloud \[difficulté : 4\]
- [ ] Déploiement automatique sur Google Cloud avec Terraform/Ansible

#### 4.8 Badges \[difficulté : 1\]
- [ ] Badge CI/CD dans le README
- [ ] Badge couverture de code

#### 4.9 Valorisation de la bibliothèque \[difficulté : 1\]
- [x] Site web GitHub Pages — maven-site avec JaCoCo, Javadoc et Surefire, déployé depuis `main` et `develop`

#### 4.10 SonarQube \[difficulté : 3\]
- [ ] Analyse statique intégrée à la pipeline

#### 5.2 Fonctionnalités optionnelles
- [ ] Support `Matrix2D` complet
- [ ] Broadcast (opérations entre dimensions différentes)
- [ ] Universal functions (`sum`, `min`, `max`, etc.)
- [ ] Support d'autres types de données (`int`, `double`, etc.)

---

## Feedback

<!-- TODO: compléter cette section en fin de projet avec le retour d'expérience de chaque membre -->

### GitHub Actions

<!-- TODO: retour sur la facilité de mise en place, les limitations rencontrées, etc. -->

### Maven / JaCoCo

<!-- TODO: retour sur l'intégration des outils de build et de couverture -->

### Git Flow

<!-- TODO: retour sur le workflow adopté, ce qui a bien fonctionné ou non en équipe -->

### Outils généraux

<!-- TODO: retour global sur l'expérience DevOps du projet -->
