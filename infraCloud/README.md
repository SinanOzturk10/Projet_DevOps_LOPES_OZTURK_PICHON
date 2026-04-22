# Déploiement Cloud

Ce dossier contient une configuration minimale d'Infrastructure-as-Code pour déployer l'image Docker de démonstration sur Google Cloud.

Terraform crée une machine virtuelle Compute Engine. Ansible se connecte ensuite à cette VM, installe Docker, récupère l'image depuis Docker Hub et lance la démonstration.

## Prérequis

- Un projet Google Cloud avec la facturation activée
- `gcloud`, `terraform` et `ansible` installés localement
- Une paire de clés SSH disponible localement

Attention ne jamais push les informations perso sur git (ex:inventory.ini et terraform.tfvars) Potentiellement .gitignore à faire.

## Authentification Google Cloud

Exemple de commandes, en remplaçant `your-gcp-project-id` par l'identifiant du projet Google Cloud.
Il se trouve avec `gcloud projects list`, dans la colonne `PROJECT_ID`.
Attention : il ne faut pas utiliser le `PROJECT_NUMBER`.

```bash
PROJECT_ID="your-gcp-project-id"

gcloud config set project "$PROJECT_ID"

gcloud auth application-default login

gcloud auth application-default set-quota-project "$PROJECT_ID"

gcloud services enable compute.googleapis.com --project="$PROJECT_ID"
```

Terraform utilisera cette authentification locale pour créer les ressources Google Cloud. Le compte connecté avec `gcloud` doit avoir les droits nécessaires sur le projet.

## Créer la VM

```bash
cd infra/terraform
cp terraform.tfvars.example terraform.tfvars
```

Modifier ensuite `terraform.tfvars` avec les bonnes valeurs :

```hcl
project  = "your-gcp-project-id"
ssh_user = "your-linux-user"

ssh_public_key_path = "~/.ssh/id_rsa.pub"
```

`project` doit contenir le même `PROJECT_ID` que précédemment.
`ssh_user` correspond à l'utilisateur SSH qui sera créé sur la VM. Il faudra réutiliser le même dans l'inventaire Ansible.
`ssh_public_key_path` correspond au chemin de votre clé SSH publique.

Puis lancer :

```bash
terraform init
terraform plan
terraform apply
terraform output vm_ip
```

Lors du `terraform apply`, saisir `yes` quand Terraform demande confirmation.
Conserver la valeur de `vm_ip` pour la configuration Ansible.

## Configurer la VM avec Ansible

```bash
cd ../ansible
cp inventory.ini.example inventory.ini
```

Remplacer `VM_EXTERNAL_IP` par le `vm_ip` obtenu juste avant et `YOUR_SSH_USER` par le même utilisateur SSH que dans `terraform.tfvars`, puis lancer :

```bash
ansible-playbook -i inventory.ini playbook.yml
```

Le playbook lance la démonstration dans un conteneur Docker sur la VM. Pour vérifier le résultat, il faut lire le fichier de log créé sur la VM.
Connectez-vous à la VM avec :

```bash
ssh YOUR_SSH_USER@VM_EXTERNAL_IP
```

Si votre clé SSH possède une passphrase, elle sera demandée à ce moment-là.

Puis affichez les logs :

```bash
cat ndarray-demo.log
```

Pour vous déconnecter :

```bash
exit
```

## Détruire l'infrastructure

Pour éviter de consommer des crédits cloud :

```bash
cd ../terraform
terraform destroy
```
