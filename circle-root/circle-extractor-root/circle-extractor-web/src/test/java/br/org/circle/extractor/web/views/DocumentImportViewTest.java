package br.org.circle.extractor.web.views;

import junit.framework.Assert;

import org.junit.Test;

import br.org.circle.extractor.business.exceptions.ExtensionEmptyException;
import br.org.circle.extractor.business.exceptions.ExtensionNotMappedException;
import br.org.circle.extractor.business.exceptions.FileNameAlreadyExistsException;
import br.org.circle.extractor.business.exceptions.InvalidInputStreamException;

public class DocumentImportViewTest {

	/**
	 * Teste para verificar se ao receber um arquivo o qual o nome já existe o
	 * método dispara uma mensagem a partir da exception lançada pelo método
	 * saveNewDocument
	 * 
	 * @throws ExtensionEmptyException
	 * @throws ExtensionNotMappedException
	 * @throws InvalidInputStreamException
	 * @throws FileNameAlreadyExistsException
	 */
	@Test(expected = FileNameAlreadyExistsException.class)
	public void uploadFileNameAlreadyExistsMessageUp()
			throws FileNameAlreadyExistsException, InvalidInputStreamException,
			ExtensionNotMappedException, ExtensionEmptyException {
		Assert.fail();
	}

	/**
	 * Teste para verificar se ao receber um arquivo o qual a Stream não é
	 * valida o método dispara uma mensagem a partir da exception lançada pelo
	 * método saveNewDocument
	 */
	@Test
	public void uploadFileInputStreamInvalidMessageUp() {
		Assert.fail();
	}

	/**
	 * Teste para verificar se ao receber um arquivo o qual a extensão não esta
	 * mapeada o método dispara uma mensagem a partir da exception lançada pelo
	 * método saveNewDocument
	 */
	@Test
	public void uploadFileExtensionNotMappedMessageUp() {
		Assert.fail();
	}

	/**
	 * Teste para verificar se ao receber um arquivo o qual a extensão não é
	 * identificada o método dispara uma mensagem a partir da exception lançada
	 * pelo método saveNewDocument
	 */
	@Test
	public void uploadFileExtensionIsNotReadableMessageUp() {
		Assert.fail();
	}

}
