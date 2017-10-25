package br.com.padroes.adapter;

import java.io.File;
import java.io.InputStream;

// classe que simula a api do dropBox
class DropBoxFile {

	public DropBoxFile() {
	}

	public DropBoxFile(String absolutePath) {
	}

	public String getLocalPath() {
		return null;
	}
}

class DropBox {
	void upload(DropBoxFile dbFile) {
	}

	DropBoxFile download(String id) {
		return new DropBoxFile();
	}
}

class AWS {
	void save(InputStream input, int id) {
	}

	InputStream restore(int id) {
		return null;
	}
}

class GoogleDrive {
	void send(byte[] data, String name) {
	}

	byte[] get(String name) {
		return null;
	}
}

interface Persistencia {
	public void gravar(File file);

	File ler(String id);
}

class DropBoxAdapter implements Persistencia {
	DropBox dropBox;

	DropBoxAdapter(DropBox dropBox) {
		this.dropBox = dropBox;
	}

	public void gravar(File file) {
		dropBox.upload(new DropBoxFile(file.getAbsolutePath()));
	}

	public File ler(String id) {
		DropBoxFile dbFile = dropBox.download(id);
		return new File(dbFile.getLocalPath());
	}
}

public class Adapter2 {
	public static void main(String[] args) {
		Persistencia persistencia = new DropBoxAdapter(new DropBox());
	}
}
