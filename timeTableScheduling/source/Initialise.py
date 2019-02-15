from TimeTable import *
from Subject import *
from Group import *
from CourseClass import *
from Teacher import *
from Room import *
def getDuration(_subject,s):
	for i in range(len(_subject)):
		if _subject[i][0]==s:
			return _subject[i][2]
	return -1

#no of slots of a given class
def getSlots(_subject,s):
	for i in range(len(_subject)):
		if _subject[i][0]==s:
			return _subject[i][1]
	return -1
def addToList(l1,l2):
	for i in l2:
		l1.append(i)

def initialise(_population,_group,_subject,_class,_teacher,_room):	#read input data in program
	
		
	# global _subject
	# global _group
	# global _class
	# global _max_fitness

	addToList(_subject,Subject.read())
	addToList(_group,Group.read())
	addToList(_teacher,Teacher.read())
	addToList(_room,Room.read())
	temp=CourseClass.read()
	# print(_subject)
	# print(_teacher)
	# print(_room)
	for i in range(len(temp)):	#raw class data from .csv file
		rc=temp[i]	#raw class
		d=getDuration(_subject,rc[0])
		for j in range(len(rc[1])):	#for each major(lecture) group
			cc=CourseClass(subject=rc[0],group=rc[1][j],duration=d)
			s=getSlots(_subject,rc[0])
			for k in range(s):	#for each slot
				_class.append(cc)
	
	for i in range(Value.max_pop):
		_population.append(TimeTable(len(_class)))	# _max_fitness=len(_class)
		_population[i].allotRandomClasses(_class,_teacher,_room)

	print("Total Classes : "+str(len(_class)))