package interfaz;

import vistas.VistaListadenotificaciones_item;
import basededatos.PropiedadesMencion;
import basededatos.PropiedadesSeguidos;
import basededatos.PropiedadesBaneo;

public class Listadenotificaciones_item extends VistaListadenotificaciones_item {
	// private event _eliminarnotificacin;
	// private event _mostrarmsnotificaciones;
	public Listadenotificaciones _listadenotificaciones;
	
	// Objeto que puede contener cualquier tipo de notificación
	public Object notificacion; // Puede ser PropiedadesMencion, PropiedadesSeguidos, PropiedadesBaneo, etc.

	// Constructor original (compatibilidad)
	public Listadenotificaciones_item(Listadenotificaciones _listadenotificaciones) {
		this(_listadenotificaciones, null);
	}
	
	// Nuevo constructor que recibe la entidad de notificación
	public Listadenotificaciones_item(Listadenotificaciones _listadenotificaciones, Object notificacion) {
		super();
		this._listadenotificaciones = _listadenotificaciones;
		this.notificacion = notificacion;
		
		// Poblar la interfaz con datos de la notificación si están disponibles
		if (notificacion != null) {
			actualizarDatosNotificacion();
		} else {
			// Mostrar datos por defecto si no hay notificación
			mostrarDatosPorDefecto();
		}

		this.getSeenCheckbox().addClickListener(event -> {
			Eliminarnotificacin();
		});
	}
	
	private void actualizarDatosNotificacion() {
		try {
			String descripcion = "";
					if (notificacion instanceof PropiedadesMencion) {
				PropiedadesMencion mencion = (PropiedadesMencion) notificacion;
				descripcion = "Mención en tweet: " + (mencion.getTweet() != null ? mencion.getTweet().getContenidoTweet() : "N/A");
				// TODO: Agregar más detalles cuando los getters estén disponibles
			} else if (notificacion instanceof PropiedadesSeguidos) {
				PropiedadesSeguidos seguimiento = (PropiedadesSeguidos) notificacion;
				descripcion = "Nuevo seguidor: " + (seguimiento.getSeguidoresUsuario_registrado() != null ? 
					seguimiento.getSeguidoresUsuario_registrado().getNickname() : "N/A");
				// TODO: Agregar más detalles cuando los getters estén disponibles
			} else if (notificacion instanceof PropiedadesBaneo) {
				PropiedadesBaneo baneo = (PropiedadesBaneo) notificacion;
				descripcion = "Notificación de baneo";
				// TODO: Agregar más detalles cuando los getters estén disponibles
			}
			
			if (!descripcion.isEmpty()) {
				this.getDescriptionLabel().setText(descripcion);
			}
		} catch (Exception e) {
			// Si hay algún error al obtener los datos, mostrar mensaje por defecto
			this.getDescriptionLabel().setText("Notificación");
		}
	}
	
	private void mostrarDatosPorDefecto() {
		this.getDescriptionLabel().setText("Nueva notificación");
		this.getSeenCheckbox().setValue(false);
	}

	public void Eliminarnotificacin() {
		// TODO: Implementar eliminación de notificación usando el objeto notificacion
	}

	public void Mostrarmsnotificaciones() {
		// TODO: Implementar mostrar más notificaciones
	}
}