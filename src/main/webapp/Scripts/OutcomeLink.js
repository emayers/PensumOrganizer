/**
 * 
 */
var link;
var loc;
function getLinkValue(links){
	link = links.innerHTML;
}

function outcomeSwich(){
	var page;
	loc = location.pathname;
	switch (link) {
	case 'Página Principal':
		page = window.location.href='/Dashboard.xhtml';
		break;
	case 'Ver Historial':
		page = window.location.href='/Historial.xhtml';	
		break;
	case 'Programa de la Carrera':
		page = window.location.href='/ProgramaCarrera.xhtml';
		break;
	case 'Reorganizar Pensum':
		page = window.location.href='/ReorganizarPensum';
		break;
	case 'Ayuda':
		page = window.location.href='/Help.xhtml';
		break;
	case 'Log Out':
		page = window.location.href='/Login.xhtml';
		break;

	default:
		if(loc == "/ReorganizarPensum"){
			page = window.location.href='/Dashboard.xhtml';
		} else{
			page = window.location.href='/ReorganizarPensum';
		}
		break;
	}
	
	return page;
}





