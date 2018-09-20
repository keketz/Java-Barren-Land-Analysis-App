# Java-Barren-Land-Analysis-App
This is the barren land analysis case study built in java. The Java version isn't as visual as the javascript version nore as interactive, however, I wanted to implement my solution in java as well since Target is a Java shop and I haven't worked in java for some time. 

You can run the jar file to begin the application and you can view the code under the src file. 

Barren land is input using 4 numbers separated by a space forming a rectangle representing bottom left x, bottom left y, top righht x, and tope right y. Fertile land is then listed below in ascending order, grouping adjacent fertile plots with one another and outputing the total area for each.

## Table of Contents

- [Project Instructions](#project-instructions)
- [Implementation](#implementation)
	- [Personal Javascript Solution](#personal-javascript-solution)
	- [Flood Fill Algorithm](#flood-fill-algorithm)
	- [Forest Fire Algorithm](#forest-fire-algorithm)

## Project Instructions
You have a farm of 400m by 600m where coordinates of the field are from (0, 0) to (399,
599). A portion of the farm is barren, and all the barren land is in the form of rectangles.
Due to these rectangles of barren land, the remaining area of fertile land is in no
particular shape. An area of fertile land is defined as the largest area of land that is not
covered by any of the rectangles of barren land.
Read input from STDIN. Print output to STDOUT

Input
You are given a set of rectangles that contain the barren land. These rectangles are
defined in a string, which consists of four integers separated by single spaces, with no
additional spaces in the string. The first two integers are the coordinates of the bottom
left corner in the given rectangle, and the last two integers are the coordinates of the
top right corner.

Output
Output all the fertile land area in square meters, sorted from smallest area to greatest,
separated by a space.

Sample Inputs

1. 0 292 399 307
2. 48 192 351 207,48 392 351 407,120 52 135 547,260 52 275 547

Sample Outputs

1. 116800 116800
2. 22816 192608

##Implementaion
#### Personal Javascript Solution
The first solution I tried was my own which involved using javascripts array functions to filter, split, join, and push array values around. The solution worked for a small scale, but cause the website to overload at larger scales and crash. I tried the solution in java as well with similar results. Below is the solution:

```javascript
var land = this.state.land;
var plots = [];
for (var x = 0; x < land.length; x++) {
	for (var y = 0; y < land[x].length; y++) {
		if (land[x][y]) {plots.push(x + ' ' + y); }
	}
}

var filteredLand = [[plots[0]]];
plots.splice(0, 1);
for (x = 0; x < filteredLand.length; x++) {
	for (y = 0; y < filteredLand[x].length; y++) {
		filteredLand[x] = filteredLand[x].concat(plots.filter(plot =>
			(filteredLand[x][y].split(' ')[0] === plot.split(' ')[0] &&
			Math.abs(filteredLand[x][y].split(' ')[1] - plot.split(' ')[1]) === 1 ||
			Math.abs(filteredLand[x][y].split(' ')[0] - plot.split(' ')[0]) === 1 &&
			filteredLand[x][y].split(' ')[1] === plot.split(' ')[1])
		));

		filteredLand[x].forEach(plot =>
			(plots.indexOf(plot) !== -1) ? plots.splice(plots.indexOf(plot), 1) : null
		);
	}

	if (plots.length > 0) {
		filteredLand.push([plots[0]]);
		plots.splice(0, 1);
	}
}
```
#### Flood Fill Algorithm
After this I thought that maybe the solution used to fill areas in a paint program would be good. I found a wiki page explaining the [Flood Fill](https://en.wikipedia.org/wiki/Flood_fill) formula. I first tried the four-way Stack-based recursive implementation. Results were better than my original attempt but again a larger scale would be too much for the web app to handle. I built the solution in Java and received a stackOverflow Error.. If i increased the memory used for the solution to 10m, the results would display for a 400 by 600 area without any issues. But that memory requirement was only good for a 400 by 600 area and anything larger would result in a stackOverflow error again. This solution wasn’t exactly scaleable.

Flood-fill (node, target-color, replacement-color)
1. If target-color is equal to replacement-color, return.
2. If the color of node is not equal to target-color, return.
3. Set the color of node to replacement-color.
4. Perform Flood-fill (one step to the south of node, target-color, replacement-color).
5. Perform Flood-fill (one step to the north of node, target-color, replacement-color).
6. Perform Flood-fill (one step to the west of node, target-color, replacement-color).
7. Perform Flood-fill (one step to the east of node, target-color, replacement-color).
8. Return.

#### Forest Fire Algorithm
Next I tried an alternative flood fill algorithm sometimes called the ‘Forest Fire Algorithm’. A queue-based implementation similar to the recursive solution, except that it pushes nodes into a queue instead of using recursive calls. This solution worked for me and was scalable as far as I could tell. Javascript could handle it without any issues at 400 by 600 as well as at a greater scale 1000 x 1000. However, it is javascript starts to have trouble rendering the land area greater than a 1000 x 1000 area. This solution is not ideal for much larger scales and would require a scale limit.

Forest Fire Algorithm (node, target-color, replacement-color)
1. If target-color is equal to replacement-color, return.
2. If color of node is not equal to target-color, return.
3. Set Q to the empty queue.
4. Set the color of node to replacement - color.
5. Add node to the end of Q.
6. While Q is not empty:
7. Set n equal to the first element of Q.
8. Remove first element from Q.
9. If the color of the node to the west of n is target - color, set the color of that node to replacement - color and add that node to the end of Q.
10. If the color of the node to the east of n is target - color, set the color of that node to replacement - color and add that node to the end of Q.
11. If the color of the node to the north of n is target - color, set the color of that node to replacement - color and add that node to the end of Q.
12. If the color of the node to the south of n is target - color, set the color of that node to replacement - color and add that node to the end of Q.
13. Continue looping until Q is exhausted.
14. Return.
