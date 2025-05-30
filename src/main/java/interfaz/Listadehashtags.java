package interfaz;

import java.util.Vector;

import vistas.VistaListadehashtags;

public class Listadehashtags extends VistaListadehashtags{
	public Verlistaampliadadehashtags _verlistaampliadadehashtags;
	public Vector<Listadehashtags_item> _item = new Vector<Listadehashtags_item>();

	public Listadehashtags(Verlistaampliadadehashtags _verlistaampliadadehashtags) {
		super();
		this._verlistaampliadadehashtags = _verlistaampliadadehashtags;
	}

}