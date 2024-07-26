function canFormGroups(friendList) {
	if (friendList.length === 0) return false;
  
	const friendships = new Map();
  
	// Build the friendships map
	for (const [friend1, friend2] of friendList) {
	  if (!friendships.has(friend1)) friendships.set(friend1, new Set());
	  if (!friendships.has(friend2)) friendships.set(friend2, new Set());
	  friendships.get(friend1).add(friend2);
	  friendships.get(friend2).add(friend1);
	}
  
	const visited = new Set();
  
	function dfs(student, group) {
	  const stack = [student];
	  group.push(student);
	  visited.add(student);
  
	  while (stack.length > 0) {
		const current = stack.pop();
		for (const friend of friendships.get(current)) {
		  if (!visited.has(friend)) {
			visited.add(friend);
			group.push(friend);
			stack.push(friend);
		  }
		}
	  }
	}
  
	// Check each component of the graph
	for (const student of friendships.keys()) {
	  if (!visited.has(student)) {
		const group = [];
		dfs(student, group);
		if (group.length % 2 !== 0) {
		  return false;
		}
	  }
	}
  
	// Check if any students in friendList are left unpaired
	const allStudents = new Set(friendList.flat());
	return visited.size === allStudents.size;
  }
  
  // Example usage
  console.log(canFormGroups([])); // Output: false
  console.log(canFormGroups([['A', 'B'], ['C', 'B'], ['D', 'B']])); // Output: false
  console.log(canFormGroups([['Evan', 'Pooja'], ['David', 'Tan'], ['Tan', 'David']])); // Output: false
  console.log(canFormGroups([['A', 'B'], ['C', 'D']])); // Output: true
  