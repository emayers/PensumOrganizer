
function dropList(){
	document.getElementById("dropdownContent").classList.toggle("show");
}

window.onclick = function(event){
	if(!event.target.matches('.dropdownTrigger')) {
		var dropDown = document.getElementsByClassName("dropdownClass");
		console.log(dropDown.length);
		var i;
		for (i=0;i<dropDown.length;i++){
			var openDropdown = dropDown[i];
			if(openDropdown.classList.contains('show')){
				openDropdown.classList.remove('show');
			}
		}
	}
}