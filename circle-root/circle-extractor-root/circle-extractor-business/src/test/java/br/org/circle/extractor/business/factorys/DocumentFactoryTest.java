package br.org.circle.extractor.business.factorys;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.primefaces.model.UploadedFile;

import br.org.circle.extractor.business.exceptions.ExtensionEmptyException;
import br.org.circle.extractor.business.exceptions.ExtensionNotMappedException;
import br.org.circle.extractor.business.util.FileUtil;
import br.org.circle.extractor.dao.entitys.Document;
import br.org.circle.extractor.dao.entitys.Owner;
import br.org.circle.extractor.dao.enuns.DocumentFormat;

public class DocumentFactoryTest {

	/**
	 * Teste que verifica a criação de 
	 * um Document, tendo como base que o mesmo
	 * recebe um arquivo do tipo doc e um Owner mockado
	 * 
	 * @throws ExtensionNotMappedException
	 * @throws ExtensionEmptyException
	 */
	@Test
	public void testcreateValidDocument() throws ExtensionNotMappedException, ExtensionEmptyException {
		FileUtil fileUtil = Mockito.mock(FileUtil.class);
		Owner owner = Mockito.mock(Owner.class);
		UploadedFile uploadedFile = Mockito.mock(UploadedFile.class);

		Mockito.when(uploadedFile.getFileName()).thenReturn("meu_arquivo");
		Mockito.when(uploadedFile.getSize()).thenReturn(123456l);
		Mockito.when(fileUtil.getExtension(uploadedFile)).thenReturn(
				DocumentFormat.DOC);
		
		DocumentFactory documentFactory = new DocumentFactory(fileUtil);
		Document document = documentFactory.createDocument(uploadedFile,
				owner);
		Assert.assertEquals(document.getDocumentFormat(), DocumentFormat.DOC);
		Assert.assertEquals(document.getNameFile(), "meu_arquivo");
		Assert.assertEquals(document.getSizeFile(), new Long(123456l));
	}
		
}
