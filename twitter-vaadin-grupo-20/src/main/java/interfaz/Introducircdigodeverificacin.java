package interfaz;

import mds2.MainView.Pantalla;
import vistas.VistaIntroducircdigodeverificacin;

/** Pantalla de “Introduce tu código de verificación” – versión con envío real */
public class Introducircdigodeverificacin extends VistaIntroducircdigodeverificacin {

	/* … todos los atributos que ya tenías … */

	/* === NUEVO: manejador de correo === */
	private ACT04SistemadeCorreo _aCT04SistemadeCorreo;

	public Introducircdigodeverificacin(Registrarse _registrarse) {
		super();
		this._registrarse = _registrarse;

		/* 1· Enviar automáticamente el primer código */
		String email = _registrarse.getEmailField().getValue().trim();
		_aCT04SistemadeCorreo = new ACT04SistemadeCorreo(email);

		/* 2· Listeners UI (los tenías ya; añado el de “Reenviar”) */
		setupBackButton();
		setupCodeInputs();
		setupResendButton();
		setupCodeValidation();
	}

	/* ------------  cambios mínimos  ------------ */

	private void setupResendButton() {
		this.getResendCodeButton().addClickListener(e -> {
			_aCT04SistemadeCorreo.Reenviarcdigo();
		});
	}

	/** Sustituye la lógica de validación por la comparación con el servicio. */
	private boolean isValidCode(String code) {
		return _aCT04SistemadeCorreo != null &&
		       _aCT04SistemadeCorreo.getCodigo().equals(code);
	}

	/* El resto de tu clase queda exactamente igual */
}
