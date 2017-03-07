
function dropList(){
	document.getElementById("dropdownContent").classList.toggle("show");
}

window.onclick = function(e){
	if(!e.target.matches('dropdownTrigger')) {
		var dropDown = document.getElementById("dropdownContent");
		if(dropDown.classList.contains(".show")){
			dropDown.classList.remove(".show");
		}
	}
}