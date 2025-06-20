/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: anass(University of Almeria)
 * License Type: Academic
 */
package basededatos;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Hashtag")
public class Hashtag implements Serializable {
	public Hashtag() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_HASHTAG_PERTENECE) {
			return ORM_pertenece;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@Column(name="Id_hashtag", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASEDEDATOS_HASHTAG_ID_HASHTAG_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEDEDATOS_HASHTAG_ID_HASHTAG_GENERATOR", strategy="native")	
	private int id_hashtag;
	
	@Column(name="Hashtag", nullable=true, length=255)	
	private String hashtag;
	
	@ManyToMany(mappedBy="ORM_tiene_hashtag", targetEntity=basededatos.Tweet.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_pertenece = new java.util.HashSet();
	
	private void setId_hashtag(int value) {
		this.id_hashtag = value;
	}
	
	public int getId_hashtag() {
		return id_hashtag;
	}
	
	public int getORMID() {
		return getId_hashtag();
	}
	
	public void setHashtag(String value) {
		this.hashtag = value;
	}
	
	public String getHashtag() {
		return hashtag;
	}
	
	private void setORM_Pertenece(java.util.Set value) {
		this.ORM_pertenece = value;
	}
	
	private java.util.Set getORM_Pertenece() {
		return ORM_pertenece;
	}
	
	@Transient	
	public final basededatos.TweetSetCollection pertenece = new basededatos.TweetSetCollection(this, _ormAdapter, ORMConstants.KEY_HASHTAG_PERTENECE, ORMConstants.KEY_TWEET_TIENE_HASHTAG, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_hashtag());
	}
	
}
