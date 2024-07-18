function replaceOccurance(output, token) {	
	for(let i of token){
		// Create a global regular expression to replace all occurrences of `i`
		const regex = new RegExp(i, 'g');
		output = output.replace(regex, '');
	}
	return output;	
}

let output = "1,4,13";
const challengeToken = "ucb41lr09";
console.log(replaceOccurance(output, challengeToken)); // Return ,,3