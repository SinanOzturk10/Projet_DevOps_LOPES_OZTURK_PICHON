variable "project" {
  description = "Google Cloud project id."
  type        = string
}

variable "ssh_user" {
  description = "Linux user used by Ansible to connect to the VM."
  type        = string
}

variable "ssh_public_key_path" {
  description = "Path to the SSH public key added to the VM metadata."
  type        = string
  default     = "~/.ssh/id_rsa.pub"
}
