/**
 * 
 */

function moveToBox(btn) {
	  var row = btn.parentNode.parentNode;
	  var element = row.parentNode.removeChild(row);
	  var PensumTable = btn.parentNode;
	  
	  var img = document.createElement('img');
	  img.src = "/Vistas/Images/add-circle-1.svg";
	  img.id = "addSubjects";
	  
	  var buttom = document.createElement('a');
	  buttom.onclik = function moveToTable(btn){
		  //hmmm....
	  };
	  buttom.appendChild(img);
	  buttom.href = '#';
	  
	  var table = document.getElementById("boxElements");
	  var newRow = table.insertRow(table.length);
	  newRow.insertCell(0).innerHTML = element.cells[1].innerHTML;
	  newRow.insertCell(1).innerHTML = element.cells[3].innerHTML;
	  newRow.insertCell(2).innerHTML = element.cells[2].innerHTML;
	  newRow.insertCell(3).appendChild(buttom);
	  
	  var numberLess = PensumTable.childNodes;
	  console.log(numberLess);
    
}
