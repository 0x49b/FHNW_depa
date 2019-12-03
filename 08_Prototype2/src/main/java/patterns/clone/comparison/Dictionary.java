package patterns.clone.comparison;

import patterns.clone.comparison.util.SerializableClone;

import java.io.Serializable;

@SuppressWarnings("unused")
public class Dictionary implements Serializable {
	private String language;
	private final int size;
	private String[] words;

	public Dictionary(String language, int size) {
		this.language = language;
		this.size = size;
		this.words = new String[size];
		for (int i = 0; i < size; i++)
			this.words[i] = "sample word " + i;
	}

	@Override
	public Dictionary clone() {

		return (Dictionary) SerializableClone.clone(this);

		/*
		try {
			Dictionary d = (Dictionary) super.clone();
			if (words != null) {
				d.words = words.clone();
			}
			return d;
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}*/

	}
}
