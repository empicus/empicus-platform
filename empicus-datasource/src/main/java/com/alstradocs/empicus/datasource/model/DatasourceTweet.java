/**
 * 
 */
package com.alstradocs.empicus.datasource.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.cloderia.enterprise.core.model.ArtifactData;
import com.cloderia.enterprise.core.model.ArtifactFieldData;
import com.cloderia.enterprise.core.model.BaseEntity;


/**
 * @author Edward Banfa
 */
@Entity
@Table(name="DATASOURCE_TWEET")
public class DatasourceTweet extends BaseEntity {

	private static final long serialVersionUID = 1L;
    public static final String ARTIFACT_NAME = "DatasourceTweet";
	@NotNull(message="The text is required.")
	private String text;
	@NotNull(message="The tweetDt is required.")
	private Date tweetDt;

    public DatasourceTweet() {
    }
	
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#getText()
     */
    @Column(name="TEXT", nullable=false, length=255)
    public String getText() {
        return this.text;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#setText(java.lang.String)
     */
    public void setText(String text) {
        this.text = text;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#getTweetDt()
     */
    @Column(name="TWEET_DT", nullable=false, length=26)
    public Date getTweetDt() {
        return this.tweetDt;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#setTweetDt(java.util.Date)
     */
    public void setTweetDt(Date tweetDt) {
        this.tweetDt = tweetDt;
    }

	@Transient
	public String getArtifactName() {
		return ARTIFACT_NAME;
	}
	
	/**
	 * @return
	 */
	public ArtifactData toEntityData(){
		ArtifactData entityDataInstance = new ArtifactData();
		entityDataInstance.setArtifactName(ARTIFACT_NAME);
		entityDataInstance.getFieldData().put("id", new ArtifactFieldData("id", "java.long.String", false, getId()));
		entityDataInstance.getFieldData().put("code", new ArtifactFieldData("code", "Code", false, getCode()));
		entityDataInstance.getFieldData().put("name", new ArtifactFieldData("name", "String", false, getName()));
		entityDataInstance.getFieldData().put("text", new ArtifactFieldData("text", "Text", false, getText()));
		entityDataInstance.getFieldData().put("tweetDt", new ArtifactFieldData("tweetDt", "Date", false, getTweetDt()));
		entityDataInstance.getFieldData().put("status", new ArtifactFieldData("status", "String", false, getStatus()));
		entityDataInstance.getFieldData().put("createdDt", new ArtifactFieldData("createdDt", "Date", false, getCreatedDt()));
		entityDataInstance.getFieldData().put("createdByUsr", new ArtifactFieldData("createdByUsr", "Code", false, getCreatedByUsr()));
		entityDataInstance.getFieldData().put("lastModifiedDt", new ArtifactFieldData("lastModifiedDt", "Date", false, getLastModifiedDt()));
		entityDataInstance.getFieldData().put("lastModifiedUsr", new ArtifactFieldData("lastModifiedUsr", "Code", false, getLastModifiedUsr()));

		return entityDataInstance;
	}
}


