package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SampleController {
	@FXML
	TextArea texto;
	@FXML
	Button boton;
	@FXML
	Label labelLineas;
	@FXML
	Label labelPalabras;
	@FXML
	Label labelCaracteres;

	@FXML
	public void procesaTexto(ActionEvent e) {

		// ** Cuenta caracteres
		String contTextoString = texto.getText();
		int largo = contTextoString.length();
				
		labelCaracteres.setText("Número de caracteres: " + largo);

		// ** Cuenta líneas
		int lineas = 0;
		for (int i = 0; i < largo; i++) {
			if (contTextoString.charAt(i) == '\n')
				lineas++;
		}

		// Si última línea no tiene salto al final suma uno
		lineas += largo > 0 && contTextoString.charAt(largo - 1) != '\n' ? 1 : 0;
		labelLineas.setText("Número de líneas: " + lineas);

		// ** Cuenta palabras

		// Palabra es un caracter alfabético que tiene delante uno no alfabético.

		int palabras = 0;
		char cAnt;
		for (int i = 0; i < contTextoString.length(); i++) {
			char c = contTextoString.charAt(i);

			if (i == 0) { // Primer caracter
				if (Character.isAlphabetic(c))
					palabras++;
			} else { // segunto caracter y siguientes.
				cAnt = contTextoString.charAt(i - 1);
				if (!Character.isAlphabetic(cAnt) && Character.isAlphabetic(c))
					palabras++;
			}
		}

		labelPalabras.setText("Número de palabras: " + palabras);

	}

}
