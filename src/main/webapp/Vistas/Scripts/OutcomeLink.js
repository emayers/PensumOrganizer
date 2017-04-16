/**
 * 
 */
var link
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

