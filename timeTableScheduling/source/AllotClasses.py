import random
from TimeTable import *
from copy import deepcopy
from Value import *
from Group import *
from Subject import *
from CourseClass import *
		
def showFitness(_population):
	flist=[]
	for p in _population:
		flist.append(p.fitness)
	list.sort(flist,reverse=True)
	#fitness of best time-table
	print("Fitness = ",end=' ')
	print("{0:.2f}".format((flist[0]*100)/_population[0]._max_fitness),end=" , ")
	#average fitness
	print("{0:.2f}".format(((sum(flist)/len(flist))*100)/_population[0]._max_fitness))

#kills most unfit l individuals from current population
def killUnfit(_population,l):
	list.sort(_population,reverse=True,key=TimeTable.calculateFitness)
	for i in range(l):
		del(_population[len(_population)-1])

#uniform crossover
def crossover(parent1,parent2):
	child=[]
	child.append(TimeTable(parent1._max_fitness))
	child.append(TimeTable(parent1._max_fitness))
	for i in range(parent1._max_fitness):
		#*check if pos1 and pos2 does not fall in regions of best chromosomes*
		pos1=parent1.getPos(i)
		pos2=parent2.getPos(i)
		if pos1>=0 and pos2>=0:
			if random.randint(1,2)==1:
				c1=deepcopy(parent1.chromo[pos1])
				c2=deepcopy(parent2.chromo[pos2])
				child[0].insertClass(c1)
				child[1].insertClass(c2)
			else:
				c1=deepcopy(parent1.chromo[pos1])
				c2=deepcopy(parent2.chromo[pos2])
				child[0].insertClass(c2)
				child[1].insertClass(c1)

		elif pos1>=0:
			c1=deepcopy(parent1.chromo[pos1])
			c2=deepcopy(c1)
			child[0].insertClass(c1)
			child[1].insertClass(c2)
		elif pos2>=0:
			c1=deepcopy(parent2.chromo[pos2])
			c2=deepcopy(c1)
			child[0].insertClass(c1)
			child[1].insertClass(c2)
		else:
			#*check if pos1 and pos2 does not fall in regions of best chromosomes*
			pos1=parent1.getPos(i)
			pos2=parent2.getPos(i)
			if random.randint(1,2)==1:
				c1=deepcopy(parent1.chromo[pos1])
				c2=deepcopy(parent2.chromo[pos2])
				child[0].insertClass(c1)
				child[1].insertClass(c2)
			else:
				c1=deepcopy(parent1.chromo[pos1])
				c2=deepcopy(parent2.chromo[pos2])
				child[0].insertClass(c2)
				child[1].insertClass(c1)
		
	return child

#*affects positioning of chromosomes, deletes from middle inserts at the end*
def mutate(child,prob):
	if(random.random()<prob):
		
		mut_genes=random.sample(range(0, len(child.chromo)), child.getMutSize())
		for i in mut_genes:
			tc=child.chromo[i]
			c=deepcopy(tc)
			child.delClass(tc[0])
			#check if new time does not fall in regions of best chromosomes
			trails=0
			time=child.getPreferableSlot(c)
			while trails<Value.max_trials_for_free_slots and not child.isFitTiming(c,time):
				time=child.getPreferableSlot(c)
				trails=trails+1
			c[1].time=time
			child.insertClass(c)
		return True
	return False

def reproduce(parent1,parent2):
	child=crossover(parent1,parent2)
	child[0].calculateFitness()
	child[1].calculateFitness()
	#mutation in offsprings
	if mutate(child[0],Value.offspring_mutation_prob):
		child[0].calculateFitness()
	if mutate(child[1],Value.offspring_mutation_prob):	
		child[1].calculateFitness()
	return child
	

def allot(_population):
	#writeToCSV(_population[0],"initial.csv")
	#displayTT(_population[0],4)
	showFitness(_population)
	i=0
	while i<1000 and _population[0].fitness<_population[0]._max_fitness:
		#mutation in current population
		m=random.randint(0,len(_population)-1)
		if mutate(_population[m],Value.population_mutation_prob):
			_population[m].calculateFitness()

		#showFitness()
		#kill unfit
		killUnfit(_population,Value.max_pop//2)
		#populate
		while len(_population)<Value.max_pop:
			#selection
			p1=random.randint(0,len(_population)-1)
			#p2 should be different from p1 and random as well
			p2=p1
			while p2==p1:
				p2=random.randint(0,len(_population)-1)
			#reproduction
			child=reproduce(_population[p1],_population[p2])
			#add to population
			_population.append(child[0])
			_population.append(child[1])
		i=i+1
	#displayTT(_population[0],4)
	showFitness(_population)	
	print("Iterations required = "+str(i))
	#return _population[0]
