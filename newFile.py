# making edits wooooo
def output(days):
	initial_infected = 7
	reproduction_rate = 1.2
	population = 39740
	tuition = 9972

	total = calc_total_infected(days, initial_infected, reproduction_rate)
	percentage = total / population

	print(f"total num infected: {total}")
	print(f"percentage of students infected: {percentage}")

	if days<= 14 :
		print(f"Total num withdrew: {total}")
		print(f"amount temple loses: {total * tuition}")	
	

	def calc_total_infected(days, iniyisl_infected, reproduction_rate):
		if days==0:
			return initial_infected
		return reproduction_rate * calc_total_infected(days-1, inital_infected, reproduction_rate)



	temp = "y"
	while temp == "y"
		user_input - input("Enter an amouny of days")
		output(int(user_input))
		temp = input("Do you want to keep going [y/n]")

