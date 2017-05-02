/**
 * 
 */

function selectGrab(event){
	
	console.log(event);
	console.log(event.parentNode);
	console.log(event.parentNode.parentNode);
	var selectedVal = event.options[event.selectedIndex];
	toRet = selectedVal.value; 
	
	console.log(toRet);
	
}