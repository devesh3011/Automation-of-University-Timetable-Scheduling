import random
from numpy.random import choice
import Value
from CourseClass import *
class TimeTable:
	def __init__(self,max_fitness):
		self.chromo=[]
		self.table= [[[] for x in range(Value.no_of_groups)] for y in range(Value.working_days*Value.working_hours)]
		self._max_fitness=max_fitness
		self.fitness=-1

	#index of class in list
	def getPos(self,static_pos):
		for i in range(len(self.chromo)):
			if static_pos==self.chromo[i][0]:
				return i
		return -1

	#return timing of the class
	def getTime(self,static_pos):
		for i in range(len(self.chromo)):
			if static_pos==self.chromo[i][0]:
				return self.chromo[i][1].time
		return -1


	def getMutSize(self):
		if Value.unfit_mutation_size<len(self.chromo):
			return Value.mutation_size
		return random.randint(0,len(self.chromo)+1)

	#checks if a given time falls in regions of already fit classes
	def isFitTiming(self,c,time):
		for g in c[1].group:
			for d in range(0,c[1].duration):
				if len(self.table[time+d][int(g)-1])==1:
					return False
		return True

	#handles breaks(12:00pm ,2:00 pm) and class slot probabilities
	def getPreferableSlot(self,c):
		#limits boundary condition
		class_type=c[1].subject[len(c[1].subject)-1]
		max_time_slot=Value.working_hours-c[1].duration
		slots=range(0,Value.working_hours)
		prob=[]
		if class_type=='L':
			prob=Value.lec_slot_prob
		elif c[1].subject[len(c[1].subject)-1]=='P':
			prob=Value.prac_slot_prob
		elif c[1].subject[len(c[1].subject)-1]=='T':
			prob=Value.lec_slot_prob
		#handles lecture,tuts,practicals slots
		time=-1
		if class_type=='L':
			while time<0:
				time=int(choice(slots,1,p=prob))	#choice() does not return an integer????
				for d in range(c[1].duration):
					#class should not fall in regins of zero probabilities
					if prob[time+d]<=0 or time>max_time_slot:
						time=-1
						break
		elif class_type=='P':
			while time<0:
				time=int(choice(slots,1,p=prob))
				for d in range(c[1].duration):
					if prob[time+d]<=0 or time>max_time_slot:
						time=-1
						break		
		elif class_type=='T':
			while time<0:
				time=int(choice(slots,1,p=prob))
				for d in range(c[1].duration):
					if prob[time+d]<=0 or time>max_time_slot:
						time=-1
						break		
		return random.randint(0,Value.working_days-1)*Value.working_hours+time

	def delClass(self,static_pos):
		i=self.getPos(static_pos)
		if i>=0:
			c=self.chromo[i]
			for d in range(c[1].duration):
				for g in c[1].group:
					self.table[c[1].time+d][int(g)-1].remove(c)
			del(self.chromo[i])
			return
		i=getPos(static_pos)
		if i>=0:
			c=self.chromo[i]
			for d in range(c[1].duration):
				for g in c[1].group:
					self.table[c[1].time+d][int(g)-1].remove(c)
			del(self.chromo[i])
			return

	def insertClass(self,c):
		self.chromo.append(c);
		for d in range(c[1].duration):
			for g in c[1].group:
				self.table[c[1].time+d][int(g)-1].append(c)
	def calculateFitness(self):
		sum=0
		bad_genes=[]
		for i in range(len(self.table)):
			for j in range(len(self.table[0])):
				if(len(self.table[i][j])>1):
					for k in self.table[i][j]:
						if not isPresent(bad_genes,k):
							bad_genes.append(k)
							sum=sum+1
		#print(bad_genes)
		self.fitness=self._max_fitness-sum
		return self.fitness

	def allotRandomClasses(self,_class,_teacher,_room):
		i=0	#to mark index corresponding to indexing in _class
		for rc in _class:
			t_subject=rc.subject
			t_group=rc.group
			t_time=self.getPreferableSlot([i,rc])
			t_teacher=_teacher[random.randint(0,len(_teacher)-1)].code
			t_room=_room[random.randint(0,len(_room)-1)].code
			t_duration=rc.duration
			t_lab=False
			c=[i,CourseClass(t_subject,t_group,t_time,t_teacher,t_room,t_duration,t_lab)]
			self.insertClass(c)
			i=i+1
		self.calculateFitness()

#checks if a class is already present in the list
def isPresent(l,k):
	for i in l:
		if i==k:
			return True
	return False
	
# TimeTable(100)