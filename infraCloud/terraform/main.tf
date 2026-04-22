terraform {
  required_version = ">= 1.5.0"

  required_providers {
    google = {
      source  = "hashicorp/google"
      version = "~> 5.0"
    }
  }
}

provider "google" {
  project = var.project
  region  = "europe-west1"
  zone    = "europe-west1-b"
}

resource "google_compute_firewall" "allow_ssh" {
  name    = "ndarray-demo-allow-ssh"
  network = "default"

  allow {
    protocol = "tcp"
    ports    = ["22"]
  }

  source_ranges = ["0.0.0.0/0"]
  target_tags   = ["ndarray-demo"]
}

resource "google_compute_instance" "vm_instance" {
  name         = "ndarray-demo-vm"
  machine_type = "e2-micro"
  tags         = ["ndarray-demo"]

  boot_disk {
    initialize_params {
      image = "debian-cloud/debian-12"
    }
  }

  network_interface {
    network = "default"

    access_config {
    }
  }

  metadata = {
    ssh-keys = "${var.ssh_user}:${file(pathexpand(var.ssh_public_key_path))}"
  }
}
