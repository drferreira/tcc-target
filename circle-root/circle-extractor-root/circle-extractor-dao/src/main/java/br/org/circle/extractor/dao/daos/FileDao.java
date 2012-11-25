package br.org.circle.extractor.dao.daos;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.primefaces.model.UploadedFile;

import br.org.circle.extractor.dao.daos.exceptions.DeleteFileException;
import br.org.circle.extractor.dao.entitys.Document;

/**
 * Dao responsible for managing all accesses and processes linked files saved to
 * disk.
 * 
 * @author tectuba
 * 
 */
public class FileDao extends GenericDao {
	private static final long serialVersionUID = 1L;

	/**
	 * Method responsible for writing the contents of a UploadFile in a file
	 * pointed to by a File.
	 * 
	 * @param uploadFile
	 *            : User upload file that held
	 * @param file
	 *            : Representation of the address of the file on hard disk
	 * @throws IOException
	 */
	public void writeToFile(UploadedFile uploadFile, File file) throws IOException {
		DataOutputStream outPutStream = new DataOutputStream(new FileOutputStream(file));
		outPutStream.write(uploadFile.getContents());
		outPutStream.flush();
		outPutStream.close();
	}

	/**
	 * Method responsible for carrying out the removal of a disk file. If it is
	 * not possible to perform the removal, will begin the exception
	 * DeleteFileException. Receiving a document with data to the target.
	 * 
	 * @param document
	 */
	public void removeFile(Document document) {
		File file = new File(document.getAddressFile() + document.getNameFile());
		if (!file.delete()) {
			throw new DeleteFileException();
		}
	}

	/**
	 * Method responsible for saving a file on disk. It uses the method
	 * WriteToFile to write if the file already exists it will be replaced.
	 * 
	 * @param document
	 * @param uploadFile
	 * @throws IOException
	 */
	public void saveFile(Document document, UploadedFile uploadFile) throws IOException {
		writeToFile(uploadFile, new File(document.getAddressFile() + document.getNameFile()));
	}
}
