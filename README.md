Route :
  Array of Rides

### Part 1.
  Parse
### Part 2.
  Sort
    Distance
    Start time
### Part 3 - Meat
  While (Rides left):
    Give any free cars nearest ride (time + distance)
    Remove ride from ride list
    Step time
    Remove any ride past last date
### Part 4

## Ideas
 * What about finding cycles of rides.
  for example what about finding a set of rides which
  start and end at the same (or similar) places which
  can be done without rest.
 * What about reducing the number of rides by connecting
  rides which one ends just as another begins?
 * What about a a zigzag patten?



## Todo


Write a points calulator that takes in Rides and
says how many points they create. 

Write a Rides packer that takes in rides and gives them
to cars

Write a output parser, that takes in rides and output
a .txt file to give back to the overlords (GHJ).

Write some tests (maybe have a look at jUnit?) to test the
stuff we write.
