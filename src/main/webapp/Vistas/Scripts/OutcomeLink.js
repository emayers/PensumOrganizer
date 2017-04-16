/**
 * 
 */
var link;
var toRet;
function getLinkValue(links){
	link = links.innerHTML;
}

function outcomeSwich(){
	var page;
	switch (link) {
	case 'Página Principal':
		page = window.location.href='/Vistas/VistaDashboard.xhtml';
		break;
	case 'Ver Historial':
		page = window.location.href='/Vistas/VistaHistorial.xhtml';	
		break;
	case 'Programa de la Carrera':
		page = window.location.href='/Vistas/VistaPrograma.xhtml';
		break;
	case 'Reorganizar Pensum':
		page = window.location.href='/Vistas/VistaPOAuto.xhtml';
		break;
	case 'Ayuda':
		page = window.location.href='/Vistas/VistaHelp.xhtml';
		break;

	default:
		page = window.location.href='/Vistas/VistaPOAuto.xhtml';
		break;
	}
	
	return page;
}

function selectGrab(event){
	
	console.log(event);
	var selectedVal = event.options[event.selectedIndex];
	toRet = selectedVal.value; 
	
	console.log(toRet);
	
}





