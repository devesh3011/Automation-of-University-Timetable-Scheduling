import Value
import Initialise
import AllotClasses
import Teacher
from Output import *

_population=[]

_group=[]
_subject=[]
_class=[]
_teacher=[]
_room=[]

_max_fitness=-1
_max_pop=Value.max_pop
print("Started")
Initialise.initialise(_population,_group,_subject,_class,_teacher,_room)

AllotClasses.allot(_population)
writeToCSV(_population[0],"E:/Capstone/timeTableScheduling/source/final.csv")

# for t in _teacher:
# 	print("here")
# 	t.display()