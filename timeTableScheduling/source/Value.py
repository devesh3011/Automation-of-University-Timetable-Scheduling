data_path="E:/Capstone/timeTableScheduling/data/"
subjects_filename=data_path+"subjects.csv"
groups_filename=data_path+"groups.csv"
teachers_filename=data_path+"teachers.csv"
rooms_filename=data_path+"rooms.csv"
classes_filename=data_path+"classes.csv"

max_pop=16
no_of_groups=5

working_days=5
working_hours=11
lec_slot_prob=[0.21,0.21,0.20,0.20,0.03,0.00,0.05,0.05,0.05,0.00,0.00]
tut_slot_prob=[0.01,0.01,0.01,0.01,0.01,0.00,0.32,0.32,0.31,0.00,0.00]
prac_slot_prob=[0.02,0.02,0.02,0.02,0.00,0.00,0.31,0.31,0.30,0.00,0.00]

crossover_points=5

population_mutation_prob=0.7
offspring_mutation_prob=0.2
max_trials_for_free_slots=10

mutation_size=5
unfit_mutation_size=5
fit_mutation_size=1