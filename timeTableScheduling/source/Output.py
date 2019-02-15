import Value
def displayTT(t,g):	#tt for a given group
	index=1
	for i in range(len(t.table)):
		print(str(index)+" : ",end='')
		for j in range(len(t.table[i][g-1])):
			print(t.table[i][g-1][j][1].subject,end=' ,')
		index=index+1
		print('')
	print('')

def writeToCSV(t,file_name):
	f = open(file_name,'w')
	for g in range(1,len(t.table[0])+1):
		f.write("Group_"+str(g)+"\n")
		f.write("MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,\n")
		for hr in range(Value.working_hours):
			for day in range(Value.working_days):
				f.write("\"")
				flag=0
				for c in range(len(t.table[hr+Value.working_hours*day][g-1])):
					flag=1
					f.write(t.table[hr+Value.working_hours*day][g-1][c][1].subject)
				if flag:
					f.write("\n"+t.table[hr+Value.working_hours*day][g-1][c][1].room)
					f.write("          "+t.table[hr+Value.working_hours*day][g-1][c][1].teacher)
				f.write("\"")
				f.write(',')
			f.write('\n')
		f.write('\n')
	f.close()