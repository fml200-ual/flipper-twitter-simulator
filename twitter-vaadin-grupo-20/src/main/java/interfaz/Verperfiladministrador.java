package interfaz;

import java.util.Date;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.BDPrincipal;
import basededatos.Usuario_Registrado;
import mds2.MainView;
import mds2.MainView.Pantalla;
import mds2.MainView.TipoUser;
import mds2.MainView.Usuario;

public class Verperfiladministrador extends Verperfil {
	// private event _eliminarperfil;
	// private event _banearusuario;
	// private event _detallarlongitudbaneo;
	public Vertweetadministrador _vertweetadministrador;
	public Verretweetadministrador _verretweetadministrador;

	// Objeto ORMPersistable para el usuario cuyo perfil se muestra
	public basededatos.Usuario_Registrado u;

	public Verperfiladministrador(Vertweetadministrador _vertweetadministrador, basededatos.Usuario_Registrado u) {
		super();
		Usuario.tipoUsuario = TipoUser.ADMINISTRADOR;
		this._vertweetadministrador = _vertweetadministrador;
		this.u = u;
		this.getEditAccountButton().setVisible(false);

		// Rellenar datos del perfil con información del usuario
		if (u != null) {
			rellenarDatosPerfil();
		}

		this.Agrupartweets(u);
		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_vertweetadministrador);
		});

		this.getDeleteProfileButton().addClickListener(event -> {
			Eliminarperfil();
		});
		this.getBanProfileButton().addClickListener(event -> {
			Banearusuario();
		});

		this.getUserTweetsTab().addClickListener(event -> {
			this.Agrupartweets(u);
		});

		this.getLikedTweetsTab().addClickListener(event -> {
			this.Agrupartweetsgustados(u);
		});
		this.getRetweetsTab().addClickListener(event -> {
			this.Agruparretweets(u);
		});

	}

	public Verperfiladministrador(Verretweetadministrador _verretweetadministrador, basededatos.Usuario_Registrado u) {
		super();
		Usuario.tipoUsuario = TipoUser.ADMINISTRADOR;
		this._verretweetadministrador = _verretweetadministrador;
		this.u = u;
		this.getEditAccountButton().setVisible(false);

		// Rellenar datos del perfil con información del usuario
		if (u != null) {
			rellenarDatosPerfil();
		}

		this.Agrupartweets(u);
		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_vertweetadministrador);
		});

		this.getDeleteProfileButton().addClickListener(event -> {
			Eliminarperfil();
		});
		this.getBanProfileButton().addClickListener(event -> {
			Banearusuario();
		});

		this.getUserTweetsTab().addClickListener(event -> {
			this.Agrupartweets(u);
		});

		this.getLikedTweetsTab().addClickListener(event -> {
			this.Agrupartweetsgustados(u);
		});
		this.getRetweetsTab().addClickListener(event -> {
			this.Agruparretweets(u);
		});
	}

	private void rellenarDatosPerfil() {
		try {
			if (u != null) {
				// Rellenar nombre y nickname
				if (u.getNickname() != null) {
					this.getProfileName().setText(u.getNickname());
					this.getProfileUsername().setText("@" + u.getNickname());
				}

				// Rellenar descripción
				if (u.getDescripcion() != null && !u.getDescripcion().trim().isEmpty()) {
					this.getDescription().setText(u.getDescripcion());
				} else {
					this.getDescription().setText("Usuario de Twitter");
				}

				// Rellenar fecha de registro
				if (u.getFechaDeRegistro() != null) {
					java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM yyyy");
					this.getJoinDate().setText("Se unió en " + sdf.format(u.getFechaDeRegistro()));
				} // Calcular y mostrar contadores reales de seguidores y seguidos desde la base
					// de datos
				// mostrar imagen de perfil
				configurarImagenesPerfil(u);

				try {
					basededatos.BDPrincipal bd = new basededatos.BDPrincipal();

					// Número de usuarios que sigue este usuario
					int siguiendo = bd.contarSeguidos(u.getId_usuario());
					this.getFollowingCount().setText(siguiendo + " siguiendo");

					// Número de usuarios que siguen a este usuario
					int seguidores = bd.contarSeguidores(u.getId_usuario());
					String seguidoresTexto;
					if (seguidores >= 1000) {
						double seguidoresK = seguidores / 1000.0;
						seguidoresTexto = String.format("%.1fK seguidores", seguidoresK);
					} else {
						seguidoresTexto = seguidores + " seguidores";
					}
					this.getFollowersCount().setText(seguidoresTexto);

				} catch (Exception e) {
					// En caso de error, mostrar valores por defecto
					this.getFollowingCount().setText("0 siguiendo");
					this.getFollowersCount().setText("0 seguidores");
					System.err.println("Error calculando seguidores/siguiendo: " + e.getMessage());
				}

				System.out.println("Datos de perfil cargados para administrador viendo: " + u.getNickname());
			} else {
				System.err.println("Error: No se pudo acceder a los datos del usuario");
			}
		} catch (Exception e) {
			System.err.println("Error al cargar datos del perfil: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void Eliminarperfil() {
		Dialog dialog = new Dialog();
		dialog.setWidth("400px"); // Configura el ancho del pop-up
		dialog.setHeight("180px"); // Configura la altura del pop-up
		dialog.setCloseOnOutsideClick(false); // Desactiva el cierre al hacer clic fuera del pop-up

		// Crear el layout para organizar los elementos
		VerticalLayout layout = new VerticalLayout();
		layout.setAlignItems(Alignment.CENTER);

		// Añadir botones
		HorizontalLayout textoImagenLayout = new HorizontalLayout();
		textoImagenLayout.setWidth("100%");
		textoImagenLayout.setAlignItems(Alignment.CENTER);
		// Añadir el mensaje de advertencia
		Label mensaje = new Label("¿Seguro que desea eliminar el perfil?");
		mensaje.getStyle().set("font-weight", "bold");
		textoImagenLayout.add(mensaje);

		Button cancelarButton = new Button();
		Image cerrarIcono = new Image("https://icons.getbootstrap.com/assets/icons/x-lg.svg", "Cerrar");
		cerrarIcono.setWidth("40px"); // Ajusta el tamaño de la imagen
		cerrarIcono.setHeight("40px");

		cancelarButton.setIcon(cerrarIcono);
		cancelarButton.addClickListener(e -> dialog.close());

		textoImagenLayout.add(cancelarButton);

		layout.add(textoImagenLayout);

		// Añadir botones
		HorizontalLayout botonesLayout = new HorizontalLayout();
		botonesLayout.setJustifyContentMode(JustifyContentMode.CENTER);
		Button eliminarButton = new Button("Eliminar");
		eliminarButton.getStyle().set("color", "white").set("background-color", "red");
		eliminarButton.addClickListener(e -> {
			// Aquí puedes añadir la lógica para eliminar el perfil
			Usuario.usuarioRegistradoInterfaz.eliminarPerfil(u.getId_usuario());
			Usuario.usuarioRegistrado = null;
			Usuario.tipoUsuario = TipoUser.NO_REGISTRADO;
			Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(new ACT03Administrador(Pantalla.MainView));
			dialog.close();
		});

		// Añadir el icono de advertencia
		Image warningIcon = new Image(
				"https://thumbs.dreamstime.com/b/se%C3%B1al-de-advertencia-aislado-rojo-vector-ilustraci%C3%B3n-cautela-imagen-disponible-en-eps-formato-totalmente-editable-216588546.jpg",
				"Advertencia");
		warningIcon.setWidth("60px"); // Ajusta el tamaño de la imagen
		warningIcon.setHeight("60px");

		botonesLayout.add(eliminarButton, warningIcon);
		layout.add(botonesLayout);

		// Añadir el botones al diálogo
		dialog.add(layout);

		dialog.open(); // Abre el pop-up
	}

	public void Banearusuario() {
		Dialog dialog = new Dialog();
		dialog.setWidth("400px"); // Configura el ancho del pop-up
		dialog.setHeight("200px"); // Configura la altura del pop-up
		dialog.setCloseOnOutsideClick(false); // Desactiva el cierre al hacer clic fuera del pop-up

		// Crear el layout para organizar los elementos
		VerticalLayout layout = new VerticalLayout();
		layout.setAlignItems(Alignment.CENTER);

		// Añadir mensaje de advertencia
		HorizontalLayout textoImagenLayout = new HorizontalLayout();
		textoImagenLayout.setWidth("100%");
		textoImagenLayout.setAlignItems(Alignment.CENTER);

		Label mensaje = new Label("Selecciona duración del baneo");
		mensaje.getStyle().set("font-weight", "bold");
		textoImagenLayout.add(mensaje);

		// Botón de cancelar con icono
		Button cancelarButton = new Button();
		Image cerrarIcono = new Image("https://icons.getbootstrap.com/assets/icons/x-lg.svg", "Cerrar");
		cerrarIcono.setWidth("40px");
		cerrarIcono.setHeight("40px");

		cancelarButton.setIcon(cerrarIcono);
		cancelarButton.addClickListener(e -> dialog.close());

		textoImagenLayout.add(cancelarButton);
		layout.add(textoImagenLayout);

		// ComboBox para seleccionar la duración del baneo
		ComboBox<String> duracionComboBox = new ComboBox<>("Duración");
		duracionComboBox.setItems("1 día", "1 semana", "1 mes", "1 año");
		duracionComboBox.setWidth("200px");

		// Botón para ejecutar el baneo
		HorizontalLayout botonesLayout = new HorizontalLayout();
		botonesLayout.setJustifyContentMode(JustifyContentMode.CENTER);

		Button banearButton = new Button("Banear");
		banearButton.getStyle().set("color", "white").set("background-color", "red");
		banearButton.addClickListener(e -> {
			String seleccion = duracionComboBox.getValue();

			int duracionDias = 0; // Valor por defecto

			if ("1 día".equals(seleccion)) {
				duracionDias = 1;
			} else if ("1 semana".equals(seleccion)) {
				duracionDias = 7;
			} else if ("1 mes".equals(seleccion)) {
				duracionDias = 30;
			} else if ("1 año".equals(seleccion)) {
				duracionDias = 365;
			}

			if (duracionDias > 0) {
				Usuario.iAdministrador.banear(Usuario.administrador.getId_usuario(), this.u.getId_usuario(),
						duracionDias,
						new Date());
				this.getBanProfileButton().setVisible(false);
				dialog.close();
			}
		});

		// Añadir icono de advertencia
		Image warningIcon = new Image(
				"https://thumbs.dreamstime.com/b/se%C3%B1al-de-advertencia-aislado-rojo-vector-ilustraci%C3%B3n-cautela-imagen-disponible-en-eps-formato-totalmente-editable-216588546.jpg",
				"Advertencia");
		warningIcon.setWidth("60px");
		warningIcon.setHeight("60px");

		botonesLayout.add(banearButton, warningIcon);
		layout.add(duracionComboBox, botonesLayout);

		// Añadir el layout al diálogo
		dialog.add(layout);
		dialog.open(); // Abre el pop-up
	}

	public void Detallarlongitudbaneo() {
		throw new UnsupportedOperationException();
	}
}