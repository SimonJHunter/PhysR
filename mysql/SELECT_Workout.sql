SELECT workouts.Name, clients.Firstname, clients.Lastname, exercises.Name, exercises.Repetitions, exercises.Sets
FROM physr.workouts
INNER JOIN physr.clients ON physr.workouts.Client_ID = physr.clients.ID
INNER JOIN physr.exercises ON physr.workouts.Excercise_ID = physr.exercises.ID
WHERE clients.ID = 1
