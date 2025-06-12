package interfaz;

import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import vistas.VistaListadehashtags;

public class Listadehashtags extends VistaListadehashtags {
	public Verlistaampliadadehashtags _verlistaampliadadehashtags;
	public Vector<Listadehashtags_item> _item = new Vector<Listadehashtags_item>();

	public Listadehashtags(Verlistaampliadadehashtags _verlistaampliadadehashtags) {
		super();
		this._verlistaampliadadehashtags = _verlistaampliadadehashtags;

		itemsHashtags();
	}

	public void itemsHashtags() {
		for (int i = 0; i < 3; i++) {
			this.getMainContainer().as(VerticalLayout.class)
					.add(new Listadehashtags_item(this));
		}
	}

}