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
	case 'Log Out':
		page = window.location.href='/Vistas/VistaLogin.xhtml';
		break;

	default:
		if(loc == "/Vistas/VistaPOAuto.xhtml"){
			page = window.location.href='/Vistas/VistaDashboard.xhtml';
		} else{
			page = window.location.href='/Vistas/VistaPOAuto.xhtml';
		}
		break;
	}
	
	return page;
}





