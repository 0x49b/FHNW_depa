package patterns.observer.color;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ColorTest {
	private ColorModel model;
	private int cnt;

	@Before
	public void init() {
		model = new ColorModel();
	}

	@Test
	public void test1() {
		model.addColorListener((s, c) -> cnt++);
		model.setColor(Color.red);
		assertEquals(1, cnt);
	}

	@Test
	public void test2() {
		model.addColorListener((s, c) -> cnt++);
		model.addColorListener((s, c) -> cnt++);
		model.setColor(Color.red);
		assertEquals(2, cnt);
	}

	@Test
	public void test3() {
		model.addColorListener(new ColorListener() {
			@Override
			public void colorValueChanged(ColorModel source, Color newColor) {
				assertEquals(source, model);
				assertEquals(newColor, Color.red);
			}
		});
		model.setColor(Color.red);
	}

	@Test
	public void test4() {
		model.addColorListener((s, c) -> cnt++);
		model.setColor(Color.red);
		model.setColor(Color.red);
		assertEquals(1, cnt);
	}

	@Test
	public void test5() {
		ColorListener l = (s, c) -> cnt++;
		model.addColorListener(l);
		model.addColorListener(l);
		model.setColor(Color.red);
		assertEquals(2, cnt);
	}
}
