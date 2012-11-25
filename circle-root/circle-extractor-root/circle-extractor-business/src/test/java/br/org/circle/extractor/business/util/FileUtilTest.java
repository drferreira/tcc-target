package br.org.circle.extractor.business.util;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

import org.junit.Test;
import org.mockito.Mockito;
import org.primefaces.model.UploadedFile;

import br.org.circle.extractor.business.exceptions.ExtensionEmptyException;
import br.org.circle.extractor.business.exceptions.ExtensionNotMappedException;
import br.org.circle.extractor.dao.enuns.DocumentFormat;

public class FileUtilTest {

	/**
	 * Testa o retorno de uma extenção a partir de um InputStream valido, tendo
	 * como pré condição que o mapeamento da extensão existe.
	 * @throws ExtensionEmptyException 
	 * @throws ExtensionNotMappedException 
	 */
	@Test
	public void testGetExtensionMapValid() throws ExtensionNotMappedException, ExtensionEmptyException {
		UploadedFile uploadedFile = Mockito.mock(UploadedFile.class);
		Mockito.when(uploadedFile.getFileName()).thenReturn("file.doc");
		FileUtil fileUtil = new FileUtil();
		assertEquals(DocumentFormat.DOC.getType(),
				fileUtil.getExtension(uploadedFile).getType());

		Mockito.when(uploadedFile.getFileName()).thenReturn("file.docx");
		assertEquals(DocumentFormat.DOCX.getType(),
				fileUtil.getExtension(uploadedFile).getType());
	}

	/**
	 * Testa o retorno de uma extenção a partir de um InputStream valido, tendo
	 * como pré condição que o mapeamento da extensão não existe.
	 * 
	 * @throws ExtensionEmptyException 
	 * @throws ExtensionNotMappedException 
	 * 
	 */
	@Test(expected=ExtensionNotMappedException.class)
	public void testGetExtensionMapInvalid() throws ExtensionNotMappedException, ExtensionEmptyException {
		UploadedFile uploadedFile = Mockito.mock(UploadedFile.class);
		Mockito.when(uploadedFile.getFileName()).thenReturn("arquivo.jpg");
		FileUtil fileUtil = new FileUtil();
		fileUtil.getExtension(uploadedFile);

		Mockito.when(uploadedFile.getFileName()).thenReturn("arquivo.xxx");
		fileUtil.getExtension(uploadedFile);

		Mockito.when(uploadedFile.getFileName()).thenReturn("arquivo.gif");
		fileUtil.getExtension(uploadedFile);
	}

	/**
	 * Testa um comportamento valido de extração de uma extenção de um full name
	 * de um arquivo
	 * @throws ExtensionEmptyException 
	 */
	@Test
	public void testGetFinalNameFileValidResult() throws ExtensionEmptyException {
		FileUtil fileUtil = new FileUtil();
		Assert.assertEquals("jpg", fileUtil.getExtension("meu arquivo.jpg"));
		Assert.assertEquals("txt", fileUtil.getExtension("meu_arquivo.txt"));
		Assert.assertEquals("bla", fileUtil.getExtension("meu*arquivo.bla"));
		Assert.assertEquals("txt", fileUtil.getExtension("me.u.ar.qu.ivo.txt"));
	}

	/**
	 * Testa se o retorno esta sendo nulo quando um determinado valor é passado
	 * como full name de um arquivo porem o mesmo não possui uma extensão tal
	 * como ".doc"
	 * @throws ExtensionEmptyException 
	 */
	@Test(expected=ExtensionEmptyException.class)
	public void testGetFinalNameFileNoExtension() throws ExtensionEmptyException {
		FileUtil fileUtil = new FileUtil();
		fileUtil.getExtension("asdasd");
		fileUtil.getExtension("cad4%$##&(@#%");
		fileUtil.getExtension("351516_, ");
	}

}
