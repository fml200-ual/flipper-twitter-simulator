package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Input;

@Tag("vista-introducircdigodeverificacin")
@JsModule("./views/vista-introducircdigodeverificacin.ts")
public class VistaIntroducircdigodeverificacin extends LitTemplate {

    @Id("backButton")
    private Button backButton;
    @Id("verificationContainer")
    private Div verificationContainer;
    @Id("codeFormBox")
    private Div codeFormBox;
    @Id("codeInputs")
    private Div codeInputs;
    @Id("codeDigit1")
    private Input codeDigit1;
    @Id("codeDigit2")
    private Input codeDigit2;
    @Id("codeDigit3")
    private Input codeDigit3;
    @Id("codeDigit4")
    private Input codeDigit4;
    @Id("resendCodeButton")
    private Button resendCodeButton;    public VistaIntroducircdigodeverificacin() {
        // You can initialise any data required for the connected UI components here.
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public Div getVerificationContainer() {
        return verificationContainer;
    }

    public void setVerificationContainer(Div verificationContainer) {
        this.verificationContainer = verificationContainer;
    }

    public Div getCodeFormBox() {
        return codeFormBox;
    }

    public void setCodeFormBox(Div codeFormBox) {
        this.codeFormBox = codeFormBox;
    }

    public Div getCodeInputs() {
        return codeInputs;
    }

    public void setCodeInputs(Div codeInputs) {
        this.codeInputs = codeInputs;
    }

    public Input getCodeDigit1() {
        return codeDigit1;
    }

    public void setCodeDigit1(Input codeDigit1) {
        this.codeDigit1 = codeDigit1;
    }

    public Input getCodeDigit2() {
        return codeDigit2;
    }

    public void setCodeDigit2(Input codeDigit2) {
        this.codeDigit2 = codeDigit2;
    }

    public Input getCodeDigit3() {
        return codeDigit3;
    }

    public void setCodeDigit3(Input codeDigit3) {
        this.codeDigit3 = codeDigit3;
    }

    public Input getCodeDigit4() {
        return codeDigit4;
    }

    public void setCodeDigit4(Input codeDigit4) {
        this.codeDigit4 = codeDigit4;
    }

    public Button getResendCodeButton() {
        return resendCodeButton;
    }

    public void setResendCodeButton(Button resendCodeButton) {
        this.resendCodeButton = resendCodeButton;
    }
}