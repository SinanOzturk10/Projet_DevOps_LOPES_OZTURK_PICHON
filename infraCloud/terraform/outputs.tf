output "vm_ip" {
  description = "External IP address of the VM."
  value       = google_compute_instance.vm_instance.network_interface[0].access_config[0].nat_ip
}

output "ssh_command" {
  description = "SSH command to connect to the VM."
  value       = "ssh ${var.ssh_user}@${google_compute_instance.vm_instance.network_interface[0].access_config[0].nat_ip}"
}
