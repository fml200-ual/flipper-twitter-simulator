package basededatos;


import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class BD_Documento {
	public BDPrincipal _bd_prin_documento;
	public Vector<Documento> _contiene_Documento = new Vector<Documento>();

	public void nuevoDocumentoTweet(int id_tweet, String URLDocumento, String tipoDocumento) throws PersistentException {
		PersistentTransaction t = MDS12425PFMurilloSuanesPersistentManager.instance()
				.getSession().beginTransaction();
		try {
			Documento documento = DocumentoDAO.createDocumento();
			documento.setImagenVideoURL(URLDocumento);
			documento.setTipo(tipoDocumento);
			Tweet tweet = TweetDAO.getTweetByORMID(id_tweet);
			documento.tweets.add(tweet);
			DocumentoDAO.save(documento);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		MDS12425PFMurilloSuanesPersistentManager.instance().disposePersistentManager();
	}

	public void nuevoDocumentoComentario(int id_comentario, String URLDocumento, String tipoDocumento) throws PersistentException {
		PersistentTransaction t = MDS12425PFMurilloSuanesPersistentManager.instance()
				.getSession().beginTransaction();
		try {
			Documento documento = DocumentoDAO.createDocumento();
			documento.setImagenVideoURL(URLDocumento);
			documento.setTipo(tipoDocumento);
			Comentario comentario = ComentarioDAO.getComentarioByORMID(id_comentario);
			documento.comentarios.add(comentario);
			DocumentoDAO.save(documento);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		MDS12425PFMurilloSuanesPersistentManager.instance().disposePersistentManager();
	}
}