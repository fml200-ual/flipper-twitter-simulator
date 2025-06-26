package interfaz;

import mds2.MainView.Pantalla;
import vistas.VistaIntroducircdigodeverificacin;

public class Introducircdigodeverificacin extends VistaIntroducircdigodeverificacin {
	// private event _mensajedeerrordecdigo;
	// private event _reenviarcdigo;
	public Registrarse _registrarse;
	public ACT04SistemadeCorreo _aCT04SistemadeCorreo;

	public Introducircdigodeverificacin(Registrarse _registrarse) {
		super();
		this._registrarse = _registrarse;
		// Ensamblado dinámico - Configurar listeners y validación
		setupBackButton();
		setupCodeInputs();
		setupResendButton();
		setupCodeValidation();
	}

	private void setupBackButton() {
		this.getBackButton().addClickListener(event -> goBack());
	}

	private void goBack() {
		// Volver a la vista de registro
		if (_registrarse != null) {
			if (_registrarse._aCT01UsuarioNoRegistrado != null) {
				_registrarse._aCT01UsuarioNoRegistrado.getVerticalLayoutCentralNoRegistrado()
						.as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class).removeAll();
				_registrarse._aCT01UsuarioNoRegistrado.getVerticalLayoutCentralNoRegistrado()
						.as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class).add(_registrarse);
			} else if (_registrarse._iniciarsesin != null) {
				_registrarse._iniciarsesin._aCT01UsuarioNoRegistrado.getVerticalLayoutCentralNoRegistrado()
						.as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class).removeAll();
				_registrarse._iniciarsesin._aCT01UsuarioNoRegistrado.getVerticalLayoutCentralNoRegistrado()
						.as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class).add(_registrarse);
			}
		}
	}

	private void setupCodeInputs() {
		// Configurar navegación automática entre campos de código usando
		// ValueChangeListener
		this.getCodeDigit1().addValueChangeListener(event -> {
			String value = event.getValue();
			if (value != null && value.length() == 1) {
				this.getCodeDigit2().focus();
			}
		});

		this.getCodeDigit2().addValueChangeListener(event -> {
			String value = event.getValue();
			if (value != null && value.length() == 1) {
				this.getCodeDigit3().focus();
			}
		});

		this.getCodeDigit3().addValueChangeListener(event -> {
			String value = event.getValue();
			if (value != null && value.length() == 1) {
				this.getCodeDigit4().focus();
			}
		});

		this.getCodeDigit4().addValueChangeListener(event -> {
			String value = event.getValue();
			if (value != null && value.length() == 1) {
				// Cuando se complete el último dígito, validar automáticamente
				validateCompleteCode();
			}
		});

		// Configurar navegación del lado del cliente para backspace
		setupClientSideNavigation();
	}

	private void setupClientSideNavigation() {
		// Configurar navegación del lado del cliente usando JavaScript
		String navigationScript = """
				// Script para navegación automática entre campos de código
				setTimeout(() => {
					const inputs = document.querySelectorAll('.code-input');

					if (inputs.length === 4) {
						inputs.forEach((input, index) => {
							// Limpiar listeners anteriores
							input.removeEventListener('input', input._inputHandler);
							input.removeEventListener('keydown', input._keydownHandler);

							// Definir handlers
							input._inputHandler = function(e) {
								// Permitir solo números
								this.value = this.value.replace(/[^0-9]/g, '');

								// Limitar a 1 carácter
								if (this.value.length > 1) {
									this.value = this.value.charAt(0);
								}

								// Navegar al siguiente campo si hay valor
								if (this.value.length === 1 && index < inputs.length - 1) {
									inputs[index + 1].focus();
									inputs[index + 1].select();
								}
							};

							input._keydownHandler = function(e) {
								// Backspace navegación
								if (e.key === 'Backspace' && this.value === '' && index > 0) {
									inputs[index - 1].focus();
									inputs[index - 1].select();
								}

								// Prevenir caracteres no numéricos
								if (!/[0-9]/.test(e.key) && !['Backspace', 'Delete', 'Tab', 'ArrowLeft', 'ArrowRight'].includes(e.key)) {
									e.preventDefault();
								}
							};

							// Agregar los listeners
							input.addEventListener('input', input._inputHandler);
							input.addEventListener('keydown', input._keydownHandler);

							// Focus automático en el primer campo
							if (index === 0) {
								input.focus();
							}
						});
					}
				}, 200);
				""";

		// Ejecutar el script en el cliente
		this.getElement().executeJs(navigationScript);
	}

	private void setupResendButton() {
		this.getResendCodeButton().addClickListener(event -> {
			Reenviarcdigo();
		});
	}

	private void setupCodeValidation() {
		// Asegurar que solo se ingresen números
		this.getCodeDigit1().getElement().setAttribute("pattern", "[0-9]*");
		this.getCodeDigit2().getElement().setAttribute("pattern", "[0-9]*");
		this.getCodeDigit3().getElement().setAttribute("pattern", "[0-9]*");
		this.getCodeDigit4().getElement().setAttribute("pattern", "[0-9]*");
	}

	private void validateCompleteCode() {
		try {
			String digit1 = this.getCodeDigit1().getValue();
			String digit2 = this.getCodeDigit2().getValue();
			String digit3 = this.getCodeDigit3().getValue();
			String digit4 = this.getCodeDigit4().getValue();

			// Validar que todos los campos tienen valores
			if (digit1 != null && digit2 != null && digit3 != null && digit4 != null &&
					!digit1.trim().isEmpty() && !digit2.trim().isEmpty() &&
					!digit3.trim().isEmpty() && !digit4.trim().isEmpty()) {

				String completeCode = digit1.trim() + digit2.trim() + digit3.trim() + digit4.trim();

				// Validar que el código tenga exactamente 4 dígitos numéricos
				if (completeCode.matches("\\d{4}")) {
					// Validar el código
					if (isValidCode(completeCode)) {
						// Código válido - proceder con el registro
						completarRegistro();
					} else {
						// Código inválido - mostrar error
						Mensajedeerrordecdigo();
					}
				} else {
					// Formato inválido
					Mensajedeerrordecdigo();
				}
			}
		} catch (Exception e) {
			// Manejo de errores para evitar NullPointerException
			System.out.println("Error al validar código: " + e.getMessage());
			Mensajedeerrordecdigo();
		}
	}

	private boolean isValidCode(String code) {
		try {
			System.out.println("Validando código: " + code);

			// Verificar contra el código almacenado en _registrarse
			if (_registrarse != null && _registrarse._codigoVerificacion != null) {
				String codigoEsperado = _registrarse._codigoVerificacion.trim();
				System.out.println("Código esperado: " + codigoEsperado);
				return codigoEsperado.equals(code);
			} else {
				System.err.println("Error: No hay código de verificación disponible");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error en validación de código: " + e.getMessage());
			return false;
		}
	}

	private void completarRegistro() {
		try {
			// Código válido - completar el proceso de registro siguiendo el patrón ORM
			System.out.println("Código válido. Completando registro...");

			// Declaración del atributo IActor como en el patrón
			basededatos.BDPrincipal iactor = new basededatos.BDPrincipal();

			// Fallback: volver a la vista principal sin login automático
			System.out.println("Registro completado. Redirigiendo a página principal...");
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_registrarse._aCT01UsuarioNoRegistrado);
		} catch (Exception e) {
			System.err.println("Error al completar registro: " + e.getMessage());
			e.printStackTrace();
			Mensajedeerrordecdigo();
		}
	}

	private void clearCodeInputs() {
		try {
			this.getCodeDigit1().setValue("");
			this.getCodeDigit2().setValue("");
			this.getCodeDigit3().setValue("");
			this.getCodeDigit4().setValue("");
			this.getCodeDigit1().focus();
		} catch (Exception e) {
			System.out.println("Error al limpiar campos: " + e.getMessage());
		}
	}

	public void Mensajedeerrordecdigo() {
		try {
			// Limpiar los campos y mostrar error visual
			clearCodeInputs();

			// Agregar clase de error a los inputs (esto se podría hacer con CSS)
			if (this.getCodeDigit1() != null) {
				this.getCodeDigit1().getElement().getStyle().set("border-color", "#FF0000");
			}
			if (this.getCodeDigit2() != null) {
				this.getCodeDigit2().getElement().getStyle().set("border-color", "#FF0000");
			}
			if (this.getCodeDigit3() != null) {
				this.getCodeDigit3().getElement().getStyle().set("border-color", "#FF0000");
			}
			if (this.getCodeDigit4() != null) {
				this.getCodeDigit4().getElement().getStyle().set("border-color", "#FF0000");
			}

			System.out.println("Error: Código de verificación incorrecto");

			// Restaurar colores después de 3 segundos usando JavaScript
			this.getElement().executeJs("""
					setTimeout(() => {
						const inputs = document.querySelectorAll('.code-input');
						inputs.forEach(input => {
							input.style.borderColor = '#666';
						});
					}, 3000);
					""");

		} catch (Exception e) {
			System.out.println("Error al mostrar mensaje de error: " + e.getMessage());
		}
	}

	public void Reenviarcdigo() {
		try {
			// Lógica para reenviar el código de verificación
			System.out.println("Reenviando código de verificación...");

			// Limpiar los campos para el nuevo código
			clearCodeInputs();

			// Simular envío de nuevo código
			if (_aCT04SistemadeCorreo == null) {
				// _aCT04SistemadeCorreo = new ACT04SistemadeCorreo(this);
			}

			// Deshabilitar el botón temporalmente para evitar spam
			if (this.getResendCodeButton() != null) {
				this.getResendCodeButton().setEnabled(false);
				this.getResendCodeButton().setText("Código enviado...");

				// Re-habilitar después de 5 segundos usando JavaScript
				this.getElement().executeJs("""
						setTimeout(() => {
							const button = document.querySelector('#resendCodeButton');
							if (button) {
								button.disabled = false;
								button.textContent = 'Reenviar código';
							}
						}, 5000);
						""");
			}

			System.out.println("Nuevo código de verificación enviado");
		} catch (Exception e) {
			System.out.println("Error al reenviar código: " + e.getMessage());
		}
	}
}