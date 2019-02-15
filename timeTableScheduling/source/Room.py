#represents room
#CODE
import Value
class Room:
	def __init__(self,code):
		self.code=code

	def display(self):
		print(self.code)

	def read():
		f=open(Value.rooms_filename,"r")
		inp=f.read()
		#print(type(inp))
		l=inp.split("\n")
		#print(len(l))
		del(l[0])	#ignore first line
		del(l[len(l)-1])	#ignore last line
		# print(len(l))
		for i in range(len(l)):
			l[i]=l[i].split(",")
			l[i]=Room(l[i][0])
		# 	print(l[i])
		# print("here")
		# print(l)
		return l

# t=Teacher.read()
# for i in range(len(t)):
# 	t[i].display()