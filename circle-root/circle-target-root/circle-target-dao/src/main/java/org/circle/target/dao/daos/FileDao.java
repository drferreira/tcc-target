package org.circle.target.dao.daos;

import java.io.File;
import java.io.IOException;
import javax.ejb.Local;
import org.circle.target.dao.entities.Document;
import org.primefaces.model.UploadedFile;

@Local
public interface FileDao {

	void saveFile(Document document, UploadedFile uploadFile) throws IOException;

	void removeFile(Document document);

	void writeToFile(UploadedFile uploadFile, File file) throws IOException;
}
