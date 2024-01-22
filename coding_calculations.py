def energy_consumption(time_spent, power):
    new_power = power / 1000
    return new_power * time_spent

computer_time = 17
gpu_time = 13

"""
Question 2
"""

# a) For CPU
upper_cpu_energy = energy_consumption(computer_time, 95)
lower_cpu_energy = energy_consumption(computer_time, 73)

# b) For RAM
upper_RAM_energy = energy_consumption(computer_time, 1.6)
lower_RAM_energy = energy_consumption(computer_time, 1.2)

# c) For board
upper_board_energy = energy_consumption(computer_time, 40)
lower_board_energy = energy_consumption(computer_time, 25)

# d) For storage
upper_storage_energy = energy_consumption(computer_time, 2.8)
lower_storage_energy = energy_consumption(computer_time, 0.6)

print("Question 2", "\n")
print(f"CPU Energy consumption: {round(lower_cpu_energy,3)} kWh to {round(upper_cpu_energy,3)} kWh")
print(f"RAM Energy consumption: {round(lower_RAM_energy,3)} kWh to {round(upper_RAM_energy,3)} kWh")
print(f"Motherboard Energy consumption: {round(lower_board_energy,3)} kWh to {round(upper_board_energy,3)} kWh")
print(f"SSD Energy consumption: {round(lower_storage_energy,3)} kWh to {round(upper_storage_energy,3)} kWh")
print("-" * 60) # For spacing purposes

"""
Question 4
"""

# a) Load power mode

load_upper_bound = energy_consumption(gpu_time, 164)
load_lower_bound = energy_consumption(gpu_time, 110)

# b) Idle power mode

idle_upper_bound = energy_consumption(gpu_time, 13)
idle_lower_bound = energy_consumption(gpu_time, 8)

print("Question 4", "\n")
print(f"Load Power Mode: {round(load_lower_bound, 3)} kWh to {round(load_upper_bound, 3)} kWh")
print(f"Idle Power Mode: {round(idle_lower_bound, 3)} kWh to {round(idle_upper_bound, 3)} kWh")
print("-" * 60) # For spacing purposes


"""
Question 5
"""

# a) Load power mode

load_min_total_energy = lower_board_energy + lower_cpu_energy + lower_RAM_energy + lower_storage_energy + load_lower_bound
load_max_total_energy = upper_board_energy + upper_cpu_energy + upper_RAM_energy + upper_storage_energy + load_upper_bound

# b) Idle power mode

idle_min_total_energy = lower_board_energy + lower_cpu_energy + lower_RAM_energy + lower_storage_energy + idle_lower_bound
idle_max_total_energy = upper_board_energy + upper_cpu_energy + upper_RAM_energy + upper_storage_energy + idle_upper_bound

print("Question 5a", "\n")

print(f"Minimum Total Energy for Load power mode: {load_min_total_energy} kWh")
print(f"Maximum Total Energy for Load power mode: {load_max_total_energy} kWh")

print("\n", "Question 5b", "\n")

print(f"Minimum Total Energy for Idle power mode: {idle_min_total_energy} kWh")
print(f"Maximum Total Energy for Idle power mode: {idle_max_total_energy} kWh")
print("-" * 60) # For spacing purposes

"""
Question 6
"""

# a)
load_power_bill = load_max_total_energy * 0.34
january_load_bill = load_power_bill * 31

# b)
idle_power_bill = idle_max_total_energy * 0.34
january_idle_bill = idle_power_bill * 31


print("Question 6", "\n")
print(f"Bill for consuming {round(load_max_total_energy * 31,3)} kWh in Load power mode in the month of January: GHC {round(january_load_bill, 2)}")
print(f"Bill for consuming {round(idle_max_total_energy* 31,3)} kWh in Idle power mode in the month of January: GHC {round(january_idle_bill, 2)}")

