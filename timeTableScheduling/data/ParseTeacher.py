
class Teacher:
	def __init__(self,code="",name="",designation="",d_rank=0):
		self.code=code
		self.name=name
		self.designation=designation
		self.d_rank=d_rank
	def display(self):
		# print("%3d\t%5s\t%15s\t%10s\n"%(self.d_rank,self.code,self.name,self.designation))
		print(self.d_rank,"#",self.code,"#",self.name,"#",self.designation,"#","\n")
	def read():
		f=open("Teaching.csv","r")
		inp=f.read()
		#print(type(inp))
		l=inp.split("\n")
		prof=list()
		error=0
		for i in range(len(l)):
			raw=l[i].split(",")
			for j in range(len(raw)):
				raw[j]=raw[j].strip()
			if(raw[0].isdigit()):
				if(raw[2]==""):
					raw[2]="Teaching Assistant"
				prof.append(Teacher(raw[3],raw[1],raw[2],int(raw[0])+error))
				if(int(raw[0])==84):
					error=84
			
		return prof

prof=Teacher.read()
for i in range(len(prof)):
	prof[i].display()