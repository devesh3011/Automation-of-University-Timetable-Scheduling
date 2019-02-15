#represents courses taught
#CODE,DEPARTMENT,RANK,LOAD,T_PREF,S_PREF,PROJECTOR,NAME
import Value
class Teacher:
	def __init__(self,code,department,rank,load,t_pref,s_pref,projector,name):
		self.code=code
		self.department=department
		self.rank=rank
		self.load=load
		self.t_pref=t_pref
		self.s_pref=s_pref
		self.projector=projector
		self.name=name

	def display(self):
		print(self.code,"#",self.department,"#",self.rank,"#",self.load,"#",self.t_pref,"#",self.s_pref,"#",self.projector,"#",self.name)

	def read():
		f=open(Value.teachers_filename,"r")
		inp=f.read()
		#print(type(inp))
		l=inp.split("\n")
		#print(len(l))
		del(l[0])	#ignore first line
		del(l[len(l)-1])	#ignore last line
		# print(len(l))
		for i in range(len(l)):
			l[i]=l[i].split(",")
			l[i][5]=l[i][5].split(":")
			l[i]=Teacher(l[i][0],l[i][1],l[i][2],l[i][3],l[i][4],l[i][5],l[i][6],l[i][7])
		# 	print(l[i])
		# print("here")
		# print(l)
		return l

# t=Teacher.read()
# for i in range(len(t)):
# 	t[i].display()