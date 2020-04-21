/**
 * 
 */
package com.alstradocs.empicus.refdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cloderia.enterprise.core.model.ArtifactData;
import com.cloderia.enterprise.core.model.ArtifactFieldData;
import com.cloderia.enterprise.core.model.BaseEntity;

/**
 * @author Edward Banfa
 */
@Entity
@Table(name="CLINICAL_FEATURE")
public class ClinicalFeature extends BaseEntity {

	private static final long serialVersionUID = 1L;
    public static final String ARTIFACT_NAME = "ClinicalFeature";
    private DiseaseSign signId;
    private DiseaseSymptom symptonId;
	private String description;

    public ClinicalFeature() {
    }
	
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="SIGN_ID", nullable=false)
    public DiseaseSign getSignId() {
        return this.signId;
    }
    
    public void setSignId(DiseaseSign signId) {
        this.signId = signId;
    }
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="SYMPTON_ID", nullable=false)
    public DiseaseSymptom getSymptonId() {
        return this.symptonId;
    }
    
    public void setSymptonId(DiseaseSymptom symptonId) {
        this.symptonId = symptonId;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#getDescription()
     */
    @Column(name="DESCRIPTION", nullable=true, length=150)
    public String getDescription() {
        return this.description;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#setDescription(java.lang.String)
     */
    public void setDescription(String description) {
        this.description = description;
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
		entityDataInstance.getFieldData().put("signId", new ArtifactFieldData("signId", "DiseaseSign", true, getSignId()));
		entityDataInstance.getFieldData().put("symptonId", new ArtifactFieldData("symptonId", "DiseaseSymptom", true, getSymptonId()));
		entityDataInstance.getFieldData().put("code", new ArtifactFieldData("code", "Code", false, getCode()));
		entityDataInstance.getFieldData().put("name", new ArtifactFieldData("name", "String", false, getName()));
		entityDataInstance.getFieldData().put("description", new ArtifactFieldData("description", "Text", false, getDescription()));
		entityDataInstance.getFieldData().put("status", new ArtifactFieldData("status", "String", false, getStatus()));
		entityDataInstance.getFieldData().put("createdDt", new ArtifactFieldData("createdDt", "Date", false, getCreatedDt()));
		entityDataInstance.getFieldData().put("createdByUsr", new ArtifactFieldData("createdByUsr", "Code", false, getCreatedByUsr()));
		entityDataInstance.getFieldData().put("lastModifiedDt", new ArtifactFieldData("lastModifiedDt", "Date", false, getLastModifiedDt()));
		entityDataInstance.getFieldData().put("lastModifiedUsr", new ArtifactFieldData("lastModifiedUsr", "Code", false, getLastModifiedUsr()));

		return entityDataInstance;
	}
}


